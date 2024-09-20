package com.chessboard.domain.moves
import com.chessboard.domain.{Cell, Direction}

case object AllMoves extends MoveWithRegularDirections {
  override val directionsAllowedForMove: List[Direction] = MoveDirections.all
}
