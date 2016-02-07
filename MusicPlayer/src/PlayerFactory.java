
public class PlayerFactory {

	private static TunePlayer tunePlayer;
	
	public static TunePlayer getTunePlayer(Tune tune){
		if(tunePlayer != null){
			if(tunePlayer.getTune() == tune){
				return tunePlayer;
			} 
		}
		try {
			tunePlayer = new TunePlayer(tune);
		} catch (Exception e) {
			ErrorReporting.logError(e, "creating tune player");
		}
		return tunePlayer;
	}
	
}
