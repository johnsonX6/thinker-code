package com.client.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLUtils {

	static Logger logger=Logger.getLogger(XMLUtils.class);
	private XMLUtils(){
		
	}
	
	public static void createXML(){
		Document doc=DocumentHelper.createDocument();
		Element ele=doc.addElement("firstLevel");
		Element ele1=ele.addElement("firstSonOne");
		Element ele2=ele.addElement("firstSonTwo");
		ele1.addAttribute("color", "yellow");
		ele1.setText("sonOne");
		ele2.addAttribute("fontSize","20");
		ele2.setText("sonTwo");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
//		File file=new File("D:"+File.separator+"demo.xml");
		File file=new File("src/main/resources/demo.xml");
		XMLWriter writer=null;
		try {
			writer = new XMLWriter(new FileOutputStream(file),format);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.write(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("XML create end===>");
	}
	
	public static void main(String[] args) {
		XMLUtils.createXML();
		CountDownLatch countDownLatch = new CountDownLatch(1);
//		ByteBuf byteBuf = new ByteBuf();
	}
}
