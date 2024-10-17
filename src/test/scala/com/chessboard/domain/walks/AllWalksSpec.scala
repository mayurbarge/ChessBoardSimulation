package com.chessboard.domain.walks

import com.chessboard.domain.board.Cell
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AllWalksSpec extends AnyFunSpec with Matchers {

  /*describe("All Walks") {
    it("should move a piece at E4 by 1 place to reach D3, E3, F3, D4, F4, D5, F5 and E5") {
      AllWalks.startWalk(1, Cell('E', 4)) should contain theSameElementsAs List( Cell('D', 3), Cell('E', 3), Cell('F',3),
        Cell('D', 4), Cell('F', 4), Cell('D', 5), Cell('F', 5), Cell('E', 5))
    }

    it("should move a piece at E4 by 2 places to reach C2, E2, G2, C4, G4, C6, E6, G6") {
      AllWalks.startWalk(2, Cell('E', 4)) should contain theSameElementsAs
        List( Cell('C', 2), Cell('E', 2), Cell('G', 2),
          Cell('C', 4), Cell('G', 4),
          Cell('C', 6), Cell('E', 6), Cell('G', 6),
          )
    }
  }*/
}
