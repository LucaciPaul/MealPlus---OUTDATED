package lucacipaul.mealplus;

import java.util.ArrayList;

public class DataManager {

	private static DataManager instance = null;

	private ArrayList<User> users = new ArrayList<>();

	private DataManager() {
		SetupDummyData();
	}

	private void SetupDummyData() {

		User dummyCustomer1 = new Customer();
		dummyCustomer1.setEmail("test@gmail.com");
		dummyCustomer1.setPwd("password");

		register(dummyCustomer1);
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
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(email)) {
				// Found user that has the specified email,
				// return if the password matchs.
				return users.get(i).getPwd().equals(pwd);
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
		// Sanity checks to make sure the email
		// does not exist.
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(user.getEmail()))
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

}