package hf.see.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScribbleViewer {

	static ScribbleComponent Scribble = new ScribbleComponent();
	
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		// Options Panel konfiguration
		JPanel OptionsPanel = new JPanel();
		OptionsPanel.setLayout(new FlowLayout());
		
		// Optionen für Strichdicke
		JLabel LabelStrokeSize = new JLabel("Strichgrösse:");
		final JComboBox<Integer> ComboStrokeSize = new JComboBox<Integer>();
		ComboStrokeSize.setEditable(true);
		for(Integer i = 1; i<= 10;i++)
		{
			ComboStrokeSize.addItem(i);
		}
		ComboStrokeSize.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) {
					Integer set = Scribble.setThickness((Integer) ComboStrokeSize.getSelectedItem());
					ComboStrokeSize.setSelectedItem(set);
				}		
			});
		
		// Optionen für Farbe
		JLabel LabelColor = new JLabel("Farbe:");
		final JComboBox<Color> ComboColor = new JComboBox<Color>();
		ComboColor.addItem(Color.BLACK);
		ComboColor.addItem(Color.BLUE);
		ComboColor.addItem(Color.RED);
		ComboColor.addItem(Color.YELLOW);
		ComboColor.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) {
						Scribble.setColor((Color) ComboColor.getSelectedItem());
					}		
				});
		
		// Optionen zum löschen
		JButton EraseButton = new JButton("Löschen");
		EraseButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) {
						Scribble.Erase();
					}					
				});

			
		// Combo Panel füllen
		OptionsPanel.add(LabelStrokeSize);
		OptionsPanel.add(ComboStrokeSize);
		OptionsPanel.add(LabelColor);
		OptionsPanel.add(ComboColor);
		OptionsPanel.add(EraseButton);
		
		
		// Frame konfiguration
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.add(Scribble, BorderLayout.CENTER);
		f.add(OptionsPanel, BorderLayout.SOUTH);
		
		
		f.setBounds(50, 100, 800, 800);
		f.setVisible(true);

	}
	
}
