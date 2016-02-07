
public class Main {

    public static void main(String[] argv) {

    	TuneManager manager = new TuneManager();
    	manager.refreshTunes();
    	Tune tune = manager.getTunes().get(2);
    	System.out.println(tune.getFilePath());
    	TunePlayer player = PlayerFactory.getTunePlayer(tune);
    	
    	player.playTune();
    	while(player.getStatus() != 3){sleep(6000);}
    	
    	manager.saveTuneData();
    	
    	
    	
    	
    	exit();
    }
	
    public static void demoSaveLoadToManager(){
    	TuneManager manager = new TuneManager();
    	Tune tune = manager.getTunes().get(2);
    	System.out.println(tune.getFilePath());
    	TunePlayer player = PlayerFactory.getTunePlayer(tune);
    	player.playTune();
    	sleep(6000);
    	player.pauseTune();
    	sleep(3000);
    	player.resumeTune();
    	while(player.getStatus() != 3){sleep(6000);}
    	manager.saveTuneData();
    }
    
    public static void demoTunePlayer(){
    	Tune tune1 = new Tune(1,"C:/Users/Matt/Downloads/Dan Deacon - When I Was Done Dying.mp3","nametemp", "artistTemp",TuneGenre.Unknown,0);
    	TunePlayer player = PlayerFactory.getTunePlayer(tune1);
    	player.playTune();
    	sleep(3000);
    	player.pauseTune();
    	sleep(3000);
    	player.resumeTune();
    	sleep(3000);
    }
    
	public static void sleep(long timeToSleepFor){
		System.out.println("Sleeping for " + timeToSleepFor);
		try {
			Thread.sleep(timeToSleepFor);
		} catch (InterruptedException e) {
			ErrorReporting.logError(e, "while thread sleep");
		}
	}
	
	public static void exit(){
		System.out.println("Exiting");
        System.exit(0);
	}
}
