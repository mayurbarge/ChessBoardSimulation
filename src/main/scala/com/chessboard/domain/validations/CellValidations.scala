package com.chessboard.domain.validations

import com.chessboard.domain.{BoardSize, Cell}

trait CellValidations {
  def validateCell(current: Cell, boardSize: BoardSize): Boolean = {
      (current.row >= 1 && current.row <= boardSize.maxLength) &&
        (current.columnValue >= 1 && current.columnValue <= boardSize.maxLength)
  }
}
object CellValidations extends CellValidations