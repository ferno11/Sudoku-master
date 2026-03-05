package com.yourorg.sudukomasterf.core.solver

import com.yourorg.sudukomasterf.core.board.Board
import com.yourorg.sudukomasterf.core.model.Position
import com.yourorg.sudukomasterf.core.validation.BoardValidator
import com.yourorg.sudukomasterf.core.model.Cell
import com.yourorg.sudukomasterf.core.solver.SolverUtils



class SudokuSolver{ //backtracking
    fun solve(board: Board): Board?{
        val empty = SolverUtils.findEmpty(board) ?: return board
        val size = board.size

        for(value in 1..size){
            if(BoardValidator.isvalidMove(board,empty,value)){
                val newBoard = board.setCell(empty, Cell(value, false))
                val solved = solve(newBoard)
                if(solved != null){
                    return solved
                }
            }
        }
        return null
    }
}