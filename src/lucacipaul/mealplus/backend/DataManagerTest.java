package lucacipaul.mealplus.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DataManagerTest {
	
	static Scanner reader = new Scanner(System.in);  // Reading from System.in
	static User currentUser;

    public static void main(String[] args) {
    	Dummy.set();
        menu("Guest", false);
        
    }

	private static void menu(String fn, boolean isLogged) {
		
		System.out.println("Welcome, " + fn + "!\n");
		System.out.println("Please select one of the following options: ");
		if(isLogged) {
			menuOptions(1);
		} else {
			menuOptions(0);
		}
		
		System.out.println();
		
		int o = reader.nextInt();
		switch(o) {
			case 1:
				currentUser = register();
				menu(currentUser.getLastName() + " " + currentUser.getFirstName(), true);
			case 2:
				currentUser = login();
				menu(currentUser.getLastName() + " " + currentUser.getFirstName(), true);
			case 3:

				System.out.println("Running 'searchUnpublishedItems' test:");
				ArrayList<Items> avocadoToast = DataManager.getInstance().searchUnpublishedItems("toast", true);
				ArrayList<Items> eggs = DataManager.getInstance().searchUnpublishedItems("eggs", true);
				for (Items item : avocadoToast) { System.out.println("AvocadoToast: " + item.getName() + " (" + item.isPublic() + ")"); }
				for (Items item : eggs) 		{ System.out.println("Eggs: " + item.getName() + " (" + item.isPublic() + ")"); }

				System.out.println("\r\nRunning 'searchItems' test:");
				ArrayList<DietLogEntry> searchedToken = DataManager.getInstance().searchItems((Customer) currentUser, "eggs", null, null, null, false, false, false);
				for (DietLogEntry item : searchedToken) { System.out.println("Searched (token): " + item.getEntry().getName() + " (" + item.getEntry().isPublic() + ")"); }
				ArrayList<DietLogEntry> searchedAmenities = DataManager.getInstance().searchItems((Customer) currentUser, "", new ArrayList<Amenities>(Arrays.asList(Amenities.Cooker)), null, null, false, false, false);
				for (DietLogEntry item : searchedAmenities) { System.out.println("Searched (amenities): " + item.getEntry().getName() + " (" + item.getEntry().isPublic() + ")"); }
				ArrayList<DietLogEntry> searchedTypes = DataManager.getInstance().searchItems((Customer) currentUser, "", null, new ArrayList<Types>(Arrays.asList(Types.Vegetables)), null, false, false, false);
				for (DietLogEntry item : searchedTypes) { System.out.println("Searched (types): " + item.getEntry().getName() + " (" + item.getEntry().isPublic() + ")"); }
				ArrayList<DietLogEntry> searchedSellpoints = DataManager.getInstance().searchItems((Customer) currentUser, "", null, null, new ArrayList<Sellpoints>(Arrays.asList(Sellpoints.Sainsbury)), false, false, false);
				for (DietLogEntry item : searchedSellpoints) { System.out.println("Searched (sellpoints): " + item.getEntry().getName() + " (" + item.getEntry().isPublic() + ")"); }



				menu(currentUser.getLastName() + " " + currentUser.getFirstName(), true);
			case 4:
				menu("Guest", false);
		}
	}
	
	private static User login() {
		System.out.println("Email: ");
		String email = reader.next();
		System.out.println("Password: ");
		String pwd = reader.next();

		// Why 2 lines here @Paul? Seems like a very old style of programming.
		User valid = DataManager.getInstance().login(email, pwd); // polymorphism of login
		
		if(valid != null) {
			System.out.println("Success!\n\n");
			return valid;
		}
		else {
			System.out.println("Please try again!\n\n");
			return login();
		}
	}

	private static User register() {
		System.out.println("First Name: ");
		String firstName = reader.next();
		System.out.println("Last Name: ");
		String lastName = reader.next();
		System.out.println("Email: ");
		String email = reader.next();
		System.out.println("Password: ");
		String pwd = reader.next();
		
		User usr = new Customer(); // Cannot create a User by it self, must be either Customer, Adviser or Admin.
		usr.setEmail(email);
		usr.setFirstName(firstName);
		usr.setLastName(lastName);
		usr.setTitle(Title.Mx);
		usr.setPwd(pwd);
		usr.setRegistrationDate(new Date()); // Set registration date to now.
		
		/*int accountType = registerOptions();
		boolean valid;
		if (accountType == 0) {
			Customer c = (Customer)usr;
			valid = DataManager.getInstance().register(c); // polymorphism of register
		} else {
			Adviser adv = (Adviser)usr;
			valid = DataManager.getInstance().register(adv); // polymorphism of register
		}*/
		
		boolean valid = DataManager.getInstance().register(usr);
		if(valid) {
			System.out.println("Success!\n\n");
			return usr;
		}
		else {
			System.out.println("Please try again!\n\n");
			return register();
		}
		
	}
	
	private static int registerOptions() {
		
		System.out.println("[0] Customer");
		System.out.println("[1] Adviser");
		
		int type = reader.nextInt();
		
		switch(type) {
			case 0:
				return 0;
			case 1:
				return 1;
			default:
				System.out.println("Invalid selection!");
				return registerOptions();
		}
	}

	private static void menuOptions(int isLogged) {
		
		if(isLogged == 0) {
			System.out.println("[1] Register");
			System.out.println("[2] Login");
		} else {
			System.out.println("[3] Find");
			System.out.println("[4] Logout");
		}
	}
}
