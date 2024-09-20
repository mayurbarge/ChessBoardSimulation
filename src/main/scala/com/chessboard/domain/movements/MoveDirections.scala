package com.chessboard.domain.movements

import com.chessboard.domain.{Direction, East, North, NorthEast, NorthWest, South, SouthEast, SouthWest, West}

object MoveDirections {
  val horizontal: List[Direction] = List(East, West)
  val vertical: List[Direction] = List(North, South)
  val diagonal: List[Direction] = List(NorthEast, NorthWest, SouthEast, SouthWest)
  val all: List[Direction] = horizontal ::: vertical ::: diagonal
}
