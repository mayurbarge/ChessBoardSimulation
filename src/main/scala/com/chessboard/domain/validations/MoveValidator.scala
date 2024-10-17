package com.chessboard.domain.validations

import com.chessboard.domain.board.{Board, Cell}
trait MoveValidator {
  def run(previousPosition: Cell)(nextPosition: Cell): Boolean
}

object MoveValidator {
  def validateMoves(initial: Cell, nextPosition: Cell, previousPosition: Option[Cell], filters: List[MoveValidator]) = {
    filters.map {
      case checkOpponentPiecesFilter: CheckOpponentPiecesFilter if previousPosition.isDefined => checkOpponentPiecesFilter.run(previousPosition.get)(nextPosition)
      case boundaryCheckFilter: BoundaryCheckAndSameCellCheckFilter => boundaryCheckFilter.run(initial)(nextPosition)
      case _ => true
    }.reduce(_ && _)
  }
}