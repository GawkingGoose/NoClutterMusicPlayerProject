package objects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import javazoom.jl.decoder.JavaLayerException;
import utils.ErrorReporting;
import utils.FilePathUtil;
import utils.JDialog;
import utils.PlayerFactory;

public class TuneManager {

	private ArrayList<Tune> tunes;
	private String tuneFolderPath;
	private TunePlayer player;
	
	public TuneManager(){
		tunes = new ArrayList<Tune>();
		loadTuneData();
	}
	
	public void playTune(Tune tune){
		player = PlayerFactory.getTunePlayer(tune);
		player.playTune();
	}
	
	public void pauseTune(){
		if(player != null){
			player.pauseTune();
		}else{
			ErrorReporting.logError(null, "No player found");
		}
	}
	
	public void resumeTune(){
		if(player != null){
			player.resumeTune();
		}else{
			ErrorReporting.logError(null, "No player found");
		}
	}
	
	public void stopTune(){
		if(player != null){
			player.stopTune();
		}else{
			ErrorReporting.logError(null, "No player found");
		}
	}
	
	public Tune getTune(){
		if(player != null){
			return player.getTune();
		}else{
			ErrorReporting.logError(null, "No player found");
		}
		return null;
	}

	private void loadTuneData(){
		DataHandler dataHandler = new DataHandler();
		if(dataHandler.checkFileExists()){
			try {
				setTuneFolderPath(dataHandler.loadData(tunes));
				return;
			} catch (IOException e) {
				ErrorReporting.logError(e, "failed loading data");
			}
		}
		refreshTunes();
	}
	
	public void refreshTunes(){
		File folder = new File(getTuneFolderPath());
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
			if(FilePathUtil.getFileExtension(file.getAbsolutePath()).equals("mp3")){
				if(!checkIfAlreadyExists(file.getAbsolutePath())){
					tunes.add(new Tune(0, file.getAbsolutePath(), file.getName(), "me", TuneGenre.Unknown, 0));
				}
			}
		}
	}
	
	public boolean checkIfAlreadyExists(String path){
		for (Tune tune : tunes) {
			if(tune.getFilePath().equals(path)){
				return true;
			}
		}
		return false;
	}
	
	public void saveTuneData(){
		DataHandler dataHandler = new DataHandler();
		if(!dataHandler.checkFileExists()){
			try {
				dataHandler.createFile();
			} catch (IOException e) {
				ErrorReporting.logError(e, "failed file creation");
			}
		}
		try {
			dataHandler.saveData(tunes, tuneFolderPath);
		} catch (IOException e) {
			ErrorReporting.logError(e, "failed saving data");
		}
	}
	
	public String getTuneFolderPath() {
		if(tuneFolderPath == null){
			JDialog.openMessageDialog(null, "Please select a folder that contains music files.\nThis location can be used to add music by just dropping mp3 files into it!");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY); 
			fileChooser.showOpenDialog(null);
			File folder = fileChooser.getSelectedFile();
			tuneFolderPath = folder.getAbsolutePath();
		}
		return tuneFolderPath;
	}

	public void setTuneFolderPath(String tuneFolderPath) {
		this.tuneFolderPath = tuneFolderPath;
	}

	public ArrayList<Tune> getTunes() {
		return tunes;
	}
}
