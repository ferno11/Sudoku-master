package com.yourorg.sudukomasterf.core.board

import com.yourorg.sudukomasterf.core.model.Cell
import com.yourorg.sudukomasterf.core.model.Position

class Board(
    val config: BoardConfig,
    private val cells: Array<Array<Cell>>
){
    val size: Int = config.boardSize

    init{
        require(cells.size == size)
        require(cells.all{it.size == size})
    }
    fun getCell(position: Position):Cell{
        validatePosition(position)
        return cells[position.row][position.col]
    }
    fun setCell(position: Position, cell: Cell): Board{
        validatePosition(position)

        val newCells = cells.map{it.clone()}.toTypedArray()
        newCells[position.row][position.col] = cell

        return Board(config, newCells)
    }
    fun getRow(row:Int): List<Cell>{
        require(row in 0 until size)
        return cells[row].toList()
    }

    fun getCol(col:Int): List<Cell>{
        require(col in 0 until size)
        return cells.map{it[col]}
    }

    fun getBox(position: Position): List<Cell> {
        validatePosition(position)

        val boxSize = config.boxSize
        val startRow = (position.row / boxSize) * boxSize
        val startCol = (position.col / boxSize) * boxSize

        val boxCells = mutableListOf<Cell>()

        for (r in startRow until startRow + boxSize) {
            for (c in startCol until startCol + boxSize) {
                boxCells.add(cells[r][c])
            }
        }
        return boxCells
    }

    private fun validatePosition(position: Position){
        require(position.row in 0 until size)
        require(position.col in 0 until size)
    }
}