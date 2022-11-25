package com.flappyghost.InputHandlers;

import com.flappyghost.Objects.Obstacle;
import com.flappyghost.Objects.ObsticleType;

import java.util.Random;

public class ObstacleHandler {
    private static final Random random = new Random();
    public static int area;
    public static int spacing;
    public static int minSize;
    public static int maxSize;
    public static int delay;
    public static int now;

    static {
        area = 600;
        spacing = 120;
        minSize = 40;
        maxSize = area - spacing - minSize;
        delay = 150;
    }

    public ObstacleHandler() {
    }

    public static void spawnTube() {
        int heightTop;
        for(heightTop = random.nextInt(maxSize) + 1; heightTop < minSize; heightTop = random.nextInt(maxSize) + 1) {
        }

        int heightBottom = area - spacing - heightTop;
        Obstacle topObstacle = new Obstacle(500, 0, 78, heightTop, ObsticleType.TOP);
        Obstacle bottomObstacle = new Obstacle(500, heightTop + spacing, 78, heightBottom, ObsticleType.BOTTOM);
        ObjectHandler.addObject(topObstacle);
        ObjectHandler.addObject(bottomObstacle);
    }

    public static void update() {
        if (now < delay) {
            ++now;
        } else {
            spawnTube();
            now = 0;
        }

    }
}