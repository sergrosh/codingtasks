package com.coding.codewars;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length == 10) {
            int y = 0;
            int x = 0;
            for (char direction : walk) {
                switch (direction) {
                    case 'n':
                        y++;
                        break;
                    case 's':
                        y--;
                        break;
                    case 'e':
                        x++;
                        break;
                    case 'w':
                        x--;
                        break;
                    default:
                        return false;
                }
            }
            return y == 0 && x == 0;
        }
        return false;
    }
}