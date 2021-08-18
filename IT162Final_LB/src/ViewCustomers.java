import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 */

/**
 * @author lance
 *
 */
public class ViewCustomers {

	/**
	 * Method main
	 * Abstract TODO
	 * @param args
	 */
	 public static void viewCustomers() {
	        String filePath = "customers.xml";
	        File xmlFile = new File(filePath);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();

	            Document doc = dBuilder.parse(xmlFile);

	            doc.getDocumentElement().normalize();

	            NodeList nodeList = doc.getElementsByTagName("Customer");

	            List<Customer> custList = new ArrayList<Customer>();
	            for (int i = 0; i < nodeList.getLength(); i++) {
	            	custList.add(getCustomer(nodeList.item(i)));
	            }
	            for (Customer cust : custList) {
	                System.out.println(cust.toString());
	            }
	        } catch (SAXException | ParserConfigurationException | IOException e1) {
	            e1.printStackTrace();
	        }

	    }


	    private static Customer getCustomer(Node node) {
	        //XMLReaderDOM domReader = new XMLReaderDOM();
	        Customer cust = new Customer();
	        System.out.println(node.getAttributes().getNamedItem("id").getNodeValue().toString());
	        cust.setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue().toString()));
	        
	        if (node.getNodeType() == Node.ELEMENT_NODE) {
	            Element element = (Element) node;
	            cust.setName(getTagValue("name", element));
	            cust.setType(getTagValue("type", element));
	            cust.setAddress(getTagValue("address", element));
	            cust.setCity(getTagValue("city", element));
	            cust.setState(getTagValue("state", element));
	            cust.setZip(getTagValue("zipcode", element));
	        }

	        return cust;
	    }


	    private static String getTagValue(String tag, Element element) {
	        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
	        Node node = (Node) nodeList.item(0);
	        return node.getNodeValue();
	    }

}
