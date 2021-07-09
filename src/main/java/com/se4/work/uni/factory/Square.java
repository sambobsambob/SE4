package com.se4.work.uni.factory;

import com.se4.work.uni.exception.UnableToDrawShape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Square implements Shape {

    double x;
    double y;

    @Override
    public void setOrigin(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(GraphicsContext graphicsContext, List<String> params) throws UnableToDrawShape {
        try {
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillRect(x, y, Double.parseDouble(params.get(0)), Double.parseDouble(params.get(0)));
        } catch (Exception e) {
            throw new UnableToDrawShape("Unable to draw square");
        }
    }
}
