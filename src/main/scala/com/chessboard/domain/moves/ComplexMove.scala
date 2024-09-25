package com.chessboard.domain.moves

import com.chessboard.domain.Direction
import com.chessboard.domain.board.Cell

case class ComplexMove(complexMoves: List[List[(Direction, Int)]]) extends Move {
  override def shift(nthStep: Int, initial: Cell): List[Cell] = {
    val nextPositionsList = complexMoves.map(moves =>
      sequenceMultipleMovesIntoOne(applyMoves(nthStep, moves))
    )
    nextPositionsList.map(_(initial))
  }
  protected def applyMoves(nthStep: Int, moves: List[(Direction, Int)]): List[Cell => Cell] = {
    val nthStepTowardsDirection = increaseStepCount(_, nthStep)
    applyMoves(moves.map(nthStepTowardsDirection))
  }

  private def increaseStepCount(directionAndStep: (Direction, Int), nthStep: Int) = {
    val (direction, step) = directionAndStep
    (direction, step * nthStep)
  }
  def sequenceMultipleMovesIntoOne(moves: List[Cell => Cell]): Cell => Cell = moves.reduce(_ andThen _)
}