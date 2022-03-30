package contariaCalc;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoordsOverlay {
	
	JFrame coordsOverlay = new JFrame("Overlay");
	JPanel panel = new JPanel();
	JLabel coords = new JLabel();
	
	public CoordsOverlay(String sh_coords) {
		
		coordsOverlay.setSize(50, 150);
		coordsOverlay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		coordsOverlay.setVisible(true);
		coordsOverlay.add(panel);
		
		panel.setLayout(null);

		coords.setBounds(10, 0, 150, 20);
		coords.setText(sh_coords);
		panel.add(coords);

	}

}
