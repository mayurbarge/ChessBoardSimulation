package com.chessboard.domain.moves
import com.chessboard.domain.Direction

case object AllMoves extends MoveWithRegularDirections {
  override val directionsAllowedForMove: List[Direction] = MoveDirections.all
}
