package com.chessboard.domain.moves

import com.chessboard.domain._
trait MoveWithRegularDirections extends Move {
  val directionsAllowedForMove: List[Direction]
  def shift(nthStep: Int, initial: Cell) = {
    val nextPositionsList = applyMoves(directionsAllowedForMove.map((_, nthStep)))
    findNextPositions(initial, nextPositionsList)
  }
}