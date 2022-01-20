package study;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test2 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File file = new File("sample2.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		
		document.getDocumentElement().normalize();
		System.out.println("Root Element : "+document.getDocumentElement().getNodeName());
		
		NodeList nList = document.getElementsByTagName("staff");
		
		System.out.println("-----------------");
		
		for(int temp=0;temp<nList.getLength();temp++) {
			Node node = nList.item(temp);
			
			System.out.println("Current Element : " + node.getNodeName());
			
			Element element = (Element)node;
			
			System.out.println("firstname : "+element.getElementsByTagName("firstname").item(0).getTextContent());
			System.out.println("lastname : "+element.getElementsByTagName("lastname").item(0).getTextContent());
			System.out.println("nickname : "+element.getElementsByTagName("nickname").item(0).getTextContent());
			System.out.println("salary : "+element.getElementsByTagName("salary").item(0).getTextContent());
			
			System.out.println();
			
			
		}
		

	}

}
