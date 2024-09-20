package com.chessboard.domain.pieces

import com.chessboard.domain.{Cell, ValidatedCell}

trait SingleStepPiece extends Piece {
  override def allPossibleMoves(currentPosition: Cell): List[Cell] = {
    allSingleStepPossibleMoves(currentPosition)
  }
  def allSingleStepPossibleMoves(currentPosition: Cell): List[Cell] = {
    def filterCondition(cellToCheck: Cell) =
      ValidatedCell(cellToCheck).isValid && currentPosition != cellToCheck

    possibleMovesAtPositionWithFilter(1, currentPosition, filterCondition)
  }
}
