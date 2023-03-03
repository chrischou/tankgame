package com.trader99;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GameClient extends JComponent {

    private Tank playerTank;
    private List<Tank> enemyTanks;
    private List<Wall> walls;

    public GameClient() {
        this.playerTank = new Tank(400, 100, Direction.DOWN);
        this.setPreferredSize(new Dimension(800, 600));
        this.enemyTanks = new ArrayList<>(12);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                this.enemyTanks.add(new Tank(200 + j * 120, 400 + 40 * i, true,Direction.UP));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        playerTank.draw(g);
        for (Tank tank : enemyTanks){
            tank.draw(g);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setTitle("史上最無聊的坦克大戰");
        frame.setIconImage(new ImageIcon("asserts/images/tank.png").getImage());
        GameClient client = new GameClient();
        client.repaint();
        frame.add(client);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                client.playerTank.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                client.playerTank.keyRelesed(e);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true) {
            client.repaint();
            Thread.sleep(50);
        }

    }
}
