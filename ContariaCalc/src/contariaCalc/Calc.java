package contariaCalc;

import java.util.regex.Pattern;

public class Calc {
	
	public Calc() {
		
	}
	
	public static String[] Calculationinputoutput(String firstthrow, String secondthrow) {
		
		String[] result = new String[3];
		result[0] = "Error";
		
		String[] firstcoords = firstthrow.split(" ");
		String[] secondcoords = secondthrow.split(" ");
		
		if(firstcoords.length == 3 && secondcoords.length == 3) {

			double[][] xza = new double[2][3];
			
			for(int e=0; e<3; e++) {
			
			xza[0][e] = Double.parseDouble(firstcoords[e]);
			
				if(secondcoords[e].contains("+")) {
					String[] secondcoords_ = secondcoords[0].split(Pattern.quote("+"));
					xza[1][e] = xza[0][e] + Double.parseDouble(secondcoords_[1]);
				} 
				else {
					xza[1][e] = Double.parseDouble(secondcoords[e]);
				}
			}
			
			for(int e=0; e<2; e++) {
				if(xza[e][2] < 0) {
					xza[e][2] = xza[0][2] + 180;
				}
			
				xza[e][2] -= 90;
			}
			
			double xzsh[] = TriangulationCalc(xza);
			
			int x = (int) Math.round(xzsh[0]);
			int z = (int) Math.round(xzsh[1]);
			
			result[0] = x + " " + z;
			
			if(GUI.marginoferror) {
			
				result[0] += MarginOfError(xza);
			
			}
			
			if(GUI.ShowNetherCoords) {
		
				double xnether = Math.round((xzsh[0] / 8) * Math.pow(10 , GUI.NetherCoordsDecimals)) / Math.pow(10 , GUI.NetherCoordsDecimals);
				double znether = Math.round((xzsh[1] / 8) * Math.pow(10 , GUI.NetherCoordsDecimals)) / Math.pow(10 , GUI.NetherCoordsDecimals);
				if(GUI.NetherCoordsDecimals == 0) {
					result[1] = (int) xnether + " " + (int) znether;
				}
				else {
					result[1] = xnether + " " + znether;
				}
			}
			
			if(GUI.ShowChunkCoords) {
				
				int[] chunk = new int[2];
				chunk[0] = x / 16;
				chunk[1] = z / 16;
				if(x < 0) {
					chunk[0] -= 1;
				}
				if(z < 0) {
					chunk[1] -= 1;
				}

				String chunkdistance = "";
				
				if(GUI.ShowChunkDistance) {
					String[] chunkdistancetext = new String[2];
					for(int e=0; e<2; e++) {
						int[] fromchunk = new int[2];
						fromchunk[0] = (int) xza[e][0] / 16;
						fromchunk[1] = (int) xza[e][1] / 16;
						if(xza[e][0] < 0) {
							fromchunk[0] -= 1;
						}
						if(xza[e][1] < 0) {
							fromchunk[1] -= 1;
						}
						chunkdistancetext[e] = ChunkDistanceCalc(chunk, fromchunk);
					}
					GUI.chunkdistance1.setText(chunkdistancetext[0]);
					GUI.chunkdistance2.setText(chunkdistancetext[1]);
				}
				
				if(GUI.ShowChunkDistanceFromPortal) {
					String[] portalchunkcoords_split = GUI.portalchunkcoords.getText().split(" ");
					if(portalchunkcoords_split.length == 2) {
						int[] portalchunk = new int[2];
						portalchunk[0] = (int) Double.parseDouble(portalchunkcoords_split[0]);
						portalchunk[1] = (int) Double.parseDouble(portalchunkcoords_split[1]);
						if(!GUI.ShowPortalInputField) {
							chunkdistance = ChunkDistanceCalc(chunk, portalchunk).replace("C", "");
						}
						GUI.portalchunkdistance.setText(ChunkDistanceCalc(chunk, portalchunk));
					}
				}
				
				result[2] = chunk[0] + " " + chunk[1] + chunkdistance;
					
			}
		}
		
		return result;

	}
	
public static double[] TriangulationCalc(double[][] xza) {
	
	double[] m = new double[2];
	double[] n = new double[2];
	
	for(int e=0; e<2; e++) {
		
		m[e] = Math.tan(Math.toRadians(xza[e][2]));
		n[e] = xza[e][1] + (-xza[e][0] * m[e]);
	}
	
	double[] xz = new double[2];
	
	xz[0] = (n[1]-n[0]) / (m[0]-m[1]);
	xz[1] = m[0] * xz[0] + n[0];
	
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
			
			int distance_int = (int) (Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(z1 - z2), 2)));
			
			distance = distance_int + "";
		}
	}
	
	return distance;
	
}

public static String ChunkDistanceCalc(int[] xz1, int[] xz2) {
	
	int distance;
	
	if(Math.abs(xz1[0]-xz2[0]) > Math.abs(xz1[1]-xz2[1])){
		distance = Math.abs(xz1[0]-xz2[0]);
	}
	else {
		distance = Math.abs(xz1[1]-xz2[1]);
	}
	
	String chunkdistancestring = " (CD: " + distance + ")";
	
	return chunkdistancestring;
	
}

public static String MarginOfError(double[][] xza) {
	
	double xz1[] = TriangulationCalc(xza);
	
	int pv = 1;
	
	if(xza[0][2] < xza[1][2]) {
		pv = -1;
	}
	
	xza[0][2] += 0.3 * pv;
	xza[1][2] -= 0.3 * pv;
	
	double xzsh[] = TriangulationCalc(xza);

	double distance = Math.sqrt(Math.pow(Math.abs(xz1[0] - xzsh[0]), 2) + Math.pow(Math.abs(xz1[1] - xzsh[1]), 2));
	
	int margin = (int) Math.round(distance);
	
	String marginoferror = " (+- " + margin + ")";
	
	return marginoferror;
	
}

}
