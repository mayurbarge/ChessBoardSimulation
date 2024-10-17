package com.chessboard.domain.validations

import com.chessboard.domain.board.{Board, Cell}

case class BoundaryCheckAndSameCellCheckFilter(board: Board)
  extends MoveValidator {
  def run(position: Cell): Boolean = {
    CellValidations.validateCell(position, board.size) //&& previousPosition != nextPosition
  }

}