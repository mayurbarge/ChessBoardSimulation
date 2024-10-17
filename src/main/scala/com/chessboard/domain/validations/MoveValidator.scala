package com.chessboard.domain.validations

import com.chessboard.domain.board.{Board, Cell}
trait MoveValidator {
  def run(position: Cell): Boolean
}

object MoveValidator {
  def validateMoves(nextPosition: Cell, previousPosition: Option[Cell], filters: List[MoveValidator]) = {
    filters.map {
      case checkOpponentPiecesFilter: CheckOpponentPiecesFilter if previousPosition.isDefined => checkOpponentPiecesFilter.run(previousPosition.get)
      case boundaryCheckFilter: BoundaryCheckAndSameCellCheckFilter => boundaryCheckFilter.run(nextPosition)
      case _ => true
    }.reduce(_ && _)
  }
}