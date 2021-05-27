package appl;

import server.MessageImpl;

public class MyMsgFib extends MessageImpl{

	private static final long serialVersionUID = -8726895311481768235L;
	private Integer num;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
