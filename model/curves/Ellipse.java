package model.curves;

import java.awt.Point;

/**
 *
 * @author Nafanya Victorovna
 */
public class Ellipse{
    
    private Point center;
    private double radiusA;
    private double radiusB;

    
    public Ellipse(){
        
        center = new Point();         
    }
    public void setCenter(double x, double y){
        center.setLocation(x, y);
    }
    
    public Point getCenter(){
        return center;
    }
    
    public void setRadius(double a, double b){
        radiusA = a;
        radiusB = b;
    }
    
    public double getRadiusA(){
        return radiusA;
    }
     
    public double getRadiusB(){
        return radiusB;
    }
}
