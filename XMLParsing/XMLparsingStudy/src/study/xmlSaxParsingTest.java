package study;

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
		parser.parse(file, handler);
		
		List<Book> list = handler.getBooklist();
		
		for(Book b : list) {
			System.out.println(b);
			System.out.println();
		}
		
	}

}
