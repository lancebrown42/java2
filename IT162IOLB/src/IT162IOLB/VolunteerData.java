package IT162IOLB; 
import java.io.*;

/**
 *  Interface for Volunteer DTO
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-19
 *
 */
public class VolunteerData implements Serializable {
	/**
	 * I don't know what this is, but Eclipse made me do it.
	 */
	private static final long serialVersionUID = 1L;
	private String FirstName = "";
	private String LastName = "";
	private String City = "";
	private String State = "";
	private String Event="";
	/**
	 * Initializes object
	 * @param firstName
	 * @param lastName
	 * @param city
	 * @param state
	 * @param event
	 */
	public void Initialize(String firstName, String lastName, String city, String state, String event) {
		SetFirstName(firstName);
		SetLastName(lastName);
		SetCity(city);
		SetState(state);
		SetEvent(event);
	}
	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param city
	 * @param state
	 * @param event
	 */
	public VolunteerData(String firstName, String lastName, String city, String state, String event) {
		Initialize(firstName, lastName, city, state, event);
	}
	/**
	 * @param firstName
	 */
	public void SetFirstName(String firstName) {
		this.FirstName = firstName;
	}
	/**
	 * @return FirstName
	 */
	public String GetFirstName() {
		return FirstName;
	}
	/**
	 * @param lastName
	 */
	public void SetLastName(String lastName) {
		this.LastName = lastName;
	}
	/**
	 * @return LastName
	 */
	public String GetLastName() {
		return LastName;
	}
	/**
	 * @param city
	 */
	public void SetCity(String city) {
		this.City = city;
	}
	/**
	 * @return City
	 */
	public String GetCity() {
		return City;
	}
	/**
	 * @param state
	 */
	public void SetState(String state) {
		this.State = state;
	}
	/**
	 * @return State
	 */
	public String GetState() {
		return State;
	}
	/**
	 * @param event
	 */
	public void SetEvent(String event) {
		this.Event = event;
	}
	/**
	 * @return Event
	 */
	public String GetEvent() {
		return Event;
	}
	/**
	 * 
	 * Overrides toString() for print formatting
	 */
	public String toString() {
		return String.format("%-10s %-10s %-12s %-7s %-20s\n", FirstName, LastName, City, State, Event);
	}

}
