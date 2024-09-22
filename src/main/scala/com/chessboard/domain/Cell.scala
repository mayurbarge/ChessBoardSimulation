package com.chessboard.domain

import cats.data.Validated
import com.chessboard.domain.validations.CellValidations
import com.chessboard.domain.validations.CellValidations.validateCell
import com.chessboard.errors.InvalidCellException

sealed case class Cell(column: Char, row: Int) {
  def cellNumber = (columnValue, row)

  val columnValue = column - 64

}
object Cell {
  def apply(column: Int, row: Int): Cell = Cell((column+64).toChar, row)
}
class ValidatedCell[E, T] private(override val column: Char, override val row: Int) extends Cell(column, row)
object ValidatedCell {
  def apply(column: Char, row: Int, boardSize: BoardSize) = {
      val cell = Cell(column, row)
      validateCell(cell, boardSize)
  }
  def apply(cell:Cell, boardSize: BoardSize) = {
    validateCell(cell, boardSize)
  }
  private def validateCell(cell: Cell, boardSize: BoardSize) = {
    if (CellValidations.validateCell(cell, boardSize)) {
      Validated.valid(cell)
    } else Validated.invalid(InvalidCellException())
  }
}
