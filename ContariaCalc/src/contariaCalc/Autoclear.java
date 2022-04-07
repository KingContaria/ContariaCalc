package contariaCalc;


public class Autoclear extends Thread{
	
	public Autoclear(int calculationsonthreadstart, int AutoclearAfter) throws InterruptedException {

		double threadstart = System.currentTimeMillis();
		double threadend = threadstart + AutoclearAfter * 60000;
		
		while(System.currentTimeMillis() < threadend) {
			
		}
		
		if(calculationsonthreadstart == GUI.numberofcalculations) {
			GUI.Clear();
		}
		
	}

}
