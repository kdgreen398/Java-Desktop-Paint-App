package default_package;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPanel extends JPanel{
	public static int red_value = 127, green_value = 127, blue_value = 127, r_index = 0;
	public static JSlider redSlider, greenSlider, blueSlider;
	
	
	public ColorPanel(){
		
		createComponents();
	}

	private void createComponents() {
		setBackground(new Color(10, 10, 10));
		setLayout(null);
		
		redSlider = new JSlider(JSlider.HORIZONTAL,0, 255, red_value);
		addSlider(redSlider, "R", 55, 0);
		
		greenSlider = new JSlider(JSlider.HORIZONTAL,0, 255, green_value);
		addSlider(greenSlider, "G", 55, 25);
		
		blueSlider = new JSlider(JSlider.HORIZONTAL,0, 255, blue_value);
		addSlider(blueSlider, "B", 55, 50);
		
		JSlider radiusSlider = new JSlider(JSlider.HORIZONTAL,1, 80, 50);
		addSlider(radiusSlider, "Size", 55, 75);
		
		
	    
	    

	}
	

	private void addSlider(JSlider s, String str, int x, int y) {
		// TODO Auto-generated method stub
		s.setBounds(x, y, 135, 25);
		s.setBackground(new Color(10, 10, 10));
				
		JLabel v_label = new JLabel(str + ": ");
		
		s.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int c_value = ((JSlider)e.getSource()).getValue();
				String v = Integer.toString(c_value);
				setValue(c_value, str);
				v_label.setText(str + ": " + v);
			}
			
		});
		
		v_label.setBounds(x - 45, y, 135, 25);
		v_label.setForeground(new Color(255, 255, 255));
		
		add(s);
		add(v_label);

	}


	private void setValue(int value, String s) {
		switch(s) {
		case "R":
			red_value = value;
			break;
		case "G":
			green_value = value;
			break;
		case "B":
			blue_value = value;
			break;
		case "Size":
			PaintMainFrame.size = value;
		}

		PaintMainFrame.selColor = new Color(red_value, green_value, blue_value);
		
				
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint();
	}


	
}
