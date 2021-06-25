package Runner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import Controller.CustomerController;
import Model_POJO.Customer;

public class MyRunner {

	public static void main(String[] args) throws InterruptedException {
		int opCheck =0;
		CustomerController cust = new CustomerController();
		System.out.println("Enter 1: Find Customer by Country");
		System.out.println("Enter 2: Update Customer / Insert Customer");
		System.out.println("Enter 3: Find Customer by Credit Limit");
		System.out.println("Enter 4: Find Customer by Generic");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if(input == 1){cust.FindCustomerByCountry("USA");}
		else if (input == 2)
		{
			Customer cc = new Customer(20, "Baird","1979-06-29" , 3,"testemail.emailaddress.com", "USA", "active", 2000.0);
			try {
				opCheck = cust.InsertCustomer(cc);
				if (opCheck == 0)
				{
					throw new RuntimeException();
				}
			} catch (RuntimeException e)
			{
				System.out.println("Was unable to add customer!");
			}
		
		
			
		}
		else if (input == 3)
		{
			try {
				cust.extractCustomerByCreditLimit(5000);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		else if (input == 4)
		{
			try {
				
				System.out.println("Columns available:\nname\nCustomerId\ndob\nEmployeeId\ncountry\nstatus\nemail\ncreditLimit");
				System.out.println("Choose Column to query");
				String column = sc.next();
				switch (column) {
				
				case "name": {
					System.out.println("Enter value to search on (format: String):");
					String value = sc.next();
					String search = column + " = \"" + value + "\";";
					cust.GenericSearch(search);
					break;
				}
				case "CustomerId":{
					System.out.println("Enter value to search on (format: integer):");
					String value = sc.next();
					String search = column + " = " + value + ";";
					cust.GenericSearch(search);
					break;
				}
				case "dob":{
					System.out.println("Enter value to search on (format: YYYY-MM-DD):");
					String value = sc.next();
					String search = column + " = \"" + value + "\";";
					cust.GenericSearch(search);
					break;
				}
				case "EmployeeId":{
					System.out.println("Enter value to search on (format: integer):");
					String value = sc.next();
					String search = column + " = " + value + ";";
					cust.GenericSearch(search);
					break;
				}
				case "country":{
					System.out.println("Enter value to search on (format: String)::");
					String value = sc.next();
					String search = column + " = \"" + value + "\";";
					cust.GenericSearch(search);
					break;
				}
				case "status":{
					System.out.println("Enter value to search on (format: String):");
					String value = sc.next();
					String search = column + " = \"" + value + "\";";
					cust.GenericSearch(search);
					break;
				}
				case "email":{
					System.out.println("Enter value to search on (format: <String>@<String>.com):");
					String value = sc.next();
					String search = column + " = \"" + value + "\";";
					cust.GenericSearch(search);
					break;
				}
				case "creditLimit":{
					System.out.println("Enter value to search on (format: double):");
					String value = sc.next();
					String search = column + " = " + value + ";";
					cust.GenericSearch(search);
					break;
				}
			}
			} catch(Exception e) {
				
			}
		}
		else if (input == 5) 
		{
			CustomerController c1 = new CustomerController();
			Thread thrd = new Thread(c1,"T1");
			Thread t2 = new Thread(c1, "T2");
			thrd.start();
			thrd.join();
			t2.start();
		}
		else 
		{
			System.out.println("your select is wrong: Run again");
		}
		

	}

}
