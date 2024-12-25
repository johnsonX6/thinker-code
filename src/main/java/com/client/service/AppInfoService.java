package com.client.service;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {

	public String getAppInfo(){
		String xml="http://";
		File file =new File("src/main/resources/appDesc.xml");
		SAXReader reader=new SAXReader();
		Document document=null;
		try {
			 document=reader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Element> elements=document.getRootElement().elements();
		for(Element e:elements){
			if(e.getName()!=null && e.getName().equals("hostName")){
				xml+=e.getText();
			}
			if(e.getName()!=null && e.getName().equals("port")){
				xml+=":"+e.getText();
			}
			if(e.getName()!=null && e.getName().equals("applicationName")){
				xml+="/"+e.getText();
			}
			if(e.getName()!=null && e.getName().equals("testPort")){
				xml+="/"+e.getText();
			}
		}
		return xml;
	}
}
