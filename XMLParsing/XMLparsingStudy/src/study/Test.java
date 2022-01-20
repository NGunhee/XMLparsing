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
		//xml 문서를 파싱
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		
		//맨위의 요소를 지정
		document.getDocumentElement().normalize();
		System.out.println("root element : "+document.getDocumentElement().getNodeName());
		
		//nodelist에 태그이름이 book인 요소들을 삽입
		NodeList nList =document.getElementsByTagName("book");
		System.out.println("-----------");
		
		for(int temp=0;temp<nList.getLength();temp++) {
			//node에 nlist의 temp번째 요소삽입
			Node node = nList.item(temp);
			//현재 노드의 이름을 출력
			System.out.println("Current Element : "+node.getNodeName());
			if (node.getNodeType()==node.ELEMENT_NODE){
				//nList를 element로 형변환(다운캐스팅)
				Element element = (Element)node;
				//getAttribute로 element의 속성을 가져옴
				System.out.println("book category : "+element.getAttribute("category"));
				//요소의 tagname으로 요소를 가져와서 getTextContent로 읽어옴
				System.out.println("title : "+element.getElementsByTagName("title").item(0).getTextContent());
				System.out.println("author : "+element.getElementsByTagName("author").item(0).getTextContent());
				System.out.println("year : "+element.getElementsByTagName("year").item(0).getTextContent());
				System.out.println("price : "+element.getElementsByTagName("price").item(0).getTextContent());
				
				
				
			}
			
			
		}
		
	}

}
