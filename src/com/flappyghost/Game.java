package com.flappyghost;


import com.flappyghost.InputHandlers.KeyHandler;
import com.flappyghost.InputHandlers.MouseHandler;
import com.flappyghost.InputHandlers.ObjectHandler;
import com.flappyghost.InputHandlers.ObstacleHandler;
import com.flappyghost.Objects.Ghost;
import com.flappyghost.Objects.Button;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.flappyghost.utils.ResourceLoader.load;


public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 432;
    public static final int HEIGHT = 600;
    public boolean running;
    public static boolean gameOver;
    public static BufferedImage gameOverImage;
    public static BufferedImage gameBackground;
    public static Ghost ghost;
    public static Button startButton;
    public static int score;

    public Game() {
    }

    public static void main(String[] args) {
        new GameWindow(WIDTH, HEIGHT, "FlappyGhost", new Game());
    }

    public void initializeGameSetup() {
        this.running = true;
        gameOver = false;
        this.addKeyListener(new KeyHandler());
        this.addMouseListener(new MouseHandler());
        gameOverImage = loadGraphics("gameover.png");
        gameBackground = loadGraphics("dark_Background_2.png");
        System.out.println(gameOver);
        ghost = new Ghost(50, 50, 51, 36);
       startButton = new Button(138, 200, 156, 87, loadGraphics("playbutton.png"));
    }

    public void checkGameState() {
        if (!gameOver) {
            ObjectHandler.updateGameObjects();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
        } else {
            Graphics g = bs.getDrawGraphics();
            g.drawImage(gameBackground, 0, 0, null);
            ObjectHandler.render(g);
            if (gameOver) {
                g.drawImage(gameOverImage, 72, 130, null);
                startButton.render(g);
            }

            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.setColor(Color.WHITE);
            String s = Integer.toString(score);
            int textWidth = g.getFontMetrics().stringWidth(s);
            g.drawString(s, 216 - textWidth / 2, 40);
            g.dispose();
            bs.show();
        }
    }

    public void run() {
        this.initializeGameSetup();
        this.requestFocus();
        double delta = 0.0;
        long pastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1.0E9 / amountOfTicks;
        while (this.running) {
            long now = System.nanoTime();
            delta += (double) (now - pastTime) / ns;

            for (pastTime = now; delta > 0.0; --delta) {
                this.checkGameState();
                this.render();
                ObstacleHandler.update();
            }
        }
    }

    public static BufferedImage loadGraphics(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(load(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
