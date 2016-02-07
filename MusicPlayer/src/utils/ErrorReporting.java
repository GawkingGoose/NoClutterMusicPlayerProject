package utils;

public class ErrorReporting {

	public static void logError(Exception e, String message){
		if(e == null){
			System.out.println("[ERROR] - " + message + " - no Exception Object");
		}else{
			System.out.println("[ERROR] - " + message + " - " + e);
		}
	}
	
}
