package jdom;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
public class JdomTest {

	public static void main(String[] args) throws  IOException, JDOMException {
		
		File file = new File("sample.txt");
		FileInputStream input = new FileInputStream(file);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(input);
		
		//∑Á∆Æ
		Element xmlRoot = doc.getRootElement();
		
		//child
		List l_list = xmlRoot.getChildren();
		Element e_list = (Element) l_list.get(0);
		
		List l_basic=e_list.getChildren();
		
		for(int i=0;i<l_basic.size();i++) {
			Element e_basic = (Element)l_basic.get(i);
			System.out.println(e_basic.getName());
			System.out.println(e_basic.getText());
		}

	}

}
