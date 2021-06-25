package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO_Interface.*;
import SQLFile.*;
import Model_POJO.*;
import Runner.*;
import SQLFile.CustomerSQL;

public class CustomerController extends ConnectionDAO  implements CustomerDAO  {
	
	@Override
	public void run(){
		try {
			this.extractCustomerByCreditLimit(5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void GenericSearch(String s) {
		try {
			Connection con = getConnection();
			ArrayList<Customer> List = new ArrayList<Customer>();
			String teststring = "select * from customers where " + s;
			System.out.println(teststring);
			ps =  con.prepareStatement(teststring);
			rs = ps.executeQuery();
			File file = new File("results.txt");
			if (!file.exists()) file.createNewFile();
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			while(rs.next())
			{
				Customer c = new Customer();
				c.setName(rs.getString("Name"));
				c.setCountry(rs.getString("country"));
				c.setCreditLimit(rs.getDouble("creditlimit"));
				c.setCustomerID(rs.getInt("customerID"));
				c.setDob(rs.getString("dob"));
				c.setStatus(rs.getString("dob"));
				c.setEmployeeId(rs.getInt("EmployeeId"));
				c.setEmail(rs.getString("Email"));
				List.add(c);
				
			}
			bw.write("**********************************************************\nData extracted from Generic Search method!\n"	+ "Query: " + teststring + "\n**********************************************************\n");
			for(Customer cc: List)
			{
				String writer = cc.getEmployeeId() + "," + cc.getName() + "," + cc.getCountry() + "," + cc.getCreditLimit() + ","+ cc.getCustomerID() +"," +cc.getDob()+","+cc.getEmployeeId()+ ","+cc.getStatus();
				System.out.println("======================");
				System.out.println(cc.getEmployeeId()+" "+ cc.getName() + " " +cc.getCountry() +" " + cc.getCreditLimit() + " "+ cc.getCustomerID() +" " +cc.getDob()+" "+cc.getEmployeeId()+ " "+cc.getStatus());
				bw.write(writer);
				bw.newLine();
				}
			bw.close();
			fw.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally 
			{
				disconnect();
			}
		}

	@Override
	public void FindCustomerByCountry(String Country) {
		try {
			Connection con = getConnection();
			ArrayList<Customer> List = new ArrayList<Customer>();
			String FindCustomerbyCountry = CustomerSQL.FINDCUSTBYCOUNTRY;
			ps =  con.prepareStatement(FindCustomerbyCountry);
			ps.setString(1, Country);
			rs = ps.executeQuery();
			File file = new File("results.txt");
			if (!file.exists()) file.createNewFile();
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			while(rs.next())
			{
				Customer c = new Customer();
				c.setName(rs.getString("Name"));
				c.setCountry(rs.getString("country"));
				c.setCreditLimit(rs.getDouble("creditlimit"));
				c.setCustomerID(rs.getInt("customerID"));
				c.setDob(rs.getString("dob"));
				c.setStatus(rs.getString("dob"));
				c.setEmployeeId(rs.getInt("EmployeeId"));
				c.setEmail(rs.getString("Email"));
				List.add(c);
				
			}
			bw.write("**********************************************************\nData extracted from FindCustomerByCountry method!\n**********************************************************\n");
			for(Customer cc: List)
			{
				String writer = cc.getEmployeeId() + "," + cc.getName() + "," + cc.getCountry() + "," + cc.getCreditLimit() + ","+ cc.getCustomerID() +"," +cc.getDob()+","+cc.getEmployeeId()+ ","+cc.getStatus();
				System.out.println("======================");
				System.out.println(cc.getEmployeeId()+" "+ cc.getName() + " " +cc.getCountry() +" " + cc.getCreditLimit() + " "+ cc.getCustomerID() +" " +cc.getDob()+" "+cc.getEmployeeId()+ " "+cc.getStatus());
				bw.write(writer);
				bw.newLine();
				}
			bw.close();
			fw.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally 
			{
				disconnect();
			}
		}
		@Override
		public int InsertCustomer(Customer c) {
				int a = 0;
				try 
				{
					Connection con = getConnection();
					ps = con.prepareStatement(CustomerSQL.ADDCUSTOMER);
					ps.setInt(1, c.getCustomerID());
					ps.setString(2, c.getName());
					ps.setInt(3, c.getEmployeeId());
					ps.setString(4, c.getCountry());
					ps.setString(5, c.getStatus());
					ps.setDouble(6, c.getCreditLimit());
					ps.setString(7, c.getDob());
					ps.setString(8, c.getEmail());					
					a = ps.executeUpdate();
				}
				catch (ClassNotFoundException | SQLException e) 
				{

				}
				return a;
		}
		
		@Override
		public void extractCustomerByCreditLimit(double limit) throws IOException
		{
			try 
			{
				Connection con = getConnection();
				String statement = CustomerSQL.EXTRACTCUSTOMERBYCREDITLIMIT;
				ps = con.prepareStatement(statement);
				ps.setDouble(1, limit);
				ResultSet rs = ps.executeQuery();
				ArrayList<Customer> List = new ArrayList<Customer>();
				File file = new File("results.txt");
				if (!file.exists()) file.createNewFile();
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);

				while (rs.next())
				{
					Customer c = new Customer();
					c.setName(rs.getString("Name"));
					c.setCountry(rs.getString("country"));
					c.setCreditLimit(rs.getDouble("creditlimit"));
					c.setCustomerID(rs.getInt("customerID"));
					c.setDob(rs.getString("dob"));
					c.setStatus(rs.getString("dob"));
					c.setEmployeeId(rs.getInt("EmployeeId"));
					c.setEmail(rs.getString("Email"));
					List.add(c);
				}
				bw.write("**********************************************************\nData extracted from extractCustomerByCreditLimit method!\n**********************************************************\n");
				for (Customer cc : List)
				{
					
					String writer = cc.getEmployeeId() + "," + cc.getName() + "," + cc.getCountry() + "," + cc.getCreditLimit() + ","+ cc.getCustomerID() +"," +cc.getDob()+","+cc.getEmployeeId()+ ","+cc.getStatus();
					System.out.println("======================");
					System.out.println(cc.getEmployeeId()+" "+ cc.getName() + " " +cc.getCountry() +" " + cc.getCreditLimit() + " "+ cc.getCustomerID() +" " +cc.getDob()+" "+cc.getEmployeeId()+ " "+cc.getStatus());
					bw.write(writer);
					bw.newLine();

					
				}

				bw.close();
				fw.close();
				
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			} 
		}
		@Override
		public int updateCustomerByID(Customer c) {
			int a = 0;
			try 
			{
				Connection con = getConnection();
				String UpdateBYId = "update customers set Name = ?, email = ?, status = ? where CustomerId = ? ";
				ps = con.prepareStatement(UpdateBYId);
				ps.setString(1, c.getName());
				ps.setString(2, c.getEmail());
				ps.setString(3, c.getStatus());
				ps.setInt(4, c.getCustomerID());
				a = ps.executeUpdate();
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();}
			return a;
			}
		public void SetCustomerinformation(int CustomerID, String Name, String email, String Status, String operation)
		{
			Customer c = new Customer();
			c.setCustomerID(CustomerID);
			c.setName(Name);
			c.setEmail(email);
			c.setStatus(Status);
			if (operation == "Insert")
			{
				int i = InsertCustomer(c);
				System.out.println(i + "rows are added");
			}
			else if (operation == "update")
			{
				int i = updateCustomerByID(c);
				System.out.println(i + " row are updated");
			}
			else System.out.println("wrong operation: Try again");
			}
		}

