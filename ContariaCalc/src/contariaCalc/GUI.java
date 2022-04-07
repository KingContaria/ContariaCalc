package contariaCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	public static JFrame frame = new JFrame("ContariaCalc");
	static JPanel panel = new JPanel();
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
	public static boolean ShowDistance = true;
	public static int DistanceFrom = 0;
	public static boolean ShowNetherCoords = false;
	public static int NetherCoordsDecimals = 0;
	public static boolean ShowChunkCoords = false;
	public static boolean AlwaysOnTop = true ;
	public static boolean Autoclear = false;
	public static int AutoclearAfter = 15;
	public static int m = 100;
	
	static int extracoords = 0;
	public static int numberofcalculations = 0;

	public String[] firstcoords_split = firstcoords.getText().split(" ");
	public String[] secondcoords_split = secondcoords.getText().split(" ");
	
	public GUI() {
		
		Resize(m);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		panel.add(firstcoords);
		panel.add(xza1);
		panel.add(distance1);
		
		panel.add(secondcoords);
		panel.add(xza2);
		panel.add(distance2);
		
		panel.add(find);
		
		panel.add(sh);
		panel.add(result);
		
		panel.add(settings);
		
		panel.add(clear);
		
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
		
		}
	
	public static void Resize(int m) {
		
		int v = 90 * m/100;
		if(v < 100) {
			v = 100;
		}
		
		frame.setSize(225*m/100, 185*m/100+extracoords*20);
		
		firstcoords.setBounds(45*m/100, 40*m/100, 150*m/100, 20*m/100);
		xza1.setBounds(10*m/100, 40*m/100, 30*m/100, 20*m/100);
		distance1.setBounds(200*m/100, 40*m/100, 50*m/100, 20*m/100);
			
		secondcoords.setBounds(45*m/100, 65*m/100, 150*m/100, 20*m/100);
		xza2.setBounds(10*m/100, 65*m/100, 30*m/100, 20*m/100);
		distance2.setBounds(200*m/100, 65*m/100, 50*m/100, 20*m/100);
		
		find.setBounds(70*m/100, 92*m/100, 70*m/100, 25*m/100);
		
		sh.setBounds(10*m/100, 120*m/100, 90*m/100, 20*m/100);
		
		settings.setBounds(10*m/100, 10*m/100, 90*m/100, 20*m/100);
		
		clear.setBounds(110*m/100, 10*m/100, 90*m/100, 20*m/100);
		
		nethercoords.setBounds(10*m/100, 140*m/100, 100*m/100, 20*m/100);
		nethercoords_.setBounds(v, 140*m/100, 100*m/100, 20*m/100);
		
		chunkcoords.setBounds(10*m/100, (140+extracoords*20)*m/100, 100*m/100, 20*m/100);
		chunkcoords_.setBounds(v, (140+extracoords*20)*m/100, 100*m/100, 20*m/100);
		
		v = 90 * m/100;
		if(v < 90) {
			v = 90;
		}
		result.setBounds(v, 120*m/100, 150*m/100, 20*m/100);
	}
	
	public static void Clear() {

		result.setText("");
		firstcoords.setText("");
		secondcoords.setText("");
		distance1.setText("");
		distance2.setText("");
		frame.setSize(225*m/100, 185*m/100);
		nethercoords.setVisible(false);
		nethercoords_.setVisible(false);
		chunkcoords.setVisible(false);
		chunkcoords_.setVisible(false);
		extracoords = 0;
		numberofcalculations++;
	}
			

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == find) {
			
			numberofcalculations++;
			String sh_coordsraw = Calc.calculation(firstcoords.getText(), secondcoords.getText(), ShowNetherCoords, NetherCoordsDecimals, ShowChunkCoords);
			if(sh_coordsraw == "Error") {
				result.setText("Error");
			}
			else {
			String[] sh_coordssplit = sh_coordsraw.split(" / ");
			String sh_coords = sh_coordssplit[0];
			frame.setSize(225*m/100, 185*m/100);
			int framex_extra = 0;
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
						frame.setSize(260*m/100, 185*m/100);
						framex_extra = 35;
			}}
			
			int v = 90 * m/100;
			if(v < 100) {
				v = 100;
			}
			
			extracoords = 0;
			
			if(ShowNetherCoords) {
				frame.setSize((225+framex_extra)*m/100, 205*m/100);
				nethercoords_.setText(sh_coordssplit[1]);
				nethercoords_.setBounds(v, 140*m/100, 100*m/100, 20*m/100);
				nethercoords.setVisible(true);
				nethercoords_.setVisible(true);
				extracoords++;
			}
			
			if(ShowChunkCoords) {
				
				frame.setSize((225+framex_extra)*m/100, (205+extracoords*20)*m/100);
				chunkcoords.setBounds(10*m/100, (140+extracoords*20)*m/100, 100*m/100, 20*m/100);
				chunkcoords_.setBounds(v, (140+extracoords*20)*m/100, 100*m/100, 20*m/100);
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
			result.setBounds(v, 120*m/100, 150*m/100, 20*m/100);
			result.setText(sh_coords);
			
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
		
		if(e.getSource() == settings) {
			new Settings();
		}
		
		if(e.getSource() == clear) {
			GUI.Clear();
		}
	}}
