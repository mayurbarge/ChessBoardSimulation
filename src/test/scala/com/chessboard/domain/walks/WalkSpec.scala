package com.chessboard.domain.walks

import com.chessboard.domain.{East, North, NorthEast, South}
import com.chessboard.domain.board.Cell
import com.chessboard.domain.moves.{CompositeMove, Move, SimpleMove}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class WalkSpec extends AnyFunSpec with Matchers {
  val walk = new Walk {
    override def allowedMoves: List[Move] = List()
  }

  describe("A Walk with simple move") {
    it("in East direction should return C2 when applied for a single step at position B2") {
      walk.startWalk(SimpleMove(East, 1), Cell('B', 2), 1) shouldBe Cell('C', 2)
    }

    it("in North direction should return D7 when applied for a 3 steps at position D4") {
      walk.startWalk(SimpleMove(North, 1), Cell('D', 4), 3) shouldBe Cell('D', 7)
    }
  }

  describe("A walk with composite move") {
    val complexMove = CompositeMove(List(SimpleMove(East, 2), SimpleMove(South, 3)))

    it("should return G1 when applied at E4 by moving towards east by 2 steps followed by south by 3 steps") {
      walk.startWalk(complexMove, Cell('E', 4), 1) shouldBe Cell('G', 1)
    }
  }
}