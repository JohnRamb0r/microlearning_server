package application.util;

import java.io.File;


public class FolderFunctions {
	
	private static final String path = "/home/john-ramb0r/da/";

	/**
	 * Erstellt einen Ordner, falls er noch nicht exisitiert.
	 * @param foldername (String) 
	 * @return -
	 */
	public static void createFolder(String foldername){
		String fullPath = fullPath(foldername);
		
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
		String fullPath = fullPath(foldername);
		
		File file = new File(fullPath);
		
		if(file.exists() && file.isDirectory())
			return true;
		else
			return false;
	}
	
	/**
	 * @param Foldername (String) 
	 * @return Kompletten Folderpfad (String)
	 */
	public static String fullPath(String foldername){
		return path + foldername+"/";
	}
	
}
