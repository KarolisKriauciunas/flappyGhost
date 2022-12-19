package com.flappyghost.Objects;

import com.flappyghost.InputHandlers.ObjectHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.flappyghost.Game.increaseScore;
import static com.flappyghost.Game.loadGraphics;

public class Obstacle extends GameObject {
    ObsticleType type;
    BufferedImage tubeBlock;
    BufferedImage tube;

    public Obstacle(int x, int y, int width, int height, ObsticleType type) {
        super(x, y, width, height);
        this.type = type;
        this.velX = 3.0F;
        this.tube = loadGraphics("tube.png");
        if (type == ObsticleType.BOTTOM) {
            this.tubeBlock = loadGraphics("tubebottomdown.png");
        } else if (type == ObsticleType.TOP) {
            this.tubeBlock = loadGraphics("tubebottomtop.png");
        }

    }

    public void update() {
        this.x = (int)((float)this.x - this.velX);
        if (this.x + this.width < 0) {
            ObjectHandler.removeObject(this);
            if (this.type == ObsticleType.TOP) {
                increaseScore();
            }
        }

    }

    public void render(Graphics g) {
        if (this.type == ObsticleType.BOTTOM) {
            g.drawImage(this.tube, this.x, this.y, 72, this.height, null);
            g.drawImage(this.tubeBlock, this.x - 3, this.y,null);
        } else if (this.type == ObsticleType.TOP) {
            g.drawImage(this.tube, this.x, this.y, 72, this.height, null);
            g.drawImage(this.tubeBlock, this.x - 3, this.y + this.height - 36, null);
        }
    }
}
