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
	JPanel panel = new JPanel();
	JButton find = new JButton("Find");
	JButton settings = new JButton("Settings");
	JButton clear = new JButton("Clear");
	JLabel xza1 = new JLabel("x z a");
	JLabel xza2 = new JLabel("x z a");
	JLabel sh = new JLabel("SH Location:");
	JLabel distance1 = new JLabel("");
	JLabel distance2 = new JLabel("");
	JLabel result = new JLabel("");
	JLabel nethercoords = new JLabel("Nethercoords:");
	JLabel nethercoords_ = new JLabel();
	JLabel chunkcoords = new JLabel("Chunkcoords:");
	JLabel chunkcoords_ = new JLabel();
	JTextField firstcoords = new JTextField("");
	JTextField secondcoords = new JTextField("");
	
	public static boolean CoordsOverlay = false;
	public static boolean ShowDistance = true;
	public static int DistanceFrom = 0;
	public static boolean ShowNetherCoords = false;
	public static int NetherCoordsDecimals = 0;
	public static boolean ShowChunkCoords = false;
	public static boolean AlwaysOnTop = true ;

	public String[] firstcoords_split = firstcoords.getText().split(" ");
	public String[] secondcoords_split = secondcoords.getText().split(" ");
	
	public GUI() {
		
		frame.setSize(225, 185);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		firstcoords.setBounds(45, 40, 150, 20);
		panel.add(firstcoords);
		xza1.setBounds(10, 40, 30, 20);
		panel.add(xza1);
		distance1.setBounds(200, 40, 50, 20);
		panel.add(distance1);
		
		secondcoords.setBounds(45, 65, 150, 20);
		panel.add(secondcoords);
		xza2.setBounds(10, 65, 30, 20);
		panel.add(xza2);
		distance2.setBounds(200, 65, 50, 20);
		panel.add(distance2);
		
		find.setBounds(70, 92, 70, 25);
		panel.add(find);
		
		sh.setBounds(10, 120, 90, 20);
		panel.add(sh);
		result.setBounds(90, 120, 150, 20);
		panel.add(result);
		
		settings.setBounds(10, 10, 90, 20);
		panel.add(settings);
		
		clear.setBounds(110, 10, 90, 20);
		panel.add(clear);
		
		nethercoords.setBounds(10, 140, 100, 20);
		panel.add(nethercoords);
		nethercoords.setVisible(false);
		nethercoords_.setBounds(100, 140, 100, 20);
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
			

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == find) {
			
			String sh_coordsraw = Calc.calculation(firstcoords.getText(), secondcoords.getText(), ShowNetherCoords, NetherCoordsDecimals, ShowChunkCoords);
			String[] sh_coordssplit = sh_coordsraw.split(" / ");
			String sh_coords = sh_coordssplit[0];
			frame.setSize(225, 185);
			nethercoords.setVisible(false);
			nethercoords_.setVisible(false);
			chunkcoords.setVisible(false);
			chunkcoords_.setVisible(false);
			if(ShowDistance == true) {
				switch(DistanceFrom) {
				case 0:	sh_coords = sh_coords + "   (D: " + Distance.DistanceCalc(firstcoords.getText(), sh_coords) + ")"; break;
				case 1: sh_coords = sh_coords + "   (D: " + Distance.DistanceCalc(secondcoords.getText(), sh_coords) + ")"; break;
				case 2: distance1.setText("D: " + Distance.DistanceCalc(firstcoords.getText(), sh_coords));
						distance2.setText("D: " + Distance.DistanceCalc(secondcoords.getText(), sh_coords));
						frame.setSize(260, 240);
			}}
			
			if(ShowNetherCoords) {
				frame.setSize(225, 205);
				nethercoords_.setText(sh_coordssplit[1]);
				nethercoords.setVisible(true);
				nethercoords_.setVisible(true);
			}
			
			if(ShowChunkCoords) {
				if(ShowNetherCoords) {
					frame.setSize(225, 225);
					chunkcoords.setBounds(10, 160, 100, 20);
					chunkcoords_.setBounds(100, 160, 100, 20);
				}
				else {
					frame.setSize(225, 205);
					chunkcoords.setBounds(10, 140, 100, 20);
					chunkcoords_.setBounds(100, 140, 100, 20);
				}
				chunkcoords_.setText(sh_coordssplit[2]);
				chunkcoords.setVisible(true);
				chunkcoords_.setVisible(true);
			}
			
			if(CoordsOverlay == true) {
				new CoordsOverlay(sh_coords);
			}
			result.setText(sh_coords);
			
			}
		
		if(e.getSource() == settings) {
			new Settings();
		}
		
		if(e.getSource() == clear) {
			result.setText("");
			firstcoords.setText("");
			secondcoords.setText("");
			distance1.setText("");
			distance2.setText("");
			frame.setSize(225, 185);
			nethercoords.setVisible(false);
			nethercoords_.setVisible(false);
			chunkcoords.setVisible(false);
			chunkcoords_.setVisible(false);
		}
}}
