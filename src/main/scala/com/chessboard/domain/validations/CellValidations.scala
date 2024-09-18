package com.chessboard.domain.validations

import cats.data.Validated
import com.chessboard.domain.Cell
import com.chessboard.errors.InvalidCellException

sealed trait CellValidations {
  def validateCell(cell: Cell) = {
    if (isCellWithinColumnRange(cell.column) && isCellWithinRowRange(cell.row)) {
      Validated.Valid(cell)
    } else Validated.Invalid(InvalidCellException())
  }
  private def isCellWithinColumnRange(cellColumn: Char) = ('A' to 'H').contains(cellColumn)

  private def isCellWithinRowRange(cellRow: Int) = (1 to 8).contains(cellRow)
}

object CellValidations extends CellValidations

