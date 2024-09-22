package com.chessboard.domain.moves

import com.chessboard.domain.{Cell, Direction}

trait Move {
  def shift(nthStep: Int, initial: Cell): List[Cell]
  protected def applyMoves(nthStep: Int, moves: List[(Direction, Int)]): List[Cell => Cell] = {
    val nthStepTowardsDirection = increaseStepCount(_, nthStep)
    applyMoves(moves.map(nthStepTowardsDirection))
  }
  protected def applyMoves(moves: List[(Direction, Int)]) = {
    moves.map(findNthCellTowardsDirection)
  }

  private def increaseStepCount(directionAndStep: (Direction, Int), nthStep: Int) = {
    val (direction, step) = directionAndStep
    (direction, step * nthStep)
  }
  private def findNthCellTowardsDirection(directionAndStep: (Direction, Int)) = {
    val (direction, step) = directionAndStep
    direction.shiftTowardsBy(step)
  }
  protected def findNextPositions(initial: Cell, nextPositionsList: List[Cell => Cell]) = {
    nextPositionsList.map(nextCellOf => nextCellOf(initial))
  }
}