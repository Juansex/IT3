package model;

import java.time.LocalDate;

/** This class register the user
 * @param nickname nickname of the user.
 * @param id is the identification of the user.
 * @param vinculated is the the user is enrolled to the NEOTUNES.
*/

public abstract class User {
	private String nickname;
	private String id;
	protected static LocalDate vinculated;
	public User(String nickname, String id, LocalDate vinculated) {
		
		this.nickname = nickname;
		this.id = id;
		User.vinculated = vinculated;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getVinculated() {
		return vinculated;
	}
	public void setVinculated(LocalDate vinculated) {
		User.vinculated = vinculated;
	}
	
	@Override
	public String toString() {
		return "User nickname " + nickname + ", id" + id + ", vinculated " + vinculated + ".";
	}

	
}
