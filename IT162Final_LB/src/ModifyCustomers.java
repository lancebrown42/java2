import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 
 */

/**
 * @author lance
 *
 */
public class ModifyCustomers {
	public static void modifyCustomers() {
		String path = "customers.xml";
		File file = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			addElement(doc);
			
			doc.getDocumentElement().normalize();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("customer_modified.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");
			
			
			
		}catch(Exception e) {
			System.err.println(e);
			System.err.println(e.getStackTrace());
		}

	}
	/**
	 * Method addElement
	 * Abstract 
	 * @param doc xml document
	 */
	private static void addElement(Document doc) {
		NodeList customers = doc.getElementsByTagName("Customer");
		Element customer;
		for(int i = 0; i < customers.getLength(); i++) {
			customer = (Element) customers.item(i);
			Element phone = doc.createElement("phone");
			phone.appendChild(doc.createTextNode(generatePhone()));
			customer.appendChild(phone);
			Element contact = doc.createElement("contact");
			contact.appendChild(doc.createTextNode(generateContact()));
			customer.appendChild(contact);
			Element email = doc.createElement("email");
			email.appendChild(doc.createTextNode(generateEmail()));
			customer.appendChild(email);
		}
		
	}
	private static String generatePhone() {
		//random phone number generator
		String phone;
		int area1, area2, area3;
		int exchange, line;
		Random rng = new Random();
		area1 = rng.nextInt(7)+1;
		area2 = rng.nextInt(8);
		area3 = rng.nextInt(8);
		exchange = rng.nextInt(643)+100;
		line = rng.nextInt(8999)+1000;
		phone = String.format("%d%d%d-%d-%d", area1, area2, area3, exchange, line);
		return phone;
	}
	private static String generateContact() {
		//random name selector. Names generated on mockaroo.com
		String contact;
		String[] names = {"Joannes Greatbach", "Kori Cardall", "Merrili Woolis", "Marcelia Armistead", "Kylen Pedracci", "Mickey Luetkemeyers", "Sheffy Martello", "Cordey Ferrari", "Sig Vickar", "Correy Huttley", "Bondy Halburton", "Beilul Copner", "Barny Ounsworth", "Jeremie Afonso", "D'arcy Sesser", "Helaina Musterd", "Alexandros Edgerton", "Catlin Harbisher", "Merrill Eliasen", "Jone Kimmitt"};
		Random rng = new Random();
		contact = names[rng.nextInt(names.length-1)];
		return contact;
	}
	private static String generateEmail() {
		//random email generator.
		String email;
		String saltchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rng = new Random();
		while(salt.length()<10) {
			int i = rng.nextInt(saltchar.length()-1);
			salt.append(saltchar.charAt(i));
		}
		email = salt.toString() + "@gmail.com";
		return email;
	}
}
