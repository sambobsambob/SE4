package com.se4.work.uni.factory;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square implements Shape {

    int x;
    int y;

    @Override
    public void setOrigin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(GraphicsContext graphicsContext, int[] params) {
        try {
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillRect(x, y, params[0], params[0]);
        } catch (Exception e) {
            //TODO make custom exception here
        }

    }
}
