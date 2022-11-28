package model;

	/**Is the class that shows the registration of the podcast.
	 * @param description is the description about the podcast.
	 * @param category is the category where is the podcast.
	*/

public class Podcast  extends Audio{

	private String description;
	private PodcastCategory category;
	
	public Podcast(String name, String album, double duration, double solds, String urlPicture, int type, String descrption) {
		super(name, album, duration, solds, urlPicture);
		
		this.description = descrption;
		
		switch(type) {
		
		case 1:
			category = PodcastCategory.ENTERTAINMENT;
			break;
		case 2: 
			category = PodcastCategory.FASHION;
			break;
		case 3:
			category = PodcastCategory.GAME;
			break;
		case 4: 
			category = PodcastCategory.POLITCS;
			break;
		}
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrption) {
		this.description = descrption;
	}

	public PodcastCategory getCategory() {
		return category;
	}

	public void setCategory(PodcastCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Podcast (description" + description + " category" + category + ")";
	}

	

	

	
	
}
