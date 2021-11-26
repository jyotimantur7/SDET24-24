package com.crm.genericfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

public String Generic1(String key) throws IOException  {
	
	FileInputStream fis=new FileInputStream("./Data/data.properties");
	Properties Pobj=new Properties();
	Pobj.load(fis);
	String value=Pobj.getProperty(key);
	return value;

	}

	
	

}
