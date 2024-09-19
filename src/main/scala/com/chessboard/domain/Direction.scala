package com.chessboard.domain

trait Direction {
  val towardsBy: Int => Cell => Cell
}
case object East extends Direction {
  override val towardsBy: Int => Cell => Cell =
    (steps: Int) => (previousPosition: Cell) => Cell(previousPosition.columnValue + steps, previousPosition.row)
}
case object West extends Direction {
  override val towardsBy: Int => Cell => Cell =
    (steps: Int) => (previousPosition: Cell) => Cell(previousPosition.columnValue - steps, previousPosition.row)
}
case object North extends Direction {
  override val towardsBy: Int => Cell => Cell =
    (steps: Int) => (previousPosition: Cell) => Cell(previousPosition.columnValue, previousPosition.row + steps)
}
case object South extends Direction {
  override val towardsBy: Int => Cell => Cell =
    (steps: Int) => (previousPosition: Cell) => Cell(previousPosition.columnValue, previousPosition.row - steps)
}
case object NorthEast extends Direction {
  override val towardsBy: Int => Cell => Cell =
    (steps: Int) => North.towardsBy(steps) andThen East.towardsBy(steps)
}
case object SouthEast extends Direction {
  override val towardsBy: Int => Cell => Cell =
    (steps: Int) => South.towardsBy(steps) andThen East.towardsBy(steps)
}
case object NorthWest extends Direction {
  override val towardsBy: Int => Cell => Cell =
    (steps: Int) => North.towardsBy(steps) andThen West.towardsBy(steps)
}
case object SouthWest extends Direction {
  override val towardsBy: Int => Cell => Cell =
    (steps: Int) => South.towardsBy(steps) andThen West.towardsBy(steps)
}
