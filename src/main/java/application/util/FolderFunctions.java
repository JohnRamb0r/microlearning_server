package application.util;

import java.io.File;


public class FolderFunctions {
	
	private static final String path = "/home/john-ramb0r/da/";

	public static void createFolder(String foldername){
		String fullPath = fullPath(foldername);
		
		if(!doesFolderExist(foldername)){
			File dir = new File(fullPath);
			dir.mkdir();
		}
	}
	
	public static Boolean doesFolderExist(String foldername){
		String fullPath = fullPath(foldername);
		
		File file = new File(fullPath);
		
		if(file.exists() && file.isDirectory())
			return true;
		else
			return false;
	}
	
	public static String fullPath(String foldername){
		return path + foldername+"/";
	}
	
}
