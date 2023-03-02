package com.trader99;

import javax.swing.*;
import java.awt.*;

public class GameClient extends JComponent {

    public GameClient() {
        this.setPreferredSize(new Dimension(800,600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("asserts/images/cool.png").getImage(),400,100,null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("史上最無聊的坦克大戰");
        GameClient client = new GameClient();
        client.repaint();
        frame.add(client);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
