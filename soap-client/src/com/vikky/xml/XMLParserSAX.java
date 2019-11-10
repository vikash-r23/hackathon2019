
package com.vikky.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParserSAX {

	private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

	public static void main(String[] args) throws IOException {

		createXml();

		ExecutorService ex = Executors.newFixedThreadPool(AVAILABLE_PROCESSORS);

		BlockingQueue<Employee> q = new LinkedBlockingQueue<>();

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {

			System.out.println("Started================");
			long s = System.currentTimeMillis();

			SAXParser saxParser = saxParserFactory.newSAXParser();
			MyHandler handler = new MyHandler(q);
			saxParser.parse(new File("C:\\Users\\vikky\\Desktop\\XML\\employees2.xml"), handler);
			for (int i = 0; i < AVAILABLE_PROCESSORS; i++) {
				ex.submit(new Consumer(q));
			}
			ex.shutdown();
			try {
			  ex.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Get Employees list
			//List<Employee> empList = handler.getEmpList();
			// print employee information
			System.out.println("Size = " + q.size());
			System.out.println("Ended================");
			//for (Employee e : empList) {
				//System.out.println(e);
			//}
			

			System.out.println("Time taken = " + (System.currentTimeMillis() - s)/100 + "    Secs");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void createXml() throws IOException {
		String fileContent = "<Employee id=\"%d\"><age>age-%d</age><name>name-%d</name><gender>Male</gender><role>Developer</role></Employee>";

		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\vikky\\Desktop\\XML\\employees2.xml"));
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Employees>");
		for (int i = 0; i < 5; i++) {
			writer.write(String.format(fileContent, i, i, i));
		}
		writer.write("</Employees>");
		writer.close();
	}
}

class Consumer implements Runnable{

	BlockingQueue<Employee> queue;
	
	public Consumer(BlockingQueue<Employee> q) {
		this.queue = q;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				//System.out.println("VIkash Take======================================================== size" + queue.size());
				Employee take = queue.take();
				process(take);
				if (queue.size() ==0) {
					break;
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	private void process(Employee take) {
		System.out.println(take);

	}
}

