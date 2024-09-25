package com.chessboard.domain.moves

import com.chessboard.domain.Direction
sealed trait Move
case class SimpleMove(direction: Direction, steps: Int) extends Move
case class CompositeMove(simpleMoves: List[SimpleMove]) extends Move