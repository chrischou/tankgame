package com.trader99;

import javax.swing.*;
import java.awt.*;

public class Wall {
    private int x;
    private int y;
    private boolean horizontal;
    private int bricks;
    private Image brickImage;

    public Wall(int x, int y, boolean horizontal, int bricks) {
        this.brickImage = Tools.getImage("brick.png");
        this.x = x;
        this.y = y;
        this.horizontal = horizontal;
        this.bricks = bricks;
    }

    public Rectangle getRectangle() {
        if (horizontal) {
            return new Rectangle(x, y, bricks * brickImage.getWidth(null), brickImage.getHeight(null));
        } else {
            return new Rectangle(x, y, brickImage.getWidth(null), bricks * brickImage.getHeight(null));
        }
    }

    void draw(Graphics g) {
        if (horizontal) {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(brickImage, x + i * brickImage.getWidth(null), y, null);
            }
        } else {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(brickImage, x, y + i * brickImage.getHeight(null), null);
            }
        }
    }
}
