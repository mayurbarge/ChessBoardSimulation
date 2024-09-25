package com.chessboard.domain.pieces

import com.chessboard.domain.board.{Board, BoardSize, Cell}
import com.chessboard.domain.validations.{BoundaryCheckAndSameCellCheckFilter, RestrictedMovesFilter}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PieceSpec extends AnyFunSpec with Matchers {
  val validatedKing = Piece("King")
  val board = Board(BoardSize(8,8))

  describe("A Custom Piece") {
    describe("A Custom Piece") {
      it("at current position A1 should filter out invalid moves if allowed 1 step movement in all directions to give B1, A2, B2") {
        validatedKing.map(king => king.allMovesOnBoard(Cell('A', 1), board, BoundaryCheckAndSameCellCheckFilter(board)) should contain theSameElementsAs
          List(Cell('A', 2), Cell('B', 2), Cell('B', 1))
        )
      }
    }
  }

  describe("A Piece") {
    it("King is valid when input string 'King' is used to build the King instance") {
      validatedKing.isValid shouldBe true
    }

    it("Queen is valid when input string 'Queen' is used to build the King instance") {
      Piece("Queen").isValid shouldBe true
    }

    it("creation should fail with a message 'Invalid piece name passed in the input.'") {
      validatedKing.isValid shouldBe true
      validatedKing.leftMap(_.getLocalizedMessage shouldBe("Invalid piece name passed in the input."))
    }
  }
}
