package com.chessboard.domain.pieces

import com.chessboard.domain.Cell
import com.chessboard.domain.moves.{DiagonalMove, HorizontalMove, VerticalMove}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class KingSpec extends AnyFunSpec with Matchers {
  describe("A King") {
    it("should move by one position at A1 to reach A2, B1, B2") {
      val king = King(List(HorizontalMove, VerticalMove, DiagonalMove))
      king.allPossibleMoves(Cell('A', 8)) should contain theSameElementsAs
        List(Cell('B', 8), Cell('A', 7), Cell('B', 7))
    }

    it("should move by one position at D5 to reach C4, D4, E4, C5, E5, C6, D6, E6") {
      val king = King(List(HorizontalMove, VerticalMove, DiagonalMove))
      king.allPossibleMoves(Cell('D', 5)) should contain theSameElementsAs
        List(
          Cell('C', 4), Cell('D', 4), Cell('E', 4),
          Cell('C', 5), Cell('E', 5),
          Cell('C', 6), Cell('D', 6), Cell('E', 6)
        )
    }

    it("should not move to invalid position and return H7, G7 and G8 when current position is H8 ") {
      val king = King(List(HorizontalMove, VerticalMove, DiagonalMove))
      king.allPossibleMoves(Cell('H', 8)) should contain theSameElementsAs
        List(
          Cell('H', 7), Cell('G', 7), Cell('G', 8)
        )
    }

    it("should not move to invalid position and return G1, G2 and H2 when current position is H1") {
      val king = King(List(HorizontalMove, VerticalMove, DiagonalMove))
      king.allPossibleMoves(Cell('H', 1)) should contain theSameElementsAs
        List(
          Cell('G', 1), Cell('G', 2), Cell('H', 2)
        )
    }
  }
}

