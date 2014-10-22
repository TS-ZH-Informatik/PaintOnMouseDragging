package hf.see.paint;

import javax.swing.JFrame;

public class ScribbleViewer {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new ScribbleComponent());		
		f.setBounds(50, 100, 800, 800);
		f.setVisible(true);

	}

}
