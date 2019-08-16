package com.company.shapes.circle;

import com.company.interfaces.CustomShape;

import java.awt.*;

public class Circle implements CustomShape {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Circle(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.drawOval(x, y, width, height);
    }
}
