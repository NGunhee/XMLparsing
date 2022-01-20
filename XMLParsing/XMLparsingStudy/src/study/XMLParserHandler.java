package study;

import java.util.ArrayList;

import org.xml.sax.Attributes;

public class XMLParserHandler {
	
	private String elementName="";
	private StringBuffer sBufffer = new StringBuffer();
	private ArrayList<String> tagList = new ArrayList<String>();
	
	//xml 문서의 시작이 인식되었을 때 발생하는 이벤트를 처리
	public void startDocument() {
		System.out.println("log: Start Document");
	}
	
	//xml 문서의 끝이 인식되었을 때 발생하는 이벤트를 처리
	public void endDocument() {
		System.out.println("log: End Document");
	}
	//엘리먼트의 시작을 인식했을때 발생하는 이벤트를 처리
	public void startElement(String uri , String localName, String qname, Attributes attr) {
		elementName = qname; //element 명을 멤버 변수에 넣어준다
		int attrCount = attr.getLength(); //태그 개수
		String attrName = attr.getQName(0); //첫번째 태그 임의 설정
		String attrValue = attr.getValue(attrName);
		System.out.println("속성값=========="+attrName+"=="+attrValue);
		
		sBufffer.setLength(0);
	}
	//엘리먼트의 끝을 인식했었을 때 발생하는 이벤트를 처리
	public void endElement(String uri, String localName, String qname) {
		System.out.println("End element, Name: "+qname);
	}
	

}
