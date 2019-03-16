package lucacipaul.mealplus;

import java.util.ArrayList;
import java.util.Date;

public class Dummy {
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    
    public static void set() {
    	
    	Customer c = new Customer();
    	c.setFirstName("Paul"); c.setLastName("Lucaci"); c.setEmail("p@email.com"); c.setRegistrationDate(new Date()); c.setPwd(DataManager.getInstance().hashPassword(c, "password"));
    	DataManager.getInstance().register(c);
    	customers.add(c);
    	
    	c = new Customer();
    	c.setFirstName("Sadonis"); c.setLastName("Ignas"); c.setEmail("s@email.com"); c.setRegistrationDate(new Date()); c.setPwd(DataManager.getInstance().hashPassword(c, "password"));
    	DataManager.getInstance().register(c);
    	customers.add(c);
    	
    	c = new Customer();
    	c.setFirstName("Kevin"); c.setLastName("Horeau"); c.setEmail("k@email.com"); c.setRegistrationDate(new Date()); c.setPwd(DataManager.getInstance().hashPassword(c, "password"));
    	DataManager.getInstance().register(c);
    	customers.add(c);
    	
    	c = new Customer();
    	c.setFirstName("Viktorija"); c.setLastName("Kolasnikova"); c.setEmail("s@email.com"); c.setRegistrationDate(new Date()); c.setPwd(DataManager.getInstance().hashPassword(c, "password"));
    	DataManager.getInstance().register(c);
    	customers.add(c);
    	
    }
}