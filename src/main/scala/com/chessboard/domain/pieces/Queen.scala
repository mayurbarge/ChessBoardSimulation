package com.chessboard.domain.pieces

import com.chessboard.domain.walks.Walk

case class Queen(allowedWalks: List[Walk]) extends Piece {
  override val stepType: StepType = MultiStep
}
