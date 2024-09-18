package com.chessboard.domain

trait Direction {
  val transformBy:(Int, Cell) => Cell
}
case object East extends Direction {
  override val transformBy: (Int, Cell) => Cell =
    (steps: Int, previousPosition: Cell) => Cell(previousPosition.columnValue, previousPosition.row + steps)
}
case object West extends Direction {
  override val transformBy: (Int, Cell) => Cell =
    (steps: Int, previousPosition: Cell) => Cell(previousPosition.columnValue, previousPosition.row - steps)
}
case object North extends Direction {
  override val transformBy: (Int, Cell) => Cell =
    (steps: Int, previousPosition: Cell) => Cell(previousPosition.columnValue + steps, previousPosition.row)
}
case object South extends Direction {
  override val transformBy: (Int, Cell) => Cell =
    (steps: Int, previousPosition: Cell) => Cell(previousPosition.columnValue - steps, previousPosition.row)
}
case object NorthEast extends Direction {
  override val transformBy: (Int, Cell) => Cell =
    (steps: Int, previousPosition: Cell) => Cell(previousPosition.columnValue + steps, previousPosition.row + steps)
}
case object SouthEast extends Direction {
  override val transformBy:(Int, Cell) => Cell =
    (steps: Int, previousPosition: Cell) => Cell(previousPosition.columnValue - steps, previousPosition.row + steps)
}
case object NorthWest extends Direction {
  override val transformBy: (Int, Cell) => Cell =
    (steps: Int, previousPosition: Cell) => Cell(previousPosition.columnValue - steps, previousPosition.row + steps)
}
case object SouthWest extends Direction {
  override val transformBy: (Int, Cell) => Cell =
    (steps: Int, previousPosition: Cell) => Cell(previousPosition.columnValue - steps, previousPosition.row - steps)
}
