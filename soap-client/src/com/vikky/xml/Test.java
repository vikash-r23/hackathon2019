package com.vikky.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Test {

	public static void main(String[] args) throws XMLStreamException, IOException {
		long st = System.currentTimeMillis();
		parse();
		System.out.println("Total Loading time  wuth STAX = " + (System.currentTimeMillis()-st)/1000 +" s");
	}

	public static void parse() throws XMLStreamException, IOException {
		try (FileInputStream fis = new FileInputStream("C:\\\\Users\\\\vikky\\\\Desktop\\\\XML\\\\employees1.xml")) {
			XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
			XMLStreamReader reader = xmlInFact.createXMLStreamReader(fis);
			BlockingQueue<Employee> q = null ;//
			Employee e = null;
			boolean bAge = false;
			boolean bName = false;
			boolean bGender = false;
			boolean bRole = false;
			StringBuilder text = new StringBuilder();
			while (reader.hasNext()) {
				switch (reader.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					switch(elementName){
					case "Employees":
						q = new LinkedBlockingQueue<Employee>();
						break;
					case "Employee":
						e = new Employee();
						break;
					case "name":
						bName = true;
						break;
					case "age":
						bAge = true;
						break;
					case "gender":
						bGender = true;
						break;
					case "role":
						bRole = true;
						break;
					default:
						break;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					if(bName){
						e.setName(reader.getText());
						bName = false;
					}
					else if(bAge){
						e.setAge(reader.toString());
						bAge = false;
					}else if(bGender){
						e.setGender(reader.toString());
						bGender = false;
					}else if(bRole){
						e.setRole(reader.toString());
						bAge = false;
					}
					if(reader.hasText())
						text.append(reader.getText());
					break;
				case XMLStreamConstants.END_ELEMENT:
					elementName = reader.getLocalName();
					if(elementName.equals("Employee"))
						try {
							q.put(e);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					break;

				case XMLStreamConstants.START_DOCUMENT:
					q = new LinkedBlockingQueue();
					break;
				}

				reader.next();
			}
			reader.close();
			System.out.println(q.size());
		}
	}
}

