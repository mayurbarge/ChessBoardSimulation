package com.chessboard.domain.pieces

import com.chessboard.domain.moves._
import com.chessboard.domain.validations.MoveRestriction
import com.chessboard.domain.{Board, BoardSize, Cell, ValidatedCell}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PieceSpec extends AnyFunSpec with Matchers {
  describe("A Custom Piece") {

    describe("A Custom Piece") {
      it("at current position A1 should filter out invalid moves if allowed 1 step movement in all directions to give B1, A2, B2") {
        val king = King(List(HorizontalMove, VerticalMove, DiagonalMove))
        king.possibleMovesAtPositionWithFilter(1, Cell('A', 1), ValidatedCell(_).isValid) should contain theSameElementsAs
          List(Cell('A', 2), Cell('B', 2), Cell('B', 1))
      }
    }
  }
}
