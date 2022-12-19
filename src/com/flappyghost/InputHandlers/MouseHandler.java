package com.flappyghost.InputHandlers;

import com.flappyghost.Game;
import com.flappyghost.Objects.Button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.flappyghost.Game.restartGame;

public class MouseHandler implements MouseListener {
    public MouseHandler() {
    }

    public void mouseClicked(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
        if (Button.checkUserMouseCollision(event.getX(), event.getY(), Game.startButton) && Game.isGameOver()) {
            System.out.println("Game should start");
            Game.startButton.setPressed(true);
            Game.restartGame();
        }

    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }
}