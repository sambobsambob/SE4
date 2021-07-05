package com.se4.work.uni.factory;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Circle implements Shape {

    int x;
    int y;

    @Override
    public void setOrigin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(GraphicsContext graphicsContext, int[] params) {

    }
}
