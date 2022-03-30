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
	
	public Settings() {
		
		settings.setSize(250, 250);
		settings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		settings.setAlwaysOnTop(true);
		settings.setVisible(true);
		settings.add(panel);
		
		panel.setLayout(null);

		showdistance.setBounds(10, 20, 150, 20);
		panel.add(showdistance);
		showdistancetoggle.setBounds(140, 20, 60, 20);
		if(GUI.ShowDistance == false) {
			showdistancetoggle.setText("OFF");
		}
		panel.add(showdistancetoggle);
		
		distancefrom.setBounds(10, 60, 150, 20);
		panel.add(distancefrom);
		distancefromtoggle.setBounds(100, 60, 100, 20);
		switch(GUI.DistanceFrom) {
		case 1: distancefromtoggle.setText("2nd Throw"); break;
		case 2: distancefromtoggle.setText("Both"); break;
		}
		panel.add(distancefromtoggle);
		
		
		showdistancetoggle.addActionListener(this);
		distancefromtoggle.addActionListener(this);
		
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
		
	}

}
