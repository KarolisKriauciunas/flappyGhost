package com.flappyghost;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(int width, int height, String title, Game game) {
        this.setTitle(title);
        this.pack();
        this.setSize(width + this.getInsets().left + this.getInsets().right, height + this.getInsets().top + this.getInsets().bottom);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(game);
        game.run();
    }
}