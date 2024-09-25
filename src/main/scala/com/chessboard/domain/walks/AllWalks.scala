package com.chessboard.domain.walks

import com.chessboard.domain.moves.{Move, MoveDirections, SimpleMove}

case object AllWalks extends Walk {
  override def allowedMoves: List[Move] = MoveDirections.all.map(SimpleMove(_, 1))
}
