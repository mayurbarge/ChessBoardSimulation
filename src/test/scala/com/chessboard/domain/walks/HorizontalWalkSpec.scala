package com.chessboard.domain.walks

import com.chessboard.domain.board.Cell
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class HorizontalWalkSpec extends AnyFunSpec with Matchers {
  describe("A Horizontal move") {
    describe("With Single Step") {
      it("should reach at C3, E3 when current position is D3 in one step") {
        HorizontalWalk.startWalk(1, Cell('D', 3)) should contain theSameElementsAs List(Cell('C', 3), Cell('E', 3))
      }
    }

    describe("With Multiple Step") {
      it("should reach at B3, F3 when current position is D3 in 2 steps") {
        HorizontalWalk.startWalk(2, Cell('D', 3)) should contain theSameElementsAs List(Cell('B', 3), Cell('F', 3))
      }
    }
  }

}
