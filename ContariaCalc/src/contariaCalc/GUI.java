package contariaCalc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI implements ActionListener, KeyListener {
	
	static JFrame frame = new JFrame("ContariaCalc");
	static JPanel panel = new MotionPanel(frame);
	static JButton close = new JButton("×");
	static JButton minimize = new JButton("_");
	static JLabel topbar = new JLabel("ContariaCalc v1.1.8");
	static JLabel topbar2 = new JLabel();
	static JButton hide = new JButton("...");
	static JButton find = new JButton("Find");
	static JButton settings = new JButton("Settings");
	static JButton clear = new JButton("Clear");
	static JLabel xza1 = new JLabel("x z a");
	static JLabel xza2 = new JLabel("x z a");
	static JLabel xz = new JLabel("cx cz");
	static JLabel sh = new JLabel("SH:");
	static JLabel chunkdistance1 = new JLabel("");
	static JLabel chunkdistance2 = new JLabel("");
	static JLabel portalchunkdistance = new JLabel("test");
	static JLabel result = new JLabel();
	static JLabel nethercoords = new JLabel("Nether:");
	static JLabel nethercoords_ = new JLabel();
	static JLabel chunkcoords = new JLabel("Chunk:");
	static JLabel chunkcoords_ = new JLabel();
	static JTextField firstcoords = new JTextField();
	static JTextField secondcoords = new JTextField();
	static JTextField portalchunkcoords = new JTextField();
	static JButton justtogetnormalborderlayout = new JButton();
	static JTextField justtogetnormalborderlayout2 = new JTextField();
	static Image icon = Toolkit.getDefaultToolkit().getImage("images/ender_eye.png");
	
	//Options
	public static boolean CoordsOverlay = false;
	public static boolean ClipboardReader = false;
	public static int ClipboardreaderDelay = 1000;
	public static boolean copycoordstocb = false;
	public static boolean ShowDistance = true;
	public static int DistanceFrom = 0;
	public static boolean ShowNetherCoords = false;
	public static int NetherCoordsDecimals = 0;
	public static boolean ShowChunkCoords = false;
	public static boolean ShowChunkDistance = false;
	public static boolean ShowChunkDistanceFromPortal = false;
	public static boolean ShowPortalInputField = false;
	public static boolean marginoferror = false;
	public static boolean AlwaysOnTop = true ;
	public static boolean Translucent = false;
	public static boolean Autoclear = false;
	public static int AutoclearAfter = 15;
	public static boolean HideWhenCleared = false;
	public static int ShowCoordsOnHideScreen = 0;
	public static int m = 100;
	public static int g = 255;
	public static int[] c = new int[3];
	public static boolean customisetextcolor = false;
	public static String textfont = "Arial";
	public static int textsizer = 100;
	public static boolean showborders = true;
	
	//Processing variables for functions
	static int extracoords = 0;
	static int portalinput = 0;
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
		SetColor(g);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(AlwaysOnTop);
		frame.setVisible(true);
		frame.setIconImage(icon);
		frame.setLocation((int) pref.getDouble("FramePositionX", 0), (int) pref.getDouble("FramePositionY", 0));
		frame.add(panel);

		if(Translucent) {
			frame.setOpacity(0.6f);
		}
		
		panel.setLayout(null);

		panel.add(close);
		panel.add(minimize);
		panel.add(topbar);
		panel.add(topbar2);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		close.setBorder(emptyBorder);
		minimize.setBorder(emptyBorder);
		close.setBackground(new Color(220, 0, 0, 255));
		close.setForeground(new Color(255, 255, 255, 255));
		topbar.setOpaque(true);
		topbar2.setOpaque(true);

		panel.add(settings);
		panel.add(clear);
		panel.add(hide);
		panel.add(firstcoords);
		panel.add(xza1);
		panel.add(chunkdistance1);
		panel.add(secondcoords);
		panel.add(xza2);
		panel.add(chunkdistance2);
		panel.add(portalchunkcoords);
		panel.add(xz);
		panel.add(portalchunkdistance);
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
		frame.addKeyListener(this);
			
		}
	
	public static void GetPreferences() {

		ClipboardReader = pref.getBoolean("ClipboardReader", ClipboardReader);
		ClipboardreaderDelay = pref.getInt("ClipboardreaderDelay", ClipboardreaderDelay);
		copycoordstocb = pref.getBoolean("copycoordstocb", copycoordstocb);
		ShowDistance = pref.getBoolean("ShowDistance", ShowDistance);
		DistanceFrom = pref.getInt("DistanceFrom", DistanceFrom);
		ShowNetherCoords = pref.getBoolean("ShowNetherCoords", ShowNetherCoords);
		NetherCoordsDecimals = pref.getInt("NetherCoordsDecimals", NetherCoordsDecimals);
		ShowChunkCoords = pref.getBoolean("ShowChunkCoords", ShowChunkCoords);
		ShowChunkDistance = pref.getBoolean("ShowChunkDistance", ShowChunkDistance);
		ShowChunkDistanceFromPortal = pref.getBoolean("ShowChunkDistanceFromPortal", ShowChunkDistanceFromPortal);
		ShowPortalInputField = pref.getBoolean("ShowPortalInputField", ShowPortalInputField);
		marginoferror = pref.getBoolean("marginoferror", marginoferror);
		AlwaysOnTop = pref.getBoolean("AlwaysOnTop", AlwaysOnTop);
		Translucent = pref.getBoolean("Translucent", Translucent);
		Autoclear = pref.getBoolean("Autoclear", Autoclear);
		AutoclearAfter = pref.getInt("AutoclearAfter", AutoclearAfter);
		HideWhenCleared = pref.getBoolean("HideWhenCleared", HideWhenCleared);
		ShowCoordsOnHideScreen = pref.getInt("ShowCoordsOnHideScreen", ShowCoordsOnHideScreen);
		m = pref.getInt("m", m);
		g = pref.getInt("g", g);
		c[0] = pref.getInt("c0", 100);
		c[1] = pref.getInt("c1", 100);
		c[2] = pref.getInt("c2", 100);
		customisetextcolor = pref.getBoolean("customisetextcolor", customisetextcolor);
		textfont = pref.get("textfont", textfont);
		textsizer = pref.getInt("textsizer", textsizer);
		showborders = pref.getBoolean("showborders", showborders);
		
	}
	
	public static void Resize(int m) {
		
		int changeextracoordspos = 0;
		portalinput = 0;
		
		if(ShowPortalInputField) {
			portalinput = 25;
			changeextracoordspos += 25;
			portalchunkcoords.setVisible(true);
			xz.setVisible(true);
			portalchunkdistance.setVisible(true);
		}
		else {
			portalchunkcoords.setVisible(false);
			xz.setVisible(false);
			portalchunkdistance.setVisible(false);
		}
		
		int reduceinputfields = 0;
		if(chunkdistance1.getText() != "") {
			reduceinputfields = 1;
		}
		
		if(hidden) {
			int extra = 0;
			if(ShowCoordsOnHideScreen > 0) {
				if(result.getText() != "") {
					extra = 20;
				}
			}
			if(ShowCoordsOnHideScreen == 2) {
				extra += 5 + extracoords*20;
			}
			frame.setSize(220*m/100, (52+extra)*m/100 + 5);
			changeextracoordspos = -85;
		} 
		else {
			frame.setSize(220*m/100, (162+portalinput+extracoords*20)*m/100);
		}
		
		Font font = new Font(textfont + "", Font.BOLD, 12*m/100*textsizer/100);
		
		Border borders = justtogetnormalborderlayout.getBorder();
		Border textfieldborders = justtogetnormalborderlayout2.getBorder();
		if(!showborders) {
			borders = BorderFactory.createEmptyBorder();
			textfieldborders = BorderFactory.createEmptyBorder();
		}

		topbar2.setBounds(0, 0, frame.getWidth(), 25*m/100);
		close.setBounds(frame.getWidth()-25*m/100, 0, 25*m/100, 25*m/100);
		close.setFont(new Font("Arial", Font.BOLD, 24*m/100));
		minimize.setBounds(frame.getWidth()-50*m/100, 0, 25*m/100, 25*m/100);
		minimize.setFont(new Font("Arial", Font.BOLD, 16*m/100));
		topbar.setBounds(10*m/100, 0, frame.getWidth() - 50*m/100, 25*m/100);
		topbar.setFont(new Font(textfont + "", Font.BOLD, 13*m/100*textsizer/100));
		
		settings.setBounds(35*m/100, 30*m/100, 85*m/100, 20*m/100);
		settings.setFont(font);
		settings.setBorder(borders);
		clear.setBounds(125*m/100, 30*m/100, 85*m/100, 20*m/100);
		clear.setFont(font);
		clear.setBorder(borders);
		hide.setBounds(10*m/100, 30*m/100, 20*m/100, 20*m/100);
		hide.setFont(font);
		hide.setBorder(borders);
		
		firstcoords.setBounds(45*m/100, 60*m/100, (160-50*reduceinputfields)*m/100, 20*m/100);
		firstcoords.setBorder(textfieldborders);
		xza1.setBounds(10*m/100, 60*m/100, 30*m/100, 20*m/100);
		xza1.setFont(font);
		chunkdistance1.setBounds(160*m/100, 60*m/100, 60*m/100, 20*m/100);
		chunkdistance1.setFont(font);
			
		secondcoords.setBounds(45*m/100, 85*m/100, (160-50*reduceinputfields)*m/100, 20*m/100);
		secondcoords.setBorder(textfieldborders);
		xza2.setBounds(10*m/100, 85*m/100, 30*m/100, 20*m/100);
		xza2.setFont(font);
		chunkdistance2.setBounds(160*m/100, 85*m/100, 60*m/100, 20*m/100);
		chunkdistance2.setFont(font);
		
		portalchunkcoords.setBounds(45*m/100, 110*m/100, (160-50*reduceinputfields)*m/100, 20*m/100);
		portalchunkcoords.setBorder(textfieldborders);
		xz.setBounds(10*m/100, 110*m/100, 30*m/100, 20*m/100);
		xz.setFont(font);
		portalchunkdistance.setBounds(160*m/100, 110*m/100, 60*m/100, 20*m/100);
		portalchunkdistance.setFont(font);
		
		find.setBounds(75*m/100, (112+portalinput)*m/100, 70*m/100, 25*m/100);
		find.setFont(font);
		find.setBorder(borders);
		
		sh.setBounds(10*m/100, (140+changeextracoordspos)*m/100, 90*m/100, 20*m/100);
		sh.setFont(font);
		
		nethercoords.setBounds(10*m/100, (160+changeextracoordspos)*m/100, 100*m/100, 20*m/100);
		nethercoords.setFont(font);
		nethercoords_.setBounds(65*m/100, (160+changeextracoordspos)*m/100, 100*m/100, 20*m/100);
		nethercoords_.setFont(font);
		
		chunkcoords.setBounds(10*m/100, (160+changeextracoordspos+(extracoords-1)*20)*m/100, 100*m/100, 20*m/100);
		chunkcoords.setFont(font);
		chunkcoords_.setBounds(65*m/100, (160+changeextracoordspos+(extracoords-1)*20)*m/100, 100*m/100, 20*m/100);
		chunkcoords_.setFont(font);
		
		result.setBounds(65*m/100, (140+changeextracoordspos)*m/100, 160*m/100, 20*m/100);
		result.setFont(font);
	}
	
	public static void SetColor(int tone) {
		
		int paneltone = tone - 50;
		int titlebartone = paneltone - 40;
		int texttone;
		if(paneltone > 105) {
			texttone = 35;
		}
		else {
			texttone = 220;
		}

		int buttonnametone;
		if(tone > 105) {
			buttonnametone = 35;
		}
		else {
			buttonnametone = 220;
		}

		int c0t = c[0];
		int c1t = c[1];
		int c2t = c[2];
		if(!customisetextcolor) {
			c0t = 100;
			c1t = 100;
			c2t = 100;
		}
		
		Color buttons = new Color(tone*c[0]/100, tone*c[1]/100, tone*c[2]/100, 255);
		Color titlebar = new Color(titlebartone*c[0]/100, titlebartone*c[1]/100, titlebartone*c[2]/100, 255);
		Color text = new Color(texttone*c0t/100, texttone*c1t/100, texttone*c2t/100, 255);
		Color buttontext = new Color(buttonnametone*c0t/100, buttonnametone*c1t/100, buttonnametone*c2t/100, 255);
		
		panel.setBackground(new Color(paneltone*c[0]/100, paneltone*c[1]/100, paneltone*c[2]/100, 255));
		
		hide.setBackground(buttons);
		settings.setBackground(buttons);
		clear.setBackground(buttons);
		hide.setBackground(buttons);
		firstcoords.setBackground(buttons);
		secondcoords.setBackground(buttons);
		portalchunkcoords.setBackground(buttons);
		find.setBackground(buttons);
		sh.setForeground(text);
		xza1.setForeground(text);
		xza2.setForeground(text);
		xz.setForeground(text);
		result.setForeground(text);
		chunkdistance1.setForeground(text);
		chunkdistance2.setForeground(text);
		portalchunkdistance.setForeground(text);
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
		portalchunkcoords.setForeground(buttontext);
		topbar2.setBackground(titlebar);
		minimize.setBackground(titlebar);
		topbar.setBackground(titlebar);
		
	}
	
	public static void Clear() {
		
		if(hidden) {
			frame.setSize(220*m/100, 52*m/100 + 5);
		} 
		else {
			frame.setSize(220*m/100, (162+portalinput)*m/100);  
		}

		close.setBounds((220*m/100)-25*m/100, 0, 25*m/100, 25*m/100);
		minimize.setBounds((220*m/100)-50*m/100, 0, 25*m/100, 25*m/100);
		
		firstcoords.setBounds(45*m/100, 60*m/100, 160*m/100, 20*m/100);
		secondcoords.setBounds(45*m/100, 85*m/100, 160*m/100, 20*m/100);
		portalchunkcoords.setBounds(45*m/100, 110*m/100, 160*m/100, 20*m/100);
		
		result.setText("");
		firstcoords.setText("");
		secondcoords.setText("");
		portalchunkcoords.setText("");
		chunkdistance1.setText("");
		chunkdistance2.setText("");
		portalchunkdistance.setText("");
		nethercoords.setVisible(false);
		nethercoords_.setVisible(false);
		chunkcoords.setVisible(false);
		chunkcoords_.setVisible(false);
		extracoords = 0;
		numberofcalculations++;
		
		if(HideWhenCleared) {
			if(!hidden) {
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
		chunkdistance1.setVisible(hidden);
		chunkdistance2.setVisible(hidden);
		hidden = !hidden;
		Resize(m);
	}
	
	public static void Find() {

		numberofcalculations++;
		extracoords = 0;
		nethercoords.setVisible(false);
		nethercoords_.setVisible(false);
		chunkcoords.setVisible(false);
		chunkcoords_.setVisible(false);
		chunkdistance1.setText("");
		chunkdistance2.setText("");
		String[] results = Calc.Calculationinputoutput(firstcoords.getText(), secondcoords.getText());
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		if(results[0].equals("Error")) {
			result.setText("Error");
		}
		else {
		nethercoords.setVisible(ShowNetherCoords);
		nethercoords_.setVisible(ShowNetherCoords);
		chunkcoords.setVisible(ShowChunkCoords);
		chunkcoords_.setVisible(ShowChunkCoords);
		if(ShowDistance) {
			switch(DistanceFrom) {
			case 0:	results[0] = results[0] + " (D: " + Calc.DistanceCalc(firstcoords.getText(), results[0]) + ")"; break;
			case 1: results[0] = results[0] + " (D: " + Calc.DistanceCalc(secondcoords.getText(), results[0]) + ")"; break;
			}
		}
		
		if(ShowNetherCoords) {
			nethercoords_.setText(results[1]);
			extracoords++;
		}
		
		if(ShowChunkCoords) {
			chunkcoords.setBounds(10*m/100, (160+extracoords*20)*m/100, 100*m/100, 20*m/100);
			chunkcoords_.setText(results[2]);
			extracoords++;
		}
		
		result.setText(results[0]);
		
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

		if(copycoordstocb) {
			StringSelection ss = new StringSelection(results[0]);
			cb.setContents(ss, ss);
		}
		
		Resize(m);
	}
			

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == find) {
			Find();
		}
		
		if(e.getSource() == settings) {
			Settings.settings.setVisible(!Settings.settings.isVisible());
			GraphicsDevice gd = MouseInfo.getPointerInfo().getDevice();
			if(frame.getX() + frame.getWidth() + 210 < gd.getDisplayMode().getWidth()) {
				Settings.settings.setLocation(frame.getX() + frame.getWidth() + 5, frame.getY());
			}
			else {
				Settings.settings.setLocation(frame.getX() - 215, frame.getY());
			}
		}
		
		if(e.getSource() == clear) {
			GUI.Clear();
		}
		
		if(e.getSource() == hide) {
			Hide();
		}
		
		if(e.getSource() == close) {
			GUI.pref.putDouble("FramePositionX", frame.getLocation().getX());
			GUI.pref.putDouble("FramePositionY", frame.getLocation().getY());
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		
		if(e.getSource() == minimize) {
			frame.setState(JFrame.ICONIFIED);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println("Key pressed");

		switch(e.getKeyCode()) {
		case 67:
			Clear(); break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
