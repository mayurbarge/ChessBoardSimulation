package com.chessboard.domain.walks

import com.chessboard.domain.moves.{Move, MoveDirections, SimpleMove}

case object VerticalWalk extends Walk {
  override def allowedMoves: List[Move] = MoveDirections.vertical.map(SimpleMove(_, 1))
}