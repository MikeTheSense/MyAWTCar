package learnpatterns.objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Car {
    private static final int size = 25;
    private int topBorder;
    private Image  image;
    private int stopLineYY;
    private int stopLineY;

    private double x = 500;
    private double y;
    private double dx;



    public Car(int drawingSpeed, int topBorder, Image  image,int stopLineY) {
        dx = drawingSpeed;
        y = topBorder;
        this.topBorder = topBorder;
        this.image = image;
        this.stopLineYY = stopLineY;
        this.stopLineY = stopLineY + 2*size;
        //dy = 0;
    }

    private void move(Color color) {
        if (!((color == Color.RED) && ((y < (stopLineY)) && y > (stopLineYY))))
        {
            y -= dx;
            if (y < 0)
                y = topBorder;
        }
    }

    public void draw(Graphics g, Color color) {
        move(color);
        g.drawImage(image,(int) x, (int) y,60,60,null);
    }


}
