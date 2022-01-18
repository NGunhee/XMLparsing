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

public class xmlDomParsingTest {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		File file = new File("sample.xml");
		//xml������ �Ľ�
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		//getDocumentElement().normalize() XML�� �ֻ��� tag ���� ������
		document.getDocumentElement().normalize();
		System.out.println("Root Element : "+ document.getDocumentElement().getNodeName());
		//nList�� tagname�� book�� ��Ҹ� ����
		NodeList nList = document.getElementsByTagName("book");
		System.out.println("nList�� ���� "+ nList.getLength());
		System.out.println("--------------------");
		for(int temp =0; temp<nList.getLength();temp++) {
			//nList�� temp��° ��Ҹ� nNode�� ����
			Node nNode = nList.item(temp);
			//���� ����� �̸��� ���
			System.out.println("\nCurrent Element :"+ nNode.getNodeName());
			//nNode�� ���Ÿ���� Node�� Ÿ�԰� ������
			if(nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element eElement = (Element) nNode;
				//getAttribute�� ����� �Ӽ��� ������
				System.out.println("book category : "+eElement.getAttribute("category"));
				//getElementTagName���� ������ �±� �̸��� ���� ����� �ڽ� ����� �÷����� ��ȯ
				System.out.println("title : "+eElement.getElementsByTagName("title").item(0).getTextContent());
				System.out.println("author : "+eElement.getElementsByTagName("author").item(0).getTextContent());
				System.out.println("year : "+eElement.getElementsByTagName("year").item(0).getTextContent());
				System.out.println("price : "+eElement.getElementsByTagName("price").item(0).getTextContent());
			}
			
		}
		

	}

}
