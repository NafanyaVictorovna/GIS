/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.curves;

import java.awt.Point;

/**
 *
 * @author Nafanya Victorovna
 */
public class Parabola {
    
    private Point apex;
    private double p;
    
    public Parabola(){
        apex = new Point(); 
    }
    public void setApex(double x, double y){
        apex.setLocation(x, y);
    }
    
    public Point getApex(){
        return apex;
    }
    
    public void setP(double x){
        p = x;
    }
    
    public double getP(){
        return p;
    }
}
