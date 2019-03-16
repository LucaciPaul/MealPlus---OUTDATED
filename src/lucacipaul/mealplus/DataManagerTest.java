package lucacipaul.mealplus;

import lucacipaul.mealplus.Customer;
import lucacipaul.mealplus.DataManager;
import lucacipaul.mealplus.User;

import java.util.Date;

// Temporary class for testing, until I can figure out
// how to actually do proper tests in Java/IntelliJ :)
public class DataManagerTest {

    public static void main(String[] args) {
        DataManager dataManager = DataManager.getInstance();

        User testCustomer = new Customer();
        testCustomer.setEmail("test@gmail.com");
        testCustomer.setLastName("test");
        testCustomer.setFirstName("test");
        testCustomer.setRegistrationDate(new Date());
        testCustomer.setPwd(dataManager.hashPassword(testCustomer, "password"));

        // Can't get assert to work, fuck java tbh.
        System.out.println ("Name       Expected value:     Result");
        System.out.println ("Register   (true):             " + dataManager.register(testCustomer));
        System.out.println ("Register   (false):            " +  dataManager.register(testCustomer));
        System.out.println ("Login   (true):            " +  dataManager.login("test@gmail.com", "password"));
        System.out.println ("Login   (false):            " +  dataManager.login("invalid@gmail.com", "password"));
        System.out.println ("Login   (false):            " +  dataManager.login("test@gmail.com", "PASSWORD"));

    }
}
