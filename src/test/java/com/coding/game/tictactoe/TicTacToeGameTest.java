package com.coding.game.tictactoe;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sergii
 * @date 2019-01-30.
 */
public class TicTacToeGameTest {

    private TicTacToeGame ticTacToeGame = new TicTacToeGame(3);

    @Test
    public void testPlayer1WonHorizontal() {
        ticTacToeGame.makeStep(0, 0, OXType.CROSS);
        ticTacToeGame.makeStep(1, 0, OXType.ZERO);
        ticTacToeGame.makeStep(0, 1, OXType.CROSS);
        GameStatus gameStatus = ticTacToeGame.makeStep(1, 1, OXType.ZERO);
        Assert.assertEquals(GameStatus.CONTINUED, gameStatus);
        gameStatus = ticTacToeGame.makeStep(0, 2, OXType.CROSS);
        Assert.assertEquals(GameStatus.WON1, gameStatus);
    }

    @Test
    public void testPlayer1WonVertical() {
        ticTacToeGame.makeStep(0, 0, OXType.CROSS);
        ticTacToeGame.makeStep(1, 1, OXType.ZERO);
        ticTacToeGame.makeStep(1, 0, OXType.CROSS);
        GameStatus gameStatus = ticTacToeGame.makeStep(1, 2, OXType.ZERO);
        Assert.assertEquals(GameStatus.CONTINUED, gameStatus);
        gameStatus = ticTacToeGame.makeStep(2, 0, OXType.CROSS);
        Assert.assertEquals(GameStatus.WON1, gameStatus);
    }

    @Test
    public void testPlayer2Won() {
        ticTacToeGame.makeStep(0, 0, OXType.CROSS);
        ticTacToeGame.makeStep(1, 0, OXType.ZERO);
        ticTacToeGame.makeStep(0, 1, OXType.CROSS);
        GameStatus gameStatus = ticTacToeGame.makeStep(1, 1, OXType.ZERO);
        Assert.assertEquals(GameStatus.CONTINUED, gameStatus);
        ticTacToeGame.makeStep(2, 2, OXType.CROSS);
        gameStatus = ticTacToeGame.makeStep(1, 2, OXType.CROSS);
        Assert.assertEquals(GameStatus.WON2, gameStatus);
    }

    @Test
    public void testCheckDraw() {
        ticTacToeGame.makeStep(0, 0, OXType.CROSS);
        ticTacToeGame.makeStep(0, 1, OXType.ZERO);
        ticTacToeGame.makeStep(0, 2, OXType.CROSS);

        ticTacToeGame.makeStep(1, 1, OXType.ZERO);
        ticTacToeGame.makeStep(1, 0, OXType.CROSS);
        ticTacToeGame.makeStep(1, 2, OXType.ZERO);

        ticTacToeGame.makeStep(2, 1, OXType.CROSS);
        ticTacToeGame.makeStep(2, 0, OXType.ZERO);
        GameStatus gameStatus = ticTacToeGame.makeStep(2, 2, OXType.CROSS);

        Assert.assertEquals(GameStatus.DRAW, gameStatus);
    }
}
