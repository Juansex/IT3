package model;

import java.time.LocalDate;

/** Is the class where creates the costumer.
 * 
*/
public class Customer extends User {

	public Customer(String nickname, String id, LocalDate vinculated) {
		super(nickname, id, vinculated);
	}

}
