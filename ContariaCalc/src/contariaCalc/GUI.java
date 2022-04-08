package contariaCalc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

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
	static JLabel topbar = new JLabel("ContariaCalc v1.1.2");
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
	
	//Options
	public static boolean CoordsOverlay = false;
	public static boolean ClipboardReader = false;
	public static int ClipboardreaderDelay = 1000;
	public static boolean ShowDistance = true;
	public static int DistanceFrom = 0;
	public static boolean ShowNetherCoords = false;
	public static int NetherCoordsDecimals = 0;
	public static boolean ShowChunkCoords = false;
	public static boolean AlwaysOnTop = true ;
	public static boolean Translucent = false;
	public static boolean Autoclear = false;
	public static int AutoclearAfter = 15;
	public static boolean HideWhenCleared = false;
	public static int ShowCoordsOnHideScreen = 0;
	public static int m = 100;
	public static int c = 255;
	public static String textfont = "Arial";
	public static int textsizer = 100;
	
	//Processing variables for functions
	static int extracoords = 0;
	static int framex_extra = 0;
	public static int numberofcalculations = 0;
	public static boolean hidden = false;
	public static boolean overwritefirst = true;

	public String[] firstcoords_split = firstcoords.getText().split(" ");
	public String[] secondcoords_split = secondcoords.getText().split(" ");
	
	static Preferences pref = Preferences.userNodeForPackage(GUI.class);
	
	public GUI() {
		
		GetPreferences();
		if(ClipboardReader) {
			new Thread() {
            public void run() {
                new ClipboardReader();
            }
        }.start();
		}
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
		
		GetPreferences();
			
		}
	
	public static void GetPreferences() {

		ClipboardReader = pref.getBoolean("ClipboardReader", ClipboardReader);
		ClipboardreaderDelay = pref.getInt("ClipboardreaderDelay", ClipboardreaderDelay);
		ShowDistance = pref.getBoolean("ShowDistance", ShowDistance);;
		DistanceFrom = pref.getInt("DistanceFrom", DistanceFrom);
		ShowNetherCoords = pref.getBoolean("ShowNetherCoords", ShowNetherCoords);;;
		NetherCoordsDecimals = pref.getInt("NetherCoordsDecimals", NetherCoordsDecimals);
		ShowChunkCoords = pref.getBoolean("ShowChunkCoords", ShowChunkCoords);;;
		AlwaysOnTop = pref.getBoolean("AlwaysOnTop", AlwaysOnTop);; ;
		Translucent = pref.getBoolean("Translucent", Translucent);;;
		Autoclear = pref.getBoolean("Autoclear", Autoclear);;;
		AutoclearAfter = pref.getInt("AutoclearAfter", AutoclearAfter);
		HideWhenCleared = pref.getBoolean("HideWhenCleared", HideWhenCleared);;;
		ShowCoordsOnHideScreen = pref.getInt("ShowCoordsOnHideScreen", ShowCoordsOnHideScreen);
		m = pref.getInt("m", m);
		c = pref.getInt("c", c);
		textfont = pref.get("textfont", textfont);
		textsizer = pref.getInt("textsizer", textsizer);
		
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
		
		Font font = new Font(textfont + "", Font.BOLD, 12*m/100*textsizer/100);

		close.setBounds((185*m/100+framex_extra), 0, 25*m/100, 25*m/100);
		close.setFont(font);
		minimize.setBounds((160+framex_extra)*m/100, 0, 25*m/100, 25*m/100);
		minimize.setFont(font);
		topbar.setBounds(10*m/100, 0, 151*m/100, 25*m/100);
		topbar2.setBounds(0, 0, 10*m/100, 25*m/100);
		topbar.setFont(font);
		
		settings.setBounds(35*m/100, 30*m/100, 85*m/100, 20*m/100);
		settings.setFont(font);
		clear.setBounds(125*m/100, 30*m/100, 75*m/100, 20*m/100);
		clear.setFont(font);
		hide.setBounds(10*m/100, 30*m/100, 20*m/100, 20*m/100);
		hide.setFont(font);
		
		firstcoords.setBounds(45*m/100, 60*m/100, 150*m/100, 20*m/100);
		xza1.setBounds(10*m/100, 60*m/100, 30*m/100, 20*m/100);
		xza1.setFont(font);
		distance1.setBounds(200*m/100, 60*m/100, 50*m/100, 20*m/100);
		distance1.setFont(font);
			
		secondcoords.setBounds(45*m/100, 85*m/100, 150*m/100, 20*m/100);
		xza2.setBounds(10*m/100, 85*m/100, 30*m/100, 20*m/100);
		xza2.setFont(font);
		distance2.setBounds(200*m/100, 85*m/100, 50*m/100, 20*m/100);
		distance2.setFont(font);
		
		find.setBounds(70*m/100, 112*m/100, 70*m/100, 25*m/100);
		find.setFont(font);
		
		sh.setBounds(10*m/100, 140*m/100, 90*m/100, 20*m/100);
		sh.setFont(font);
		
		nethercoords.setBounds(10*m/100, 160*m/100, 100*m/100, 20*m/100);
		nethercoords.setFont(font);
		nethercoords_.setBounds(v, 160*m/100, 100*m/100, 20*m/100);
		nethercoords_.setFont(font);
		
		chunkcoords.setBounds(10*m/100, (160+(extracoords-1)*20)*m/100, 100*m/100, 20*m/100);
		chunkcoords.setFont(font);
		chunkcoords_.setBounds(v, (160+(extracoords-1)*20)*m/100, 100*m/100, 20*m/100);
		chunkcoords_.setFont(font);
		
		v = 90 * m/100;
		if(v < 90) {
			v = 90;
		}
		result.setBounds(v, 140*m/100, 150*m/100, 20*m/100);
		result.setFont(font);
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
		
		Color buttons = new Color(tone, tone, tone, 255);
		Color text = new Color(texttone, texttone, texttone, 255);
		Color buttontext = new Color(buttonnametone, buttonnametone, buttonnametone, 255);
		Color titlebar = new Color(titlebartone, titlebartone, titlebartone, 255);
		
		panel.setBackground(new Color(paneltone, paneltone, paneltone, 255));
		
		hide.setBackground(buttons);
		settings.setBackground(buttons);
		clear.setBackground(buttons);
		hide.setBackground(buttons);
		firstcoords.setBackground(buttons);
		secondcoords.setBackground(buttons);
		find.setBackground(buttons);
		sh.setForeground(text);
		xza1.setForeground(text);
		xza2.setForeground(text);
		result.setForeground(text);
		distance1.setForeground(text);
		distance2.setForeground(text);
		nethercoords.setForeground(text);
		nethercoords_.setForeground(text);
		chunkcoords.setForeground(text);
		chunkcoords_.setForeground(text);
		topbar.setForeground(text);
		minimize.setForeground(text);
		hide.setForeground(buttontext);
		settings.setForeground(buttontext);
		clear.setForeground(buttontext);
		find.setForeground(buttontext);
		firstcoords.setForeground(buttontext);
		secondcoords.setForeground(buttontext);
		minimize.setBackground(titlebar);
		topbar.setBackground(titlebar);
		topbar2.setBackground(titlebar);
		
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
		
		xza1.setVisible(hidden);
		xza2.setVisible(hidden);
		firstcoords.setVisible(hidden);
		secondcoords.setVisible(hidden);
		find.setVisible(hidden);
		distance1.setVisible(hidden);
		distance2.setVisible(hidden);
		if(hidden) {
			Resize(m);
			frame.setSize((210+framex_extra)*m/100, (165+extracoords*20)*m/100);
		} 
		else {
			frame.setSize(210*m/100, 50*m/100 + 5);
			close.setBounds(185*m/100, 0, 25*m/100, 25*m/100);
			minimize.setBounds(160*m/100, 0, 25*m/100, 25*m/100);
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
				}
			}
		}

		hidden = !hidden;
	}
	
	public static void Find() {
		
		numberofcalculations++;
		String sh_coordsraw = Calc.calculation(firstcoords.getText(), secondcoords.getText(), ShowNetherCoords, NetherCoordsDecimals, ShowChunkCoords);
		if(sh_coordsraw.equals("Error")) {
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
