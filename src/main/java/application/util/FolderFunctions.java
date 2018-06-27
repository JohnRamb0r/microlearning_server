package application.util;

import java.io.File;


public class FolderFunctions {
	
	// path (String) zum express.js images serverfolder
	private static final String path = "C:/Users/Fabian/Documents/GitHub/imageserver/public/images/";

	/**
	 * Erstellt einen Ordner, falls er noch nicht exisitiert.
	 * @param foldername (String) 
	 * @return -
	 */
	public static void createFolder(String foldername){
		String fullPath = getFullPath(foldername);
		
		if(!doesFolderExist(foldername)){
			File dir = new File(fullPath);
			dir.mkdir();
		}
	}
	/**
	 * Überprüft, ob ein Ordner bereits existiert.
	 * @param foldername (String) 
	 * @return true falls er existiert, false wenn der Ordner nicht existiert (Boolean)
	 */
	public static Boolean doesFolderExist(String foldername){
		String fullPath = getFullPath(foldername);
		
		File file = new File(fullPath);
		
		if(file.exists() && file.isDirectory())
			return true;
		else
			return false;
	}
	
	/**
	 * Gibt den ganzen Pfad zurück.
	 * @param Foldername (String) 
	 * @return Kompletten Folderpfad (String) fürs Datenablegen
	 */
	public static String getFullPath(String foldername){
		return path + foldername+"/";
	}
	
	/**
	 * Gibt den ganzen Pfad samt Datei zurück.
	 * @param Foldername (String), Dateiname (String) 
	 * @return Kompletten Folderpfad samt Dateiname (String)
	 */
	
	public static String getFullPathWithData(String foldername, String dataname){
		return FolderFunctions.getFullPath(foldername) + dataname;
	}
	
	/**
	 * Gibt den ganzen Pfad zurück.
	 * @param Foldername (String) 
	 * @return Kompletten Folderpfad (String) zum Serverfolder fürs online abrufen
	 */
	
	public static String getServerPath(String foldername){
		
		return "http://localhost:3000/images/" + foldername + "/";
	}
	
	/**
	 * Gibt den ganzen Pfad samt Datei zurück.
	 * @param Foldername (String) 
	 * @return Kompletten Folderpfad samt Datei (String) 
	 */
	public static String getServerPathWithData(String foldername, String dataname){
		return FolderFunctions.getServerPath(foldername) + dataname;
	}
	
}
