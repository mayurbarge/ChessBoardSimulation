package com.chessboard.domain.validations

import com.chessboard.domain.{Board, BoardSize, Cell}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class RestrictedMovesFilterSpec extends AnyFunSpec with Matchers {

  val board = Board(BoardSize(8,8))

  describe("A Restricted Move Filter") {
    describe("A BoundaryChecksFilter Filter") {
      it("should return false when calculated cell is invalid") {
        BoundaryCheckAndSameCellCheckFilter(board).run(Cell('H', 8))(Cell('H', 9)) shouldBe false
      }

      it("should return false when cell to filter and current cell is same") {
        BoundaryCheckAndSameCellCheckFilter(board).run(Cell('A', 1))(Cell('A', 1)) shouldBe false
      }

      it("should return true when cell is within the bounds of board and not same as the cell to filter") {
        BoundaryCheckAndSameCellCheckFilter(board).run(Cell('A', 1))(Cell('A', 2)) shouldBe true
      }
    }
  }
}
