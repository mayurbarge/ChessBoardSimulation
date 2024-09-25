package com.chessboard.domain.board

case class Cell(column: Char, row: Int) {
  def cellNumber = (columnValue, row)

  val columnValue = column - 64

  override def toString: String = column.toString + row.toString
}
object Cell {
  def apply(column: Int, row: Int): Cell = Cell((column+64).toChar, row)
}
