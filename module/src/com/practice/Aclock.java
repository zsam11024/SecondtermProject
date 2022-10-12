package com.practice;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

//Thread and Jframe classes are extended and Inhehritance is implememted here
class Aclock extends JFrame {
    private JLabel heading;
    private JLabel ClockLabel;
    private Font font=new Font("",Font.ITALIC,20);

    Aclock(){
        super.setTitle("A clock");
        super.setSize(400,400);
        super.setLocation(300,50);
        this.creatGUI();
        this.startClock();
        super.setVisible(true);

    }
    public void creatGUI(){
        //GUI
        //heading=new JLabel("It's clock");
        ClockLabel= new JLabel("clock");
        //heading.setFont(font);
        ClockLabel.setFont(font);
        this.setLayout(new GridLayout(2,1));
        //this.add(heading);
        this.add(ClockLabel);
        this.setDefaultCloseOperation(0);
    }
  public void startClock() {

    }
    public void display(){
        creatGUI();
        DateDisplay dateDisplay= new DateDisplay();
        dateDisplay.display_date();

    }
    //composition
    class DateDisplay{
        public void display_date() {
            try{
                while(true){
                    Date d=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("hh : mm : ss a"); //hh:mm:ss are specifiers
                    sdf.format(d);
                    String dateTime=sdf.format(d);
                    ClockLabel.setText(dateTime);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}

class Clock extends Thread{

    //aggregation
    //threads implemented
    Aclock clock;
    Clock(){
        clock= new Aclock();
    }

    public void run() {
        clock.display();
    }
}