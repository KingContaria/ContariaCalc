package contariaCalc;

public class EnterClipboardData {
	
	public EnterClipboardData(String data) {

		String[] datasplit = data.split(" ");
		if(datasplit.length == 3) {
			if(GUI.firstcoords.getText().equals("")) {
				GUI.firstcoords.setText(data);
			}
			else {
				GUI.secondcoords.setText(data);
				GUI.Find();
			}
		}
	}

}
