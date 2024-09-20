package com.chessboard.domain

trait Direction {
  def shiftTowardsBy(steps: Int): Cell => Cell
}
case object East extends Direction {
  override def shiftTowardsBy(steps: Int): Cell => Cell =
    (currentCell: Cell) => Cell(currentCell.columnValue + steps, currentCell.row)
}
case object West extends Direction {
  override def shiftTowardsBy(steps: Int): Cell => Cell =
    (currentCell: Cell) => Cell(currentCell.columnValue - steps, currentCell.row)
}
case object North extends Direction {
  override def shiftTowardsBy(steps: Int): Cell => Cell =
    (currentCell: Cell) => Cell(currentCell.columnValue, currentCell.row + steps)
}
case object South extends Direction {
  override def shiftTowardsBy(steps: Int): Cell => Cell =
    (currentCell: Cell) => Cell(currentCell.columnValue, currentCell.row - steps)
}
case object NorthEast extends Direction {
  override def shiftTowardsBy(steps: Int): Cell => Cell =
    North.shiftTowardsBy(steps) andThen East.shiftTowardsBy(steps)
}
case object SouthEast extends Direction {
  override def shiftTowardsBy(steps: Int): Cell => Cell =
    South.shiftTowardsBy(steps) andThen East.shiftTowardsBy(steps)
}
case object NorthWest extends Direction {
  override def shiftTowardsBy(steps: Int): Cell => Cell =
    North.shiftTowardsBy(steps) andThen West.shiftTowardsBy(steps)
}
case object SouthWest extends Direction {
  override def shiftTowardsBy(steps: Int): Cell => Cell =
    South.shiftTowardsBy(steps) andThen West.shiftTowardsBy(steps)
}
