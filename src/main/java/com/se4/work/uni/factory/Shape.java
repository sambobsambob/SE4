package com.se4.work.uni.factory;

import com.se4.work.uni.exception.UnableToDrawShape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public interface Shape {

    void setOrigin(double x, double y);

    void render(GraphicsContext graphicsContext, List<String> params) throws UnableToDrawShape;
}
