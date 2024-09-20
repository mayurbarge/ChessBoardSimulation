package com.chessboard.domain.pieces

import com.chessboard.domain.Cell
import com.chessboard.domain.moves.Move

case class Queen(allowedMoves: List[Move], reachableCellsLimit: Int) extends Piece with MultiStepPiece {
  override val stepType: StepType = MultiStep
}
