package ui;

import java.util.Scanner;
import model.Controller;


public class NeoTunnes {
	private Scanner sc;
	private  Controller controller;

	/**Is the main class
	*/
	public static void main(String[] args) {
		
		System.out.println( "Welcome to NEOTUNES");
		
		NeoTunnes neotunnes = new NeoTunnes();
		
		int option = 0;

		do {
			option = neotunnes.showMenu();
			neotunnes.executeOperation(option);

		} while (option != 0);

	}
	
	/**Is the the neotunes class
	 * 
	*/
	public NeoTunnes() {
		sc= new Scanner(System.in);
		controller = new Controller();
	}
	
	public int showMenu() {
		
		int option = 0;
		
		System.out.println("Choose an option\n" 
				+ "1. Create a user \n"
				+ "2. Select a user \n"				
				+ "3. To exit" 
				+ "\n");
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
		
	}
	/**Executes the option that the user have chosen.
	 * 
	*/
	public void executeOperation(int operation) {

		switch (operation) {
		case 1:
			registerUser();   
			break;
		case 2:
			selectUser();
			break;
		case 3: 
			System.out.println("Thank you for choosing NEOTUNES");
			break;
		

		default:
			System.out.println("Type a valid option");

		}

	}
	
	/**Choose the type of user.
	 * 
	*/
	private void selectUser() {
		
		System.out.println("select an user\n"
				+"1. Producer\n"
				+"2. Coustomer\n");
		
		String optionTemp1 = sc.nextLine();
		
		int option2 = Integer.parseInt(optionTemp1);
		
		if (option2 == 1 ) {
			
			
			System.out.println("select an option\n"
					+"1. Store \n"
					+"2. list of song / podcasts buyed \n"
					+"3. Create a playlist \n"
					+"4. Share playlist \n"
					+"5. Reproduce playlist \n");
			
			String optionTemp = sc.nextLine();
			
			int option = Integer.parseInt(optionTemp);
			
			
			switch(option) {
			case 1:
				buySong();
				break;
			case 2:
				info();
				break;
			case 3:
				createPlaylist();
				break;
			case 4:
				sharePlaylist();
				break;
			case 5:
				reproducePlaylist();
				break;
			
			}
			
		}
		
		else if(option2 == 2 ) {
			
			
			
		System.out.println("Choose an option\n"
							+"1. register song\n"
							+"2. Register Podcast\n");
		String optionTemp = sc.nextLine();
		
		int option = Integer.parseInt(optionTemp);
		
		switch (option) {
		case 1:
			registerSong();
			break;
		case 2:
			registerPodcast();
			break;
		} 
		
		}else {
			String msg = "Choose a valid option ";
			System.out.println(msg);
			
		}
		
		
		
		
	}

	

	/**Shows the information about the NEOTUNES (Songs registered, podcasts, user type, songs buyed) 
	 */
	private void info() {
		
		
	}
	/**
	 * register podcast
	 */
	private void registerPodcast() {
		
		
		
	}
	/**
	  * register buyed songs 
	  */
	private void buySong() {
		
		
	}
	/**Simulated the reproduction of the song
	 */
	private void reproducePlaylist() {
		
		
	}
	/**Give the option to share 
	 */
	private void sharePlaylist() {
		
		
	}
	/**Create playlist
	 */
	private void createPlaylist() {
		
		
	}
	/**Register songs (name, album, duration, solds, urlPicture)
	 */
	private void registerSong() {
		
		
		System.out.println("What is the name");
		String name = sc.nextLine();
		System.out.println("What is the Album");
		String album = sc.nextLine();
		sc.nextLine();
		String durationtemp = sc.nextLine();
		int duration = Integer.parseInt(durationtemp);
		System.out.println("Price");
		String pricetemp = sc.nextLine();
		int price = Integer.parseInt(pricetemp);
		System.out.println("paste the url of picture");
		String url = sc.nextLine();
		
		controller.registersong(name, album, duration, price, url);
		
	}
	/**	Register user type 
	 */
	private void registerUser() {
		
		System.out.println("Choose the type of user to be registered\n"
							+"1. Premium\n"
							+"2. Standart\n"
							+"3. Artist\n"
							+"4. Content Creator\n");
		
		String optiontemp = sc.nextLine();
		int option = Integer.parseInt(optiontemp);
		
		switch(option) {
		case 1:
			registerPremiumUser();
			break;
		case 2:
			registerStandartUser();
			break;
		case 3:
			registerArtistUser();
			break;
		case 4: 
			registerCCUser();
			break;
		}
		
		
		
	}
	/**Register content creator
	 */

	private void registerCCUser() {
		
		System.out.println("What is the NickName?");
		String nickName = sc.nextLine();
		System.out.println("Write the id");
		String id = sc.nextLine();
		
		if (controller.registerCC(nickName, id, null)) {
			
			System.out.println("Registered succesfully");
		} else {
			System.out.println("Something went wrong");
		}
	}
	/**Register artist
	 */
	private void registerArtistUser() {
		
		System.out.println("Write artist NickName");
		String nickName = sc.nextLine();
		System.out.println("Write the id");
		String id = sc.nextLine();
		
		if (controller.registerArtist(nickName, id, null)) {
			
			System.out.println("Registered succesfuly");
		} else {
			System.out.println("Something went wrong");
		}
	}
	/**Register standart user
	 */
	private void registerStandartUser() {
		
		System.out.println("Write the NickName?");
		
		String nickName = sc.nextLine();
		
		System.out.println("Write the id");
		
		String id = sc.nextLine();
		
		if (controller.registerStandar(nickName, id, null)) {
			
			System.out.println("Registered succesfuly");
		} else {
			System.out.println("Something went wrong");
		}
		
	}
	
	
	/**Register the premium user
	 */

	private void registerPremiumUser() {
		
		System.out.println("Write the NickName");
		String nickName = sc.nextLine();
		System.out.println("Write the id");
		String id = sc.nextLine();
		
		if (controller.registerPremiumUser(nickName, id, null)) {
			
			System.out.println("Registered succesfuly");
		} else {
			System.out.println("Something went wrong");
		}


		
	}

}


