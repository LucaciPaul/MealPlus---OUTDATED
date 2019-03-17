package lucacipaul.mealplus;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DataManager {

	private static DataManager instance = null;

	private static User loggedUser = null;
	
	private DataManager() {	}

	public static DataManager getInstance() {
		if(instance == null) {
			instance = new DataManager();
		}
		return instance;
	}

	/**
	 * 
	 * @param email
	 */
	public ArrayList<User> searchAccount(String email) {
		ArrayList<User> users = new ArrayList<User>();
		
		for (User usr : Dummy.customers) {
			if(usr.getEmail().contains(email))
					users.add(usr);
		}
		for (User usr : Dummy.advisers) {
			if(usr.getEmail().contains(email))
					users.add(usr);
		}
		for (User usr : Dummy.admins) {
			if(usr.getEmail().contains(email))
					users.add(usr);
		}
		return users;
	}

	/**
	 * 
	 * @param token
	 * @param amenities
	 * @param types
	 * @param sellpoints
	 * @param searchFrequentlyEaten
	 * @param searchSelfMade
	 * @param recommend
	 */
	public ArrayList<DietLogEntry> searchItems(
			String token,
			ArrayList<Amenities> amenities, ArrayList<Types> types, ArrayList<Sellpoints> sellpoints,
			boolean searchFrequentlyEaten, boolean searchSelfMade, boolean recommend)
	{	
		ArrayList<DietLogEntry> yield = new ArrayList<DietLogEntry>();
		if(loggedUser != null) {
			if(loggedUser instanceof Customer) {
				if(searchSelfMade && !searchFrequentlyEaten) {
					ArrayList<Food> customerOwnedFood = ((Customer) loggedUser).getOwnedFood();
					ArrayList<Recipe> customerOwnedRecipe = ((Customer) loggedUser).getOwnedRecipes();
					if(!customerOwnedFood.isEmpty()) {
						
					}
					if(!customerOwnedRecipe.isEmpty()) {
						
					}
					
				} else if(!searchSelfMade && searchFrequentlyEaten) {
					ArrayList<DietLogEntry> customerFreqEaten = ((Customer) loggedUser).getFrequentlyEaten();
					if(!customerFreqEaten.isEmpty()) {
						
					}
					
				} else {
					ArrayList<DietLogEntry> customerFreqEaten = ((Customer) loggedUser).getFrequentlyEaten();
					if(!customerFreqEaten.isEmpty()) {
						ArrayList<Food> customerOwnedFood = ((Customer) loggedUser).getOwnedFood();
						ArrayList<Recipe> customerOwnedRecipe = ((Customer) loggedUser).getOwnedRecipes();
						
						for(DietLogEntry dietLogEntry : ((Customer) loggedUser).getFrequentlyEaten()) {
							if(!customerOwnedFood.isEmpty()) {
								
							}
							if(!customerOwnedRecipe.isEmpty()) {
								
							}
							if(customerOwnedFood.isEmpty() &&
									customerOwnedRecipe.isEmpty()) {
								// from frequently eaten only.
							}
						}
					}
				}
			}
			if(!searchFrequentlyEaten && !searchSelfMade) {
				//Dummy.foods;
				//Dummy.recipes;
			}
		}
		
		if(yield.isEmpty()) {
			return null;
		}
		return yield;
		
		// types, amenities, sellpoints got to be instanceof ArrayList<..>();
		// searchFrequentlyEaten of which Customer? Where to find that Customer?
		// recommend based on whose nutritional values?
		// search by @param token
	}

	/**
	 * 
	 * @param dietLog
	 * @param toggle
	 */
	public void toggleDietLog(DietLog dietLog, boolean toggle) {
		dietLog.setClosed(toggle);
	}

	/**
	 * 
	 * @param dietLog
	 */
	public Report generateReport(DietLog dietLog) {
		Report report = new Report();
		dietLog.setClosed(true);
		report.setDietLog(dietLog);
		
		// compute nutritional values - yet corrupt
		
		return report;
	}

	/**
	 * 
	 * @param email
	 * @param pwd
	 */
	public User login(String email, String pwd) { // works

		// No need to sanitise parameters, as if they do not
		// match then it will just return false.
		ArrayList<User> users = searchAccount(email);
		if(users.size() == 1 && users.get(0).getEmail().equalsIgnoreCase(email)) {
			User usr = users.get(0);
			if(usr.getPwd().equals(hashPassword(usr, pwd))) { // Critical bug fixed here, make sure to have { } @Paul.
				loggedUser = usr;
				return usr;
			}
		}
		// Email was not found in the users array.
		return null;
	}

	/**
	 * 
	 * @param user
	 */
	public boolean register(User user) {

		// Sanity checks for user inputted data.
		if(user == null) return false;
		if(!user.getEmail().contains("@") || !sanityCheckInputField(user.getEmail(), false)) return false;
		if(!sanityCheckInputField(user.getFirstName(), false) || !sanityCheckInputField(user.getLastName(), false)) return false;
		if(!sanityCheckInputField(user.getPwd(), true)) return false;

		// Sanity checks to make sure the email
		// does not exist.
		ArrayList<User> users = searchAccount(user.getEmail());
		for(User u:users)
			System.out.println(u.getEmail());
		if(!users.isEmpty()) {
			return false;
		}

		if(user instanceof Customer) return Dummy.customers.add((Customer) user); // corrupt due to unvalid downcasting
		if(user instanceof Adviser) return Dummy.advisers.add((Adviser) user);
		return false;
	}

	/**
	 * 
	 * @param email
	 * @param approved
	 */
	public ArrayList<Adviser> searchAdviserAccounts(String email, boolean approved) {
		ArrayList<Adviser> advisers = new ArrayList<Adviser>();
		
		for(Adviser adviser : advisers){
			if(adviser.getApproved() == approved) {
				if(adviser.getEmail().contains(email)) {
					advisers.add(adviser);
				}
			}
		}
		
		return advisers;
	}

	/**
	 * 
	 * @param token
	 * @param isPublic
	 */
	public ArrayList<Items> searchUnpublishedItems(String token, boolean isPublic) {
		ArrayList<Items> items = new ArrayList<Items>();
		
		for(Items item : items){
			if(item.isPublic() == isPublic) {
				// search token here - yet corrupt
			}
		}
		
		return items;
	}

	/**
	 * 
	 * @param dietLog
	 */
	public void removeReport(DietLog dietLog) {
		// TODO - implement DataManager.removeReport
		throw new UnsupportedOperationException();
	}

	public String hashPassword(User user, String password) {
		// SHA-256 is virtually uncrackable, however due to it's
		// relatively fast computation times it's not ideal to store passwords with,
		// as rainbow table attacks could easily "crack" common password.
		// To combat this we will be using salt to encrypt the password.
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// If we cannot use SHA-256 then crash the program,
			// as we cannot run without having this critical function.
			throw new RuntimeException("SHA-256 algorithm is required, however was not found.");
		}

		// Salt password in order to protect it from rainbow table attacks.
		String saltedPassword = user.getLastName() + password + user.getLastName() + user.getRegistrationDate().toString();
		byte[] hashedBytes = md.digest(saltedPassword.getBytes(StandardCharsets.UTF_8)); // Charset.forName("UTF_8") - does not actually work. " java.nio.charset.UnsupportedCharsetException: UTF_8"

		// Convert hash bytes back to a string, as User contains
		// a string, and return it.
		return new String(hashedBytes, StandardCharsets.UTF_8);
	}

	private static boolean sanityCheckInputField(String input, boolean password) {
		if(input == null ||
		   input.length() <= (password?6:1) || // Password must be at least 6 characters long for security purposes.
		   input.length() > 512) return false;
		return true;
	}

}