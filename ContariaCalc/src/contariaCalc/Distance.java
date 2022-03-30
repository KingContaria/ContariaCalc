package contariaCalc;

public class Distance {
	
	public Distance() {
		
	}
	
	public static String DistanceCalc(String eyethrow_coords, String sh_coords) {
		
		String distance = "Error";
		
		String[] eyethrow_coords_split = eyethrow_coords.split(" ");
		String[] sh_coords_split = sh_coords.split(" ");
		
		if(eyethrow_coords_split.length == 3) {
			if(sh_coords_split.length == 2) {
				
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
