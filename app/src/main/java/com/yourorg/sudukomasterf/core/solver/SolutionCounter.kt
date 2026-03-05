package com.yourorg.sudukomasterf.core.solver

import com.yourorg.sudukomasterf.core.board.Board
import com.yourorg.sudukomasterf.core.model.Cell
import com.yourorg.sudukomasterf.core.model.Position
import com.yourorg.sudukomasterf.core.validation.BoardValidator
import com.yourorg.sudukomasterf.core.solver.SolverUtils
class SolutionCounter {

    fun countSolution(board: Board, limit: Int = 2): Int{
        return count(board,limit)
    }

    private fun count(board: Board, limit: Int, currentCount: Int = 0): Int{
        if(currentCount >= limit){
            return currentCount
        }
        val empty = SolverUtils.findEmpty(board) ?: return currentCount + 1

        var solutions = currentCount

        for(value in 1..board.size) {
            if (BoardValidator.isvalidMove(board, empty, value)) {
                val newBoard = board.setCell(empty, Cell(value, false))
                solutions = count(newBoard, limit, solutions)
                if (solutions >= limit) {
                    return solutions
                }
            }
        }
        return solutions
    }
}