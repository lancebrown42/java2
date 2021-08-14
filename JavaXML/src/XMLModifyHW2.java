/**
 * 
 */
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
/**
 *  Alters existing xml document of student info
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-07-13
 *
 */
public class XMLModifyHW2 {

	/**
	 * Method main
	 * Abstract main method
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "students.xml";
		File file = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			updateAttributeValue(doc);
			updateElementValue(doc);
			deleteElement(doc);
			addElement(doc);
			
			doc.getDocumentElement().normalize();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("students_update.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");
			
			
			
		}catch(Exception e) {
			System.err.println(e.getStackTrace());
		}

	}
	/**
	 * Method addElement
	 * Abstract Adds credit element. Chosen because it's another thing that students have.
	 * @param doc xml document
	 */
	private static void addElement(Document doc) {
		NodeList students = doc.getElementsByTagName("Student");
		Element student;
		for(int i = 0; i < students.getLength(); i++) {
			student = (Element) students.item(i);
			Element credits = doc.createElement("credits");
			credits.appendChild(doc.createTextNode((Double.toString(Math.floor(Math.random() * 30)))));
			student.appendChild(credits);
		}
		
	}
	/**
	 * Method deleteElement
	 * Abstract Deletes gender element. Chosen because it's the least important data point
	 * @param doc xml document
	 */
	private static void deleteElement(Document doc) {
        NodeList students = doc.getElementsByTagName("Student");
        Element student = null;
        for(int i=0; i<students.getLength();i++){
            student = (Element) students.item(i);
            Node genderNode = student.getElementsByTagName("gender").item(0);
            student.removeChild(genderNode);
        }
        
    }

    /**
     * Method updateElementValue
     * Abstract changes value in name to all upper case. Chosen because I couldn't think of anything and this is what the class example did
     * @param doc xml document
     */
    private static void updateElementValue(Document doc) {
        NodeList students = doc.getElementsByTagName("Student");
        Element student = null;
        for(int i=0; i<students.getLength();i++){
            student = (Element) students.item(i);
            Node name = student.getElementsByTagName("name").item(0).getFirstChild();
            name.setNodeValue(name.getNodeValue().toUpperCase());
        }
    }

    /**
     * Method updateAttributeValue
     * Abstract updates ID attribute to include gender. Chosen because I couldn't think of anything and this is what the class example did
     * @param doc xml document
     */
    private static void updateAttributeValue(Document doc) {
        NodeList students = doc.getElementsByTagName("Student");
        Element student = null;
        for(int i=0; i<students.getLength();i++){
            student = (Element) students.item(i);
            String gender = student.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
            if(gender.equalsIgnoreCase("male")){
                student.setAttribute("id", "M"+student.getAttribute("id"));
            }else{
                student.setAttribute("id", "F"+student.getAttribute("id"));
            }
        }
    }

}
