package com.vikky.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Test {

	private static final Employee PILL = new Employee();
	

	public static void main(String[] args) throws XMLStreamException, IOException {
		long st = System.currentTimeMillis();
		Test t = new Test();
		
		ExecutorService ex = Executors.newFixedThreadPool(5);
		
		BlockingQueue<Employee> q= new LinkedBlockingQueue<>() ;

		Runnable r = ()->{
			try {
				t.parse(q);
			} catch (XMLStreamException | IOException e) {
				e.printStackTrace();
			}
		};

		//new Thread(r).start();
		//System.out.println("Total Loading time  wuth STAX = " + (System.currentTimeMillis()-st)/1000 +" s");

		ex.submit(r);

		Runnable c1 = ()->{

		while(true) {
			try {
				//System.out.println("Taking out - before = "+q.size());
				Employee take = q.take();
				if (PILL == take) {
					break;
				}
				System.out.println(Thread.currentThread().getName() + ":::::::" +take);
				//System.out.println("Taking out - After = "+q.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		};

		
		ex.submit(c1);
		ex.submit(c1);
		ex.submit(c1);

		//new Thread(c1).start();
		//ex.shutdown();
		System.out.println("Total Loading time  wuth STAX = " + (System.currentTimeMillis()-st)/1000 +" s");
	}

	public  void parse(BlockingQueue<Employee> q) throws XMLStreamException, IOException {
		try (FileInputStream fis = new FileInputStream("C:\\\\Users\\\\vikky\\\\Desktop\\\\XML\\\\employees2.xml")) {
			XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
			XMLStreamReader reader = xmlInFact.createXMLStreamReader(fis);
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
						//q = new LinkedBlockingQueue<Employee>();
						break;
					case "Employee":
						e = new Employee();
						e.setId(reader.getAttributeValue(null, "id"));
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
						e.setAge(reader.getText());
						bAge = false;
					}else if(bGender){
						e.setGender(reader.getText());
						bGender = false;
					}else if(bRole){
						e.setRole(reader.getText());
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
					//q = new LinkedBlockingQueue();
					break;
				}

				reader.next();
			}
			reader.close();
			q.put(PILL);
			q.put(PILL);
			q.put(PILL);
			System.out.println(q.size());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
