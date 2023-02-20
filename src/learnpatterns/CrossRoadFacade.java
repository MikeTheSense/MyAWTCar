package learnpatterns;

import learnpatterns.objects.Car;
import learnpatterns.objects.TrafficLight;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CrossRoadFacade extends JComponent {
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 900;
    private static final int PREF_H = 700;
    private static final int TIMER_DELAY = 15;

    private static final int TFP_X = 605;
    private static final int TFP_Y = 575;


    private Car car;
    private TrafficLight trafficLight;

    private Image backgroundImage;



    public CrossRoadFacade() {
        Image  image = null;
        try
        {
            image = ImageIO.read(new File("C:\\Users\\MISHA\\IdeaProjects\\MyAWTCar\\src\\images\\krisha.png"));
            try {backgroundImage = ImageIO.read(new File("C:\\Users\\MISHA\\IdeaProjects\\MyAWTCar\\src\\images\\29358483_2e25da3d3da6b19eaf55755edcddef6f_800.jpg"));} catch (IOException e) {
                e.printStackTrace();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.car = new Car(3, PREF_W, image, TFP_Y);
        this.trafficLight = new TrafficLight(TIMER_DELAY, TFP_X, TFP_Y);
    }

    public void draw()
    {
        new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actEvt) {
                    repaint();
                }
        }).start();
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0,0,PREF_W,PREF_H,this);
        g.setColor(Color.BLACK);
        car.draw(g,trafficLight.draw(g));
    }

    public static void createAndShowGui() {
        CrossRoadFacade crossRoad = new CrossRoadFacade();
        crossRoad.draw();
        JFrame frame = new JFrame("CrossRoadFacade by Mikola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(crossRoad);
        frame.pack();
        frame.setLocationByPlatform(true);
        //frame.setLocation(50,50);
        frame.setVisible(true);
    }




}
