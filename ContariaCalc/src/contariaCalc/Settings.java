package contariaCalc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings implements ActionListener, ChangeListener {
	
	static JFrame settings = new JFrame("Settings");
	static JPanel panel = new MotionPanel(settings);
	static JButton close = new JButton("×");
	static JButton minimize = new JButton("_");
	static JLabel topbar = new JLabel("Settings");
	static JLabel topbar2 = new JLabel();
	static JButton showcalcsettings = new JButton("CALC");
	static JButton showfeaturesettings = new JButton("FEATURES");
	static JButton showwindowsettings = new JButton("WINDOW");
	static JLabel showaccuracy = new JLabel("Show Margin of Error:");
	static JButton showaccuracytoggle = new JButton("OFF");
	static JLabel clipboardreader = new JLabel("ClipboardReader:");
	static JButton clipboardreadertoggle = new JButton("OFF");
	static JLabel clipboardreaderdelay = new JLabel("Check every                 ms");
	static JTextField clipboardreaderdelayms = new JTextField(GUI.ClipboardreaderDelay + "");
	static JButton applyclipboardreaderdelayms = new JButton("✔");
	static JLabel showdistance = new JLabel("Show Distance to SH:");
	static JButton showdistancetoggle = new JButton("OFF");
	static JLabel distancefrom = new JLabel("Distance from:");
	static JButton distancefromtoggle = new JButton("1st Throw");
	static JLabel shownethercoords = new JLabel("Show Nether Coords:");
	static JButton shownethercoordstoggle = new JButton("OFF");
	static JLabel nethercoordsdecimals = new JLabel("Nether Coords Decimals:");
	static JLabel showchunkcoords = new JLabel("Show Chunk Coords:");
	static JButton nethercoordsdecimalstoggle = new JButton("0");
	static JButton showchunkcoordstoggle = new JButton("OFF");
	static JLabel alwaysontop = new JLabel("Always On Top:");
	static JButton alwaysontoptoggle = new JButton("OFF");
	static JLabel translucent = new JLabel("Translucent:");
	static JButton translucenttoggle = new JButton("OFF");
	static JLabel autoclear = new JLabel("Autoclear:");
	static JButton autocleartoggle = new JButton("OFF");
	static JLabel autoclearafter = new JLabel("Autoclear after           min");
	static JTextField autoclearmin = new JTextField(GUI.AutoclearAfter +  "");
	static JButton applyautoclearmin = new JButton("✔");
	static JLabel hidewhencleared = new JLabel("Hide when cleared:");
	static JButton hidewhenclearedtoggle = new JButton("OFF");
	static JLabel showcoordsonhidescreen = new JLabel("Result on Hide Screen:");
	static JButton showcoordsonhidescreentoggle = new JButton("No");
	static JLabel textfont = new JLabel("Text Font:");
	static JTextField settextfont = new JTextField(GUI.textfont + "");
	static JButton applysettextfont = new JButton("✔");
	static JLabel resize = new JLabel("Resize:");
	static JSlider resizing = new JSlider(JSlider.HORIZONTAL, 50, 200, GUI.m);
	static JButton resetsize = new JButton("Reset");
	static JLabel color = new JLabel("Color:");
	static JSlider changecolor = new JSlider(JSlider.HORIZONTAL, 90, 255, Math.abs(GUI.g - 345));
	static JButton morecoloroptions = new JButton("More");
	static JLabel red = new JLabel("Red:");
	static JSlider changered = new JSlider(JSlider.HORIZONTAL, 0, 100, GUI.c[0]);
	static JLabel green = new JLabel("Green:");
	static JSlider changegreen = new JSlider(JSlider.HORIZONTAL, 0, 100, GUI.c[1]);
	static JLabel blue = new JLabel("Blue");
	static JSlider changeblue = new JSlider(JSlider.HORIZONTAL, 0, 100, GUI.c[2]);
	static JLabel customisetextcolor = new JLabel("Change Text Color:");
	static JButton customisetextcolortoggle = new JButton("OFF");
	
	boolean calcsettings = false;
	boolean featuresettings = false;
	boolean windowsettings = false;
	static boolean morecolorsettings = false;

	static int settingsnumber = 1;
	static int settingsgap = 25;
	
	public Settings() {
		
		settings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		settings.setUndecorated(true);
		settings.setAlwaysOnTop(true);
		settings.setVisible(false);
		settings.setIconImage(GUI.icon);
		settings.add(panel);

		panel.add(close);
		panel.add(minimize);
		panel.add(topbar);
		panel.add(topbar2);

		panel.add(topbar);
		panel.add(topbar2);
		panel.add(close);
		panel.add(minimize);
		panel.add(showcalcsettings);
		panel.add(showaccuracy);
		panel.add(showaccuracytoggle);
		panel.add(showdistance);
		panel.add(showdistancetoggle);
		panel.add(distancefrom);
		panel.add(distancefromtoggle);
		panel.add(shownethercoords);
		panel.add(shownethercoordstoggle);
		panel.add(nethercoordsdecimals);
		panel.add(nethercoordsdecimalstoggle);
		panel.add(showchunkcoords);
		panel.add(showchunkcoordstoggle);
		panel.add(showcoordsonhidescreen);
		panel.add(showcoordsonhidescreentoggle);
		panel.add(showfeaturesettings);
		panel.add(clipboardreader);
		panel.add(clipboardreadertoggle);
		panel.add(clipboardreaderdelay);
		panel.add(clipboardreaderdelayms);
		panel.add(applyclipboardreaderdelayms);
		panel.add(autoclear);
		panel.add(autocleartoggle);
		panel.add(autoclearafter);
		panel.add(autoclearmin);
		panel.add(applyautoclearmin);
		panel.add(hidewhencleared);
		panel.add(hidewhenclearedtoggle);
		panel.add(showwindowsettings);
		panel.add(alwaysontop);
		panel.add(alwaysontoptoggle);
		panel.add(translucent);
		panel.add(translucenttoggle);
		panel.add(textfont);
		panel.add(settextfont);
		panel.add(applysettextfont);
		panel.add(resize);
		panel.add(resizing);
		panel.add(resetsize);
		panel.add(color);
		panel.add(changecolor);
		panel.add(morecoloroptions);
		panel.add(red);
		panel.add(changered);
		panel.add(green);
		panel.add(changegreen);
		panel.add(blue);
		panel.add(changeblue);
		panel.add(customisetextcolor);
		panel.add(customisetextcolortoggle);

		panel.setLayout(null);
		
		GUI();
		SetColor(GUI.g);
		
		minimize.addActionListener(this);
		close.addActionListener(this);
		
		showcalcsettings.addActionListener(this);
		showfeaturesettings.addActionListener(this);
		showwindowsettings.addActionListener(this);
		
		showaccuracytoggle.addActionListener(this);
		clipboardreadertoggle.addActionListener(this);
		applyclipboardreaderdelayms.addActionListener(this);
		showdistancetoggle.addActionListener(this);
		distancefromtoggle.addActionListener(this);
		shownethercoordstoggle.addActionListener(this);
		nethercoordsdecimalstoggle.addActionListener(this);
		alwaysontoptoggle.addActionListener(this);
		translucenttoggle.addActionListener(this);
		showchunkcoordstoggle.addActionListener(this);
		autocleartoggle.addActionListener(this);
		applyautoclearmin.addActionListener(this);
		hidewhenclearedtoggle.addActionListener(this);
		showcoordsonhidescreentoggle.addActionListener(this);
		applysettextfont.addActionListener(this);
		resetsize.addActionListener(this);
		morecoloroptions.addActionListener(this);
		customisetextcolortoggle.addActionListener(this);
		resizing.addChangeListener(this);
		changecolor.addChangeListener(this);
		changered.addChangeListener(this);
		changegreen.addChangeListener(this);
		changeblue.addChangeListener(this);
		
	}
	
	public void GUI() {
		
		settingsnumber = 1;
		
		Border emptyBorder = BorderFactory.createEmptyBorder();

		topbar.setBounds(10, 0, 150, 25);
		topbar.setOpaque(true);
		topbar2.setBounds(0, 0, 10, 25);
		topbar2.setOpaque(true);
		close.setBorder(emptyBorder);
		close.setBackground(new Color(220, 0, 0, 255));
		close.setFont(new Font("Arial", Font.BOLD, 24));
		close.setForeground(new Color(255, 255, 255, 255));
		close.setBounds(185, 0, 25, 25);
		minimize.setBorder(emptyBorder);
		minimize.setBounds(160, 0, 25, 25);
		minimize.setFont(new Font("Arial", Font.BOLD, 16));
		
		showaccuracy.setVisible(false);
		showaccuracytoggle.setVisible(false);
		showdistance.setVisible(false);
		showdistancetoggle.setVisible(false);
		distancefrom.setVisible(false);
		distancefromtoggle.setVisible(false);
		shownethercoords.setVisible(false);
		shownethercoordstoggle.setVisible(false);
		nethercoordsdecimals.setVisible(false);
		nethercoordsdecimalstoggle.setVisible(false);
		showchunkcoords.setVisible(false);
		showchunkcoordstoggle.setVisible(false);
		showcoordsonhidescreen.setVisible(false);
		showcoordsonhidescreentoggle.setVisible(false);
		clipboardreader.setVisible(false);
		clipboardreadertoggle.setVisible(false);
		clipboardreaderdelay.setVisible(false);
		clipboardreaderdelayms.setVisible(false);
		applyclipboardreaderdelayms.setVisible(false);
		autoclear.setVisible(false);
		autocleartoggle.setVisible(false);
		autoclearafter.setVisible(false);
		autoclearmin.setVisible(false);
		applyautoclearmin.setVisible(false);
		hidewhencleared.setVisible(false);
		hidewhenclearedtoggle.setVisible(false);
		alwaysontop.setVisible(false);
		alwaysontoptoggle.setVisible(false);
		translucent.setVisible(false);
		translucenttoggle.setVisible(false);
		textfont.setVisible(false);
		settextfont.setVisible(false);
		applysettextfont.setVisible(false);
		resize.setVisible(false);
		resizing.setVisible(false);
		resetsize.setVisible(false);
		color.setVisible(false);
		changecolor.setVisible(false);
		morecoloroptions.setVisible(false);
		red.setVisible(false);
		changered.setVisible(false);
		green.setVisible(false);
		changegreen.setVisible(false);
		blue.setVisible(false);
		changeblue.setVisible(false);
		customisetextcolor.setVisible(false);
		customisetextcolortoggle.setVisible(false);
		
		showcalcsettings.setBounds(5, 5 + settingsnumber * settingsgap, 200, 20);
		showcalcsettings.setBorder(emptyBorder);
		settingsnumber++;
		
		ToggleCalcSettings(calcsettings);
		
		showfeaturesettings.setBounds(5, 5 + settingsnumber * settingsgap, 200, 20);
		showfeaturesettings.setBorder(emptyBorder);
		settingsnumber++;
		
		ToggleFeatureSettings(featuresettings);
		
		showwindowsettings.setBounds(5, 5 + settingsnumber * settingsgap, 200, 20);
		showwindowsettings.setBorder(emptyBorder);
		settingsnumber++;
		
		ToggleWindowSettings(windowsettings);

		settings.setSize(210, 5 + settingsnumber * settingsgap);
		
	}
	
	public static void ToggleWindowSettings(boolean shown) {

		if(shown) {
			alwaysontop.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			alwaysontoptoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.AlwaysOnTop) {
				alwaysontoptoggle.setText("ON");
			}
			settingsnumber++;
			
			translucent.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			translucenttoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.Translucent) {
				translucenttoggle.setText("ON");
			}
			settingsnumber++;
			
			textfont.setBounds(10, 5 + settingsnumber * settingsgap, 250, 20);
			settextfont.setBounds(75, 5 + settingsnumber * settingsgap, 70, 20);
			applysettextfont.setBounds(156, 5 + settingsnumber * settingsgap, 44, 20);
			settingsnumber++;
			
			resize.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			resizing.setBounds(50, 7 + settingsnumber * settingsgap, 80, 20);
			resetsize.setBounds(133, 5 + settingsnumber * settingsgap, 67, 20);
			settingsnumber++;
			
			color.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			changecolor.setBounds(50, 7 + settingsnumber * settingsgap, 80, 20);
			morecoloroptions.setBounds(133, 5 + settingsnumber * settingsgap, 67, 20);
			settingsnumber++;
			
			if(morecolorsettings) {
				red.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
				changered.setBounds(50, 7 + settingsnumber * settingsgap, 145, 20);
				settingsnumber++;
				
				green.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
				changegreen.setBounds(50, 7 + settingsnumber * settingsgap, 145, 20);
				settingsnumber++;
				
				blue.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
				changeblue.setBounds(50, 7 + settingsnumber * settingsgap, 145, 20);
				settingsnumber++;
				
				customisetextcolor.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
				customisetextcolortoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
				settingsnumber++;

				red.setVisible(true);
				changered.setVisible(true);
				green.setVisible(true);
				changegreen.setVisible(true);
				blue.setVisible(true);
				changeblue.setVisible(true);
				customisetextcolor.setVisible(true);
				customisetextcolortoggle.setVisible(true);
			}
			
			alwaysontop.setVisible(true);
			alwaysontoptoggle.setVisible(true);
			translucent.setVisible(true);
			translucenttoggle.setVisible(true);
			textfont.setVisible(true);
			settextfont.setVisible(true);
			applysettextfont.setVisible(true);
			resize.setVisible(true);
			resizing.setVisible(true);
			resetsize.setVisible(true);
			color.setVisible(true);
			changecolor.setVisible(true);
			morecoloroptions.setVisible(true);
		}
	}
	
	public static void ToggleFeatureSettings(boolean shown) {

		if(shown) {
			clipboardreader.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			clipboardreadertoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.ClipboardReader) {
				clipboardreadertoggle.setText("ON");
			}
			settingsnumber++;
			
			clipboardreaderdelay.setBounds(10, 5 + settingsnumber * settingsgap, 250, 20);
			clipboardreaderdelayms.setBounds(84, 5 + settingsnumber * settingsgap, 45, 20);
			applyclipboardreaderdelayms.setBounds(156, 5 + settingsnumber * settingsgap, 44, 20);
			settingsnumber++;
			
			autoclear.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			autocleartoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.Autoclear) {
				autocleartoggle.setText("ON");
			}
			settingsnumber++;
			
			autoclearafter.setBounds(10, 5 + settingsnumber * settingsgap, 250, 20);
			autoclearmin.setBounds(100, 5 + settingsnumber * settingsgap, 25, 20);
			applyautoclearmin.setBounds(156, 5 + settingsnumber * settingsgap, 44, 20);
			settingsnumber++;
			
			hidewhencleared.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			hidewhenclearedtoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.HideWhenCleared) {
				hidewhenclearedtoggle.setText("ON");
			}
			settingsnumber++;
			
			clipboardreader.setVisible(true);
			clipboardreadertoggle.setVisible(true);
			clipboardreaderdelay.setVisible(true);
			clipboardreaderdelayms.setVisible(true);
			applyclipboardreaderdelayms.setVisible(true);
			autoclear.setVisible(true);
			autocleartoggle.setVisible(true);
			autoclearafter.setVisible(true);
			autoclearmin.setVisible(true);
			applyautoclearmin.setVisible(true);
			hidewhencleared.setVisible(true);
			hidewhenclearedtoggle.setVisible(true);
		}
	}

	public static void ToggleCalcSettings(boolean shown) {
		
		if(shown) {
			showaccuracy.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			showaccuracytoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.marginoferror) {
				showaccuracytoggle.setText("ON");
			}
			settingsnumber++;
			
			showdistance.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			showdistancetoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.ShowDistance) {
				showdistancetoggle.setText("ON");
			}
			settingsnumber++;
			
			distancefrom.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			distancefromtoggle.setBounds(100, 5 + settingsnumber * settingsgap, 100, 20);
			switch(GUI.DistanceFrom) {
			case 1: distancefromtoggle.setText("2nd Throw"); break;
			case 2: distancefromtoggle.setText("Both"); break;
			}
			settingsnumber++;
			
			shownethercoords.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			shownethercoordstoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.ShowNetherCoords) {
				shownethercoordstoggle.setText("ON");
			}
			settingsnumber++;
			
			nethercoordsdecimals.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			nethercoordsdecimalstoggle.setBounds(159, 5 + settingsnumber * settingsgap, 41, 20);
			nethercoordsdecimalstoggle.setText("" + GUI.NetherCoordsDecimals);
			settingsnumber++;
			
			showchunkcoords.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			showchunkcoordstoggle.setBounds(140, 5 + settingsnumber * settingsgap, 60, 20);
			if(GUI.ShowChunkCoords) {
				showchunkcoordstoggle.setText("ON");
			}
			settingsnumber++;

			showcoordsonhidescreen.setBounds(10, 5 + settingsnumber * settingsgap, 150, 20);
			showcoordsonhidescreentoggle.setBounds(150, 5 + settingsnumber * settingsgap, 50, 20);
			switch(GUI.ShowCoordsOnHideScreen) {
			case 1: showcoordsonhidescreentoggle.setText("SH"); break;
			case 2: showcoordsonhidescreentoggle.setText("All"); break;
			}
			settingsnumber++;
			
			showaccuracy.setVisible(true);
			showaccuracytoggle.setVisible(true);
			showdistance.setVisible(true);
			showdistancetoggle.setVisible(true);
			distancefrom.setVisible(true);
			distancefromtoggle.setVisible(true);
			shownethercoords.setVisible(true);
			shownethercoordstoggle.setVisible(true);
			nethercoordsdecimals.setVisible(true);
			nethercoordsdecimalstoggle.setVisible(true);
			showchunkcoords.setVisible(true);
			showchunkcoordstoggle.setVisible(true);
			showcoordsonhidescreen.setVisible(true);
			showcoordsonhidescreentoggle.setVisible(true);
		}
	}
	
	public static void SetColor(int tone) {
		
		int paneltone = tone - 50;
		int texttone;
		int textfieldtone = tone;
		int titlebartone = paneltone - 40;
		if(textfieldtone > 235) {
			textfieldtone = 255;
		}
		else {
			textfieldtone += 20;
		}
		
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
		
		if(paneltone > 140) {
			tone = paneltone - 40;
		}
		else {
			tone = paneltone + 60;
		}
		
		int c0t = GUI.c[0];
		int c1t = GUI.c[1];
		int c2t = GUI.c[2];
		if(!GUI.customisetextcolor) {
			c0t = 100;
			c1t = 100;
			c2t = 100;
		}

		Color titlebar = new Color(titlebartone*GUI.c[0]/100, titlebartone*GUI.c[1]/100, titlebartone*GUI.c[2]/100, 255);
		Color buttons = new Color(tone*GUI.c[0]/100, tone*GUI.c[1]/100, tone*GUI.c[2]/100, 255);
		Color text = new Color(texttone*c0t/100, texttone*c1t/100, texttone*c2t/100, 255);
		Color buttontext = new Color(buttonnametone*c0t/100, buttonnametone*c1t/100, buttonnametone*c2t/100, 255);
		Color background = new Color(paneltone*GUI.c[0]/100, paneltone*GUI.c[1]/100, paneltone*GUI.c[2]/100, 255);
		Color textfield = new Color(textfieldtone*GUI.c[0]/100, textfieldtone*GUI.c[1]/100, textfieldtone*GUI.c[2]/100, 255);
		
		panel.setBackground(background);
		resizing.setBackground(background);
		changecolor.setBackground(background);
		changered.setBackground(background);
		changegreen.setBackground(background);
		changeblue.setBackground(background);
		
		minimize.setBackground(titlebar);
		topbar.setBackground(titlebar);
		topbar2.setBackground(titlebar);
		
		showcalcsettings.setBackground(buttons);
		showfeaturesettings.setBackground(buttons);
		showwindowsettings.setBackground(buttons);
		showaccuracytoggle.setBackground(buttons);
		clipboardreadertoggle.setBackground(buttons);
		applyclipboardreaderdelayms.setBackground(buttons);
		showdistancetoggle.setBackground(buttons);
		distancefromtoggle.setBackground(buttons);
		shownethercoordstoggle.setBackground(buttons);
		nethercoordsdecimalstoggle.setBackground(buttons);
		showchunkcoordstoggle.setBackground(buttons);
		alwaysontoptoggle.setBackground(buttons);
		translucenttoggle.setBackground(buttons);
		autocleartoggle.setBackground(buttons);
		applyautoclearmin.setBackground(buttons);
		hidewhenclearedtoggle.setBackground(buttons);
		showcoordsonhidescreentoggle.setBackground(buttons);
		applysettextfont.setBackground(buttons);
		resetsize.setBackground(buttons);
		morecoloroptions.setBackground(buttons);
		customisetextcolortoggle.setBackground(buttons);
		
		clipboardreaderdelayms.setBackground(textfield);
		autoclearmin.setBackground(textfield);
		settextfont.setBackground(textfield);
		
		showcalcsettings.setForeground(buttontext);
		showfeaturesettings.setForeground(buttontext);
		showwindowsettings.setForeground(buttontext);
		showaccuracytoggle.setForeground(buttontext);
		clipboardreadertoggle.setForeground(buttontext);
		clipboardreaderdelayms.setForeground(buttontext);
		applyclipboardreaderdelayms.setForeground(buttontext);
		showdistancetoggle.setForeground(buttontext);
		distancefromtoggle.setForeground(buttontext);
		shownethercoordstoggle.setForeground(buttontext);
		nethercoordsdecimalstoggle.setForeground(buttontext);
		showchunkcoordstoggle.setForeground(buttontext);
		alwaysontoptoggle.setForeground(buttontext);
		translucenttoggle.setForeground(buttontext);
		autocleartoggle.setForeground(buttontext);
		autoclearmin.setForeground(buttontext);
		applyautoclearmin.setForeground(buttontext);
		hidewhenclearedtoggle.setForeground(buttontext);
		showcoordsonhidescreentoggle.setForeground(buttontext);
		settextfont.setForeground(buttontext);
		applysettextfont.setForeground(buttontext);
		resetsize.setForeground(buttontext);
		morecoloroptions.setForeground(buttontext);
		customisetextcolortoggle.setForeground(buttontext);
		
		minimize.setForeground(text);
		topbar.setForeground(text);
		showaccuracy.setForeground(text);
		clipboardreader.setForeground(text);
		clipboardreaderdelay.setForeground(text);
		showdistance.setForeground(text);
		distancefrom.setForeground(text);
		shownethercoords.setForeground(text);
		nethercoordsdecimals.setForeground(text);
		showchunkcoords.setForeground(text);
		alwaysontop.setForeground(text);
		translucent.setForeground(text);
		autoclear.setForeground(text);
		autoclearafter.setForeground(text);
		hidewhencleared.setForeground(text);
		showcoordsonhidescreen.setForeground(text);
		textfont.setForeground(text);
		resize.setForeground(text);
		color.setForeground(text);
		red.setForeground(text);
		green.setForeground(text);
		blue.setForeground(text);
		customisetextcolor.setForeground(text);
		
	}

	public void stateChanged(ChangeEvent e) {
		
		if(e.getSource() == resizing) {
			GUI.m = resizing.getValue();
			GUI.Resize(resizing.getValue());
			GUI.pref.putInt("m", GUI.m);
		}
		
		if(e.getSource() == changecolor) {
			GUI.g = Math.abs(changecolor.getValue() - 345);
			GUI.SetColor(GUI.g);
			SetColor(GUI.g);
			GUI.pref.putInt("g", GUI.g);
		}

		if(e.getSource() == changered) {
			GUI.c[0] = changered.getValue();
			GUI.SetColor(GUI.g);
			SetColor(GUI.g);
			GUI.pref.putInt("c0", GUI.c[0]);
		}

		if(e.getSource() == changegreen) {
			GUI.c[1] = changegreen.getValue();
			GUI.SetColor(GUI.g);
			SetColor(GUI.g);
			GUI.pref.putInt("c1", GUI.c[1]);
		}

		if(e.getSource() == changeblue) {
			GUI.c[2] = changeblue.getValue();
			GUI.SetColor(GUI.g);
			SetColor(GUI.g);
			GUI.pref.putInt("c2", GUI.c[2]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == showcalcsettings) {
			calcsettings = !calcsettings;
			GUI();
		}

		if(e.getSource() == showfeaturesettings) {
			featuresettings = !featuresettings;
			GUI();
		}

		if(e.getSource() == showwindowsettings) {
			windowsettings = !windowsettings;
			GUI();
		}
		
		if(e.getSource() == showaccuracytoggle) {
			if(GUI.marginoferror) {
				showaccuracytoggle.setText("OFF");
			}
			else {
				showaccuracytoggle.setText("ON");
			}
			GUI.marginoferror = !GUI.marginoferror;
			GUI.pref.putBoolean("marginoferror", GUI.marginoferror);
		}

		if(e.getSource() == clipboardreadertoggle) {
			if(GUI.ClipboardReader) {
				clipboardreadertoggle.setText("OFF");
			}
			else {
				clipboardreadertoggle.setText("ON");
				new Thread() {
		            public void run() {
		                new ClipboardReader();
		            }
		        }.start();
			}
			GUI.ClipboardReader = !GUI.ClipboardReader;
			GUI.pref.putBoolean("ClipboardReader", GUI.ClipboardReader);
		}
		
		if(e.getSource() == applyclipboardreaderdelayms) {
			GUI.ClipboardreaderDelay = (int) Double.parseDouble(clipboardreaderdelayms.getText());
			GUI.pref.putInt("ClipboardreaderDelay", GUI.ClipboardreaderDelay);
		}
		
		if(e.getSource() == showdistancetoggle) {
			if(GUI.ShowDistance) {
				showdistancetoggle.setText("OFF");
			}
			else {
				showdistancetoggle.setText("ON");
			}
			GUI.ShowDistance = !GUI.ShowDistance;
			GUI.pref.putBoolean("ShowDistance", GUI.ShowDistance);
		}
		
		if(e.getSource() == distancefromtoggle) {
			GUI.DistanceFrom = (GUI.DistanceFrom + 1) % 3;
			switch(GUI.DistanceFrom) {
			case 0: distancefromtoggle.setText("1st Throw"); break;
			case 1: distancefromtoggle.setText("2nd Throw"); break;
			case 2: distancefromtoggle.setText("Both"); break;
			}
			GUI.pref.putInt("DistanceFrom", GUI.DistanceFrom);
		}
		
		if(e.getSource() == shownethercoordstoggle) {
			if(GUI.ShowNetherCoords) {
				shownethercoordstoggle.setText("OFF");
			}
			else {
				shownethercoordstoggle.setText("ON");
			}
			GUI.ShowNetherCoords = !GUI.ShowNetherCoords;
			GUI.pref.putBoolean("ShowNetherCoords", GUI.ShowNetherCoords);
		}
		
		if(e.getSource() == nethercoordsdecimalstoggle) {
			GUI.NetherCoordsDecimals = (GUI.NetherCoordsDecimals + 1) % 4;
			nethercoordsdecimalstoggle.setText("" + GUI.NetherCoordsDecimals);
			GUI.pref.putInt("NetherCoordsDecimals", GUI.NetherCoordsDecimals);
		}
		
		if(e.getSource() == showchunkcoordstoggle) {
			if(GUI.ShowChunkCoords) {
				showchunkcoordstoggle.setText("OFF");
			}
			else {
				showchunkcoordstoggle.setText("ON");
			}
			GUI.ShowChunkCoords = !GUI.ShowChunkCoords;
			GUI.pref.putBoolean("ShowChunkCoords", GUI.ShowChunkCoords);
		}
		
		if(e.getSource() == alwaysontoptoggle) {
			if(GUI.AlwaysOnTop) {
				alwaysontoptoggle.setText("OFF");
			}
			else {
				alwaysontoptoggle.setText("ON");
			}
			GUI.AlwaysOnTop = !GUI.AlwaysOnTop;
			GUI.frame.setAlwaysOnTop(GUI.AlwaysOnTop);
			settings.setAlwaysOnTop(GUI.AlwaysOnTop);
			GUI.pref.putBoolean("AlwaysOnTop", GUI.AlwaysOnTop);
		}
		
		if(e.getSource() == translucenttoggle) {
			if(GUI.Translucent) {
				translucenttoggle.setText("OFF");
				GUI.frame.setOpacity(1.0f);
			}
			else {
				translucenttoggle.setText("ON");
				GUI.frame.setOpacity(0.6f);
			}
			GUI.Translucent = !GUI.Translucent;
			GUI.pref.putBoolean("Translucent", GUI.Translucent);
		}
		
		if(e.getSource() == autocleartoggle) {
			if(GUI.Autoclear) {
				autocleartoggle.setText("OFF");
			}
			else {
				autocleartoggle.setText("ON");
			}
			GUI.Autoclear = !GUI.Autoclear;
			GUI.pref.putBoolean("Autoclear", GUI.Autoclear);
		}
		
		if(e.getSource() == applyautoclearmin) {
			GUI.AutoclearAfter = (int) Double.parseDouble(autoclearmin.getText());
			GUI.pref.putInt("AutoclearAfter", GUI.AutoclearAfter);
		}
		
		if(e.getSource() == hidewhenclearedtoggle) {
			if(GUI.HideWhenCleared) {
				hidewhenclearedtoggle.setText("OFF");
			}
			else {
				hidewhenclearedtoggle.setText("ON");
			}
			GUI.HideWhenCleared = !GUI.HideWhenCleared;
			GUI.pref.putBoolean("HideWhenCleared", GUI.HideWhenCleared);
		}
		
		if(e.getSource() == showcoordsonhidescreentoggle) {
			GUI.ShowCoordsOnHideScreen = (GUI.ShowCoordsOnHideScreen + 1) % 3;
			switch(GUI.ShowCoordsOnHideScreen) {
			case 0: showcoordsonhidescreentoggle.setText("No"); break;
			case 1: showcoordsonhidescreentoggle.setText("SH"); break;
			case 2: showcoordsonhidescreentoggle.setText("All"); break;
			}
			GUI.pref.putInt("ShowCoordsOnHideScreen", GUI.ShowCoordsOnHideScreen);
		}
		
		if(e.getSource() == applysettextfont) {
			String settextfontsplit[] = settextfont.getText().split(Pattern.quote("*"));
			GUI.textfont = settextfontsplit[0];
			if(settextfontsplit.length == 2) {
				GUI.textsizer = (int) (Double.parseDouble(settextfontsplit[1]) * 100);
			}
			else {
				GUI.textsizer = 100;
			}
			GUI.Resize(GUI.m);
			GUI.pref.put("textfont", GUI.textfont);
			GUI.pref.putInt("textsizer", GUI.textsizer);
		}
		
		if(e.getSource() == resetsize) {
			GUI.m = 100;
			GUI.Resize(100);
			resizing.setValue(100);
			GUI.pref.putInt("m", GUI.m);
		}
		
		if(e.getSource() == morecoloroptions) {
			morecolorsettings = !morecolorsettings;
			GUI();
			SetColor(GUI.g);
		}
		
		if(e.getSource() == customisetextcolortoggle) {
			if(GUI.customisetextcolor) {
				customisetextcolortoggle.setText("OFF");
			}
			else {
				customisetextcolortoggle.setText("ON");
			}
			GUI.customisetextcolor = !GUI.customisetextcolor;
			SetColor(GUI.g);
			GUI.SetColor(GUI.g);
		}
		
		if(e.getSource() == close) {
			GUI.pref.putDouble("FramePositionX", settings.getLocation().getX());
			GUI.pref.putDouble("FramePositionY", settings.getLocation().getY());
			settings.dispatchEvent(new WindowEvent(settings, WindowEvent.WINDOW_CLOSING));
		}
		
		if(e.getSource() == minimize) {
			settings.setState(JFrame.ICONIFIED);
		}
	}
}
