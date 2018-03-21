package application.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
 
public class UtilBase64Image {
	
	/**
	 * Eine Bildatei wird übergeben und in das Base64 Format gebracht.
	 * @param imagePath (String) 
	 * @return Kodiertes Bild (String)
	 */
	public static String encoder(String imagePath) {
	    File file = new File(imagePath);
	    try (FileInputStream imageInFile = new FileInputStream(file)) {
	        // Reading a Image file from file system
	    	String base64Image = "";
	        byte imageData[] = new byte[(int) file.length()];
	        imageInFile.read(imageData);
	        base64Image = Base64.getEncoder().encodeToString(imageData);
	        return base64Image;
	    } catch (FileNotFoundException e) {
	        System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	        System.out.println("Exception while reading the Image " + ioe);
	    }
	    return null;
	}
	/**
	 * Ein base64-kodiertes Bild wird zu einem Bild umgewandelt und in einem übergebenem Pfad abgespeichert
	 * @param 1. base64Image (String), 2. pathfile (String)
	 * @return -
	 */
	public static void decoder(String base64Image, String pathFile) {
	    try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
	        // Converting a Base64 String into Image byte array
	        byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
	        imageOutFile.write(imageByteArray);
	    } catch (FileNotFoundException e) {
	        System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	        System.out.println("Exception while reading the Image " + ioe);
	    }
	}
}