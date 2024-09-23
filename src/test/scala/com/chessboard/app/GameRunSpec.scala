package com.chessboard.app

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import com.chessboard.domain.moves.AllMoves
import com.chessboard.domain.pieces.{King, Piece}
import com.chessboard.domain.{BoardSize, Cell}
import com.chessboard.errors.{InvalidCellException, InvalidPieceNameException}
import org.scalatest.freespec.AsyncFreeSpec
import org.scalatest.matchers.should.Matchers
class GameRunSpec extends AsyncFreeSpec with AsyncIOSpec with Matchers {

  "A game run" - {
    val validatedInput: IO[(Piece, Cell)] = GameRun.splitTokens(BoardSize(8,8),  "King, D2")
    "should split input string and create a validated piece and cell" in {
      val piece: IO[Piece] = validatedInput.map(_._1)
      val cell = validatedInput.map(_._2)
      piece.asserting( _ shouldBe King(List(AllMoves)))
      cell.asserting( _ shouldBe Cell('D', 2))
    }

    "should give Invalid Cell Error if input is incorrect" in {
      val validatedInput: IO[(Piece, Cell)] = GameRun.splitTokens(BoardSize(8,8),  "King, D0")
      val cell = validatedInput.map(_._2)
      cell.assertThrowsWithMessage[InvalidCellException]("Cell is invalid.")
    }

    "should give Invallid Piece Name Error if input is incorrect" in {
      val validatedInput: IO[(Piece, Cell)] = GameRun.splitTokens(BoardSize(8,8),  "Parrot, D0")
      val piece = validatedInput.map(_._1)
      piece.assertThrowsWithMessage[InvalidPieceNameException]("Invalid piece passed in the input.")
    }
  }
}
