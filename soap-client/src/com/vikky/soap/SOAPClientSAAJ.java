package com.vikky.soap;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class SOAPClientSAAJ {

	// SAAJ - SOAP Client Testing
	public static void main(String args[]) {
		/*
		 * The example below requests from the Web Service at:
		 * http://www.dneonline.com/calculator.asmx
		 * 
		 * 
		 * To call other WS, change the parameters below, which are: - the SOAP Endpoint
		 * URL (that is, where the service is responding from) - the SOAP Action
		 * 
		 * Also change the contents of the method createSoapEnvelope() in this class. It
		 * constructs the inner part of the SOAP envelope that is actually sent.
		 */
		String soapEndpointUrl = "http://www.dneonline.com/calculator.asmx";
		String soapAction = "http://tempuri.org/Add";

		callSoapWebService(soapEndpointUrl, soapAction);
	}
	
	private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
		try {
			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			// Send SOAP Message to SOAP Server
			SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

			// Print the SOAP Response
			System.out.println("Response SOAP Message:");
			soapResponse.writeTo(System.out);
			System.out.println();

			soapConnection.close();
		} catch (Exception e) {
			System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
			e.printStackTrace();
		}
	}

	private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();

		createSoapEnvelope(soapMessage);

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", soapAction);

		soapMessage.saveChanges();

		/* Print the request message, just for debugging purposes */
		System.out.println("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println("\n");

		return soapMessage;
	}
	
	private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
		SOAPPart soapPart = soapMessage.getSOAPPart();

		// Read WSDL for these 
		String myNamespace = "tem";
		String myNamespaceURI = "http://tempuri.org/";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

		/*
		 * Constructed SOAP Request Message:
		 * 
		 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
   		 * 	<soapenv:Header/>
         * 	<soapenv:Body>
         *  	<tem:Add>
         *			<tem:intA>1</tem:intA>
         *			<tem:intB>8</tem:intB>
      	 *		</tem:Add>
   		 * 	</soapenv:Body>
         * </soapenv:Envelope>
		 * 
		 */

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("Add", myNamespace);
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("intA", myNamespace);
		soapBodyElem1.addTextNode("1");
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("intB", myNamespace);
		soapBodyElem2.addTextNode("8");
	}





}