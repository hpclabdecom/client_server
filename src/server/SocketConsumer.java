package server;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// exemplo de um consumidor !!!

public class SocketConsumer<S extends Socket> extends GenericConsumer<S>{
	//create any constructor type 
		
	public SocketConsumer(GenericResource<S> re) {		
		super(re);			
	}

	@Override
	protected void doSomething(S str) {
		try{
			// TODO Auto-generated method stub
			ObjectInputStream in = new ObjectInputStream(str.getInputStream());
			
			Message msg = (Message) in.readObject();
			System.err.println("Server: " + msg.getType());
			
			Object response = commands.get(msg.getType()).execute(msg);
			ObjectOutputStream out = new ObjectOutputStream(str.getOutputStream());
			out.writeObject(response);
			out.flush();
			out.close();
			in.close();
						
			str.close();
				
		}catch (Exception e){
			e.printStackTrace();
			
		}
				
	}		

}
