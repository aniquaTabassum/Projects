package com.company.shapes.triangle;

import com.company.interfaces.CustomShape;

import java.awt.*;

public class Triangle implements CustomShape {
    private int[] xCoordinates;
    private int[] yCoordinates;
    private int numOfPoints = 3;

    public Triangle(int[] xCoordinates, int[] yCoordinates)
    {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.drawPolygon(xCoordinates, yCoordinates, numOfPoints);
    }
}
