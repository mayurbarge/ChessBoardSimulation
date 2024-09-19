package com.chessboard.domain

import com.chessboard.domain.validations.CellValidations

sealed case class Cell(column: Char, row: Int) {
  def cellNumber = (columnValue, row)

  val columnValue = column - 64

}
object Cell {
  def apply(column: Int, row: Int): Cell = Cell((column+64).toChar, row)
}
class ValidatedCell[E, T] private(override val column: Char, override val row: Int) extends Cell(column, row)
object ValidatedCell {
  def apply(column: Char, row: Int) = {
    CellValidations.validateCell(new ValidatedCell(column, row))
  }
  def apply(cell: Cell) = {
    CellValidations.validateCell(cell)
  }
}