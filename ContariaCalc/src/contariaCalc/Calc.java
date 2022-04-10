package contariaCalc;

import java.util.regex.Pattern;

public class Calc {
	
	public Calc() {
		
	}
	
	public static String Calculationinputoutput(String firstthrow, String secondthrow) {
		
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
				
				double xz[] = TriangulationCalc(x1, z1, a1, x2, z2, a2);
				
				int x = (int) Math.round(xz[0]);
				int z = (int) Math.round(xz[1]);
			
				sh_coords = x + " " + z;
				
				if(GUI.marginoferror) {
					
					sh_coords += MarginOfError(x1, z1, a1, x2, z2, a2);
					
				}
				
				if(GUI.ShowNetherCoords) {
					
					double xnether = Math.round((xz[0] / 8) * Math.pow(10 , GUI.NetherCoordsDecimals)) / Math.pow(10 , GUI.NetherCoordsDecimals);
					double znether = Math.round((xz[1] / 8) * Math.pow(10 , GUI.NetherCoordsDecimals)) / Math.pow(10 , GUI.NetherCoordsDecimals);
					if(GUI.NetherCoordsDecimals == 0) {
						int xnether_ = (int) xnether;
						int znether_ = (int) znether;
						sh_coords += " / " + xnether_ + " " + znether_;
					}
					else {
						sh_coords += " / " + xnether + " " + znether;
					}
					
				}
				else {
					sh_coords += " / ";
				}
				
				if(GUI.ShowChunkCoords) {
					
					int xchunk = x / 16;
					int zchunk = z / 16;
					if(x < 0) {
						xchunk -= 1;
					}
					if(z < 0) {
						zchunk -= 1;
					}
					sh_coords += " / " + xchunk + " " + zchunk;
					
				}
			}
		}
		
		return sh_coords;

	}
	
public static double[] TriangulationCalc(double x1, double z1, double a1, double x2, double z2, double a2) {
	
	if(a1 < 0) {
		a1 = a1 + 180;
	}
	if(a2 < 0) {
		a2 = a2 + 180;
	}
	
	a1 = a1 - 90;
	a2 = a2 - 90;
	
	double m1 = Math.tan(Math.toRadians(a1));
	double m2 = Math.tan(Math.toRadians(a2));
	double n1 = z1 + (-x1 * m1);
	double n2 = z2 + (-x2 * m2);
	
	double[] xz = new double[2];
	
	xz[0] = (n2-n1) / (m1-m2);
	xz[1] = m1 * xz[0] + n1;
	
	return xz;
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

public static String MarginOfError(double x1, double z1, double a1, double x2, double z2, double a2) {
	
	double xz1[] = TriangulationCalc(x1, z1, a1, x2, z2, a2);
	
	int pv = 1;
	
	if(a1 < a2) {
		pv = -1;
	}
	
	a1 += 0.3 * pv;
	a2 -= 0.3 * pv;
	
	double xz2[] = TriangulationCalc(x1, z1, a1, x2, z2, a2);

	double distance = Math.sqrt(Math.pow(Math.abs(xz1[0] - xz2[0]), 2) + Math.pow(Math.abs(xz1[1] - xz2[1]), 2));
	
	int margin = (int) Math.round(distance);
	
	String marginoferror = " (+- " + margin + ")";
	
	return marginoferror;
	
}

}
