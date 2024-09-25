package com.chessboard.domain.pieces

import com.chessboard.domain.board.{Board, BoardSize, Cell}
import com.chessboard.domain.moves.{CompositeMove, SimpleMove}
import com.chessboard.domain.validations.BoundaryCheckAndSameCellCheckFilter
import com.chessboard.domain.walks.ComplexWalk
import com.chessboard.domain.{East, North, South, West}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class HorseSpec extends AnyFunSpec with Matchers {
  val horseWalks = List(ComplexWalk(
    List(
      CompositeMove(List(SimpleMove(North, 2), SimpleMove(East, 1))),
      CompositeMove(List(SimpleMove(North, 2), SimpleMove(West, 1))),

      CompositeMove(List(SimpleMove(South, 2), SimpleMove(East, 1))),
      CompositeMove(List(SimpleMove(South, 2), SimpleMove(West, 1))),

      CompositeMove(List(SimpleMove(East, 2), SimpleMove(North, 1))),
      CompositeMove(List(SimpleMove(East, 2), SimpleMove(South, 1))),

      CompositeMove(List(SimpleMove(West, 2), SimpleMove(North, 1))),
      CompositeMove(List(SimpleMove(West, 2), SimpleMove(South, 1))),
    )
  ))

  val horse = Horse(horseWalks)
  val board = Board(BoardSize(8,8))
  val moveRestrictions = BoundaryCheckAndSameCellCheckFilter(board)

  describe("A Horse") {
    it("should calculate horse moves from E4 to reach F6, D6, F2, D2, G5, G3, C5, C3") {
      horse.allMovesOnBoard(Cell('E', 4), board, moveRestrictions) should contain theSameElementsAs
        List(Cell('F',6), Cell('D',6), Cell('F',2), Cell('D',2), Cell('G',5), Cell('G',3), Cell('C',5), Cell('C',3))
    }

    it("should calculate horse moves from H1 to reach G3, F2") {
      horse.allMovesOnBoard(Cell('H', 1), board, moveRestrictions) should contain theSameElementsAs
        List(Cell('F',2), Cell('G', 3))
    }

    it("should calculate horse moves from H8 to reach F7, G6") {
      horse.allMovesOnBoard(Cell('H', 8), board, moveRestrictions) should contain theSameElementsAs
        List(Cell('F',7), Cell('G', 6))
    }
  }
}
