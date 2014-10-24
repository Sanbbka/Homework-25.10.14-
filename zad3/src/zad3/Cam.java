package zad3;

public class Cam {
	private int id;
	private String ip;
	private boolean video;
	private boolean audio;
	private String audioStream;
	private String videoStream;
	private String login;
	private String pass;
	
	
	public Cam( int id,String ip, String login, String pass ){
		this.id = id;
		this.setIp(ip);
		setPass(pass);
		setLogin(login);
	}

	public boolean hasVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public boolean hasAudio() {
		return audio;
	}

	public void setAudio(boolean audio) {
		this.audio = audio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public boolean equals(Object obj) {
		return ip.equals(((Cam)obj).ip);
	}

	public String getAudioStream() {
		return audioStream;
	}

	public void setAudioStream(String audioStream) {
		this.audioStream = audioStream;
	}

	public String getVideoStream() {
		return videoStream;
	}

	public void setVideoStream(String videoStream) {
		this.videoStream = videoStream;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		
		return  id + " "+ip + " " +login + " " + pass + " " + videoStream + " " + audioStream + "\n" ;
	}
	
}