package com.company.paint;

import com.company.interfaces.CustomShape;

import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel {
    private CustomShape[] drawableArray = new CustomShape[100];
    private int count = 0;
    public void paint(Graphics g)
    {
        System.out.println(drawableArray.length+" "+count);
        for(int i=0;i<count;i++)
        {
            drawableArray[i].draw(g);
        }

    }

    public int getCount() {
        return count;
    }

    public void addShape(CustomShape customShape)
    {
       drawableArray[count++] = customShape;
    }

}
