package com.flappyghost.Objects;

import com.flappyghost.InputHandlers.ObjectHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.flappyghost.Game.gameOver;
import static com.flappyghost.Game.loadGraphics;

public class Ghost extends GameObject {
    public float gravity = 0.3F;
    public float maxSpeed = 12.0F;
    public BufferedImage birdSprite;
    public Ghost(int x, int y, int width, int height) {
        super(x, y, width, height);
        birdSprite = loadGraphics("ghost.png");
        ObjectHandler.addObject(this);
    }

    public void update() {
        this.velY += this.gravity;
        this.y = (int) ((float) this.y + this.velY);
        if (this.velY > this.maxSpeed) {
            this.velY = this.maxSpeed;
        }

        if (this.y + this.height > 602) {
            this.y = 602 - this.height;
            this.setVelY(0.0F);
        }

        if (this.y < 0) {
            this.y = 0;
            this.setVelY(0.0F);
        }

        GameObject gameObject;

        for (int i = 0; i < ObjectHandler.list.size(); ++i) {
            gameObject = ObjectHandler.list.get(i);
            if ((gameObject instanceof Obstacle && this.getBounds().intersects(gameObject.getBounds()))){
                gameOver = true;
            }

        }
    }

    public void render(Graphics g) {
        g.drawImage(birdSprite, this.x, this.y, this.width,this.height, null );
    }
}