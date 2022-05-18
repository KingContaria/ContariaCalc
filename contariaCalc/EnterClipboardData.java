package contariaCalc;

public class EnterClipboardData {
	
	public EnterClipboardData(String data) {

		String[] datasplit = data.split(" ");
		if(datasplit.length == 3) {
			if(GUI.firstcoords.getText().equals("")) {
				GUI.firstcoords.setText(data);
			}
			else {
				if(GUI.secondcoords.getText().equals("")) {
					GUI.secondcoords.setText(data);
					GUI.Find();
				}
				else {
					if(GUI.overwritefirst) {
						GUI.firstcoords.setText(data);
						GUI.Find();
						GUI.overwritefirst = false;
					}
					else {
						GUI.secondcoords.setText(data);
						GUI.Find();
						GUI.overwritefirst = true;
					}
				}
			}
		}
	}

}
