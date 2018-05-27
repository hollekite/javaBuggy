package com.lgs.dom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 利用DOM4J获取xml 文件的Document 对象，同时将Document对象写入一个xml文件中
 * @author Administrator
 *
 */
public class XMLUtil {
	
	
	/**
	 * 获取xml文件的Document对象
	 * @param path xml文件的路径
	 * @return	得到XML的Document对象
	 */
	public static  Document getElement(String path)
	{
		SAXReader saxReader = new SAXReader();  
		Document document = null;
		File file = new File(path);
		if(path.toUpperCase().endsWith("XML") && file.exists()) {
			try {
				document = saxReader.read(file);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			System.out.println(path+" 该文件路径错误，或xml文件不存在");
		}
		return document;
	}
	
	/**
	 * 将XML的document 对象写入一个xml文件中，如果文件不是xml文件则报错
	 * @param document Document对象
	 * @param path 要写入的xml文件的路径
	 */
	
	public static void loadDocument(Document document,String path)
	{
		
		if(path!= null && !path.toUpperCase().endsWith("XML"))
		{
			try {
				throw new  Exception("文件不为xml文件");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			FileWriter out = null;
			try {
				out = new FileWriter(path);
				document.write(out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	

}
