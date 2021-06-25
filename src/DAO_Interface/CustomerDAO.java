package DAO_Interface;

import java.io.IOException;

import Model_POJO.Customer;

public interface CustomerDAO extends Runnable {
	void FindCustomerByCountry(String Country);
	void extractCustomerByCreditLimit(double limit) throws IOException;
	int updateCustomerByID(Customer c);
	int InsertCustomer(Customer c);
	void GenericSearch(String s);
}
