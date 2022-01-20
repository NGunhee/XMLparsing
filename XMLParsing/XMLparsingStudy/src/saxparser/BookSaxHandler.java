package saxparser;

import java.util.ArrayList;


import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//sax�� defaultHandler�� ��ӹ޾� �޼������ �������̵�
public class BookSaxHandler extends DefaultHandler {
	
	//�Ľ��� å��ü�� ���� ����Ʈ
	private List<Book> booklist;
	//�Ľ��� å ��ü
	private Book book;
	//charcater �޼ҵ忡�� ������ ���ڿ� ����
	private String str;
	
	public BookSaxHandler() {
		booklist = new ArrayList<>();
	}
	

	//���� �±׸� ������ �� �߻��ϴ� �̺�Ʈ
	public void startElement(String uri,String localName, String name, Attributes att) {
		
		if(name.equals("book")) {
			
			book = new Book();
			booklist.add(book);
			
			//category�� attName�� ����
			String attName=att.getQName(0);
			//category���� ������ attValue�� ����
			String attValue=att.getValue(attName);
			book.setCateory(attValue);
			
		
			
		}
	}
	
	//�� �±׸� ������ �� �߻��ϴ� �̺�Ʈ
	public void endElement(String uri, String localName, String name) {
		
	
		if(name.equals("title")) {
			book.setTitle(str);
		}
		else if(name.equals("author")) {
			book.setAuthor(str);
		}
		else if(name.equals("year")) {
			book.setYear(Integer.parseInt(str));
		}
		else if(name.equals("price")) {
			book.setPrice(Double.parseDouble(str));
		}
	}
	public void characters(char[] ch , int start , int length) {
		//�±׿� �±� ������ ������ ó��
		str = new String(ch,start,length);
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	
	

}
