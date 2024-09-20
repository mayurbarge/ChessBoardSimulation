package com.chessboard.domain.moves

case object HorizontalMove extends Move with MoveWithRegularDirections {
  val directionsAllowedForMove = MoveDirections.horizontal
}