package com.chessboard.domain.pieces

import com.chessboard.domain.validations.MoveRestriction
import com.chessboard.domain.{Board, BoardSize, Cell}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PieceSpec extends AnyFunSpec with Matchers {
  val king = Piece("King")
  val board = Board(BoardSize(8,8))

  describe("A Custom Piece") {
    describe("A Custom Piece") {
      it("at current position A1 should filter out invalid moves if allowed 1 step movement in all directions to give B1, A2, B2") {
        king.map(_.allMovesOnBoard(Cell('A', 1), board, new MoveRestriction {}) should contain theSameElementsAs
          List(Cell('A', 2), Cell('B', 2), Cell('B', 1))
        )
      }
    }
  }

  describe("A Piece") {
    it("King is valid when input string 'King' is used to build the King instance") {
      king.isValid shouldBe true
    }

    it("Queen is valid when input string 'Queen' is used to build the King instance") {
      Piece("Queen").isValid shouldBe true
    }

    it("creation should fail with a message 'Invalid piece name passed in the input.'") {
      king.isValid shouldBe true
      king.leftMap(_.getLocalizedMessage shouldBe("Invalid piece name passed in the input."))
    }
  }
}
