package lucacipaul.mealplus;

import lucacipaul.mealplus.Customer;
import lucacipaul.mealplus.DataManager;
import lucacipaul.mealplus.User;

import java.util.Date;
import java.util.Scanner;

public class DataManagerTest {
	
	static Scanner reader = new Scanner(System.in);  // Reading from System.in

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
				User usr = register();
				menu(usr.getLastName() + " " + usr.getFirstName(), true);
			case 2:
				User usr1 = login();
				menu(usr1.getLastName() + " " + usr1.getFirstName(), true);
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
