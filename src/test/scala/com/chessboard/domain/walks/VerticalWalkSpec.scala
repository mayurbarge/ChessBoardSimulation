package com.chessboard.domain.walks

import com.chessboard.domain.board.{Board, BoardSize, Cell}
import com.chessboard.domain.validations.BoundaryCheckAndSameCellCheckFilter
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class VerticalWalkSpec extends AnyFunSpec with Matchers {
  val boundaryCheckFilter = List(BoundaryCheckAndSameCellCheckFilter(Board(BoardSize(8,8))))

  describe("A Vertical Walk") {
    it("should move a piece D3 by 2 place to reach ") {
      VerticalWalk.startWalkAndCheckRestrictedMoves(8, Cell('D', 3), boundaryCheckFilter) should contain theSameElementsAs
        List(Cell('D', 1), Cell('D', 2), Cell('D', 4), Cell('D', 5), Cell('D', 6), Cell('D', 7), Cell('D', 8))
    }
  }

}