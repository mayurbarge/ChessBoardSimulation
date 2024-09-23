package com.chessboard.domain.validations

import com.chessboard.domain.{Board, Cell}

abstract class RestrictedMovesFilter {
  def run(currentPosition: Cell)(nextPosition: Cell): Boolean
}
case class BoundaryCheckAndSameCellCheckFilter(board: Board)
  extends RestrictedMovesFilter {
  def run(currentPosition: Cell)(nextPosition: Cell): Boolean = {
    (nextPosition.row >= 1 && nextPosition.row <= board.size.maxLength) &&
      (nextPosition.columnValue >= 1 && nextPosition.columnValue <= board.size.maxLength) && currentPosition != nextPosition
  }
}


