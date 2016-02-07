package objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import utils.FilePathUtil;


/**
 * This class will handle the saving and loading of data
 * 
 * @author Matt
 *
 */
public class DataHandler {

	private String taskDataDirPath = "\\taskData.txt";
	
	public String getFileDirectory(){
		return FilePathUtil.getPathToSaveDataFolder() + taskDataDirPath;
	}
	
	public boolean checkFileExists(){
		File f = new File(FilePathUtil.getPathToSaveDataFolder() + taskDataDirPath);
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		}
		return false;
	}
	
	public void createFile() throws IOException{
//		String path = "C:" + File.separator + "hello" + File.separator + "hi.txt";
		// Use relative path for Unix systems
		File f = new File(FilePathUtil.getPathToSaveDataFolder() + taskDataDirPath);
		// Works for both Windows and Linux
		f.getParentFile().mkdirs(); 
		f.createNewFile();
	}
	
	public String loadData(ArrayList<Tune> tunes) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(getFileDirectory())); {
			int linesLeftInFile = countLinesInFile();
			String tuneFolderPath = br.readLine();
			linesLeftInFile--;
			
			for (int i = 0; i < linesLeftInFile/6; i++) {
				 int id = Integer.parseInt(br.readLine());
				 String path = br.readLine();
				 String name = br.readLine();
				 String artist = br.readLine();
				 String genre = br.readLine();//-------------genre converter needed
				 int imgId = Integer.parseInt(br.readLine());
				 
				 tunes.add(new Tune(id,path,name,artist,TuneGenre.Unknown, imgId));
			}
			System.out.println(tunes.toString());
			return tuneFolderPath;
		}
	}
	
	private int countLinesInFile(){
		int num = 0;
		try{
		BufferedReader br = new BufferedReader(new FileReader(getFileDirectory())); {
		    for(String line; (line = br.readLine()) != null; ) {
		        num++;
		    }
		}
		return num;
		}catch(Exception e){
			System.out.println("ERROR - " + e);
		}
		return 0;
	}
	
	public void saveData(ArrayList<Tune> tunes, String musicFolderLocation) throws IOException{
		
		File fout = new File(getFileDirectory());
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		bw.write(musicFolderLocation);
		
		for (Tune tune : tunes) {
			bw.newLine();
			bw.write(""+tune.getId());
			bw.newLine();
			bw.write(tune.getFilePath());
			bw.newLine();
			bw.write(tune.getName());
			bw.newLine();
			bw.write(tune.getArtist());
			bw.newLine();
			bw.write("genre");//-------------genre converter needed
			bw.newLine();
			bw.write(""+tune.getImgId());
		}
	 
		bw.close();
	}
}
