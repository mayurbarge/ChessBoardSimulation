package com.chessboard.domain.validations

import com.chessboard.domain.board.{Board, Cell}

case class BoundaryCheckAndSameCellCheckFilter(board: Board)
  extends MoveValidator {
  def run(previousPosition: Cell)(nextPosition: Cell): Boolean = {
    CellValidations.validateCell(nextPosition, board.size) && previousPosition != nextPosition
  }
}