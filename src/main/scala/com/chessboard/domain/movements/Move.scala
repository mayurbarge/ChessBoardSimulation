package com.chessboard.domain.movements

import com.chessboard.domain._


sealed trait Move {
  def shift(steps: Int, initial: Cell): List[Cell]
}
case object HorizontalMove extends Move {
  def shift(steps: Int, initial: Cell) = List(East.towardsBy(steps)(initial), West.towardsBy(steps)(initial))
}
case object VerticalMove extends Move {
  def shift(steps: Int, initial: Cell) = List(North.towardsBy(steps)(initial), South.towardsBy(steps)(initial))
}
case object DiagonalMove extends Move {
  def shift(steps: Int, initial: Cell) = List(NorthEast.towardsBy(steps)(initial),
                              NorthWest.towardsBy(steps)(initial),
                              SouthEast.towardsBy(steps)(initial),
                              SouthWest.towardsBy(steps)(initial))
}
object Move {
  def buildComplexMove(directions: List[(Direction, Int)]) = {
    val cellsAfterApplicationOfSteps = directions.map(directionAndStep => {
      val (direction, step) = directionAndStep
      direction.towardsBy(step)
    })

    val combinedResult: Cell => Cell = cellsAfterApplicationOfSteps.reduce(_ andThen _)
    combinedResult
  }

}
