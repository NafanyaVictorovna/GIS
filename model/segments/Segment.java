package model.segments;

import java.awt.Point;

public class Segment {
	
	public Segment() {
		point1 = new Point();
		point2 = new Point();
	}
	
	public void setPoint1(int x, int y){
		point1.setLocation(x, y);
	}
	
	public void setPoint2(int x, int y){
		point2.setLocation(x, y);
	}

	public Point getPoint1(){ return point1; }	
	
	public Point getPoint2(){ return point2; }
	
	private Point point1;
	private Point point2;
}
