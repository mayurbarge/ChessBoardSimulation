package com.chessboard.domain.moves

case object DiagonalMove extends Move with MoveWithRegularDirections {
  val directionsAllowedForMove = MoveDirections.diagonal
}
