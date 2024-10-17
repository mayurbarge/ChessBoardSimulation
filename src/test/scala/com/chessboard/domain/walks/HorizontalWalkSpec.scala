package com.chessboard.domain.walks

import com.chessboard.domain.board.{Board, BoardSize, Cell}
import com.chessboard.domain.validations.BoundaryCheckAndSameCellCheckFilter
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class HorizontalWalkSpec extends AnyFunSpec with Matchers {
  val boundaryCheckFilter = List(BoundaryCheckAndSameCellCheckFilter(Board(BoardSize(8,8))))

  describe("A Horizontal move") {
      it("should find all possible horizontal positions when current position is D3") {
        HorizontalWalk.startWalkAndCheckRestrictedMoves(8, Cell('D', 3), boundaryCheckFilter) should contain theSameElementsAs
          List(Cell('A', 3), Cell('B', 3), Cell('C', 3), Cell('E', 3), Cell('F', 3), Cell('G', 3), Cell('H', 3))
      }
    }
}
