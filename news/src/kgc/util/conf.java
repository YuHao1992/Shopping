package kgc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class conf {
	private static conf confiConf;
	private Properties properties;
	public conf(){
		String configfile="database.properties";
		InputStream inputStream=conf.class.getResourceAsStream(configfile);
		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static synchronized conf getInstance(){
		if (confiConf==null) {
			confiConf=new conf();
		}
		return confiConf;
	}
	
	
	public String getsString(String key){
		return properties.getProperty(key);
		
		
	}
	
	
	
}
