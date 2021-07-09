package com.se4.work.uni.factory;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class DrawCircle implements Shape {

    double x;
    double y;

    @Override
    public void setOrigin(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(GraphicsContext graphicsContext, List<String> params) {
        graphicsContext.fillOval(x, y, Double.parseDouble(params.get(0)), Double.parseDouble(params.get(0)));
    }
}
