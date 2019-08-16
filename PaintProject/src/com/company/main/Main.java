package com.company.main;

import com.company.paint.Paint;
import com.company.shapes.circle.Circle;
import com.company.shapes.line.Line;
import com.company.shapes.rectangle.FilledRectangle;
import com.company.shapes.circle.TextInCircle;
import com.company.shapes.rectangle.Rectangle;
import com.company.shapes.triangle.Triangle;

import javax.swing.*;
//this class will paint all the shapes in the given assignment
//note that, not much attention has been paid to the co-ordinates of the shapes, especially the triangle
//please fix the co-ordinates according to your own needs
public class Main {

    public static void main(String[] args) {
	Paint myPaint = new Paint();

	//the following two arrays will be needed to draw the triangle
	int[] yCoordinates = new int[]{200,250, 300, 350};
	int[] xCoordinates = new int[]{350, 400, 420, 450, 475, 500,335,325,300, 275, 210};

	myPaint.addShape(new Line(50,50,100,100));
	myPaint.addShape(new Line(50,50,100,150));
	myPaint.addShape(new Rectangle(50,500,40,50));
	myPaint.addShape(new Circle(100,500,50,50));
	myPaint.addShape(new Triangle(xCoordinates, yCoordinates));
	myPaint.addShape(new FilledRectangle(155,500,40,50));
	myPaint.addShape(new TextInCircle(200,300,150,150, "hope this helps"));

	JFrame myFrame = new JFrame("My Paint");
	myFrame.setSize(600,600);
	myFrame.setContentPane(myPaint);
	myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	myFrame.setVisible(true);
    }
}
