package com.coding.game.tictactoe;

/**
 * @author sergii
 * @date 2019-01-30.
 */
public enum OXType {
    ZERO("O"), CROSS("X");

    private String value;

    OXType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
