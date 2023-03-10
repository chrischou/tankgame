package com.trader99;

import java.awt.*;

public enum Direction {
    UP("U", 0, -1),
    DOWN("D", 0, 1),
    LEFT("L", -1, 0),
    RIGHT("R", 1, 0),
    LEFT_UP("LU", -1, -1),
    RIGHT_UP("RU", 1, -1),
    LEFT_DOWN("LD", -1, 1),
    RIGHT_DOWN("RD", 1, 1);
    public final int xFactor, yFactor;
    private final String abbrev;


    Direction(String abbrev,int xFactor,int yFactor) {
        this.abbrev = abbrev;
        this.xFactor = xFactor;
        this.yFactor = yFactor;
    }

    Image getImage(String prefix) {
//        約定優於配置
        return Tools.getImage(prefix + abbrev + ".gif");


    }

}
