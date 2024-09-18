package com.chessboard.domain

import com.chessboard.domain.validations.CellValidations

case class Cell(column: Char, row: Int) {
  def cellNumber = (columnValue, row)

  val columnValue = column - 64

}
object Cell {
  def apply(column: Int, row: Int): Cell = Cell((column+64).toChar, row)
}