package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbox extends JPanel{
	
	
	public static int save_index;
	
	public Toolbox() {
		
		setBackground(new Color(25, 25, 25));
		setLayout(null);
		
		JButton[] saves = new JButton[6];
		for (int i = 0; i < saves.length; i++) {
			saves[i] = new JButton("");
			JButton temp = saves[i];
			saves[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					PaintMainFrame.selColor = temp.getBackground();
					ColorPanel.redSlider.setValue(temp.getBackground().getRed());
					ColorPanel.greenSlider.setValue(temp.getBackground().getGreen());
					ColorPanel.blueSlider.setValue(temp.getBackground().getBlue());
				}
				
			});
			
			saves[i].setBounds(i * (300/6), 75, 300/6 , 20);
			saves[i].setBackground(new Color(25,25,25));
			saves[i].setBorder(BorderFactory.createEmptyBorder());
			add(saves[i]);
		}
		
		JButton save = new JButton("Save");
		save.setBounds(245, 30, 50, 20);
		setButtonProperties(save);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saves[save_index].setBackground(PaintMainFrame.selColor);
				save_index++;
				if (save_index == 6) {save_index = 0;}
			}
			
		});
		add(save);
		
		JButton brush = new JButton("Brush");
		brush.setBounds(5, 5, 75, 20);
		addButton(brush, "brush");
		
		JButton block = new JButton("Block");
		block.setBounds(85, 5, 75, 20);
		addButton(block, "block");
		
		JButton eraser = new JButton("Eraser");
		eraser.setBounds(165, 5, 75, 20);
		addButton(eraser, "eraser");
		
		JButton color = new JButton("RGB");
		color.setBounds(245, 5, 50, 20);
		setButtonProperties(color);
		color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// open color selector to the right of tool box
				PaintMainFrame.showCP = !PaintMainFrame.showCP;
				if (PaintMainFrame.showCP) {
					PaintMainFrame.cp.setVisible(true);
					save.setVisible(true);
				} else {
					PaintMainFrame.cp.setVisible(false);
					save.setVisible(false);
				}
			}
			
		});
		add(color);		
		
		
	}
	
	private void setButtonProperties(JButton b) {
		b.setBackground(new Color(10, 10, 10));
		b.setForeground(new Color(240, 240, 240));
		b.setBorder(BorderFactory.createEmptyBorder());
		b.setFocusPainted(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(PaintMainFrame.selColor);
		g.fillRect(0, 95, 300, 5);
		
		repaint();
	}
	
	private void addButton(JButton b, String mode) {
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PaintMainFrame.mode = mode;
			}
			
		});
		b.setBackground(new Color(10, 10, 10));
		b.setForeground(new Color(240, 240, 240));
		b.setFocusPainted(false);
		b.setBorder(BorderFactory.createEmptyBorder());
		add(b);
	}
	
	
	
}
