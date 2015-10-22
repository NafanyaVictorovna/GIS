/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.choosing.shape;

import java.awt.Graphics;
import model.choosing.shape.MyPoint;
import java.util.ArrayList;

/**
 *
 * @author Nafanya Victorovna
 */
public class Cube {
    
    private int center;                          //center of gravity
    private ArrayList<MyPoint> all_vertex;         //vertexes of cube
    private Graphics g;
 //   private MyPoint vertex;
    
    void Cube(){
        all_vertex.add(new MyPoint());
    }
    
    
    public int getCenter() {
        return center;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public ArrayList<MyPoint> getAll_vertex() {
        return all_vertex;
    }

    public void setAll_vertex(ArrayList<MyPoint> all_vertex) {
        this.all_vertex = all_vertex;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }
//
//    public MyPoint getVertex() {
//        return vertex;
//    }
//
//    public void setVertex(MyPoint vertex) {
//        this.vertex = vertex;
//    }

}
