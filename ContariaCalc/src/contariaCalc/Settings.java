package contariaCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Settings implements ActionListener {
	
	JFrame settings = new JFrame("Settings");
	JPanel panel = new JPanel();
	JLabel showdistance = new JLabel("Show Distance to SH:");
	JButton showdistancetoggle = new JButton("ON");
	JLabel distancefrom = new JLabel("Distance from:");
	JButton distancefromtoggle = new JButton("1st Throw");
	JLabel shownethercoords = new JLabel("Show Nether Coords:");
	JButton shownethercoordstoggle = new JButton("OFF");
	JLabel nethercoordsdecimals = new JLabel("Nether Coords Decimals:");
	JLabel showchunkcoords = new JLabel("Show Chunk Coords:");
	JButton nethercoordsdecimalstoggle = new JButton("0");
	JButton showchunkcoordstoggle = new JButton("OFF");
	JLabel alwaysontop = new JLabel("Always On Top:");
	JButton alwaysontoptoggle = new JButton("ON");
	
	public Settings() {
		
		int settingsnumber = 0;
		int settingsgap = 30;
		
		settings.setSize(230, 230);
		settings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		settings.setAlwaysOnTop(true);
		settings.setVisible(true);
		settings.add(panel);
		
		panel.setLayout(null);

		showdistance.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(showdistance);
		showdistancetoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.ShowDistance == false) {
			showdistancetoggle.setText("OFF");
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
		if(GUI.ShowNetherCoords == true) {
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
		if(GUI.ShowChunkCoords == true) {
			showchunkcoordstoggle.setText("ON");
		}
		panel.add(showchunkcoordstoggle);
		settingsnumber++;
		
		alwaysontop.setBounds(10, 10 + settingsnumber * settingsgap, 150, 20);
		panel.add(alwaysontop);
		alwaysontoptoggle.setBounds(140, 10 + settingsnumber * settingsgap, 60, 20);
		if(GUI.AlwaysOnTop == false) {
			alwaysontoptoggle.setText("OFF");
		}
		panel.add(alwaysontoptoggle);
		settingsnumber++;
		
		
		showdistancetoggle.addActionListener(this);
		distancefromtoggle.addActionListener(this);
		shownethercoordstoggle.addActionListener(this);
		nethercoordsdecimalstoggle.addActionListener(this);
		alwaysontoptoggle.addActionListener(this);
		showchunkcoordstoggle.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == showdistancetoggle) {
			if(GUI.ShowDistance == true) {
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
			if(GUI.ShowNetherCoords == true) {
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
			if(GUI.ShowChunkCoords == true) {
				GUI.ShowChunkCoords = false;
				showchunkcoordstoggle.setText("OFF");
			}
			else {
				GUI.ShowChunkCoords = true;
				showchunkcoordstoggle.setText("ON");
			}
		}
		
		if(e.getSource() == alwaysontoptoggle) {
			if(GUI.AlwaysOnTop == true) {
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
		
	}

}
