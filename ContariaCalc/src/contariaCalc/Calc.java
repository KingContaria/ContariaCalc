package contariaCalc;

import java.util.regex.Pattern;

public class Calc {
	
	public Calc() {
		
	}
	
	public static String calculation(String firstthrow, String secondthrow, boolean ShowNetherCoords, int NetherCoordsDecimals, boolean ShowChunkCoords) {
		
		String sh_coords = "Error";
		
		String[] firstcoords = firstthrow.split(" ");
		String[] secondcoords = secondthrow.split(" ");
		
		if(firstcoords.length == 3) {
			if(secondcoords.length == 3) {

				double x1 = Double.parseDouble(firstcoords[0]);
				double z1 = Double.parseDouble(firstcoords[1]);
				double a1 = Double.parseDouble(firstcoords[2]);
				double x2;
				double z2;
				double a2;
				
				if(secondcoords[0].contains("+")) {
					String[] secondcoords_ = secondcoords[0].split(Pattern.quote("+"));
					x2 = x1 + Double.parseDouble(secondcoords_[1]);
				} else {
					x2 = Double.parseDouble(secondcoords[0]);
				}
				
				if(secondcoords[1].contains("+")) {
					String[] secondcoords_ = secondcoords[1].split(Pattern.quote("+"));
					z2 = z1 + Double.parseDouble(secondcoords_[1]);
				} else {
					z2 = Double.parseDouble(secondcoords[1]);
				}
				
				if(secondcoords[2].contains("+")) {
					String[] secondcoords_ = secondcoords[2].split(Pattern.quote("+"));
					a2 = a1 + Double.parseDouble(secondcoords_[1]);
				} else {
					a2 = Double.parseDouble(secondcoords[2]);
				}
				
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
				
				if(ShowNetherCoords) {
					
					double xnether = Math.round((x / 8) * Math.pow(10 , NetherCoordsDecimals)) / Math.pow(10 , NetherCoordsDecimals);
					double ynether = Math.round((y / 8) * Math.pow(10 , NetherCoordsDecimals)) / Math.pow(10 , NetherCoordsDecimals);
					if(NetherCoordsDecimals == 0) {
						int xnether_ = (int) xnether;
						int ynether_ = (int) ynether;
						sh_coords += " / " + xnether_ + " " + ynether_;
					}
					else {
						sh_coords += " / " + xnether + " " + ynether;
					}
					
				}
				else {
					sh_coords += " / ";
				}
				
				if(ShowChunkCoords) {
					
					int xchunk = x_ / 16;
					int ychunk = y_ / 16;
					if(x_ < 0) {
						xchunk -= 1;
					}
					if(y_ < 0) {
						ychunk -= 1;
					}
					sh_coords += " / " + xchunk + " " + ychunk;
					
				}
				
				
			}
		}
		
		return sh_coords;

	}

public static String DistanceCalc(String eyethrow_coords, String sh_coords) {
	
	String distance = "Error";
	
	String[] eyethrow_coords_split = eyethrow_coords.split(" ");
	String[] sh_coords_split = sh_coords.split(" ");
	
	if(eyethrow_coords_split.length == 3) {
		if(sh_coords_split.length > 1) {
			
			double x1 = Double.parseDouble(eyethrow_coords_split[0]);
			double z1 = Double.parseDouble(eyethrow_coords_split[1]);
			double x2 = Double.parseDouble(sh_coords_split[0]);
			double z2 = Double.parseDouble(sh_coords_split[1]);
			
			double distance_ = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(z1 - z2), 2));
			
			int distance__ = (int) Math.round(distance_);
			
			distance = distance__ + "";
		}
	}

			
	
	return distance;
	
}

}
