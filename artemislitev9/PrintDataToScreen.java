/**
 * 
 */
package artemislitev9;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author MCdal
 *
 */
public class PrintDataToScreen implements Runnable {

	/**
	 * sop object
	 */
	public StateOfPlay sop;
	
	public StateOfPlay getSop() {
		return sop;
	}

	public void setSop(StateOfPlay sop) {
		this.sop = sop;
	}

	@Override
	public void run() {
		
		try {
			// creates new file based on serialised number
			File file = new File(ArtemisLite.fileName+".JSON");
			
			if (!file.exists()) {
				file.createNewFile();
			}
			 
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream gamePlayOut = new ObjectOutputStream(fileOut);

			// checking that the sop object is not null
			if (sop != null) {
				gamePlayOut.writeObject(sop);
			} else {
				System.out.println("Data has not been printed to file.");
			}
			
			// closing resources.
			gamePlayOut.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
