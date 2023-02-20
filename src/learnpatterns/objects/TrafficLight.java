package learnpatterns.objects;

import java.awt.*;

public class TrafficLight {
    private final int size = 35;
    private int posx = 350;
    private int posy = 350;
    private Color color = Color.GREEN;
    private int currentTime;

    private int greenTime = 30;
    private int yellowTime = 5;
    private int redTime = 20;


    public TrafficLight(int ticks, int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        greenTime *=  ticks;
        yellowTime *= ticks;
        redTime *= ticks;
        currentTime = greenTime;

    }

    private void time() {
        if (color == Color.GREEN)
        {
            currentTime--;
            if (currentTime < 0) {
                currentTime = yellowTime;
                color = Color.YELLOW;
            }
        }
        else if (color == Color.YELLOW) {
            currentTime--;
            if (currentTime < 0) {
                currentTime = redTime;
                color = Color.RED;
            }
        }
        else {
            currentTime--;
            if (currentTime < 0) {
                currentTime = greenTime;
                color = Color.GREEN;
            }
        }
    }

    public Color draw(Graphics g) {
        time();
        g.setColor(color);
       // g.fillRect((int) posx, (int) posx, size, size);
        g.fillOval((int) posx, (int) posy, size,size);
        return g.getColor();
    }



}
