package com.company.shapes.rectangle;

import java.awt.*;


public class FilledRectangle extends Rectangle {
    public FilledRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);

    }

    @Override
    public void draw(Graphics g)
    {
        //setting the color
        g.setColor(Color.CYAN);
        g.drawRect(super.x,super.y, super.width, super.height);
        g.fillRect(super.x, super.y, super.width, super.height);

    }
}
