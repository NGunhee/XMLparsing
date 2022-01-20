package study;

import java.util.ArrayList;

import org.xml.sax.Attributes;

public class XMLParserHandler {
	
	private String elementName="";
	private StringBuffer sBufffer = new StringBuffer();
	private ArrayList<String> tagList = new ArrayList<String>();
	
	//xml ������ ������ �νĵǾ��� �� �߻��ϴ� �̺�Ʈ�� ó��
	public void startDocument() {
		System.out.println("log: Start Document");
	}
	
	//xml ������ ���� �νĵǾ��� �� �߻��ϴ� �̺�Ʈ�� ó��
	public void endDocument() {
		System.out.println("log: End Document");
	}
	//������Ʈ�� ������ �ν������� �߻��ϴ� �̺�Ʈ�� ó��
	public void startElement(String uri , String localName, String qname, Attributes attr) {
		elementName = qname; //element ���� ��� ������ �־��ش�
		int attrCount = attr.getLength(); //�±� ����
		String attrName = attr.getQName(0); //ù��° �±� ���� ����
		String attrValue = attr.getValue(attrName);
		System.out.println("�Ӽ���=========="+attrName+"=="+attrValue);
		
		sBufffer.setLength(0);
	}
	//������Ʈ�� ���� �ν��߾��� �� �߻��ϴ� �̺�Ʈ�� ó��
	public void endElement(String uri, String localName, String qname) {
		System.out.println("End element, Name: "+qname);
	}
	

}
