package appl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.Message;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client();
		//new Client(true);
	}
	
	public Client(){
		try{
			Socket s = new Socket("localhost", 6969);
			Message msg = new MyMsgFib();
			msg.setType("3");
			((MyMsgFib)msg).setNum(new Integer(200));
						
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
						
			out.writeObject(msg);
			out.flush();
			
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
			String response = (String) in.readObject();
			
			System.err.println("client: " + response);
			
			in.close();
			out.close();			
			s.close();
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Client(boolean b){
		try{
			Socket s = new Socket("localhost", 6969);

			Message msg = new MyMessage();
			msg.setType("2");
			((MyMessage)msg).setMyData("this is my message and that´s all!!!");
						
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
						
			out.writeObject(msg);
			out.flush();
			
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
			String response = (String) in.readObject();
			
			System.err.println("client: " + response);
			
			
			in.close();
			out.close();			
			s.close();
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
