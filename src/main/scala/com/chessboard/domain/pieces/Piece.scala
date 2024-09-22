package com.chessboard.domain.pieces

import cats.data.Validated
import com.chessboard.domain.{Board, Cell}
import com.chessboard.domain.moves.{AllMoves, Move}
import com.chessboard.domain.validations.MoveRestriction
import com.chessboard.errors.InvalidPieceNameException

trait Piece { self =>
  val stepType: StepType
  def allowedMoves: List[Move]
  protected def allMovesOnBoardWithRestrictions(steps: Int, currentPosition: Cell, isMoveAllowed: Cell => Boolean): List[Cell] = {
    self.allowedMoves.flatMap(movement => movement.shift(steps, currentPosition).filter(isMoveAllowed(_)))
  }
  def allMovesOnBoard(currentPosition: Cell, board: Board, moveRestriction: MoveRestriction): List[Cell] = {
    stepType  match {
      case SingleStep => allMovesOnBoardWithRestrictions(1, currentPosition, moveRestriction.isMoveAllowed(_, currentPosition))
      case MultiStep => (1 to board.size.maxLength)
        .flatMap(allMovesOnBoardWithRestrictions(_, currentPosition, moveRestriction.isMoveAllowed(_, currentPosition))).toList
    }

  }
}
object Piece {
  def apply(pieceName: String): Validated[Exception, Piece] = {
    pieceName match {
      case PieceNames.KING => Validated.valid(King(List(AllMoves)))
      case PieceNames.QUEEN => Validated.valid(Queen(List(AllMoves)))
      case _=> Validated.invalid(new InvalidPieceNameException)
    }
  }
}