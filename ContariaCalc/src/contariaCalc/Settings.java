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
	JLabel autoclear = new JLabel("Autoclear:");
	JButton autocleartoggle = new JButton("OFF");
	JLabel autoclearafter = new JLabel("Autoclear after           min");
	JTextField autoclearmin = new JTextField(GUI.AutoclearAfter +  "");
	JButton applyautoclearmin = new JButton("✔");
	JLabel hidewhencleared = new JLabel("Hide when cleared:");
	JButton hidewhenclearedtoggle = new JButton("OFF");
	JLabel showcoordsonhidescreen = new JLabel("Result on Hide Screen:");
	JButton showcoordsonhidescreentoggle = new JButton("No");
	JLabel resize = new JLabel("Resize:");
	JSlider resizing = new JSlider(JSlider.HORIZONTAL, 50, 200, GUI.m);
	JButton resetsize = new JButton("Reset");
	
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
		
		resize.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(resize);
		resizing.setBounds(50, 12 + settingsnumber * settingsgap, 80, 20);
		panel.add(resizing);
		resetsize.setBounds(130, 10 + settingsnumber * settingsgap, 70, 20);
		panel.add(resetsize);
		settingsnumber++;
		
		settings.setSize(230, 50 + settingsnumber * settingsgap);
		
		clipboardreadertoggle.addActionListener(this);
		applyclipboardreaderdelayms.addActionListener(this);
		showdistancetoggle.addActionListener(this);
		distancefromtoggle.addActionListener(this);
		shownethercoordstoggle.addActionListener(this);
		nethercoordsdecimalstoggle.addActionListener(this);
		alwaysontoptoggle.addActionListener(this);
		showchunkcoordstoggle.addActionListener(this);
		autocleartoggle.addActionListener(this);
		applyautoclearmin.addActionListener(this);
		hidewhenclearedtoggle.addActionListener(this);
		showcoordsonhidescreentoggle.addActionListener(this);
		resetsize.addActionListener(this);
		resizing.addChangeListener(this);
		
	}

	
	public void stateChanged(ChangeEvent e) {
		
		if(e.getSource() == resizing) {
			GUI.m = resizing.getValue();
			GUI.Resize(resizing.getValue());
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == clipboardreadertoggle) {
			if(GUI.ClipboardReader) {
				GUI.ClipboardReader = false;
				clipboardreadertoggle.setText("OFF");
			}
			else {
				GUI.ClipboardReader = true;
				clipboardreadertoggle.setText("ON");
				new Thread() {
		            public void run() {
		                new ClipboardReader();
		            }
		        }.start();
			}
		}
		
		if(e.getSource() == applyclipboardreaderdelayms) {
			GUI.ClipboardreaderDelay = (int) Double.parseDouble(clipboardreaderdelayms.getText());
		}
		
		if(e.getSource() == showdistancetoggle) {
			if(GUI.ShowDistance) {
				GUI.ShowDistance = false;
				showdistancetoggle.setText("OFF");
			}
			else {
				GUI.ShowDistance = true;
				showdistancetoggle.setText("ON");
			}
		}
		
		if(e.getSource() == distancefromtoggle) {
			GUI.DistanceFrom = (GUI.DistanceFrom + 1) % 3;
			switch(GUI.DistanceFrom) {
			case 0: distancefromtoggle.setText("1st Throw"); break;
			case 1: distancefromtoggle.setText("2nd Throw"); break;
			case 2: distancefromtoggle.setText("Both"); break;
			}
		}
		
		if(e.getSource() == shownethercoordstoggle) {
			if(GUI.ShowNetherCoords) {
				GUI.ShowNetherCoords = false;
				shownethercoordstoggle.setText("OFF");
			}
			else {
				GUI.ShowNetherCoords = true;
				shownethercoordstoggle.setText("ON");
			}
		}
		
		if(e.getSource() == nethercoordsdecimalstoggle) {
			GUI.NetherCoordsDecimals = (GUI.NetherCoordsDecimals + 1) % 4;
			nethercoordsdecimalstoggle.setText("" + GUI.NetherCoordsDecimals);
			
		}
		
		if(e.getSource() == showchunkcoordstoggle) {
			if(GUI.ShowChunkCoords) {
				GUI.ShowChunkCoords = false;
				showchunkcoordstoggle.setText("OFF");
			}
			else {
				GUI.ShowChunkCoords = true;
				showchunkcoordstoggle.setText("ON");
			}
		}
		
		if(e.getSource() == alwaysontoptoggle) {
			if(GUI.AlwaysOnTop) {
				GUI.AlwaysOnTop = false;
				alwaysontoptoggle.setText("OFF");
				GUI.frame.setAlwaysOnTop(false);
				settings.setAlwaysOnTop(false);
			}
			else {
				GUI.AlwaysOnTop = true;
				alwaysontoptoggle.setText("ON");
				GUI.frame.setAlwaysOnTop(true);
				settings.setAlwaysOnTop(true);
			}
		}
		
		if(e.getSource() == autocleartoggle) {
			if(GUI.Autoclear) {
				GUI.Autoclear = false;
				autocleartoggle.setText("OFF");
			}
			else {
				GUI.Autoclear = true;
				autocleartoggle.setText("ON");
			}
		}
		
		if(e.getSource() == applyautoclearmin) {
			GUI.AutoclearAfter = (int) Double.parseDouble(autoclearmin.getText());
		}
		
		if(e.getSource() == hidewhenclearedtoggle) {
			if(GUI.HideWhenCleared) {
				GUI.HideWhenCleared = false;
				hidewhenclearedtoggle.setText("OFF");
			}
			else {
				GUI.HideWhenCleared = true;
				hidewhenclearedtoggle.setText("ON");
			}
		}
		
		if(e.getSource() == showcoordsonhidescreentoggle) {
			GUI.ShowCoordsOnHideScreen = (GUI.ShowCoordsOnHideScreen + 1) % 3;
			switch(GUI.ShowCoordsOnHideScreen) {
			case 0: showcoordsonhidescreentoggle.setText("No"); break;
			case 1: showcoordsonhidescreentoggle.setText("SH"); break;
			case 2: showcoordsonhidescreentoggle.setText("All"); break;
			}
		}
		
		if(e.getSource() == resetsize) {
			GUI.m = 100;
			GUI.Resize(100);
			resizing.setValue(100);
		}
		
	}

}
