package com.trader99;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameClient extends JComponent {

    private static final GameClient INSTANCE = new GameClient();

    public static GameClient getInstance() {
        return INSTANCE;
    }

    private Tank playerTank;
    private List<Tank> enemyTanks;
    private List<Wall> walls;
    private List<Missile> missiles;

    public Tank getPlayerTank() {
        return playerTank;
    }

    public void add(Missile missile) {
        missiles.add(missile);
    }

    public void removeMissile(Missile missile) {
        missiles.remove(missile);
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Tank> getEnemyTanks() {
        return enemyTanks;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    private GameClient() {
        this.playerTank = new Tank(400, 100, Direction.DOWN);
        this.setPreferredSize(new Dimension(800, 600));
        this.missiles = new ArrayList<>();
        this.walls = Arrays.asList(
                new Wall(200, 140, true, 15),
                new Wall(200, 540, true, 15),
                new Wall(100, 80, false, 15),
                new Wall(700, 80, false, 15)
        );
        initEnemyTanks();
    }

    private void initEnemyTanks() {
        this.enemyTanks = new ArrayList<>(12);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                this.enemyTanks.add(new Tank(200 + j * 120, 400 + 40 * i, true, Direction.UP));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        playerTank.draw(g);
        enemyTanks.removeIf(t -> !t.isLive());
        if(enemyTanks.isEmpty()){
            initEnemyTanks();
        }
        for (Tank tank : enemyTanks) {
            tank.draw(g);
        }
        for (Wall wall : walls) {
            wall.draw(g);
        }
        missiles.removeIf(m->!m.isLive());
        for (Missile missile : missiles) {
            missile.draw(g);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
        JFrame frame = new JFrame();
        frame.setTitle("??????????????????????????????");
        frame.setIconImage(new ImageIcon("asserts/images/tank.png").getImage());
        final GameClient client = GameClient.getInstance();
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
