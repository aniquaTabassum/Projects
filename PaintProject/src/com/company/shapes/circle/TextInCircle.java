package com.company.shapes.circle;

import com.company.shapes.circle.Circle;

import java.awt.*;

public class TextInCircle extends Circle {
    String text = "";
    public TextInCircle(int x, int y, int width, int height, String text) {
        super(x, y, width, height);
        this.text = text;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
        //adding the text
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.drawString(text, (x + (width/5)), (y+ (height/2)));
    }
}
