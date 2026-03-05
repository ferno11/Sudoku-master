package com.yourorg.sudukomasterf.core.validation

import com.yourorg.sudukomasterf.core.board.Board
import com.yourorg.sudukomasterf.core.model.Position
import com.yourorg.sudukomasterf.core.model.Cell

object BoardValidator{
    fun isvalidMove(board: Board, position: Position, value: Int): Boolean{
        return isRowValid(board, position, value) &&
                isColValid(board, position, value) &&
                isBoxValid(board, position, value)
    } // checks whether no exists in row , column or box

    private fun isRowValid(board: Board, position: Position, value: Int): Boolean{
        return board.getRow(position.row).filterNotNullValues().none{it == value} //checks if no already exists
    }

    private fun isColValid(board: Board, position: Position, value: Int): Boolean{
        return board.getCol(position.col).filterNotNullValues().none{it == value}
    }

    private fun isBoxValid(board: Board, position: Position, value: Int): Boolean{
        return board.getBox(position).filterNotNullValues().none{it == value}
    }

    private fun List<Cell>.filterNotNullValues(): List<Int>{
        return this.mapNotNull { it.value } //to extract non null values only
    }

}