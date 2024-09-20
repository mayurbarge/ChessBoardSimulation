package com.chessboard.domain.movements

import com.chessboard.domain._
sealed trait Move {
  def shift(steps: Int, initial: Cell): List[Cell]
  def applyMoves(moves: List[(Direction, Int)]) = {
    moves.map(directionAndStep => {
      val (direction, step) = directionAndStep
      direction.towardsBy(step)
    })
  }
}
case object HorizontalMove extends Move {
  def shift(steps: Int, initial: Cell) = {
    super.applyMoves(List((East, steps), (West, steps))).map(f => f(initial))
  }
}
case object VerticalMove extends Move {
  def shift(steps: Int, initial: Cell) = {
    super.applyMoves(List((North, steps), (South, steps))).map(f => f(initial))
  }
}

case object DiagonalMove extends Move {
  def shift(steps: Int, initial: Cell) = {
    super.applyMoves(List((
      NorthEast, steps),
      (NorthWest, steps),
      (SouthEast, steps),
      (SouthWest, steps))).map(f => f(initial))
  }
}
case class ComplexMove(complexMoves: List[List[(Direction, Int)]]) extends Move {
  def sequenceMovesInLine(moves: List[Cell => Cell]): Cell => Cell = moves.reduce(_ andThen _)
  override def shift(steps: Int, initial: Cell): List[Cell] = {
    complexMoves.map(moves =>
      sequenceMovesInLine(super.applyMoves(moves.map(
        directionAndStep => (directionAndStep._1, directionAndStep._2 * steps))))
    ).map(f => f(initial))
  }
}
