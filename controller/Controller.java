package controller;

import javax.swing.JTextArea;

import model.segments.Segment;


public class Controller {

	private int numMethodSegments = 0;
	//private JTextArea text;
        private int numMethodCurve = 0;
                
	public Controller(){
		//text =new JTextArea();
	}
	
	public void setMethodSegments(int num){
		numMethodSegments = num;	
		
	}
	
	public int getMethodSegments(){
		return numMethodSegments;
	}
	
	public void setPointText(int x, int y){
		
	/*	System.out.println("Point!");
		
		 String str = text.getText();
		StringBuffer sb = new StringBuffer(str);
		
		String addStr = "Point: (" + Integer.toString(x) + " , " + Integer.toString(y) + ")";
		sb.append(addStr);
		
		text.setText(sb.toString());*/
	}

        public void setMethodCurve(int num) {
            numMethodCurve = num;
        }
        public int getMethodCurve(){
            return numMethodCurve; 
        }
	
}
