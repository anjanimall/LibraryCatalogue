package edu.sjsu.p146.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtil {
	
	//methods in this class: writeToFile
	
	/**
	 * method that writes the data to file
	 * @param fileName the name of the file, in UserService.java fileName was defined by the path to users.txt
	 * @param jsonData the JSON string representation of the object
	 * @throws IOException
	 */
	public static void writeToFile(String fileName, String jsonData) throws IOException {
		FileOutputStream fOut = null;
	    OutputStreamWriter myOutWriter = null;
		try {
			File myFile = new File(fileName); //creates a new File Object that passes fileName (filePath) called myFile
	        myFile.createNewFile(); //creates new File in File myFile, if file does not exist				
	        fOut = new FileOutputStream(myFile);
	        myOutWriter = new OutputStreamWriter(fOut);
	        myOutWriter.append(jsonData);
		} finally {
			if(myOutWriter != null) {
				myOutWriter.close();
			}
			if(fOut != null) {
				fOut.close();
			}
		}
	}
}
