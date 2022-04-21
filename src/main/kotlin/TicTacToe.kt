class TicTacToe {
    private val firstPlayer = "X"
    private val secondPlayer = "O"

    var board = arrayOf(
        arrayOf("", "", ""),
        arrayOf("", "", ""),
        arrayOf("", "", "")
    )

    private var currentPlayer = firstPlayer

    /**
     * Makes a play for the corresponding player.
     */
    fun makeMove(x: Int, y: Int) {
        if (board[x][y] != "") {
            throw Exception("The tile is not empty!")
        }

        board[x][y] = currentPlayer
        currentPlayer = if (currentPlayer == firstPlayer) secondPlayer else firstPlayer
    }

    /**
     * Checks whether any of the players have won and returns its symbol, or an empty string if there are no winners.
     */
    fun winner(): String {
        if (hasWonPlayer(firstPlayer)) {
            return firstPlayer
        }

        if (hasWonPlayer(secondPlayer)) {
            return secondPlayer
        }

        return ""
    }

    private fun hasWonPlayer(player: String): Boolean {
        return hasFilledOneRow(player)
                || hasFilledOneColumn(player)
                || hasFilledOneDiagonal(player)
    }

    private fun hasFilledOneRow(player: String): Boolean {
        for (i in 0..2) {
            if (player == board[i][0] && player == board[i][1] && player == board[i][2]) {
                return true
            }
        }

        return false
    }

    private fun hasFilledOneColumn(player: String): Boolean {
        for (i in 0..2) {
            if (player == board[0][i] && player == board[1][i] && player == board[2][i]) {
                return true
            }
        }

        return false
    }

    private fun hasFilledOneDiagonal(player: String): Boolean {
        return ((player == board[0][0] && player == board[1][1] && player == board[2][2])
                || (player == board[0][2] && player == board[1][1] && player == board[2][0]))
    }
}