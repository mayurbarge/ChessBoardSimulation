package com.chessboard.domain.movements

import cats.kernel.{Monoid, Semigroup}
import com.chessboard.domain.{Cell, Direction, East, North, NorthEast, NorthWest, South, SouthEast, SouthWest, West}

/*case class DirectionalMove(direction: Direction, steps: Int)
case object DirectionalMove {
  implicit val directionalMoveSemigroup = new Semigroup[DirectionalMove] {

    override def combine(x: DirectionalMove, y: DirectionalMove): DirectionalMove =
      x.direction.towardsBy(x.steps) andThen y.direction.towardsBy(y.steps)
  }
}*/
sealed trait Movement {
  def towards: Int => List[Cell => Cell]
}
case object HorizontalMovement extends Movement {
  val towards = (steps: Int) => List(East.towardsBy(steps), West.towardsBy(steps))
}
case object VerticalMovement extends Movement {
  val towards = (steps: Int) => List(North.towardsBy(steps), South.towardsBy(steps))
}
case object DiagonalMovement extends Movement {
  val towards = (steps: Int) => List(NorthEast.towardsBy(steps), NorthWest.towardsBy(steps),
                                  SouthEast.towardsBy(steps), SouthWest.towardsBy(steps))
}
object Movement {
  def buildComplexMove(directions: List[(Direction, Int)]) = {
    val cellsAfterApplicationOfSteps = directions.map(directionAndStep => {
      val (direction, step) = directionAndStep
      direction.towardsBy(step)
    })

    val combinedResult: Cell => Cell = cellsAfterApplicationOfSteps.reduce(_ andThen _)
    combinedResult
  }

}
