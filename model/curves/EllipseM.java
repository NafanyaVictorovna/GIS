/*
*
*/

package model.curves.method;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.curves.Ellipse;
import model.segments.method.Method;



/**
 *
 * @author Nafanya Victorovna
 */
public class EllipseM implements Method{

        private Ellipse ellipse;
        private Graphics g;
        private ArrayList<Point> point_list;
        private  Point point;

        
    public EllipseM(Ellipse elem, Graphics g) {
            ellipse = elem;
            this.g = g;
            point_list = new ArrayList<Point>();
            point = new Point();
    }
    
    
    @Override
    public void init(double x, double y ) {      
            ellipse.setCenter(x, y);
            String w = JOptionPane.showInputDialog("Input width of your ellipse:");
            String h = JOptionPane.showInputDialog("Input height of your ellipse:");
            int b = Integer.parseInt(w);   //b - по оси x
            int a = Integer.parseInt(h); //a  - по оси y
            ellipse.setRadius(b, a);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke((float)2.0));        
// непосредственное рисование эллипса инструментами java            
 //           g2.drawOval((int)x, (int)y, (int)b*20, (int)a*25);
            
            int cx = (int)x;
            int cy = (int)y;
//алгоритм... кривоват           
            double error = 2*b*b*(a-1)*a + Math.pow(b,2) + 2*(1-b*b)*a*a;
            int coordX = 0;
            int coordY = a;
            while(coordY*b*b > a*a*coordX){
                point = new Point(cx+coordX, cy+coordY);
                point_list.add(point);
                point = new Point(cx+coordX, cy-coordY);
                point_list.add(point);
                point = new Point(cx-coordX, cy+coordY);
                point_list.add(point);
                point = new Point(cx-coordX, cy-coordY);
                point_list.add(point);
                if(error>=0){
                    coordY--;
                    error -= 4*b*b*coordY;
                }
                error += 2*a*a*(3 + 2*coordX);
                coordX++; 
            } 
 //           
            error = 2*a*a*(coordX+1)*coordX + 2*b*b*(coordY*(coordY-2)+1)+(1-2*b*b)*a*a;   
//            
            while(coordY+1>0){
                point = new Point(cx+coordX, cy+coordY);
                point_list.add(point);
                point = new Point(cx+coordX, cy-coordY);
                point_list.add(point);
                point = new Point(cx-coordX, cy+coordY);
                point_list.add(point);
                point = new Point(cx-coordX, cy-coordY);
                point_list.add(point);
            if(error<=0){
                    coordX++;
                    error += 4*a*a*coordX;
                }   
               coordY--;
               error += 2*b*b*(3 - 2*coordY);
            }
            
            for(int i=0; i<point_list.size()-1; i++){
		plot(point_list.get(i));
                        
            }
        } 
    	
        private void plot(Point p){	
		int px = (int)p.getX();
		int py = (int)p.getY();
		
		Graphics2D g2 = (Graphics2D) g;		
		g2.setStroke(new BasicStroke((float)2.0));
                g2.drawOval(px, py, 1, 0);
	}

    @Override
    public void init() {}
}
