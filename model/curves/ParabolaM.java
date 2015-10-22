package model.curves.method;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.QuadCurve2D;
import static java.net.URI.create;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import model.curves.Parabola;
import model.segments.method.Method;

/**
 *
 * @author Nafanya Victorovna
 */
public class ParabolaM implements Method{
            
        private Parabola parabola;
        private Graphics g;
        private Point apex, point;
        private ArrayList<Point> point_list;
        
        
    
        public ParabolaM(Parabola elem, Graphics g){
            
            parabola = elem;
            this.g = g;
            apex = new Point();
            point_list = new ArrayList<Point>();

        }
        
     @Override
     public void init(double x, double y){
        int vertical, horizontal, diagonal;
        int xpositive = 0;
        int xnegative = 0;
        int cy = 0;   
        
        parabola.setApex(x, y);
        String p = JOptionPane.showInputDialog("Input p:");
        double param = Double.parseDouble(p); 
        if(param == 0)JOptionPane.showMessageDialog(null, "This number can't be equal 0!", 
                "Warning!", ERROR_MESSAGE);
        
        parabola.setP(param);
        apex = parabola.getApex();
        point_list.add(apex);

            diagonal = (xpositive+1)*(xpositive+1)/2/(int)param + (cy-1);
            vertical = (xpositive+1)*(xpositive+1)/2/(int)param + cy;
            horizontal = xpositive*xpositive/2/(int)param + (cy-1);
        if(param > 0){
            while((int)y+cy>(int)y-200){
            if(Math.abs(horizontal)-Math.abs(vertical)<=0){
                if(Math.abs(diagonal)-Math.abs(horizontal)<0){
                    xpositive++;
                    xnegative--;
                }
                cy--;
            } else{
                if(Math.abs(vertical)-Math.abs(diagonal)>0){
                   cy--; 
                }
                xpositive++;
                xnegative--;
            }
            point = new Point(xpositive+(int)x,(int)y+cy);
            point_list.add(point);
            point = new Point((int)x+xnegative,(int)y+cy);
            point_list.add(point);
            
            diagonal = (xpositive+1)*(xpositive+1)/2/(int)param + (cy-1);
            vertical = (xpositive+1)*(xpositive+1)/2/(int)param + cy;
            horizontal = xpositive*xpositive/2/(int)param + (cy-1);
            
            }
        } else if(param < 0){
        while((int)y+cy<(int)y+200){
            if(Math.abs(vertical)-Math.abs(horizontal)>=0){
                if(Math.abs(diagonal)-Math.abs(vertical)>0){//horizontal
                    xpositive++;
                    xnegative--;
                }
                cy++;
            } else{
                if(Math.abs(horizontal)-Math.abs(diagonal)<0){//vertical
                   cy++; 
                }
                xpositive++;
                xnegative--;
            }
            point = new Point(xpositive+(int)x,(int)y+cy);
            point_list.add(point);
            point = new Point((int)x+xnegative,(int)y+cy);
            point_list.add(point);
            
            diagonal = (xpositive+1)*(xpositive+1)/2/(int)param + (cy+1);
            vertical = (xpositive+1)*(xpositive+1)/2/(int)param + cy;
            horizontal = xpositive*xpositive/2/(int)param + (cy+1);
            } 
        }
            for(int i =0; i<point_list.size()-1; i++){
                plot(point_list.get(i));
            }

     }

    @Override
    public void init() {}
        
    public void plot(Point point){
        Graphics2D g2 = (Graphics2D) g;
        double x = point.getX();
        double y = point.getY();
 //       QuadCurve2D q = new QuadCurve2D.Float();
//        q.setCurve((x-54),(x+54)/Math.pow(2*p, 1.0/2),x, y,
//                (x+54),(x+54)/Math.pow(2*p, 1.0/2));  
        g2.setStroke(new BasicStroke((float)2.0));
//        g2.draw(q);
        g2.drawOval((int)x, (int)y, 0, 1);
}
}
