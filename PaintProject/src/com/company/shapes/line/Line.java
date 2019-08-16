package com.company.shapes.line;

import com.company.interfaces.CustomShape;

import java.awt.*;

public class Line implements CustomShape {
    public int x1;
    public int x2;
    public int y1;
    public int y2;

    public Line(int x1, int x2, int y1, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawLine(x1, x2, y1, y2);
    }
}
