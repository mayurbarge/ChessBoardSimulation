package com.chessboard.domain.moves

import com.chessboard.domain.Direction

case object DiagonalMove extends Move with MoveWithRegularDirections {
  val directionsAllowedForMove: List[Direction] = MoveDirections.diagonal
}
