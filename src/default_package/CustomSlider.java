package default_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CustomSlider extends JPanel implements ChangeListener {

	JColorChooser tcc = new JColorChooser(Color.black);
	

	
	public CustomSlider() {
		super(new BorderLayout());
		tcc.getSelectionModel().addChangeListener(this);
		tcc.setPreviewPanel(new JPanel());	
		// tcc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
	    add(tcc);
	}
	
	

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		Color newColor = tcc.getColor();
		PaintMainFrame.selColor = newColor;
	}
}
