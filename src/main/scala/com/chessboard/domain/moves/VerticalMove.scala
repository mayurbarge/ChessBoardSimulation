package com.chessboard.domain.moves

case object VerticalMove extends Move with MoveWithRegularDirections {
  val directionsAllowedForMove = MoveDirections.vertical
}