package saxparser;

import java.io.File;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class xmlSaxParsingTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File file = new File("sample.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		BookSaxHandler handler = new BookSaxHandler();
		//xml¹®¼­¸¦ saxÆÄ½Ì 
		parser.parse(file, handler);
		
		List<Book> list = handler.getBooklist();
		
		for(Book b : list) {
			
			System.out.println("category: "+b.getCateory());
			System.out.println("title: "+b.getTitle());
			System.out.println("author: "+b.getAuthor());
			System.out.println("year: "+b.getYear());
			System.out.println("price: "+b.getPrice());
			System.out.println("*************************");
			
		
		}
		
	}

}
