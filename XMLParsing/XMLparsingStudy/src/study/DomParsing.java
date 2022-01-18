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

public class DomParsing {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File file = new File("sample.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		document.getDocumentElement().normalize();
		System.out.println("root Element : "+document.getDocumentElement().getNodeName());
		
		NodeList nList = document.getElementsByTagName("book");
		System.out.println("------------");
		
		for(int temp=0 ;temp<nList.getLength();temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :"+ nNode.getNodeName());
			
			if(nNode.getNodeType()==Node.ELEMENT_NODE) {
				Element eElement = (Element)nNode;
				
				System.out.println("book category : "+eElement.getAttribute("category"));
				System.out.println("author : "+eElement.getElementsByTagName("author").item(0).getTextContent());
				System.out.println("year : "+eElement.getElementsByTagName("year").item(0).getTextContent());
				System.out.println("price : "+eElement.getElementsByTagName("price").item(0).getTextContent());
				
			}
		}

	}

}
