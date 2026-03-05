package com.yourorg.sudukomasterf.core.generator

import com.yourorg.sudukomasterf.core.board.Board
import com.yourorg.sudukomasterf.core.board.BoardConfig
import com.yourorg.sudukomasterf.core.model.Position
import com.yourorg.sudukomasterf.core.model.Cell
import com.yourorg.sudukomasterf.core.validation.BoardValidator
import com.yourorg.sudukomasterf.core.solver.SolverUtils
import com.yourorg.sudukomasterf.core.solver.SolutionCounter
import com.yourorg.sudukomasterf.core.model.Puzzle
import kotlin.random.Random

class SudokuGenerator (private val config: BoardConfig,
    private val random: Random = Random.Default) {

    private val solutionCounter = SolutionCounter()

    fun gerneratePuzzle(targetRemovals: Int): Puzzle {
        val solutionBoard = generateSolvedBoard()
        val puzzleBoard = removeNumbers(solutionBoard, targetRemovals)

        return Puzzle(puzzleBoard, solutionBoard)
    }

    fun generateSolvedBoard(): Board {
        val emptyBoard = createEmptyBoard()
        return fillBoard(emptyBoard) ?: throw IllegalStateException("Failed to generate Board")
    }

    private fun createEmptyBoard(): Board {
        val size = config.boardSize

        val cells = Array(size) { Array(size) { Cell(null, false) } }
        return Board(config, cells)
    }

    private fun fillBoard(board: Board): Board? {
        val empty = SolverUtils.findEmpty(board) ?: return board

        val numbers = (1..board.size).shuffled(Random)

        for (value in numbers) {
            if (BoardValidator.isvalidMove(board, empty, value)) {
                val newBoard = board.setCell(empty, Cell(value, false))

                val solved = fillBoard(newBoard)
                if (solved != null) {
                    return solved
                }
            }
        }
        return null
    }

    private fun removeNumbers(solution: Board, targetRemovals: Int): Board {
        var puzzleBoard = solution

        val size = solution.size
        val positions = mutableListOf<Position>()

        for(r in 0 until size) {
            for (c in 0 until size) {
                positions.add(Position(r, c))
            }
        }
        positions.shuffle(random)

        var removed = 0

        for(pos in positions){
            if(removed >= targetRemovals){
                break
            }
            val cell =puzzleBoard.getCell(pos)
            if(cell.value == null) continue
            val backup = cell

            puzzleBoard = puzzleBoard.setCell(pos, Cell(null, false))

            val solutions = solutionCounter.countSolution(puzzleBoard)

            if(solutions == 1)
                removed++
            else
                puzzleBoard = puzzleBoard.setCell(pos, backup)
        }
        return puzzleBoard
    }
}