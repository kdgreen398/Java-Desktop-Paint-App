package default_package;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class PaintMainFrame extends JPanel implements MouseMotionListener, MouseListener{
	
		
	private JFrame window = new JFrame("WhiteBoard by Kaleb");
	private Toolbox tb = new Toolbox();
	public static ColorPanel cp = new ColorPanel();
	
	private int x, y; 
	public static int size = 25;
	public static String mode = "brush";
	public static Color selColor = new Color(ColorPanel.red_value, ColorPanel.green_value, ColorPanel.blue_value);
	
	public static boolean showCP = true;
	
	public PaintMainFrame() {
		addMouseMotionListener(this);
		addMouseListener(this);
		
		setLayout(null);
		setSize(new Dimension(700, 600));
		setPreferredSize(getSize());
		
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.add(this);
		
		final int WIDTH = getWidth();
		final int HEIGHT = getHeight();
		
		
		tb.setBounds(WIDTH/2 - 150, HEIGHT - 110, 300, 100);
		
		cp.setBounds(WIDTH/2 + 155, HEIGHT - 110, WIDTH/2 - 160, 100);	
		
		add(tb);
		add(cp);
	    window.pack();
	    
	}
	
	public static void main(String[] args) {
		new PaintMainFrame();
	}
	

	
	public void action(MouseEvent e) {
		int offset = size/2;
		Graphics g = getGraphics();
		x = e.getX();
		y = e.getY();
			
		switch(mode) {
		case "brush":
			g.setColor(selColor);
			g.fillOval(x - offset, y - offset, size, size);
			break;
		case "block":
			g.setColor(selColor);
			g.fillRect(x - offset, y - offset, size, size);
			break;
		case "eraser":
			g.setColor(getBackground());
			g.fillRect(x - offset, y - offset, size, size);
			break;
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		action(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		action(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {

		System.out.println(e);
	}

}
