package com.chessboard.domain.board

import cats.data.Validated
import com.chessboard.domain.errors.InvalidCellException
import com.chessboard.domain.validations.CellValidations

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