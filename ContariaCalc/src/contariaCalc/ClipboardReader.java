package contariaCalc;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardReader {
	
	public int p = 0;
	
	public ClipboardReader() {

	String data = null;
	try {
		data = (String) Toolkit.getDefaultToolkit()
		        .getSystemClipboard().getData(DataFlavor.stringFlavor);
	} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
		e.printStackTrace();
	}
	
	String lastclipboard = data;
	
	while(GUI.ClipboardReader) {
		
		try {
			data = (String) Toolkit.getDefaultToolkit()
			        .getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}
		
		if(data.equals(lastclipboard)) {}
		else {
			new EnterClipboardData(data);
		}
		
		lastclipboard = data;
		
		try {
			Thread.sleep(GUI.ClipboardreaderDelay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
}