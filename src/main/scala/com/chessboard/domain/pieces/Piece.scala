package com.chessboard.domain.pieces

import cats.data.Validated
import com.chessboard.domain.board.{Board, Cell}
import com.chessboard.domain.errors.InvalidPieceNameException
import com.chessboard.domain.validations.RestrictedMovesFilter
import com.chessboard.domain.walks.{AllWalks, Walk}

trait Piece { self =>
  val stepType: StepType
  def allowedWalks: List[Walk]

  protected def getAllMovesByRestrictedMovesFilter(steps: Int, currentPosition: Cell, moveRestriction: RestrictedMovesFilter): List[Cell] = {
    self.allowedWalks.flatMap(movement =>
      movement.startWalkAndCheckRestrictedMoves(steps, currentPosition, moveRestriction.run(currentPosition)))
  }
  def allMovesOnBoard(currentPosition: Cell, board: Board, moveRestriction: RestrictedMovesFilter): List[Cell] = {
    stepType  match {
      case SingleStep => getAllMovesByRestrictedMovesFilter(1, currentPosition, moveRestriction)
      case MultiStep => (1 to board.size.maxLength)
        .flatMap(getAllMovesByRestrictedMovesFilter(_, currentPosition, moveRestriction)).toList
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