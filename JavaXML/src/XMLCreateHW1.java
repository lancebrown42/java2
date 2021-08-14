/**
 * 
 */
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

/**
 *  Populates xml document with student info
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-07-23
 *
 */
public class XMLCreateHW1 {

	/**
	 * Method main
	 * Abstract main method
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element root = doc.createElementNS("https://www.w3.org/1999/xhtml", "Students");
			
			//root
			doc.appendChild(root);
			//deets
			root.appendChild(getStudent(doc, "1001", "Kevin Damon", "27", "CPDM", "Male"));
			root.appendChild(getStudent(doc, "1002", "Amy Johnson", "30", "CPDM", "Female"));
			root.appendChild(getStudent(doc, "1003", "Liam Mercer", "35", "CPDM", "Male"));
			root.appendChild(getStudent(doc, "1004", "Ashley Carrero", "32", "CPDM", "Female"));
			root.appendChild(getStudent(doc, "1005", "Robbie OBrien", "40", "CPDM", "Male"));
			
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult file = new StreamResult(new File("students.xml"));
			
			trans.transform(source, file);
			System.out.println("File written");
			
			
			
		}catch(Exception e) {
			System.err.println(e.getStackTrace());
		}

	}
	
	/**
	 * Method getStudent
	 * Abstract Creates student element node
	 * @param doc xml document
	 * @param id student id
	 * @param name student name
	 * @param age student age
	 * @param major student major
	 * @param gender student gender
	 * @return student node
	 */
	private static Node getStudent(Document doc, String id, String name, String age, String major, String gender) {
		Element student = doc.createElement("Student");
		student.setAttribute("id", id);
		student.appendChild(getStudentElements(doc, student, "name", name));
		student.appendChild(getStudentElements(doc, student, "age", age));
		student.appendChild(getStudentElements(doc, student, "major", major));
		student.appendChild(getStudentElements(doc, student, "gender", gender));
		
		
		return student;
		
	}
	
	/**
	 * Method getStudentElements
	 * Abstract appends elements to student element
	 * @param doc xml document
	 * @param element student element
	 * @param name element name
	 * @param value element value
	 * @return element node
	 */
	private static Node getStudentElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

}
