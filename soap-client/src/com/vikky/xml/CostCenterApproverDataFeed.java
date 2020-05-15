package com.vikky.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CostCenterApproverDataFeed {
	
	private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
	
	
	public static void main(String[] args) {
		
		long st = System.currentTimeMillis();
		
		BlockingQueue<Employee> q = new LinkedBlockingQueue<Employee>();
		XMLManager.load(new EmployeeProcessor() {
			@Override
			public void process(Employee employee) {
				try {
					q.put(employee);
					//System.out.println("After putting = " + q.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println(q.size());
		System.out.println("Total Loading time with SAX = " + (System.currentTimeMillis()-st)/1000 +" s");
	}
	
}




interface EmployeeProcessor {
    void process(Employee employee);
}

class XMLManager {

    public static void load(EmployeeProcessor processor) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser parser = factory.newSAXParser();
            File file = new File("C:\\Users\\vikky\\Desktop\\XML\\employees1.xml");
            EmployeeHandler pageHandler = new EmployeeHandler(processor);

            parser.parse(file, pageHandler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class EmployeeHandler extends DefaultHandler {

	// List to hold Employees object
	private List<Employee> empList = null;
	private Employee emp = null;
	private StringBuilder data = null;
	private final EmployeeProcessor processor;
	
	public EmployeeHandler(EmployeeProcessor processor) {
		 this.processor = processor;
	}

	// getter method for employee list
	public List<Employee> getEmpList() {
		return empList;
	}

	boolean bAge = false;
	boolean bName = false;
	boolean bGender = false;
	boolean bRole = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Employee")) {
			// create a new Employee and put it in Map
			String id = attributes.getValue("id");
			// initialize Employee object and set id attribute
			emp = new Employee();
			emp.setId(id);
		} else if (qName.equalsIgnoreCase("name")) {
			// set boolean values for fields, will be used in setting Employee variables
			bName = true;
		} else if (qName.equalsIgnoreCase("age")) {
			bAge = true;
		} else if (qName.equalsIgnoreCase("gender")) {
			bGender = true;
		} else if (qName.equalsIgnoreCase("role")) {
			bRole = true;
		}
		// create the data container
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bAge) {
			// age element, set Employee age
			emp.setAge(data.toString());
			bAge = false;
		} else if (bName) {
			emp.setName(data.toString());
			bName = false;
		} else if (bRole) {
			emp.setRole(data.toString());
			bRole = false;
		} else if (bGender) {
			emp.setGender(data.toString());
			bGender = false;
		}
		
		if (qName.equalsIgnoreCase("Employee")) {
			processor.process(emp);
		}else {
			//emp=null;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}
