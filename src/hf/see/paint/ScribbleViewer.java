package hf.see.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class ScribbleViewer {

	public static void main(String[] args) {
		
		// Options Panel konfiguration
		JPanel OptionsPanel = new JPanel();
		OptionsPanel.setLayout(new FlowLayout());
		
		// Label konfiguration
		JLabel LabelStrokeSize = new JLabel("Strichgrösse:");
		JLabel LabelColor = new JLabel("Farbe:");
		
		// Combobox konfiguration
		JComboBox<Integer> ComboStrokeSize = new JComboBox<Integer>();
		ComboStrokeSize.setEditable(true);
		for(int i = 1; i<= 10;i++)
		{
			ComboStrokeSize.addItem(i);
		}
			
		// Combo Panel füllen
		OptionsPanel.add(LabelStrokeSize);
		OptionsPanel.add(ComboStrokeSize);
		OptionsPanel.add(LabelColor);
		
		// Scribble konfiguration
		ScribbleComponent Scribble = new ScribbleComponent();
		
		// Frame konfiguration
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.add(Scribble, BorderLayout.CENTER);
		f.add(OptionsPanel, BorderLayout.SOUTH);
		
		
		f.setBounds(50, 100, 800, 800);
		f.setVisible(true);

	}

}
