package com.chessboard.domain.walks

import com.chessboard.domain.moves.CompositeMove

case class ComplexWalk(allowedMoves: List[CompositeMove]) extends Walk