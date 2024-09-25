package com.chessboard.domain.walks

import com.chessboard.domain.moves.{Move, MoveDirections, SimpleMove}

case object DiagonalWalk extends Walk {
  override def allowedMoves: List[Move] = MoveDirections.diagonal.map(SimpleMove(_, 1))
}