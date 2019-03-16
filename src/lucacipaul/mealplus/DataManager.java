package lucacipaul.mealplus;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DataManager {

	private static DataManager instance = null;

	private ArrayList<User> users;

	private DataManager() {
		Dummy.set();
		users = Dummy.customers; // Err
	}

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
		// TODO - implement DataManager.searchAccount
		throw new UnsupportedOperationException();
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
	public ArrayList<DietLogEntry> searchItems(String token, Amenities amenities, Types types, Sellpoints sellpoints, boolean searchFrequentlyEaten, boolean searchSelfMade, boolean recommend) {
		// TODO - implement DataManager.searchItems
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dietLog
	 * @param toggle
	 */
	public void toggleDietLog(DietLog dietLog, boolean toggle) {
		// TODO - implement DataManager.toggleDietLog
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dietLog
	 */
	public Report generateReport(DietLog dietLog) {
		// TODO - implement DataManager.generateReport
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param pwd
	 */
	public boolean login(String email, String pwd) {

		// No need to sanitise parameters, as if they do not
		// match then it will just return false.

		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equalsIgnoreCase(email)) {
				// Found user that has the specified email,
				// return if the password matches.
				return users.get(i).getPwd().equals(hashPassword(users.get(i), pwd));
			}
		}
		// Email was not found in the users array.
		return false;
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
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equalsIgnoreCase(user.getEmail()))
				return false; // Email already exists.
		}

		return users.add(user);
	}

	/**
	 * 
	 * @param email
	 * @param approved
	 */
	public ArrayList<Adviser> searchAdviserAccounts(String email, boolean approved) {
		// TODO - implement DataManager.searchAdviserAccounts
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param token
	 * @param isPublic
	 */
	public ArrayList<Items> searchUnpublishedItems(String token, boolean isPublic) {
		// TODO - implement DataManager.searchUnpublishedItems
		throw new UnsupportedOperationException();
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
		byte[] hashedBytes = md.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));

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