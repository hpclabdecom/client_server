package appl;

import server.Message;
import server.ServerCommand;

public class ServerCommandThree implements ServerCommand{
	@Override
	public Object execute(Message m) {
		System.err.println("command three");
		//estaria o algo de fib
		/*int proximo=0,atual=0,anterior=1;
		while(proximo<=((MyMsgFib)m).getNum()){
		    proximo=atual+anterior;
			System.out.print(proximo+",");
			anterior=atual;
			atual=proximo;
		}*/
		System.out.println(((MyMsgFib)m).getNum());
		
		return String.valueOf(m.getType());
	}
	
}
