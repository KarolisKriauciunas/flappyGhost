package com.flappyghost.InputHandlers;


import com.flappyghost.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public KeyHandler() {
    }

    public void keyTyped(KeyEvent event) {
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == 32) {
            Game.ghost.setVelY(-5.0F);
        }

    }

    public void keyReleased(KeyEvent event) {
    }
}
