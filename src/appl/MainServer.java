package appl;

import java.net.Socket;

import server.GenericConsumer;
import server.GenericResource;
import server.Server;
import server.SocketConsumer;

public class MainServer extends Server{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int serverPort = 6969;
		new MainServer(serverPort);
	}
	
	public MainServer(int port){
		super(port);
				
		System.err.println("server ok!");
		
		this.begin();
				
	}

	@Override
	protected GenericConsumer<Socket> createSocketConsumer(
			GenericResource<Socket> r) {
		// TODO Auto-generated method stub
		return new SocketConsumer<Socket>(r);
	}

}
