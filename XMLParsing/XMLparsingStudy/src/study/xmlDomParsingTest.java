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
		//xml문서를 파싱
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		//getDocumentElement().normalize() XML의 최상위 tag 값을 가져옴
		document.getDocumentElement().normalize();
		System.out.println("Root Element : "+ document.getDocumentElement().getNodeName());
		//nList에 tagname이 book인 요소를 삽입
		NodeList nList = document.getElementsByTagName("book");
		System.out.println("nList의 개수 "+ nList.getLength());
		System.out.println("--------------------");
		for(int temp =0; temp<nList.getLength();temp++) {
			//nList의 temp번째 요소를 nNode에 삽입
			Node nNode = nList.item(temp);
			//현재 노드의 이름을 출력
			System.out.println("\nCurrent Element :"+ nNode.getNodeName());
			//nNode의 노드타입이 Node의 타입과 같으면
			if(nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element eElement = (Element) nNode;
				//getAttribute로 요소의 속성을 가져옴
				System.out.println("book category : "+eElement.getAttribute("category"));
				//getElementTagName으로 지정된 태그 이름을 가진 요소의 자식 요소의 컬렉션을 반환
				System.out.println("title : "+eElement.getElementsByTagName("title").item(0).getTextContent());
				System.out.println("author : "+eElement.getElementsByTagName("author").item(0).getTextContent());
				System.out.println("year : "+eElement.getElementsByTagName("year").item(0).getTextContent());
				System.out.println("price : "+eElement.getElementsByTagName("price").item(0).getTextContent());
			}
			
		}
		

	}

}
