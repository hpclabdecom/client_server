package appl;

import server.MessageImpl;

public class MyMessage extends MessageImpl{

	private static final long serialVersionUID = 7878010073671492379L;
	private String myData;
	
	public String getMyData() {
		return myData;
	}
	public void setMyData(String myData) {
		this.myData = myData;
	}
	
}
