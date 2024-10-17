package com.chessboard.domain.walks

import com.chessboard.domain.board.{Board, BoardSize, Cell}
import com.chessboard.domain.validations.BoundaryCheckAndSameCellCheckFilter
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class DiagonalWalkSpec extends AnyFunSpec with Matchers {
  val boundaryCheckFilter = List(BoundaryCheckAndSameCellCheckFilter(Board(BoardSize(8,8))))

  describe("A Diagonal Walk") {
    it("should find all possible diagonal moves when current position is E4") {
      DiagonalWalk.startWalkAndCheckRestrictedMoves(8, Cell('E', 4), boundaryCheckFilter) should contain theSameElementsAs
        List(Cell('B', 1), Cell('C', 2), Cell('D', 3), Cell('F', 5), Cell('G', 6), Cell('H', 7),
          Cell('A', 8), Cell('B', 7), Cell('C', 6), Cell('D', 5), Cell('F', 3), Cell('G', 2), Cell('H', 1))
    }
  }

}