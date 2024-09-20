package com.chessboard.domain.pieces

import com.chessboard.domain.moves._
import com.chessboard.domain.{Cell, ValidatedCell}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PieceSpec extends AnyFunSpec with Matchers {
  describe("A Custom Piece") {
    it("at current position E2 and allowed move in East by 1 place should return possible moves D2 and F2") {
      val customPiece = new SingleStepPiece {
        override val stepType = SingleStep
        override val allowedMoves: List[Move] = List(HorizontalMove)
      }
      customPiece.possibleMovesAtPosition(1, Cell('E', 2)) should contain theSameElementsAs List(Cell('D', 2), Cell('F', 2))
    }
  }

  describe("A Custom Piece") {
    it("at current position A1 should filter out invalid moves if allowed 1 step movement in all directions to give B1, A2, B2") {
      val king = King(List(HorizontalMove, VerticalMove, DiagonalMove))
      king.possibleMovesAtPositionWithFilter(1, Cell('A', 1), ValidatedCell(_).isValid) should contain theSameElementsAs
        List(Cell('A', 2), Cell('B', 2), Cell('B', 1))
    }
  }

}
