import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TicTacToeTest {
    @Test
    fun `there are no winners at the beginning`() {
        val ticTacToe = TicTacToe()

        val result = ticTacToe.winner()
        val expected = ""

        assertEquals(expected, result)
    }

    @Test
    fun `X wins with a row`() {
        val ticTacToe = TicTacToe()
        ticTacToe.makeMove(0, 0)
        ticTacToe.makeMove(1, 0)
        ticTacToe.makeMove(0, 1)
        ticTacToe.makeMove(2, 0)
        ticTacToe.makeMove(0, 2)

        val result = ticTacToe.winner()
        val expected = "X"

        assertEquals(expected, result)
    }

    @Test
    fun `X wins with a column`() {
        val ticTacToe = TicTacToe()
        ticTacToe.makeMove(0, 0)
        ticTacToe.makeMove(1, 2)
        ticTacToe.makeMove(1, 0)
        ticTacToe.makeMove(2, 2)
        ticTacToe.makeMove(2, 0)

        val result = ticTacToe.winner()
        val expected = "X"

        assertEquals(expected, result)
    }
    @Test
    fun `X wins with left to right diagonal`() {
        val ticTacToe = TicTacToe()
        ticTacToe.makeMove(0, 0)
        ticTacToe.makeMove(0, 1)
        ticTacToe.makeMove(1, 1)
        ticTacToe.makeMove(0, 2)
        ticTacToe.makeMove(2, 2)

        val result = ticTacToe.winner()
        val expected = "X"

        assertEquals(expected, result)
    }

    @Test
    fun `X wins with right to left diagonal`() {
        val ticTacToe = TicTacToe()
        ticTacToe.makeMove(0, 2)
        ticTacToe.makeMove(0, 0)
        ticTacToe.makeMove(1, 1)
        ticTacToe.makeMove(0, 1)
        ticTacToe.makeMove(2, 0)

        val result = ticTacToe.winner()
        val expected = "X"

        assertEquals(expected, result)
    }

    @Test
    fun `no one wins`() {
        val ticTacToe = TicTacToe()
        ticTacToe.makeMove(0, 0)
        ticTacToe.makeMove(0, 1)
        ticTacToe.makeMove(0, 2)
        ticTacToe.makeMove(1, 1)
        ticTacToe.makeMove(1, 0)
        ticTacToe.makeMove(1, 2)
        ticTacToe.makeMove(2, 1)
        ticTacToe.makeMove(2, 0)
        ticTacToe.makeMove(2, 2)

        val winner = ticTacToe.winner()

        assertEquals("", winner)
    }

    @Test
    fun `a taken field cannot be taken again`() {
        val ticTacToe = TicTacToe()
        ticTacToe.makeMove(0, 0)

        assertThrows<Exception> {
            ticTacToe.makeMove(0, 0)
        }
    }

}