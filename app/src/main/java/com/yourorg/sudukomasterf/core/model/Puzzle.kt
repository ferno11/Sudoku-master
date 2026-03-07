package com.yourorg.sudukomasterf.core.model
import com.yourorg.sudukomasterf.core.board.Board

data class Puzzle (
    val initialBoard: Board,
    val solutionBoard: Board,
)