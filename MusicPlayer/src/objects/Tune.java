package objects;

public class Tune {

	private int id;
	private String filePath;
	private String name;
	private String artist;
	private TuneGenre genre;
	private int imgId;
	
	public Tune(int id, String path, String name, String artist, TuneGenre genre, int imgId) {
		super();
		this.id = id;
		this.filePath = path;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.imgId = imgId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String fileName) {
		this.filePath = fileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public TuneGenre getGenre() {
		return genre;
	}

	public void setGenre(TuneGenre genre) {
		this.genre = genre;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public int getId() {
		return id;
	}
	
	public String toString(){
		return "Tune " + getName() + " Path " + getFilePath();
	}
	
}
