package com.chessboard.domain.walks

import com.chessboard.domain._
import com.chessboard.domain.board.Cell
import com.chessboard.domain.moves.{CompositeMove, Move, SimpleMove}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ComplexWalkSpec extends AnyFunSpec with Matchers {
  describe("A SingleStep Complex Walk") {
    it("should calculate a move at E5 from combination of 2 East and 3 South steps in succession to reach at G2") {
      val complexMoves = CompositeMove(List(SimpleMove(East, 2), SimpleMove(South, 3)))
      ComplexWalk(List(complexMoves)).startWalk(1, Cell('E', 5)) shouldBe List(Cell('G', 2))
    }

    it("should return the same position for a circular path") {
      val complexMoves = List(CompositeMove(
        List(SimpleMove(North, 2), SimpleMove(East, 2), SimpleMove(South, 2), SimpleMove(West, 2))))
      ComplexWalk(complexMoves).startWalk(1, Cell('E', 5)) shouldBe List(Cell('E', 5))
    }
  }

  describe("A multistep Complex Walk") {
    it("should calculate a move at A7 from combination of 1 East and 2 South in 2 steps to reach at G2") {
      val complexMoves = List(CompositeMove(List(SimpleMove(East, 1), SimpleMove(South, 2))))
      ComplexWalk(complexMoves).startWalk(2, Cell('A', 7)) shouldBe List(Cell('C', 3))
    }
  }
}
