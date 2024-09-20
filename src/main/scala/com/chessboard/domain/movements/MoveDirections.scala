package com.chessboard.domain.movements

import com.chessboard.domain.{East, North, NorthEast, NorthWest, South, SouthEast, SouthWest, West}

object MoveDirections {
  val horizontal = List(East, West)
  val vertical = List(North, South)
  val diagonal = List(NorthEast, NorthWest, SouthEast, SouthWest)
  val all = horizontal ::: vertical ::: diagonal
}
