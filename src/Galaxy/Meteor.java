package Galaxy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Meteor extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JButton startButton;
	private JButton stopButton;
	private JButton resetButton;
	
	private int[] x = new int[1000];
    private int[] y = new int[1000];
    
    boolean isRunning = true;

    public Meteor() {
        setTitle("Meteor Shower");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        for (int i = 0; i < 1000; i++) {
            x[i] = (int) (Math.random() * getWidth());
            y[i] = (int) (Math.random() * getHeight());
        }
        
        
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		isRunning = true;
        	}
        });
        
        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		isRunning = false;
        	}
        });
        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for (int i = 0; i < 1000; i++) {
                    x[i] = (int) (Math.random() * getWidth());
                    y[i] = (int) (Math.random() * getHeight());
                }
        	}
        });
        
        startButton.setBounds(50, 500, 100, 30);
        stopButton.setBounds(200, 500, 100, 30);
        resetButton.setBounds(350, 500, 100, 30);
        
        
        add(startButton);
        add(stopButton);
        add(resetButton);

             
        

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                	
                    for (int i = 0; i < 1000; i++) {
                    	x[i] += (int) (Math.random() * 3 - 1);
                        y[i] += (int) (3);
                        
                        if (x[i] < 0) x[i] = getWidth();
                        if (x[i] > getWidth()) x[i] = 0;
                        if (y[i] < 0) y[i] = getHeight();
                        if (y[i] > getHeight()) y[i] = 0;
                    }

                    repaint();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } 
        }).start();
             
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        for (int i = 0; i < 1000; i++) {
            g.drawLine(x[i], y[i], x[i] + 1, y[i] + 1);
        }
    }
    
    

    public static void main(String[] args) {
        Meteor sky = new Meteor();
        sky.setVisible(true);
    }


}
