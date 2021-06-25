package Model_POJO;

public class Customer {

		private int CustomerID;
		private String Name;
		private String dob;
		private int EmployeeId;
		private String email;
		private String country;
		private String status;
		private double creditLimit;
			
		public Customer(){
		
		}
		
		public Customer(int customerID, String name, String dob, int employeeId, String email, String country,
				String status, double creditLimit) {
			super();
			CustomerID = customerID;
			Name = name;
			this.dob = dob;
			EmployeeId = employeeId;
			this.email = email;
			this.country = country;
			this.status = status;
			this.creditLimit = creditLimit;
		}
		public int getCustomerID() {
			return CustomerID;
		}
		public void setCustomerID(int customerID) {
			CustomerID = customerID;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public int getEmployeeId() {
			return EmployeeId;
		}
		public void setEmployeeId(int employeeId) {
			EmployeeId = employeeId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public double getCreditLimit() {
			return creditLimit;
		}
		public void setCreditLimit(double creditLimit) {
			this.creditLimit = creditLimit;
		}

	}

