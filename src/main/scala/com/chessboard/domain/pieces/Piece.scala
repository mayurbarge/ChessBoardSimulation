package com.chessboard.domain.pieces

import com.chessboard.domain.movements.{Move, SingleStep, StepType}
import com.chessboard.domain.{Cell, ValidatedCell}

trait Piece { self =>
  val stepType: StepType
  def allowedMoves: List[Move]
  def possibleMovesAtPositionWithFilter(steps: Int, currentPosition: Cell, filterCondition: Cell => Boolean): List[Cell] = {
    self.allowedMoves.flatMap(movement => movement.shift(steps, currentPosition).filter(filterCondition(_)))
  }

  def possibleMovesAtPosition(steps: Int, currentPosition: Cell) = {
    self.allowedMoves.flatMap(movement => movement.shift(steps, currentPosition))
  }
  def allSingleStepPossibleMoves(currentPosition: Cell): List[Cell] = {
    def filterCondition(cellToCheck: Cell) =
      ValidatedCell(cellToCheck).isValid && currentPosition != cellToCheck

    possibleMovesAtPositionWithFilter(1, currentPosition, filterCondition)
  }
  def allPossibleMoves(currentPosition: Cell): List[Cell]
}
trait SingleStepPiece extends Piece {
  override def allPossibleMoves(currentPosition: Cell): List[Cell] = {
    allSingleStepPossibleMoves(currentPosition)
  }
}
case class King(allowedMoves: List[Move]) extends Piece with SingleStepPiece {
  override val stepType: StepType = SingleStep
}