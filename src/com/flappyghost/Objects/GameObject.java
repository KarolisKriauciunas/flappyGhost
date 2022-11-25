package com.flappyghost.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Setter
@Getter
@AllArgsConstructor
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected float velX;
    protected float velY;
    public void render(Graphics g) {
    }
    public void update(){
    }
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }
}