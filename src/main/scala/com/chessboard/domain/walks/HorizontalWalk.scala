package com.chessboard.domain.walks

import com.chessboard.domain.moves.{Move, MoveDirections, SimpleMove}

case object HorizontalWalk extends Walk {
  override def allowedMoves: List[Move] = MoveDirections.horizontal.map(SimpleMove(_, 1))
}