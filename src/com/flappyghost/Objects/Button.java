package com.flappyghost.Objects;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@Setter
public class Button {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private boolean pressed;
    private final BufferedImage image;

    public Button(int x, int y, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public static boolean checkUserMouseCollision(int mouseX, int mouseY, Button btn) {
        return mouseX >= btn.getX() && mouseX <= btn.getX() + btn.getWidth() && mouseY >= btn.getY() && mouseY <= btn.getY() + btn.getWidth();
    }

    public void render(Graphics g) {
        if (this.pressed) {
            g.drawImage(this.image, this.x + 1, this.y + 1, this.width - 2, this.height - 2, null);
        } else {
            g.drawImage(this.image, this.x, this.y, null);
        }

    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
}