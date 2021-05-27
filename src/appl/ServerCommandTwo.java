package appl;

import server.Message;
import server.ServerCommand;

public class ServerCommandTwo implements ServerCommand{

	@Override
	public Object execute(Message m) {
		System.err.println("command Two");
		System.err.println(((MyMessage)m).getMyData());
		return "command Two";
	}

}
