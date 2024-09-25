package com.chessboard.app

import cats.effect.unsafe.implicits.global
import cats.effect.{IO, IOApp}
import com.chessboard.domain.pieces.Piece
import com.chessboard.domain.validations.BoundaryCheckAndSameCellCheckFilter
import cats.effect.std.Console
import com.chessboard.domain.board.{Board, BoardSize, Cell, ValidatedCell}

object GameRun {
  def splitTokens(boardSize: BoardSize, input: String) = {
    input.split(",").toList match {
      case head :: tail :: Nil => IO.fromEither(validateInput(head.trim, tail.trim, boardSize))
      case _ => IO.raiseError(new Exception("Invalid input. Please enter {Piece Name}, {Position} format."))
    }
  }
  def validateInput(pieceName: String, position: String, boardSize: BoardSize) = {
    for {
      piece <- Piece(pieceName).toEither
      cell <- ValidatedCell(Cell(position.charAt(0), position.charAt(1).toString.toInt), boardSize).toEither
    } yield  {
      (piece, cell)
    }
}
  def main(args: Array[String]): Unit = {
    val boardSize = BoardSize(8, 8)
    val board = Board(boardSize)
    val gameConstraints = BoundaryCheckAndSameCellCheckFilter(board)

    val gameRun =
      for {
        input <- Console[IO].readLine
        pieceAndCell <- splitTokens(boardSize, input)
      } yield {
        val (piece, cell) = pieceAndCell
        Console[IO].println(piece.allMovesOnBoard(cell, board, gameConstraints).sortBy(e => (e.column, e.row)).mkString(" "))
      }
    //gameRun.flatten.unsafeRunSync()

    gameRun.flatten.unsafeRunSync()
  }
}

