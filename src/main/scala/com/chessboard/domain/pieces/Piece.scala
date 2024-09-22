package com.chessboard.domain.pieces

import com.chessboard.domain.{Board, Cell}
import com.chessboard.domain.moves.Move
import com.chessboard.domain.validations.MoveRestriction

trait Piece { self =>
  val stepType: StepType

  def allowedMoves: List[Move]
  def possibleMovesAtPositionWithFilter(steps: Int, currentPosition: Cell, isMoveAllowed: Cell => Boolean): List[Cell] = {
    self.allowedMoves.flatMap(movement => movement.shift(steps, currentPosition).filter(isMoveAllowed(_)))
  }

  def allPossibleMoves(currentPosition: Cell, board: Board, moveRestriction: MoveRestriction): List[Cell] = {
    stepType  match {
      case SingleStep => possibleMovesAtPositionWithFilter(1, currentPosition, moveRestriction.isMoveAllowed(_, currentPosition))
      case MultiStep => (1 to board.size.maxLength)
        .flatMap(possibleMovesAtPositionWithFilter(_, currentPosition, moveRestriction.isMoveAllowed(_, currentPosition))).toList
    }

  }
}