package utils;

import java.io.File;

public class FilePathUtil {
	
	private static String saveDataFolder = "\\TTSData\\MusicPlayerData";
	
	public static String getPathToHome(){
		
		return System.getProperty("user.home");
	}
	
	public static String getPathToSaveDataFolder(){
		
		return getPathToHome() + saveDataFolder;
	}
	
	public static String getFileExtension(String path){
		String extension = "";

		int i = path.lastIndexOf('.');
		int p = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));

		if (i > p) {
		    extension = path.substring(i+1);
		}
		return extension;
	}
	
	public static boolean doesSaveDataFolderExists(){
		File f = new File(getPathToSaveDataFolder());
		if (f.exists() && f.isDirectory()) {
		   return true;
		}
		return false;
	}
	
	public static boolean createSaveDataFolder(){
		File dir = new File(getPathToSaveDataFolder());
	    // attempt to create the directory here
	    boolean successful = dir.mkdir();
	    if (successful){
	      // creating the directory succeeded
	      System.out.println("directory was created successfully");
	    }else{
	      // creating the directory failed
	      System.out.println("failed trying to create the directory");
	    }
	    return successful;
	}
	
}
