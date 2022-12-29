package basics;

import java.awt.*;
import javax.swing.*;

public class BouncingBox extends JPanel {

	private static final long serialVersionUID = 6138827786825L;
	private long rstart;
	private long rend;
	
	int width;
	int height;
	
	float radius = 60;
	float diameter1 = radius * 2;
	float diameter2 = radius * 2;
	float diameter3 = radius * 2;
	
	
	float box1X = radius + 30;
	float box1Y = radius = 50;
	float box2X = radius + 30;
	float box2Y = radius = 50;
	float box3X = radius + 30;
	float box3Y = radius = 50;
	
	float dx1 = 4;
	float dy1 = 5;
	float dx2 = 6;
	float dy2 = 3;
	float dx3 = 3;
	float dy3 = 4;
	

	public BouncingBox() { 
		
		Thread thread = new Thread() {
			public void run() {
				while (true) { 
					try {
					width = getWidth();
					height = getHeight();
					 
					box1X = box1X + dx1 ;
					box1Y = box1Y + dy1;
					
					box2X = box2X + dx2 ;
					box2Y = box2Y + dy2;
					
					box3X = box3X + dx3 ;
					box3Y = box3Y + dy3;
					
					
					if (box1X - radius < 0) {
						dx1 = -dx1;
						box1X = radius;
					} else if (box1X + radius > width) {
						dx1 = -dx1;
						box1X = width - radius;
					}
					
					if (box1Y - radius < 0) {
						dy1 = -dy1;
						box1Y = radius;
					} else if (box1Y + radius > height) {
						dy1 = -dy1;
						box1Y = height - radius;
					}
					if (box2X - radius < 0) {
						dx2 = -dx2;
						box2X = radius;
					} else if (box2X + radius > width) {
						dx2 = -dx2;
						box2X = width - radius;
					}
					
					if (box2Y - radius < 0) {
						dy2 = -dy2;
						box2Y = radius;
					} else if (box2Y + radius > height) {
						dy2 = -dy2;
						box2Y = height - radius;
					}
					if (box3X - radius < 0) {
						dx3 = -dx3;
						box3X = radius;
					} else if (box3X + radius > width) {
						dx3 = -dx3;
						box3X = width - radius;
					}
					
					if (box3Y - radius < 0) {
						dy3 = -dy3;
						box3Y = radius;
					} else if (box3Y + radius > height) {
						dy3 = -dy3;
						box3Y = height - radius;
					}
					repaint();
					
					rstart= System.currentTimeMillis();
					repaint();
					rend = System.currentTimeMillis();
					
						Thread.sleep(16-(rend-rstart));
					}catch (InterruptedException ex) {
			        }
			}	
		}
	};
	thread.start();
   }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
        g.setColor(Color.BLACK);
		g.fillRect((int) (box1X-radius), (int) (box1Y-radius), (int)diameter1, (int)diameter1);
        g.setColor(Color.RED);
        g.fillRect((int) (box2X-radius), (int) (box2Y-radius), (int)diameter2, (int)diameter2);
        g.setColor(Color.PINK);
        g.fillRect((int) (box3X-radius), (int) (box3Y-radius), (int)diameter3, (int)diameter3);
       
	}
	
	public static void main(String[] args) {
		BouncingBox fr = new BouncingBox();
		
		JFrame frame = new JFrame("Bouncing Box");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setContentPane(new BouncingBox());
		frame.setVisible(true);
	}
}