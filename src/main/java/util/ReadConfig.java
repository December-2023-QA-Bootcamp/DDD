package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig 
{

	private Properties properties;
	
	public ReadConfig(String fileName) 
	{
		properties = new Properties();
		
		try 
		{
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
			properties.load(inputStream);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String get(String key) 
	{
		return properties.getProperty(key);
	}
}
