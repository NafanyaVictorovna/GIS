package model.segments.method;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import model.segments.Segment;


public class MethodCDA implements Method {
	
	public MethodCDA(Segment segm, Graphics g){
		segment = segm;
		graph = g;
		lists = new ArrayList<Point>();
	}

        @Override
        public void init(double x, double y){}
        
	@Override
	public void init() {
		// TODO Auto-generated method stub
			
		double X1 = segment.getPoint1().getX();
		double Y1 = segment.getPoint1().getY();		
		double X2 = segment.getPoint2().getX();
		double Y2 = segment.getPoint2().getY();
		
		double delX = X2 - X1;
		double delY = Y2 - Y1;
		
		double length = Math.max(Math.abs(X2 - X1), Math.abs(Y2 - Y1));
		
		double dx = delX / length;
		double dy = delY / length;
		
		//���������� �� 3� ������ ����� �������
		double retDX = new BigDecimal(dx).setScale(3, RoundingMode.UP).doubleValue();
		double retDY = new BigDecimal(dy).setScale(3, RoundingMode.UP).doubleValue();

		double X = X1 + (0.5*sign(retDX));
		double Y = Y1 + (0.5*sign(retDY));
		
		Point start = new Point((int)X, (int)Y);	
		lists.add(start);
		
		int i=0;
		while(i <= (int)length){
			X = X + retDX;
			Y = Y + retDY;			
			Point point = new Point((int)X, (int)Y);
			lists.add(point);			
			i = i+1;
		}
		
		for(int k=0; k<lists.size()-1; k++){
			Point point1 = lists.get(k);
			Point point2 = lists.get(k+1);			
			plot(point1, point2);
		}
				
	}
	
	private int sign(double num){
		int value = 0;		
		if(num < 0){ value = -1;}
		if(num == 0){ value = 0;}
		if(num > 0){ value = 1;}		
		return value;
	}
	
	private void plot(Point p1, Point p2){	
		int px1 = (int)p1.getX();
		int py1 = (int)p1.getY();
		int px2 = (int)p2.getX();
		int py2 = (int)p2.getY();
		
		Graphics2D g2 = (Graphics2D) graph;		
		g2.setColor(Color.BLACK);	
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2.drawLine(px1,py1,px2,py2);
	}
	
	
	private Segment segment;
	private Graphics graph;	
	private List<Point> lists;
}





