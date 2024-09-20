package com.chessboard.domain.validations

import com.chessboard.domain.{Cell, ValidatedCell}

trait CellFilters {
  def filterCondition(cell: Cell*): Boolean = {
    ValidatedCell(cell.head).isValid && cell.last != cell.head
  }
}