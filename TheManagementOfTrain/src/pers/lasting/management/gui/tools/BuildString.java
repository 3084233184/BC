package pers.lasting.management.gui.tools;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import pers.lasting.management.gui.function.Authentication;

public class BuildString implements Runnable{
	
	private JLabel jl1, jl2, jl3;
	private String uid;
	public BuildString(JLabel hello1,JLabel hello2,JLabel hello3,String uid){
		jl1=hello1;
		jl2=hello2;
		jl3=hello3;
		this.uid = uid;
	}
	
	public BuildString(JLabel hello,String uid) {
		// TODO Auto-generated constructor stub
		jl1 = hello;
		jl2=jl3=new JLabel();
		this.uid = uid;
	}
	public static String buildToken(int length) {
		String token = "";
		String []inventory = {
				"0","1","2","3","4","5","6","7","8","9",
				"A","B","C","D","E","F","G","H","I","J",
				"K","L","M","N","O","P","Q","R","S","T",
				"U","V","W","X","Y","Z","a","b","c","d",
				"e","f","g","h","i","j","k","l","m","n",
				"o","p","q","r","s","t","u","v","w","x",
				"y","z"		
		};
		
		for(int i = 0;i < length;i++) {
			int no = (int)(Math.random()*60);
			if(i==0 && no==0) {
				i-=1;
			}
			token = token + inventory[no];
		}
		return token;
	}

	
	public static String buildHello(String uid) {
		try {
			String uname = Authentication.getUserNameByID(uid);
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("HH");
			SimpleDateFormat dtf = new SimpleDateFormat("HH:mm:ss");
			String str=df.format(date);
			String time = dtf.format(date);
			int a=Integer.parseInt(str);
			if (a>=0&&a<=6) {
			return "<html><body>"+uname+",现在是凌晨"+time+"了，注意休息嗷！</body></html>";
			}
			if (a>6&&a<=12) {
			return "<html><body>"+uname+",上午好，现在是"+time+"</body></html>";
			}
			if (a>12&&a<=13) {
			return "<html><body>"+uname+",中午好，现在是"+time+"</body></html>";
			}
			if (a>13&&a<=18) {
			return "<html><body>"+uname+",下午好，现在是"+time+"</body></html>";
			}
//			if (a>18&&a<=24) {
			else {	
			return "<html><body>"+uname+",晚上好，现在是晚上"+time+"，<br/>早点休息嗷！</body></html>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return "你好！";
		}
	}
	public static void main(String[] args) {
		System.err.println(buildHello("1120259135"));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				jl1.setText(buildHello(uid));
				jl2.setText(buildHello(uid));
				jl3.setText(buildHello(uid));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}