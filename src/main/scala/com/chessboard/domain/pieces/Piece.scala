package com.chessboard.domain.pieces

import com.chessboard.domain.Cell
import com.chessboard.domain.movements.{Move, Step}

trait Piece { self =>
  val stepType: Step
  val allowedMoves: List[Move]
  def possibleMovesAtPosition(steps: Int, currentPosition: Cell) =
    self.allowedMoves.flatMap(movement => movement.shift(steps, currentPosition))
  def possibleMovesAtPositionWithFilter(steps: Int, currentPosition: Cell, filter: Cell => Boolean) = {
    self.allowedMoves.flatMap(movement => movement.shift(steps, currentPosition).takeWhile(filter(_)))
  }

}
case class King(stepType: Step, allowedMoves: List[Move]) extends Piece