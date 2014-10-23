package hf.see.paint;

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
	
	public ScribbleComponent() {
		this.addMouseMotionListener(new MyMouseMotionListener());
	}
	
	
	List<Point> Points = new ArrayList<Point>();
	boolean draggingComplete = true;
	
	
	private List<Line2D> convertPointsToLines()
	{
		List<Line2D> Lines = new ArrayList<Line2D>();
		Point lastPoint = null;
		Point currentPoint = null;
		
		for(Iterator<Point> i = Points.iterator();i.hasNext();)
		{	
			currentPoint = i.next();
			if(lastPoint == null || currentPoint == null)
			{
				lastPoint = currentPoint;
				continue;
			}
			
			Line2D line = new Line2D.Float(lastPoint.x, lastPoint.y, currentPoint.x, currentPoint.y);
			lastPoint = currentPoint;
			Lines.add(line);
		}
		return Lines;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		if(draggingComplete == true)
		{
			draggingComplete = false;
		}
		
		List<Line2D> Lines = convertPointsToLines();
		for(Iterator<Line2D> i = Lines.iterator();i.hasNext();)
		{	
			g2.draw(i.next());
		}
	}
	
	public class MyMouseMotionListener implements MouseMotionListener {

		public void mouseDragged(MouseEvent e) {

			Points.add(new Point(e.getX(), e.getY()));
			System.out.println( e.getX() + "/" +  e.getY() + " point added");
			repaint();
			
		}

		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub		
			if(draggingComplete == false)
			{
				draggingComplete = true;
				Points.add(null);
				System.out.println("null point added");
			}
						
			
		}
		
		
	}
	

}
