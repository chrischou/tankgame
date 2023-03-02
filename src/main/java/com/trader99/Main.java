package com.trader99;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        System.out.println("TANK GAME");
        JFrame frame = new JFrame();
        frame.setTitle("史上最無聊的坦克大戰");
        frame.setIconImage(new ImageIcon("asserts/images/cool.png").getImage());


        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        frame.setVisible(true);


    }

}
