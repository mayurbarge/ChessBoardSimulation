package com.chessboard.domain.movements

sealed trait Step
case object SingleStep extends Step
case object MultiStep extends Step