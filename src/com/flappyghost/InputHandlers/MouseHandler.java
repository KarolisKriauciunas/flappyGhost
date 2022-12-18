package com.flappyghost.InputHandlers;

import com.flappyghost.Game;
import com.flappyghost.Objects.Button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public MouseHandler() {
    }

    public void mouseClicked(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
        if (Button.checkUserMouseCollision(event.getX(), event.getY(), Game.startButton) && Game.gameOver) {
            System.out.println("Game should start");
            Game.startButton.setPressed(true);
            ObjectHandler.list.clear();
            ObjectHandler.addObject(Game.ghost);
            Game.gameOver = false;
            Game.score = 0;
            Game.startButton.setPressed(false);

        }

    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }
}