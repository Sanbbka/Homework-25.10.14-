package zad3;



import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class qwe {

	private static String protocolReg = "[a-zA-Z]+";
	private static String ipReg = "([01]?\\d\\d|2([0-4]\\d|5[0-5]))(\\.[01]?\\d\\d?|\\.2([0-4]\\d|5[0-5])){3}";
	private static String portReg = "[1-9](\\d?){3}|[1-5](\\d?){4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5]";
	private static String loginPassReg = "[a-zA-Z][a-zA-Z0-9]*";
	private static String videoAudioReg = "(video|audio)(/[a-zA-Z0-9]+)+";
	private static String audioReg = "audio(/[a-zA-Z0-9]+)+";
	private static String videoReg = "video(/[a-zA-Z0-9]+)+";
	private static String reg = protocolReg + "://" + "(" + loginPassReg + "(:" + loginPassReg + ")?@)?" + ipReg + ":(" + portReg + ")/(" + videoAudioReg + ")";
								
	private ArrayList<Cam> list;

	public qwe() {
		list = new ArrayList<Cam>();
	}

	public boolean add(String s) {
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(s);
		
		if( !m.matches() )
			return false;
		
		p = Pattern.compile(ipReg+":("+portReg+")");
		m = p.matcher(s);
		m.find();
		
		String ip = m.group();
		String login = "";
		String pass  = "";
		boolean b = false;
		for (Cam c : list) {
			if (c.getIp().equals(ip)) {
				b = true;
				break;
			}
		}

		if(!b){
		
			p = Pattern.compile(loginPassReg + ":" + loginPassReg);
			m = p.matcher(s);
			
			if( m.find() ){
				
				p = Pattern.compile(loginPassReg);
				m = p.matcher(s);
				m.find();
				m.find();
				login = m.group();
				m.find();
				pass = m.group();
			
			}
			
			p = Pattern.compile(loginPassReg + "@");
			m = p.matcher(s);
			
			if(m.find()){
				p = Pattern.compile(loginPassReg);
				m = p.matcher(s);
				m.find();
				m.find();
				login = m.group();			
			}
			
				
			list.add(new Cam(list.size(),ip,login,pass));
		}
		p = Pattern.compile(videoReg);
		m = p.matcher(s);
		if( m.find() ){
			addVideo(ip,m.group());	
		}
		p = Pattern.compile(audioReg);
		m = p.matcher(s);
		if( m.find() ){
			addAudio(ip,m.group());	
		}
		
		
		return true;
	}

	public void playVideo(String ip) {

		for (Cam c : list) {
			if (c.getIp().equals(ip) && c.hasVideo()) {
				System.out.println("Видео воспроизводится");
				return;
			}
		}

		System.out.println("Видео не воспроизводится");
	}

	public void addVideo(String ip, String videoStream) {
		for (Cam c : list) {
			if (c.getIp().equals(ip)) {
				c.setVideo(true);
				c.setVideoStream(videoStream);
				return;
			}
		}

	}

	public void addAudio(String ip, String audioStream) {
		for (Cam c : list) {
			if (c.getIp().equals(ip)) {
				c.setAudio(true);
				c.setAudioStream(audioStream);
				return;
			}
		}
	}

	public int cameraCount() {
		System.out.println(list);
		return list.size();
	}

}
