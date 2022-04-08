package contariaCalc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI implements ActionListener {
	
	public static JFrame frame = new JFrame("ContariaCalc");
	static JPanel panel = new MotionPanel(frame);
	static JButton close = new JButton("X");
	static JButton minimize = new JButton("_");
	static JLabel topbar = new JLabel("ContariaCalc v1.1.1");
	static JLabel topbar2 = new JLabel();
	static JButton hide = new JButton("...");
	static JButton find = new JButton("Find");
	static JButton settings = new JButton("Settings");
	static JButton clear = new JButton("Clear");
	static JLabel xza1 = new JLabel("x z a");
	static JLabel xza2 = new JLabel("x z a");
	static JLabel sh = new JLabel("SH Location:");
	static JLabel distance1 = new JLabel("");
	static JLabel distance2 = new JLabel("");
	static JLabel result = new JLabel("");
	static JLabel nethercoords = new JLabel("Nethercoords:");
	static JLabel nethercoords_ = new JLabel();
	static JLabel chunkcoords = new JLabel("Chunkcoords:");
	static JLabel chunkcoords_ = new JLabel();
	static JTextField firstcoords = new JTextField("");
	static JTextField secondcoords = new JTextField("");
	
	public static boolean CoordsOverlay = false;
	public static boolean ClipboardReader = false;
	public static int ClipboardreaderDelay = 1000;
	public static boolean ShowDistance = true;
	public static int DistanceFrom = 0;
	public static boolean ShowNetherCoords = false;
	public static int NetherCoordsDecimals = 0;
	public static boolean ShowChunkCoords = false;
	public static boolean AlwaysOnTop = true ;
	public static boolean Autoclear = false;
	public static int AutoclearAfter = 15;
	public static boolean HideWhenCleared;
	public static int ShowCoordsOnHideScreen = 0;
	public static int m = 100;
	public static int c = 255;
	
	static int extracoords = 0;
	static int framex_extra = 0;
	public static int numberofcalculations = 0;
	public static boolean hidden = false;
	public static boolean overwritefirst = true;

	public String[] firstcoords_split = firstcoords.getText().split(" ");
	public String[] secondcoords_split = secondcoords.getText().split(" ");
	
	public GUI() {
		
		Resize(m);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.add(panel);
		frame.setBackground(Color.gray);
		
		panel.setLayout(null);
		
		panel.add(close);
		panel.add(minimize);
		panel.add(topbar);
		panel.add(topbar2);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		close.setBorder(emptyBorder);
		minimize.setBorder(emptyBorder);
		close.setBackground(new Color(220, 0, 0, 255));
		minimize.setBackground(Color.lightGray);
		topbar.setBackground(Color.lightGray);
		topbar.setOpaque(true);
		topbar2.setBackground(Color.lightGray);
		topbar2.setOpaque(true);

		panel.add(settings);
		panel.add(clear);
		panel.add(hide);
		
		panel.add(firstcoords);
		panel.add(xza1);
		panel.add(distance1);
		
		panel.add(secondcoords);
		panel.add(xza2);
		panel.add(distance2);
		
		panel.add(find);
		
		panel.add(sh);
		panel.add(result);
		
		panel.add(nethercoords);
		nethercoords.setVisible(false);
		panel.add(nethercoords_);
		nethercoords_.setVisible(false);
		
		panel.add(chunkcoords);
		chunkcoords.setVisible(false);
		panel.add(chunkcoords_);
		chunkcoords_.setVisible(false);
		
		
		find.addActionListener(this);
		settings.addActionListener(this);
		clear.addActionListener(this);
		hide.addActionListener(this);
		close.addActionListener(this);
		minimize.addActionListener(this);
		
		}
	
	public static void Resize(int m) {
		
		int v = 90 * m/100;
		if(v < 100) {
			v = 100;
		}
		
		if(hidden) {
			frame.setSize(210*m/100, 30*m/100 + 45);
		} 
		else {
			frame.setSize(210*m/100, (165+extracoords*20)*m/100);  
		}

		close.setBounds((185*m/100+framex_extra), 0, 25*m/100, 25*m/100);
		close.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		minimize.setBounds((160+framex_extra)*m/100, 0, 25*m/100, 25*m/100);
		minimize.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		topbar.setBounds(10*m/100, 0, 185*m/100, 25*m/100);
		topbar2.setBounds(0, 0, 10*m/100, 25*m/100);
		topbar.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		
		settings.setBounds(35*m/100, 30*m/100, 85*m/100, 20*m/100);
		settings.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		clear.setBounds(125*m/100, 30*m/100, 75*m/100, 20*m/100);
		clear.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		hide.setBounds(10*m/100, 30*m/100, 20*m/100, 20*m/100);
		hide.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		
		firstcoords.setBounds(45*m/100, 60*m/100, 150*m/100, 20*m/100);
		xza1.setBounds(10*m/100, 60*m/100, 30*m/100, 20*m/100);
		xza1.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		distance1.setBounds(200*m/100, 60*m/100, 50*m/100, 20*m/100);
		distance1.setFont(new Font("Arial", Font.BOLD, 12*m/100));
			
		secondcoords.setBounds(45*m/100, 85*m/100, 150*m/100, 20*m/100);
		xza2.setBounds(10*m/100, 85*m/100, 30*m/100, 20*m/100);
		xza2.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		distance2.setBounds(200*m/100, 85*m/100, 50*m/100, 20*m/100);
		distance2.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		
		find.setBounds(70*m/100, 112*m/100, 70*m/100, 25*m/100);
		find.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		
		sh.setBounds(10*m/100, 140*m/100, 90*m/100, 20*m/100);
		sh.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		
		nethercoords.setBounds(10*m/100, 160*m/100, 100*m/100, 20*m/100);
		nethercoords.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		nethercoords_.setBounds(v, 160*m/100, 100*m/100, 20*m/100);
		nethercoords_.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		
		chunkcoords.setBounds(10*m/100, (160+(extracoords-1)*20)*m/100, 100*m/100, 20*m/100);
		chunkcoords.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		chunkcoords_.setBounds(v, (160+(extracoords-1)*20)*m/100, 100*m/100, 20*m/100);
		chunkcoords_.setFont(new Font("Arial", Font.BOLD, 12*m/100));
		
		v = 90 * m/100;
		if(v < 90) {
			v = 90;
		}
		result.setBounds(v, 140*m/100, 150*m/100, 20*m/100);
		result.setFont(new Font("Arial", Font.BOLD, 12*m/100));
	}
	
	public static void SetColor(int tone) {
		
		int paneltone = tone - 50;
		int titlebartone = paneltone - 40;
		int texttone = 255-paneltone;
		if(220 > texttone) {
			if(texttone > 35) {
				if(texttone > 150) {
					texttone = 220;
				}
				else {
					texttone = 35;
				}
			}
		}
		int buttonnametone = 255-tone;
		if(230 > buttonnametone) {
			if(buttonnametone > 35) {
				if(buttonnametone > 140) {
					buttonnametone = 230;
				}
				else {
					buttonnametone = 35;
				}
			}
		}
		
		panel.setBackground(new Color(paneltone, paneltone, paneltone, 255));
		
		hide.setBackground(new Color(tone, tone, tone, 255));
		settings.setBackground(new Color(tone, tone, tone, 255));
		clear.setBackground(new Color(tone, tone, tone, 255));
		hide.setBackground(new Color(tone, tone, tone, 255));
		firstcoords.setBackground(new Color(tone, tone, tone, 255));
		secondcoords.setBackground(new Color(tone, tone, tone, 255));
		find.setBackground(new Color(tone, tone, tone, 255));
		sh.setForeground(new Color(texttone, texttone, texttone, 255));
		xza1.setForeground(new Color(texttone, texttone, texttone, 255));
		xza2.setForeground(new Color(texttone, texttone, texttone, 255));
		result.setForeground(new Color(texttone, texttone, texttone, 255));
		distance1.setForeground(new Color(texttone, texttone, texttone, 255));
		distance2.setForeground(new Color(texttone, texttone, texttone, 255));
		nethercoords.setForeground(new Color(texttone, texttone, texttone, 255));
		nethercoords_.setForeground(new Color(texttone, texttone, texttone, 255));
		chunkcoords.setForeground(new Color(texttone, texttone, texttone, 255));
		chunkcoords_.setForeground(new Color(texttone, texttone, texttone, 255));
		topbar.setForeground(new Color(texttone, texttone, texttone, 255));
		minimize.setForeground(new Color(texttone, texttone, texttone, 255));
		hide.setForeground(new Color(buttonnametone, buttonnametone, buttonnametone, 255));
		settings.setForeground(new Color(buttonnametone, buttonnametone, buttonnametone, 255));
		clear.setForeground(new Color(buttonnametone, buttonnametone, buttonnametone, 255));
		find.setForeground(new Color(buttonnametone, buttonnametone, buttonnametone, 255));
		firstcoords.setForeground(new Color(buttonnametone, buttonnametone, buttonnametone, 255));
		secondcoords.setForeground(new Color(buttonnametone, buttonnametone, buttonnametone, 255));
		minimize.setBackground(new Color(titlebartone, titlebartone, titlebartone, 255));
		topbar.setBackground(new Color(titlebartone, titlebartone, titlebartone, 255));
		topbar2.setBackground(new Color(titlebartone, titlebartone, titlebartone, 255));
		
	}
	
	public static void Clear() {
		
		if(hidden) {
			frame.setSize(210*m/100, 50*m/100 + 5);
		} 
		else {
			frame.setSize(210*m/100, 165*m/100);  
		}

		close.setBounds(185*m/100, 0, 25*m/100, 25*m/100);
		minimize.setBounds(160*m/100, 0, 25*m/100, 25*m/100);
		
		result.setText("");
		firstcoords.setText("");
		secondcoords.setText("");
		distance1.setText("");
		distance2.setText("");
		nethercoords.setVisible(false);
		nethercoords_.setVisible(false);
		chunkcoords.setVisible(false);
		chunkcoords_.setVisible(false);
		extracoords = 0;
		framex_extra = 0;
		numberofcalculations++;
		
		if(HideWhenCleared) {
			if(hidden == false) {
				Hide();
			}
		}
		
	}
	
	public static void Hide() {
		if(hidden) {
			hidden = false;
			xza1.setVisible(true);
			xza2.setVisible(true);
			firstcoords.setVisible(true);
			secondcoords.setVisible(true);
			find.setVisible(true);
			distance1.setVisible(true);
			distance2.setVisible(true);
			Resize(m);
			frame.setSize((210+framex_extra)*m/100, (165+extracoords*20)*m/100);
		} 
		else {
			frame.setSize(210*m/100, 50*m/100 + 5);
			close.setBounds(185*m/100, 0, 25*m/100, 25*m/100);
			minimize.setBounds(160*m/100, 0, 25*m/100, 25*m/100);
			hidden = true;
			if(result.getText().split(" ").length > 1) {
				if(ShowCoordsOnHideScreen > 0) {
					frame.setSize(210*m/100, ((75+20*extracoords*(ShowCoordsOnHideScreen-1))*m/100) + 5);
					sh.setBounds(10*m/100, 55*m/100, 90*m/100, 20*m/100);
					int v = 90 * m/100;
					if(v < 90) {
						v = 90;
					}
					result.setBounds(v, 55*m/100, 150*m/100, 20*m/100);
					if(v < 100) {
						v = 100;
					}
					nethercoords.setBounds(10*m/100, 75*m/100, 100*m/100, 20*m/100);
					nethercoords_.setBounds(v, 75*m/100, 100*m/100, 20*m/100);
					chunkcoords.setBounds(10*m/100, (75+(extracoords-1)*20)*m/100, 100*m/100, 20*m/100);
					chunkcoords_.setBounds(v, (75+(extracoords-1)*20)*m/100, 100*m/100, 20*m/100);
					xza1.setVisible(false);
					xza2.setVisible(false);
					firstcoords.setVisible(false);
					secondcoords.setVisible(false);
					find.setVisible(false);
					distance1.setVisible(false);
					distance2.setVisible(false);
				}
			}
		}
	}
	
	public static void Find() {
		
		numberofcalculations++;
		String sh_coordsraw = Calc.calculation(firstcoords.getText(), secondcoords.getText(), ShowNetherCoords, NetherCoordsDecimals, ShowChunkCoords);
		if(sh_coordsraw == "Error") {
			result.setText("Error");
		}
		else {
		String[] sh_coordssplit = sh_coordsraw.split(" / ");
		String sh_coords = sh_coordssplit[0];
		frame.setSize(210*m/100, 165*m/100);
		framex_extra = 0;
		nethercoords.setVisible(false);
		nethercoords_.setVisible(false);
		chunkcoords.setVisible(false);
		chunkcoords_.setVisible(false);
		if(ShowDistance) {
			switch(DistanceFrom) {
			case 0:	sh_coords = sh_coords + "   (D: " + Distance.DistanceCalc(firstcoords.getText(), sh_coords) + ")"; break;
			case 1: sh_coords = sh_coords + "   (D: " + Distance.DistanceCalc(secondcoords.getText(), sh_coords) + ")"; break;
			case 2: distance1.setText("D: " + Distance.DistanceCalc(firstcoords.getText(), sh_coords));
					distance2.setText("D: " + Distance.DistanceCalc(secondcoords.getText(), sh_coords));
					frame.setSize(245*m/100, 165*m/100);
					close.setBounds(220*m/100, 0, 25*m/100, 25*m/100);
					minimize.setBounds(195*m/100, 0, 25*m/100, 25*m/100);
					framex_extra = 35;
		}}
		
		int v = 90 * m/100;
		if(v < 100) {
			v = 100;
		}
		
		extracoords = 0;
		
		if(ShowNetherCoords) {
			frame.setSize((210+framex_extra)*m/100, 185*m/100);
			nethercoords_.setText(sh_coordssplit[1]);
			nethercoords_.setBounds(v, 160*m/100, 100*m/100, 20*m/100);
			nethercoords.setVisible(true);
			nethercoords_.setVisible(true);
			extracoords++;
		}
		
		if(ShowChunkCoords) {
			
			frame.setSize((210+framex_extra)*m/100, (185+extracoords*20)*m/100);
			chunkcoords.setBounds(10*m/100, (160+extracoords*20)*m/100, 100*m/100, 20*m/100);
			chunkcoords_.setBounds(v, (160+extracoords*20)*m/100, 100*m/100, 20*m/100);
			chunkcoords_.setText(sh_coordssplit[2]);
			chunkcoords.setVisible(true);
			chunkcoords_.setVisible(true);
			extracoords++;
		}
		
		if(CoordsOverlay == true) {
			new CoordsOverlay(sh_coords);
		}
		
		v = 90 * m/100;
		if(v < 90) {
			v = 90;
		}
		result.setBounds(v, 140*m/100, 150*m/100, 20*m/100);
		result.setText(sh_coords);
		
		if(hidden) {
			hidden = false;
			Hide();
		}
		
		}
		
		if(Autoclear) {
			new Thread() {
				
	            @Override
	            public void run() {
	                try {
	                	new Autoclear(numberofcalculations, AutoclearAfter);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
	        }.start();
		}
		
	}
			

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == find) {
			Find();
		}
		
		if(e.getSource() == settings) {
			new Settings();
		}
		
		if(e.getSource() == clear) {
			GUI.Clear();
		}
		
		if(e.getSource() == hide) {
			Hide();
		}
		
		if(e.getSource() == close) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		
		if(e.getSource() == minimize) {
			frame.setState(JFrame.ICONIFIED);
		}
	}}
