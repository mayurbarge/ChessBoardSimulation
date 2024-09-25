package com.chessboard.domain.moves

import com.chessboard.domain._
import com.chessboard.domain.board.Cell
trait MoveWithRegularDirections extends Move {
  val directionsAllowedForMove: List[Direction]
  def shift(nthStep: Int, initial: Cell) = {
    val nextPositionsList = applyMoves(directionsAllowedForMove.map((_, nthStep)))
    nextPositionsList.map(_(initial))
  }
}