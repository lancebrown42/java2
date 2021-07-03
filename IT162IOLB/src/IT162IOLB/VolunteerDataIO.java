package IT162IOLB;
import java.io.*;
import java.io.ObjectOutputStream;

/**
 *  Writes data to a file and reads it back out
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-19
 *
 */
public class VolunteerDataIO{

	/**
	 * @param args
	 * Main method
	 */
	public static void main(String[] args) {
		VolunteerData udtLance = new VolunteerData("Lance", "Brown", "Cincinnati", "OH", "Paddlefest");
		VolunteerData udtJim = new VolunteerData("Jim", "Jones", "Hebron", "KY", "5K");
		VolunteerData udtKaren = new VolunteerData("Karen", "Katz", "Mason", "OH", "Flying Pig");
		VolunteerData udtAnna = new VolunteerData("Anna", "Karenina", "Moscow", "OH", "Red Cross");
		try {
			File foutput = new File("Volunteers.txt");
			foutput.createNewFile();
			FileOutputStream fsOut = new FileOutputStream(foutput);
			ObjectOutputStream osOut = new ObjectOutputStream(fsOut);
			osOut.writeObject(udtLance);
			osOut.writeObject(udtJim);
			osOut.writeObject(udtKaren);
			osOut.writeObject(udtAnna);
			
			
			osOut.close();
			fsOut.close();
			
			FileInputStream fsIn = new FileInputStream(foutput);
			ObjectInputStream osIn = new ObjectInputStream(fsIn);
			
			VolunteerData vol1 = (VolunteerData) osIn.readObject();
			VolunteerData vol2 = (VolunteerData) osIn.readObject();
			VolunteerData vol3 = (VolunteerData) osIn.readObject();
			VolunteerData vol4 = (VolunteerData) osIn.readObject();
			
			osIn.close();
			fsIn.close();
			
			System.out.printf("%-10s %-10s %-12s %-7s %-20s\n", "First Name", "Last Name", "City", "State", "Event");
			System.out.print(vol1);
			System.out.print(vol2);
			System.out.print(vol3);
			System.out.print(vol4);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Contact support.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File could not be written");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}

	}

}
