package com.coding.game.tictactoe;

/**
 * @author sergii
 * @date 2019-01-30.
 */
public class TicTacToeGame {
    private OXType[][] board;
    private int size;
    private int steps;

    public TicTacToeGame(int size) {
        this.size=size;
        board = new OXType[size][size];
    }

    public GameStatus makeStep(int x, int y, OXType oxType) {
        if (board[x][y] == null) {
            board[x][y] = oxType;
            steps++;
        }

        //check horizontal
        for (int i = 0; i < size; i++) {
            if (board[x][i] != oxType)
                break;
            if (i == size - 1) {
                if (steps % 2 != 0)
                    return GameStatus.WON1;
                else
                    return GameStatus.WON2;
            }
        }

        //check vertical
        for (int i = 0; i < size; i++) {
            if (board[i][y] != oxType)
                break;
            if (i == size - 1) {
                if (steps % 2 != 0)
                    return GameStatus.WON1;
                else
                    return GameStatus.WON2;
            }
        }

        //check diagonal
        for (int i = 0; i < size; i++) {
            if (board[i][i] != oxType)
                break;
            if (i == size - 1) {
                if (steps % 2 != 0)
                    return GameStatus.WON1;
                else
                    return GameStatus.WON2;
            }
        }

        //check diagonal
        for (int i = size - 1; i >= 0; i--) {
            if (board[i][size - 1 - i] != oxType)
                break;
            if (i == 0) {
                if (steps % 2 != 0)
                    return GameStatus.WON1;
                else
                    return GameStatus.WON2;
            }
        }

        if (Math.sqrt(steps) == size)
            return GameStatus.DRAW;

        return GameStatus.CONTINUED;
    }

}
