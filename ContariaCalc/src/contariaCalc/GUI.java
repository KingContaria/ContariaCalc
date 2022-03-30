package contariaCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	JFrame frame = new JFrame("ContariaCalc");
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
	JTextField firstcoords = new JTextField("");
	JTextField secondcoords = new JTextField("");
	
	public static boolean CoordsOverlay = false;
	public static boolean ShowDistance = true;
	public static int DistanceFrom = 0;

	public String[] firstcoords_split = firstcoords.getText().split(" ");
	public String[] secondcoords_split = secondcoords.getText().split(" ");
	
	public GUI() {
		
		
		frame.setSize(250, 230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		firstcoords.setBounds(45, 60, 150, 20);
		panel.add(firstcoords);
		xza1.setBounds(10, 60, 30, 20);
		panel.add(xza1);
		distance1.setBounds(200, 60, 50, 20);
		panel.add(distance1);
		
		secondcoords.setBounds(45, 90, 150, 20);
		panel.add(secondcoords);
		xza2.setBounds(10, 90, 30, 20);
		panel.add(xza2);
		distance2.setBounds(200, 90, 50, 20);
		panel.add(distance2);
		
		find.setBounds(80, 120, 70, 30);
		panel.add(find);
		
		sh.setBounds(10, 160, 90, 20);
		panel.add(sh);
		result.setBounds(90, 160, 150, 20);
		panel.add(result);
		
		settings.setBounds(20, 20, 90, 20);
		panel.add(settings);
		
		clear.setBounds(120, 20, 90, 20);
		panel.add(clear);
		
		
		find.addActionListener(this);
		settings.addActionListener(this);
		clear.addActionListener(this);
		
		}
			
		

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource() == find) {
			
			String sh_coords = Calc.calculation(firstcoords.getText(), secondcoords.getText());
			if(ShowDistance == true) {
				switch(DistanceFrom) {
				case 0:	sh_coords = sh_coords + "   (D: " + Distance.DistanceCalc(firstcoords.getText(), sh_coords) + ")"; break;
				case 1: sh_coords = sh_coords + "   (D: " + Distance.DistanceCalc(secondcoords.getText(), sh_coords) + ")"; break;
				case 2: distance1.setText("D: " + Distance.DistanceCalc(firstcoords.getText(), sh_coords));
						distance2.setText("D: " + Distance.DistanceCalc(secondcoords.getText(), sh_coords));
						frame.setSize(260, 240);
			}}
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
			frame.setSize(250, 230);
		}
}}
