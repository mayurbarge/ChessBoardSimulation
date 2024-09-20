package com.chessboard.domain.pieces

import com.chessboard.domain.Cell
import com.chessboard.domain.moves.Move

trait Piece { self =>
  val stepType: StepType
  def allowedMoves: List[Move]
  def possibleMovesAtPositionWithFilter(steps: Int, currentPosition: Cell, filterCondition: Cell => Boolean): List[Cell] = {
    self.allowedMoves.flatMap(movement => movement.shift(steps, currentPosition).filter(filterCondition(_)))
  }

  def possibleMovesAtPosition(steps: Int, currentPosition: Cell) = {
    self.allowedMoves.flatMap(movement => movement.shift(steps, currentPosition))
  }

  def allPossibleMoves(currentPosition: Cell): List[Cell]
}