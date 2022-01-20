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

public class Test {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File file = new File("sample.xml");
		//xml ������ �Ľ�
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		
		//������ ��Ҹ� ����
		document.getDocumentElement().normalize();
		System.out.println("root element : "+document.getDocumentElement().getNodeName());
		
		//nodelist�� �±��̸��� book�� ��ҵ��� ����
		NodeList nList =document.getElementsByTagName("book");
		System.out.println("-----------");
		
		for(int temp=0;temp<nList.getLength();temp++) {
			//node�� nlist�� temp��° ��һ���
			Node node = nList.item(temp);
			//���� ����� �̸��� ���
			System.out.println("Current Element : "+node.getNodeName());
			if (node.getNodeType()==node.ELEMENT_NODE){
				//nList�� element�� ����ȯ(�ٿ�ĳ����)
				Element element = (Element)node;
				//getAttribute�� element�� �Ӽ��� ������
				System.out.println("book category : "+element.getAttribute("category"));
				//����� tagname���� ��Ҹ� �����ͼ� getTextContent�� �о��
				System.out.println("title : "+element.getElementsByTagName("title").item(0).getTextContent());
				System.out.println("author : "+element.getElementsByTagName("author").item(0).getTextContent());
				System.out.println("year : "+element.getElementsByTagName("year").item(0).getTextContent());
				System.out.println("price : "+element.getElementsByTagName("price").item(0).getTextContent());
				
				
				
			}
			
			
		}
		
	}

}
