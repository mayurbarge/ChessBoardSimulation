package com.chessboard.domain.pieces

import com.chessboard.domain.validations.{CellFilters}
import com.chessboard.domain.{Cell, ValidatedCell}

trait SingleStepPiece extends Piece with CellFilters {
  override def allPossibleMoves(currentPosition: Cell): List[Cell] = {
    allSingleStepPossibleMoves(currentPosition)
  }
  def allSingleStepPossibleMoves(currentPosition: Cell): List[Cell] = {
    possibleMovesAtPositionWithFilter(1, currentPosition, filterCondition(_, currentPosition))
  }
}
