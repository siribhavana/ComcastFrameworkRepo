package com.cast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility 
{
	public String getDataFromJsonFile(String key) throws Exception
	{
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./configAppData/appCommonData.json"));
		JSONObject map=(JSONObject)obj;
		String data=(String) map.get(key);
		return data;
	}
}
