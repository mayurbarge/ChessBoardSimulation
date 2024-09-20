package com.chessboard.domain.moves

import com.chessboard.domain.Cell
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class HorizontalMoveSpec extends AnyFunSpec with Matchers {
  describe("A Horizontal move") {
    describe("With Single Step") {
      it("should move a piece D3 by 1 place to reach C3, E3") {
        HorizontalMove.shift(1, Cell('D', 3)) should contain theSameElementsAs List(Cell('C', 3), Cell('E', 3))
      }
    }

    describe("With Multiple Step") {
      it("should move a piece D3 by 2 places to reach B3, F3") {
        HorizontalMove.shift(2, Cell('D', 3)) should contain theSameElementsAs List(Cell('B', 3), Cell('F', 3))
      }
    }
  }

}
