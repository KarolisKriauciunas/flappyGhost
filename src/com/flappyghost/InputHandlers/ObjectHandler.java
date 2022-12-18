package com.flappyghost.InputHandlers;

import com.flappyghost.Objects.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {
    public static LinkedList<GameObject> list = new LinkedList();

    public static void addObject(GameObject o) {
        list.add(o);
    }

    public static void removeObject(GameObject o) {
        list.remove(o);
    }

    public static void render(Graphics g) {
        GameObject object;

        for (GameObject gameObject : list) {
            object = gameObject;
            object.render(g);
        }
    }

    public static void updateGameObjects() {
        GameObject object;

        for (int objectIndex = 0; objectIndex < list.size(); ++objectIndex) {
            object = list.get(objectIndex);
            object.update();
        }

    }
}