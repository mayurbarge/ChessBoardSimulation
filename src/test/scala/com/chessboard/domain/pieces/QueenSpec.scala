package com.chessboard.domain.pieces

import com.chessboard.domain.{Board, BoardSize, Cell}
import com.chessboard.domain.moves.{DiagonalMove, HorizontalMove, MoveDirections, VerticalMove}
import com.chessboard.domain.validations.{BoundaryCheckAndSameCellCheckFilter, RestrictedMovesFilter}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class QueenSpec extends AnyFunSpec with Matchers {
  val queenMoves = List(HorizontalMove, VerticalMove, DiagonalMove)
  val queen = Queen(queenMoves)
  val board = Board(BoardSize(8,8))
  val moveRestrictions = BoundaryCheckAndSameCellCheckFilter(board)

  describe("A Queen") {
    it("should move in all directions by in multiple steps to cover valid 27 cells") {
      queen.allMovesOnBoard(Cell('E', 4), board, moveRestrictions) should contain theSameElementsAs
        List(
          Cell('E', 1), Cell('E', 2), Cell('E', 3),
          Cell('A', 4), Cell('B', 4), Cell('C', 4), Cell('D', 4),
          Cell('F', 4), Cell('G', 4), Cell('H', 4),
          Cell('E', 5), Cell('E', 6), Cell('E', 7), Cell('E', 8),
          Cell('B', 1), Cell('C', 2), Cell('D', 3),
          Cell('F', 5), Cell('G', 6), Cell('H', 7),
          Cell('A', 8), Cell('B', 7), Cell('C', 6), Cell('D', 5),
          Cell('F', 3), Cell('G', 2), Cell('H', 1)
        )
    }

    it("should move in North, East and NorthEast directions from A1 cell to cover A2 to A8 vertical, A1 to H8 diagonal and A2 to H1 horizontal moves") {
      queen.allMovesOnBoard(Cell('A', 1), board, moveRestrictions).sortBy(_.row) should contain theSameElementsAs
        List(
          Cell('A', 2), Cell('A', 3), Cell('A', 4), Cell('A', 5), Cell('A', 6), Cell('A', 7), Cell('A', 8),
          Cell('B', 2), Cell('C', 3), Cell('D', 4), Cell('E', 5), Cell('F', 6), Cell('G', 7), Cell('H', 8),
          Cell('B', 1), Cell('C', 1), Cell('D', 1), Cell('E', 1), Cell('F', 1), Cell('G', 1), Cell('H', 1)
        ).sortBy(_.row)
    }
  }
}
