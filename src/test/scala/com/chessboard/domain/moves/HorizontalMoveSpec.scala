package com.chessboard.domain.moves

import com.chessboard.domain.board.Cell
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class HorizontalMoveSpec extends AnyFunSpec with Matchers {
  describe("A Horizontal move") {
    describe("With Single Step") {
      it("should reach at C3, E3 when current position is D3 in one step") {
        HorizontalMove.shift(1, Cell('D', 3)) should contain theSameElementsAs List(Cell('C', 3), Cell('E', 3))
      }
    }

    describe("With Multiple Step") {
      it("should reach at B3, F3 when current position is D3 in 2 steps") {
        HorizontalMove.shift(2, Cell('D', 3)) should contain theSameElementsAs List(Cell('B', 3), Cell('F', 3))
      }
    }
  }

}
