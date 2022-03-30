package contariaCalc;

public class Calc {
	
	public Calc() {
		
	}
	
	public static String calculation(String firstthrow, String secondthrow) {
		
		String sh_coords = "Error";
		
		String[] firstcoords = firstthrow.split(" ");
		String[] secondcoords = secondthrow.split(" ");
		
		if(firstcoords.length == 3) {
			if(secondcoords.length == 3) {

				double x1 = Double.parseDouble(firstcoords[0]);
				double z1 = Double.parseDouble(firstcoords[1]);
				double a1 = Double.parseDouble(firstcoords[2]);
				double x2 = Double.parseDouble(secondcoords[0]);
				double z2 = Double.parseDouble(secondcoords[1]);
				double a2 = Double.parseDouble(secondcoords[2]);
				
				double a1_ = a1;
				double a2_ = a2;
				
				if(a1 < 0) {
					a1_ = a1 + 180;
				}
				if(a2 < 0) {
					a2_ = a2 + 180;
				}
				
				a1_ = a1_ - 90;
				a2_ = a2_ - 90;
				
				double m1 = Math.tan(Math.toRadians(a1_));
				double m2 = Math.tan(Math.toRadians(a2_));
				double n1 = z1 + (-x1 * m1);
				double n2 = z2 + (-x2 * m2);
				
				double x = (n2-n1) / (m1-m2);
				double y = m1 * x + n1;
				
				//double throwdistance = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(z1 - z2), 2));
				
				int x_ = (int) Math.round(x);
				int y_ = (int) Math.round(y);
				
				sh_coords = x_ + " " + y_;
				
				
			}
		}
		
		return sh_coords;

}}
