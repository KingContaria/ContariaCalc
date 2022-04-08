package contariaCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings implements ActionListener, ChangeListener {
	
	JFrame settings = new JFrame("Settings");
	JPanel panel = new JPanel();
	JLabel clipboardreader = new JLabel("ClipboardReader:");
	JButton clipboardreadertoggle = new JButton("OFF");
	JLabel clipboardreaderdelay = new JLabel("Check every                 ms");
	JTextField clipboardreaderdelayms = new JTextField(GUI.ClipboardreaderDelay + "");
	JButton applyclipboardreaderdelayms = new JButton("✔");
	JLabel showdistance = new JLabel("Show Distance to SH:");
	JButton showdistancetoggle = new JButton("OFF");
	JLabel distancefrom = new JLabel("Distance from:");
	JButton distancefromtoggle = new JButton("1st Throw");
	JLabel shownethercoords = new JLabel("Show Nether Coords:");
	JButton shownethercoordstoggle = new JButton("OFF");
	JLabel nethercoordsdecimals = new JLabel("Nether Coords Decimals:");
	JLabel showchunkcoords = new JLabel("Show Chunk Coords:");
	JButton nethercoordsdecimalstoggle = new JButton("0");
	JButton showchunkcoordstoggle = new JButton("OFF");
	JLabel alwaysontop = new JLabel("Always On Top:");
	JButton alwaysontoptoggle = new JButton("OFF");
	JLabel translucent = new JLabel("Translucent:");
	JButton translucenttoggle = new JButton("OFF");
	JLabel autoclear = new JLabel("Autoclear:");
	JButton autocleartoggle = new JButton("OFF");
	JLabel autoclearafter = new JLabel("Autoclear after           min");
	JTextField autoclearmin = new JTextField(GUI.AutoclearAfter +  "");
	JButton applyautoclearmin = new JButton("✔");
	JLabel hidewhencleared = new JLabel("Hide when cleared:");
	JButton hidewhenclearedtoggle = new JButton("OFF");
	JLabel showcoordsonhidescreen = new JLabel("Result on Hide Screen:");
	JButton showcoordsonhidescreentoggle = new JButton("No");
	JLabel textfont = new JLabel("Text Font:");
	JTextField settextfont = new JTextField(GUI.textfont + "");
	JButton applysettextfont = new JButton("✔");
	JLabel resize = new JLabel("Resize:");
	JSlider resizing = new JSlider(JSlider.HORIZONTAL, 50, 200, GUI.m);
	JButton resetsize = new JButton("Reset");
	JLabel color = new JLabel("Color:");
	JSlider changecolor = new JSlider(JSlider.HORIZONTAL, 90, 255, Math.abs(GUI.c - 345));
	
	public Settings() {
		
		int settingsnumber = 0;
		int settingsgap = 30;
		
		settings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		settings.setAlwaysOnTop(true);
		settings.setVisible(true);
		settings.add(panel);
		
		panel.setLayout(null);

		clipboardreader.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(clipboardreader);
		clipboardreadertoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.ClipboardReader) {
			clipboardreadertoggle.setText("ON");
		}
		panel.add(clipboardreadertoggle);
		settingsnumber++;
		
		clipboardreaderdelay.setBounds(10, 10 + settingsnumber * settingsgap, 250, 20);
		panel.add(clipboardreaderdelay);
		clipboardreaderdelayms.setBounds(84, 10 + settingsnumber * settingsgap, 45, 20);
		panel.add(clipboardreaderdelayms);
		applyclipboardreaderdelayms.setBounds(156, 10 + settingsnumber * settingsgap, 44, 20);
		panel.add(applyclipboardreaderdelayms);
		settingsnumber++;
		
		showdistance.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(showdistance);
		showdistancetoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.ShowDistance) {
			showdistancetoggle.setText("ON");
		}
		panel.add(showdistancetoggle);
		settingsnumber++;
		
		distancefrom.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(distancefrom);
		distancefromtoggle.setBounds(100, 10 + settingsnumber * settingsgap, 100, 20);
		switch(GUI.DistanceFrom) {
		case 1: distancefromtoggle.setText("2nd Throw"); break;
		case 2: distancefromtoggle.setText("Both"); break;
		}
		panel.add(distancefromtoggle);
		settingsnumber++;
		
		
		shownethercoords.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(shownethercoords);
		shownethercoordstoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.ShowNetherCoords) {
			shownethercoordstoggle.setText("ON");
		}
		panel.add(shownethercoordstoggle);
		settingsnumber++;
		
		nethercoordsdecimals.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(nethercoordsdecimals);
		nethercoordsdecimalstoggle.setBounds(159, 10 + settingsnumber * settingsgap, 41, 20);
		nethercoordsdecimalstoggle.setText("" + GUI.NetherCoordsDecimals);
		panel.add(nethercoordsdecimalstoggle);
		settingsnumber++;
		
		showchunkcoords.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(showchunkcoords);
		showchunkcoordstoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.ShowChunkCoords) {
			showchunkcoordstoggle.setText("ON");
		}
		panel.add(showchunkcoordstoggle);
		settingsnumber++;
		
		alwaysontop.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(alwaysontop);
		alwaysontoptoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.AlwaysOnTop) {
			alwaysontoptoggle.setText("ON");
		}
		panel.add(alwaysontoptoggle);
		settingsnumber++;
		
		translucent.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(translucent);
		translucenttoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.Translucent) {
			translucenttoggle.setText("ON");
		}
		panel.add(translucenttoggle);
		settingsnumber++;
		
		autoclear.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(autoclear);
		autocleartoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.Autoclear) {
			autocleartoggle.setText("ON");
		}
		panel.add(autocleartoggle);
		settingsnumber++;
		
		autoclearafter.setBounds(10, 10 + settingsnumber * settingsgap, 250, 20);
		panel.add(autoclearafter);
		autoclearmin.setBounds(100, 10 + settingsnumber * settingsgap, 25, 20);
		panel.add(autoclearmin);
		applyautoclearmin.setBounds(156, 10 + settingsnumber * settingsgap, 44, 20);
		panel.add(applyautoclearmin);
		settingsnumber++;
		
		hidewhencleared.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(hidewhencleared);
		hidewhenclearedtoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.HideWhenCleared) {
			hidewhenclearedtoggle.setText("ON");
		}
		panel.add(hidewhenclearedtoggle);
		settingsnumber++;
		
		showcoordsonhidescreen.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(showcoordsonhidescreen);
		showcoordsonhidescreentoggle.setBounds(150, 10 + settingsnumber * settingsgap, 50, 20);
		switch(GUI.ShowCoordsOnHideScreen) {
		case 1: showcoordsonhidescreentoggle.setText("SH"); break;
		case 2: showcoordsonhidescreentoggle.setText("All"); break;
		}
		panel.add(showcoordsonhidescreentoggle);
		settingsnumber++;
		
		textfont.setBounds(10, 10 + settingsnumber * settingsgap, 250, 20);
		panel.add(textfont);
		settextfont.setBounds(75, 10 + settingsnumber * settingsgap, 70, 20);
		panel.add(settextfont);
		applysettextfont.setBounds(156, 10 + settingsnumber * settingsgap, 44, 20);
		panel.add(applysettextfont);
		settingsnumber++;
		
		resize.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(resize);
		resizing.setBounds(50, 12 + settingsnumber * settingsgap, 80, 20);
		panel.add(resizing);
		resetsize.setBounds(130, 10 + settingsnumber * settingsgap, 70, 20);
		panel.add(resetsize);
		settingsnumber++;
		
		color.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(color);
		changecolor.setBounds(50, 12 + settingsnumber * settingsgap, 150, 20);
		panel.add(changecolor);
		settingsnumber++;
		
		settings.setSize(230, 50 + settingsnumber * settingsgap);
		
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
		resizing.addChangeListener(this);
		changecolor.addChangeListener(this);
		
	}

	
	public void stateChanged(ChangeEvent e) {
		
		if(e.getSource() == resizing) {
			GUI.m = resizing.getValue();
			GUI.Resize(resizing.getValue());
			GUI.pref.putInt("m", GUI.m);
		}
		
		if(e.getSource() == changecolor) {
			GUI.c = Math.abs(changecolor.getValue() - 345);
			GUI.SetColor(GUI.c);
			GUI.pref.putInt("c", GUI.c);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

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
			GUI.textfont = settextfont.getText();
			GUI.Resize(GUI.m);
			GUI.pref.put("textfont", GUI.textfont);
		}
		
		if(e.getSource() == resetsize) {
			GUI.m = 100;
			GUI.Resize(100);
			resizing.setValue(100);
			GUI.pref.putInt("m", GUI.m);
		}
		
	}

}
