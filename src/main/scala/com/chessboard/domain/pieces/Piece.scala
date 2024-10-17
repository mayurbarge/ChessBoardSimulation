package com.chessboard.domain.pieces

import cats.data.Validated
import com.chessboard.domain.board.{Board, Cell}
import com.chessboard.domain.errors.InvalidPieceNameException
import com.chessboard.domain.validations.MoveValidator
import com.chessboard.domain.walks.{AllWalks, Walk}

trait Piece { self =>
  val stepType: StepType
  def allowedWalks: List[Walk]

  protected def getAllMovesByRestrictedMovesFilter(maximumSteps: Int, currentPosition: Cell, moveRestrictions: List[MoveValidator]): List[Cell] = {
    self.allowedWalks.flatMap(walk =>
      walk.startWalkAndCheckRestrictedMoves(maximumSteps, currentPosition, moveRestrictions))
  }
  def allMovesOnBoard(currentPosition: Cell, board: Board, moveRestrictions: List[MoveValidator]): List[Cell] = {
    stepType  match {
      case SingleStep => getAllMovesByRestrictedMovesFilter(1, currentPosition, moveRestrictions)
      case MultiStep => getAllMovesByRestrictedMovesFilter(board.size.maxLength, currentPosition, moveRestrictions)
    }
  }
}
object Piece {
  def apply(pieceName: String): Validated[InvalidPieceNameException, Piece] = {
    pieceName match {
      case PieceNames.KING => Validated.valid(King(List(AllWalks)))
      case PieceNames.QUEEN => Validated.valid(Queen(List(AllWalks)))
      case _=> Validated.invalid(new InvalidPieceNameException)
    }
  }
}