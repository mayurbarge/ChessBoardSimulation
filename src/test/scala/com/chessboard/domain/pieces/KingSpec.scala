package com.chessboard.domain.pieces

import com.chessboard.domain.board.{Board, BoardSize, Cell}
import com.chessboard.domain.validations.BoundaryCheckAndSameCellCheckFilter
import com.chessboard.domain.walks.{DiagonalWalk, HorizontalWalk, VerticalWalk}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class KingSpec extends AnyFunSpec with Matchers {
  val king = King(List(HorizontalWalk, VerticalWalk, DiagonalWalk))

  val board = Board(BoardSize(8,8))
  val moveRestrictions = BoundaryCheckAndSameCellCheckFilter(board)

  describe("A King") {
    it("should move by one position at A1 to reach A2, B1, B2") {
      king.allMovesOnBoard(Cell('A', 8), board, List(moveRestrictions)) should contain theSameElementsAs
        List(Cell('B', 8), Cell('A', 7), Cell('B', 7))
    }

    it("should move by one position at D5 to reach C4, D4, E4, C5, E5, C6, D6, E6") {
      val king = King(List(HorizontalWalk, VerticalWalk, DiagonalWalk))
      king.allMovesOnBoard(Cell('D', 5), board, List(moveRestrictions)) should contain theSameElementsAs
        List(
          Cell('C', 4), Cell('D', 4), Cell('E', 4),
          Cell('C', 5), Cell('E', 5),
          Cell('C', 6), Cell('D', 6), Cell('E', 6)
        )
    }

    it("should not move to invalid position and return H7, G7 and G8 when current position is H8 ") {
      val king = King(List(HorizontalWalk, VerticalWalk, DiagonalWalk))
      king.allMovesOnBoard(Cell('H', 8), board, List(moveRestrictions)) should contain theSameElementsAs
        List(
          Cell('H', 7), Cell('G', 7), Cell('G', 8)
        )
    }

    it("should not move to invalid position and return G1, G2 and H2 when current position is H1") {
      val king = King(List(HorizontalWalk, VerticalWalk, DiagonalWalk))
      king.allMovesOnBoard(Cell('H', 1), board, List(moveRestrictions)) should contain theSameElementsAs
        List(
          Cell('G', 1), Cell('G', 2), Cell('H', 2)
        )
    }
  }
}

