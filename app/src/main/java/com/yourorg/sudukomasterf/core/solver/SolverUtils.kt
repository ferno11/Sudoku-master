package com.yourorg.sudukomasterf.core.solver

import com.yourorg.sudukomasterf.core.board.Board
import com.yourorg.sudukomasterf.core.model.Position

object SolverUtils{
    fun findEmpty(board: Board): Position?{ //find empty cell
        val size = board.size

        for(row in 0 until size){
            for(col in 0 until size){
                val pos = Position(row, col)
                if(board.getCell(pos).value == null){
                    return pos
                }
            }
        }
        return null
    }
}