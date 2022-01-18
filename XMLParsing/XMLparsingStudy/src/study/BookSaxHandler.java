package study;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

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
	
	public void startElement(String uri,String localName, String name, Attributes att) {
		//���� �±׸� ������ �� �߻��ϴ� �̺�Ʈ
		if(name.equals("book")) {
			book = new Book();
			booklist.add(book);
		}
	}
	
	public void endElement(String uri, String localName, String name) {
		//�� �±׸� ������ �� �߻��ϴ� �̺�Ʈ
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
