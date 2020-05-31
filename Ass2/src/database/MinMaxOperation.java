package database;

import java.sql.*;

public class MinMaxOperation 
{
	static Connection con;
	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product?user=root&password=aartiy@199614");

		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void DisplayMaxPrice()
	{
		Statement stmt=null;
		ResultSet r1=null;
		String query="select * from ProductInfo where p_price=(select max(p_price) from ProductInfo)"; 
	
		try
		{
			stmt=con.createStatement();
			r1=stmt.executeQuery(query);
			if(r1.next())
			{
				int pid=r1.getInt(1);
				String name=r1.getString(2);
				double price=r1.getDouble(3);
				
				System.out.println(pid+"\t"+name+"\t"+price);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void DisplayMinPrice()
	{
		Statement stmt=null;
		ResultSet r1=null;
		String query="select * from ProductInfo where p_price=(select min(p_price) from ProductInfo)"; 

		try
		{
			stmt=con.createStatement();
			r1=stmt.executeQuery(query);
			if(r1.next())
			{
				int pid=r1.getInt(1);
				String name=r1.getString(2);
				double price=r1.getDouble(3);
				
				System.out.println(pid+"\t"+name+"\t"+price);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}

