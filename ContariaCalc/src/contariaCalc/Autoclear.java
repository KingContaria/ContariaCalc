package contariaCalc;


public class Autoclear extends Thread{
	
	public Autoclear(int calculationsonthreadstart, int AutoclearAfter) throws InterruptedException {
		
		Thread.sleep(AutoclearAfter * 60000);
		
		if(calculationsonthreadstart == GUI.numberofcalculations) {
			GUI.Clear();
		}
		
	}

}
