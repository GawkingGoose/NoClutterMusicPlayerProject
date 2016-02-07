package objects;

import javazoom.jl.decoder.JavaLayerException;
import utils.ErrorReporting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TunePlayer extends PausablePlayer{
	
	private Tune tune;
	
	public TunePlayer(Tune tune) throws FileNotFoundException, JavaLayerException{
		super(new FileInputStream(tune.getFilePath()));
	}
	
	public void playTune(){
		try {
			play();
		} catch (JavaLayerException e) {
			ErrorReporting.logError(e, "Error playing tune");
		}
	}
	
	public boolean pauseTune(){
		return pause();
	}
	
	public boolean resumeTune(){
		return resume();
	}
	
	public void stopTune(){
		close();
	}
	
	public Tune getTune(){
		return tune;
	}
}
