package model.segments.method;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import model.segments.Segment;


public class MethodBresenhem implements Method {

	public MethodBresenhem(Segment segm, Graphics g){
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
		
		int numQadrant = 0;
		if((delX>=0) && (delY>=0)){ numQadrant=1; }
		if((delX>=0) && (delY<=0)){ numQadrant=2; }
		if((delX<=0) && (delY<=0)){ numQadrant=3; }
		if((delX<=0) && (delY>=0)){ numQadrant=4; }
	
		double dYX = new BigDecimal(delY/ delX).setScale(3, RoundingMode.UP).doubleValue();	
		double error = new BigDecimal(delY/ delX - 0.5).setScale(3, RoundingMode.UP).doubleValue();	
		
		Point p1 = new Point((int)X1, (int)Y1);
		lists.add(p1);	
		
		double i = 1;
		double X = X1;
		double Y = Y1;		
		double XXX = Math.abs(delX);
		
		switch(numQadrant){
		case 1:
			while(i <= XXX) {
				if(error >= 0){
					Y = Y + 1;
					error = error - 1;									
				} 
				X = X + 1;
				error = error + delY/delX;			
				Point pi = new Point((int)X, (int)Y);
				lists.add(pi);
				i = i+1;		
			}		
			break;
		case 2:			
			while(i <= XXX){
				if(error >= 0){
					Y = Y - 1;
					error = error + 1;									
				} 
				X = X + 1;
				error = error - delY/delX;			
				Point pi = new Point((int)X, (int)Y);
				lists.add(pi);
				i = i+1;		
			}		
			break;
		case 3:
			while(i <= XXX){
				if(error >= 0){
					Y = Y - 1;
					error = error + 1;									
				} 
				X = X - 1;
				error = error - delY/delX;			
				Point pi = new Point((int)X, (int)Y);
				lists.add(pi);
				i = i+1;		
			}			
			break;
		case 4:
			while(i <= XXX){
				if(error >= 0){
					Y = Y + 1;
					error = error - 1;									
				} 
				X = X - 1;
				error = error - delY/delX;			
				Point pi = new Point((int)X, (int)Y);
				lists.add(pi);
				i = i+1;		
			}			
			break;
		}		
		
		for(int k=0; k<lists.size()-1; k++){
			plot(lists.get(k), lists.get(k+1));
		}
			
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
