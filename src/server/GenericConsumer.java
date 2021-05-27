package server;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public abstract class GenericConsumer<S> extends Thread{
	
	protected GenericResource<S> re;
	protected Map<String, ServerCommand> commands;
		
	public GenericConsumer(GenericResource<S> re){
		this.re = re;	
		commands = new HashMap<String, ServerCommand>();
		loadCommandProperties();
	}
	
	protected void loadCommandProperties(){
		Properties properties = new Properties();
		try {
		    properties.load(new FileInputStream("config.properties"));
		    Set<String> ids = properties.stringPropertyNames();
		    for(String aux:ids){
		    	Class c = Class.forName(properties.getProperty(aux));
		    	commands.put(aux, (ServerCommand) c.newInstance());
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		try {
				S str = null;
				
				while((re.isFinished()==false)||(re.getNumOfRegisters()!=0)){
					if ((str = re.getRegister())!=null){
						//fazer algo com o recurso que foi consumido
						doSomething(str);
					}
				}					
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}		
	}
	
	protected abstract void doSomething(S str);

}
