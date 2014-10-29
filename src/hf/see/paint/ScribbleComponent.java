package hf.see.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class ScribbleComponent extends JComponent {
	
	List<AdvancedLine> Lines = new ArrayList<AdvancedLine>();	
	int currentThickness = 1;
	Color currentColor = Color.BLACK;
	
	public ScribbleComponent() {
		this.addMouseMotionListener(new MyMouseMotionListener());
	}
	
	public int setThickness(int thickness)
	{
		thickness = (thickness < 1)?1:thickness;
		thickness = (thickness > 20)?20:thickness;
		currentThickness = thickness;
		return thickness;
	}
	
	public void setColor(Color color)
	{
		currentColor = color;
	}
	
	public void Erase()
	{
		Lines.clear();
		repaint();
	}
	
	class AdvancedLine
	{
		public AdvancedLine(float x1, float y1, float x2, float y2)
		{
			Line = new Line2D.Float(x1, y1, x2, y2);
			Thickness = currentThickness;
			LineColor = currentColor;
			
		}
		public Line2D Line = null;
		public int Thickness = 1;
		public Color LineColor = Color.BLACK;
	}	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;


		for(Iterator<AdvancedLine> i = Lines.iterator();i.hasNext();)
		{	
			AdvancedLine currentLine = i.next();
			g2.setStroke(new BasicStroke(currentLine.Thickness));
			g2.setColor(currentLine.LineColor);
			g2.draw(currentLine.Line);
		}
	}
	
	public class MyMouseMotionListener implements MouseMotionListener {

		Point lastPoint = null;
		
		public void mouseDragged(MouseEvent e) {

			if(lastPoint == null)
			{
				lastPoint = new Point(e.getX(), e.getY());
			}
			else
			{
				Lines.add(new AdvancedLine(lastPoint.x, lastPoint.y, e.getX(), e.getY()));
				lastPoint = new Point(e.getX(), e.getY());
			}
			repaint();
			
		}

		public void mouseMoved(MouseEvent arg0) {
			lastPoint = null;						
			
		}
		
		
	}
	

}
