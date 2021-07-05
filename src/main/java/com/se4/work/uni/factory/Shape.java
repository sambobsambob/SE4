package com.se4.work.uni.factory;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public interface Shape {

    void setOrigin(int x, int y);

    void render(GraphicsContext graphicsContext, int[] params);
}
