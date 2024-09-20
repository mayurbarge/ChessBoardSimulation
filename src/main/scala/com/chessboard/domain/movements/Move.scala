package com.chessboard.domain.movements

import com.chessboard.domain._
import com.chessboard.domain.movements.HorizontalMove.findNextPositions
import com.chessboard.domain.movements.VerticalMove.findNextPositions
sealed trait Move {
  def shift(nthStep: Int, initial: Cell): List[Cell]
  def applyMoves(nthStep: Int, moves: List[(Direction, Int)]): List[Cell => Cell] = {
    val nthStepTowardsDirection = increaseStepCount(_, nthStep)
    applyMoves(moves.map(nthStepTowardsDirection))
  }
  def increaseStepCount(directionAndStep: (Direction, Int), nthStep: Int) = {
    val (direction, step) = directionAndStep
    (direction, step * nthStep)
  }
  protected def applyMoves(moves: List[(Direction, Int)]) = {
    moves.map(findNthCellTowardsDirection)
  }
  private def findNthCellTowardsDirection(directionAndStep: (Direction, Int)) = {
      val (direction, step) = directionAndStep
      direction.shiftTowardsBy(step)
  }
  protected def findNextPositions(initial: Cell, nextPositionsList: List[Cell => Cell]) = {
    nextPositionsList.map(nextCellOf => nextCellOf(initial))
  }
}
case object HorizontalMove extends Move {
  def shift(nthStep: Int, initial: Cell) = {
    val nextPositionsList = super.applyMoves(MoveDirections.horizontal.map((_, nthStep)))
    findNextPositions(initial, nextPositionsList)
  }
}
case object VerticalMove extends Move {
  def shift(nthStep: Int, initial: Cell) = {
    val nextPositionsList = super.applyMoves(MoveDirections.vertical.map((_, nthStep)))
    findNextPositions(initial, nextPositionsList)
  }
}

case object DiagonalMove extends Move {
  def shift(nthStep: Int, initial: Cell) = {
    val nextPositionsList = super.applyMoves(MoveDirections.diagonal.map((_, nthStep)))
    findNextPositions(initial, nextPositionsList)
  }
}
case class ComplexMove(complexMoves: List[List[(Direction, Int)]]) extends Move {
  override def shift(nthStep: Int, initial: Cell): List[Cell] = {
    val nextPositionsList = complexMoves.map(moves =>
      sequenceMultipleMovesIntoOne(applyMoves(nthStep, moves))
    )
    nextPositionsList.map(_(initial))
  }
  def sequenceMultipleMovesIntoOne(moves: List[Cell => Cell]): Cell => Cell = moves.reduce(_ andThen _)
}
