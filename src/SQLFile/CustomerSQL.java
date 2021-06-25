package SQLFile;

public class CustomerSQL {
	
	public final static String FINDCUSTBYCOUNTRY = "Select * from customers where country = ?";
	public final static String ADDCUSTOMER =  "INSERT INTO customers (CustomerId, Name, EmployeeId, country, status, creditLimit, dob, email) VALUES (?, ?, ?, ?, ?,?,?,?);";
	public final static String EXTRACTCUSTOMERBYCREDITLIMIT = "Select * from customers where creditLimit = ?";
	public final static String TESTSQL = "select * from customers where ?";
}
