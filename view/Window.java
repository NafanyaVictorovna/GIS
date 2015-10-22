package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.Controller;
import java.net.URL;

public class Window extends JFrame implements ItemListener {
	
	 private JCheckBoxMenuItem Item1;
	 private JCheckBoxMenuItem Item2;
	 private JCheckBoxMenuItem Item3;  
         private JCheckBoxMenuItem rotation;
         private JCheckBoxMenuItem reflection;
         private JCheckBoxMenuItem scale;
         private JCheckBoxMenuItem perspective;
         private JCheckBoxMenuItem transfer;
         private JCheckBoxMenuItem Ellipse;
         private JCheckBoxMenuItem Parabola;
	 //
        private JTextArea textArea;
	 
	private Controller controller;
   

	public Window(){
		this.setTitle("graphic editor");
		this.setSize(1300,700);		
		
		controller = new Controller();

		this.setJMenuBar(createMenu());
		this.getContentPane().add(initComponents());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private JMenuBar createMenu(){
		 JMenuBar menubar = new JMenuBar();			 
		 JMenu menuFile = new JMenu("file");
		 JMenu menuSegment = new JMenu("segment");
                 JMenu menuCurve = new JMenu("curve");
                 JMenu menuChoose = new JMenu("choosing");                 
                 JMenu menuAbout = new JMenu("About");
                 
                 String path_file_icon = "../images/oldopenofficeorgdraw.png";
                 URL imgURL_file = Window.class.getResource(path_file_icon);
                 ImageIcon file = new ImageIcon(imgURL_file);
                 
                 String path_segment_icon = "../images/icon1.png";
                 URL imgURL_segment = Window.class.getResource(path_segment_icon);
                 ImageIcon segment = new ImageIcon(imgURL_segment);
                 
                 String path_curve_icon = "../images/icon2.png";
                 URL imgURL_curve = Window.class.getResource(path_curve_icon);
                 ImageIcon curve = new ImageIcon(imgURL_curve);
                 
                 String path_choose_icon = "../images/папка.png";
                 URL imgURL_choose = Window.class.getResource(path_choose_icon);
                 ImageIcon choose = new ImageIcon(imgURL_choose);
                 
                 String path_about_icon = "../images/pumpkin.png";
                 URL imgURL_about = Window.class.getResource(path_about_icon);
                 ImageIcon about = new ImageIcon(imgURL_about);
                 
		 ButtonGroup group = new ButtonGroup();			 
		  Item1 = new JCheckBoxMenuItem("1_CDA");
		  Item2 = new JCheckBoxMenuItem("2_Bresengheim");
		  Item3 = new JCheckBoxMenuItem("3_aliasing");
                  group.add(Item1);
                  group.add(Item2);
                  group.add(Item3);
                 
                  ButtonGroup crv = new ButtonGroup();
                  Ellipse = new JCheckBoxMenuItem("ellipse");
                  Parabola = new JCheckBoxMenuItem("parabola");
                  crv.add(Ellipse);
                  crv.add(Parabola);
                  
//              преобразования			 
		  transfer = new JCheckBoxMenuItem("transfer");
		  rotation = new JCheckBoxMenuItem("rotation");
		  reflection = new JCheckBoxMenuItem("reflection");
                  scale = new JCheckBoxMenuItem("scale");
                  perspective = new JCheckBoxMenuItem("perspective");
                  
		 Font font = new Font("Cambria", Font.BOLD, 16);		
		 
		 Item1.setFont(font);
		 Item2.setFont(font);
		 Item3.setFont(font);
                 Ellipse.setFont(font);
                 Parabola.setFont(font);
                 rotation.setFont(font);
                 transfer.setFont(font);
                 reflection.setFont(font);
                 scale.setFont(font);
                 perspective.setFont(font);
		 
		 Item1.addItemListener(this);
		 Item2.addItemListener(this);
		 Item3.addItemListener(this);
                 Ellipse.addItemListener(this);
                 Parabola.addItemListener(this);
                 rotation.addItemListener(this);
                 transfer.addItemListener(this);
                 reflection.addItemListener(this);
                 scale.addItemListener(this);
                 perspective.addItemListener(this);
		 	 
		 //checkItem1.setSelected(true);
		 	 
		 menuFile.setFont(font);
		 menuSegment.setFont(font);						
		 menuSegment.add(Item1);
		 menuSegment.add(Item2);
		 menuSegment.add(Item3);
                 menuCurve.add(Ellipse);
                 menuCurve.add(Parabola);
		 menuChoose.add(transfer);
                 menuChoose.add(rotation);
                 menuChoose.add(reflection);
                 menuChoose.add(scale);
                 menuChoose.add(perspective);
                 
		 menubar.add(menuFile);	 
		 menubar.add(menuSegment);
                 menubar.add(menuCurve);
                 menubar.add(menuChoose);
                 menubar.add(menuAbout);
                 
                 menuFile.setIcon(file);
		 menuSegment.setIcon(segment);
                 menuCurve.setIcon(curve);
                 menuChoose.setIcon(choose);
		 menuAbout.setIcon(about);
                 
                 menuAbout.addActionListener(new java.awt.event.ActionListener() {

                     @Override
                     public void actionPerformed(ActionEvent e) {
                         JFrame frame = new JFrame();
                         JOptionPane.showMessageDialog(frame.getContentPane(), "This editor was created of:"
                                 + "O.Lipskaya & N.Tsarkevich who are students of 121702 gr.");
                          }
                 });
			
		 return menubar;
	}

	private JPanel initComponents(){
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
                //scroll 
                JScrollPane scroll = new JScrollPane(mainPanel);
                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//
		JToolBar toolBar = new JToolBar("", JToolBar.VERTICAL);
		toolBar.setSize(100, 800);
		toolBar.setBackground(Color.DARK_GRAY);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setText("?????????????");
					
		Grid net = new Grid(controller);
		net.repaint();		
			
		mainPanel.add(toolBar, BorderLayout.WEST);
		mainPanel.add(net, BorderLayout.CENTER);
		mainPanel.add(textArea, BorderLayout.EAST);
                		
		return mainPanel;
	}	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getSource().equals(Item1)){			
			int num = 1;
			controller.setMethodSegments(num);			
		}
		if(e.getSource().equals(Item2)){
			
			int num = 2;
			controller.setMethodSegments(num);
		}
		if(e.getSource().equals(Item3)){
			
			int num = 3;
			controller.setMethodSegments(num);
		}
                if(e.getSource().equals(Ellipse)){			
			controller.setMethodCurve(1);
		}
                if(e.getSource().equals(Parabola)){			
			controller.setMethodCurve(2);
		}
	}

	
}
