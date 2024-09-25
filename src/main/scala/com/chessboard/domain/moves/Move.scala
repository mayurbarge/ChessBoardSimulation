package com.chessboard.domain.moves

import com.chessboard.domain.Direction
import com.chessboard.domain.board.Cell

trait Move {
  def shift(nthStep: Int, initial: Cell): List[Cell]

  def shiftConditional(nthStep: Int, initial: Cell, condition: Cell => Boolean): List[Cell] = {
    val nextPositions = shift(nthStep, initial)
    nextPositions.filter(condition(_))
  }
  protected def applyMoves(moves: List[(Direction, Int)]) = {
    moves.map(findNthCellTowardsDirection)
  }

  private def findNthCellTowardsDirection(directionAndStep: (Direction, Int)) = {
    val (direction, step) = directionAndStep
    direction.shiftTowardsBy(step)
  }

}