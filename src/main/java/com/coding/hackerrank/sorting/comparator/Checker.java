package com.coding.hackerrank.sorting.comparator;

import java.util.Comparator;

class Checker implements Comparator<Player> {
    // complete this method
    @Override
    public int compare(Player p1, Player p2) {
        int cmp = Integer.compare(p2.score, p1.score);
        if (cmp != 0) return cmp;
        return p1.name.compareTo(p2.name);
    }
}
