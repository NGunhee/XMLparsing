package study;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class BookSaxHandler extends DefaultHandler {
	
	//파싱한 책객체를 넣을 리스트
	private List<Book> booklist;
	//파싱한 책 객체
	private Book book;
	//charcater 메소드에서 저장할 문자열 변수
	private String str;
	
	public BookSaxHandler() {
		booklist = new ArrayList<>();
	}
	
	public void startElement(String uri,String localName, String name, Attributes att) {
		//시작 태그를 만났을 때 발생하는 이벤트
		if(name.equals("book")) {
			book = new Book();
			booklist.add(book);
		}
	}
	
	public void endElement(String uri, String localName, String name) {
		//끝 태그를 만났을 때 발생하는 이벤트
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
		//태그와 태그 사이의 내용을 처리
		str = new String(ch,start,length);
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	
	

}
