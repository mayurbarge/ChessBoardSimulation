package com.chessboard.domain.validations

import com.chessboard.domain.{Cell, ValidatedCell}

trait MoveRestriction {
  def isMoveAllowed(cell: Cell*): Boolean = {
    ValidatedCell(cell.head).isValid && cell.last != cell.head &&
      cell.head != cell.last
  }
}