package com.chessboard.domain.pieces

import com.chessboard.domain.Cell
import com.chessboard.domain.validations.CellFilters

trait MultiStepPiece extends Piece with CellFilters {
  val reachableCellsLimit: Int
  override def allPossibleMoves(currentPosition: Cell): List[Cell] = {
    (1 to reachableCellsLimit)
      .flatMap(possibleMovesAtPositionWithFilter(_, currentPosition, filterCondition(_, currentPosition))).toList
  }
}
