package com.chessboard.domain.movements

import com.chessboard.domain._
import com.chessboard.domain.movements.HorizontalMove.{directionsAllowedForMove, findNextPositions}
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

trait MoveWithRegularDirections extends Move {
  val directionsAllowedForMove: List[Direction]

  def shift(nthStep: Int, initial: Cell) = {
    val nextPositionsList = applyMoves(directionsAllowedForMove.map((_, nthStep)))
    findNextPositions(initial, nextPositionsList)
  }
}
case object HorizontalMove extends Move with MoveWithRegularDirections {
  val directionsAllowedForMove = MoveDirections.horizontal
}
case object VerticalMove extends Move with MoveWithRegularDirections {
  val directionsAllowedForMove = MoveDirections.vertical
}

case object DiagonalMove extends Move with MoveWithRegularDirections {
  val directionsAllowedForMove = MoveDirections.diagonal
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