package view;

import controller.Controller;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.*;

import model.curves.Ellipse;
import model.curves.Parabola;
import model.curves.method.EllipseM;
import model.curves.method.ParabolaM;
import model.segments.Segment;
import model.segments.method.*;


public class Grid extends JPanel {
    private Graphics2D gr;
	
	public Grid(Controller contr){
		controller = contr;
		segment = new Segment();
                el = new Ellipse();
                par = new Parabola();
		this.setBackground(java.awt.Color.WHITE);	
		this.addMouseListener(new MouseMethod());	
	}
		
	public void paint(Graphics g) {	
		int cX = 1300, cY = 800;		
		for(int a = 0; a<= cX; a=a+5){ g.drawLine(a, 0, a, cY); }
		for(int b = 0; b<= cY; b=b+5){ g.drawLine(0, b, cX, b); }
                
                gr = (Graphics2D) g;
                gr.setPaint(Color.black);
                gr.setStroke(new BasicStroke((float) 1.7));
                gr.draw(new Line2D.Double(750,0,750,this.getHeight()));
                gr.draw(new Line2D.Double(0,350 ,this.getWidth(),350));
                
	}
	
	public void paintLine(){
		Graphics g = this.getGraphics();		
		switch(controller.getMethodSegments()){	
		case 1:
			segments = new MethodCDA(segment, g);
			segments.init();
			break;		
		case 2:
			segments = new MethodBresenhem(segment, g);
			segments.init();
			break;
		case 3:
			segments = new MethodWU(segment, g);
			segments.init();
			break;			
		}
	}
        
        public void paintCurve(double x,double y){
            Graphics g = this.getGraphics();
            switch(controller.getMethodCurve()){
                case 1:
                  ellipse = new EllipseM(el,g);
                  ellipse.init(x,y);
                  break;
                case 2:
                  parabola = new ParabolaM(par, g);
                  parabola.init(x,y);
                  break;
                default: ;
            }
        }
	
	public class MouseMethod implements MouseListener {	
		private boolean var = true;
//		private boolean curve = false;
                
		public void mouseClicked(MouseEvent me) {					
			if(var){
				segment.setPoint1(me.getX(), me.getY());
				controller.setPointText(me.getX(), me.getY());
				var = false;
			} else {
				segment.setPoint2(me.getX(), me.getY());
				controller.setPointText(me.getX(), me.getY());
				paintLine();				
				var = true;
			}
		}	
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me) {}
                
		public void mousePressed(MouseEvent me){
                     int curve = controller.getMethodCurve();
                     if(curve == 1){
                     paintCurve(me.getX(), me.getY());
                     }
                     else { if(curve == 2){ 
                     paintCurve(me.getX(), me.getY());
                        }
                     }    

                }
		public void mouseReleased(MouseEvent e){}			
	}
		
	public Controller controller;	
	//
	private Method segments;
        private ParabolaM parabola;
	public Segment segment;	
        public Parabola par;
        public Ellipse el;
        private EllipseM ellipse;
	//
	
}






