package model;

import java.time.LocalDate;

/**Shows the standart user
 *@param categorie 
*/
public class StandarUser extends Customer {
	
	private String categorie;

	public StandarUser(String nickname, String id, LocalDate vinculated) {
		super(nickname, id, vinculated);
	}

	@Override
	public String toString() {
		return "categorie " + categorie +  "User (nickname" + getNickname() + " id" + getId() + " vinculated" + getVinculated() + ")";
	}

	

}
