package appl;

import server.Message;
import server.ServerCommand;

public class ServerCommandOne implements ServerCommand{

	@Override
	public Object execute(Message m) {
		System.err.println("command One");
		return "command One";
	}

}
