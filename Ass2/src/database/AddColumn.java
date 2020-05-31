package database;

import java.sql.*;
import java.util.Scanner;

public class AddColumn 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query1="alter table ProductInfo add category varchar(30)";
		String query2="update ProductInfo set category='Electronic' where p_id=1";
		String query3="update ProductInfo set category='Electronic' where p_id=2";
		String query4="update ProductInfo set category='Instrument' where p_id=3";
		String query5="update ProductInfo set category='Container' where p_id=4";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product?user=root&password=aartiy@199614");
			stmt=con.createStatement();
			int count1=stmt.executeUpdate(query1);
			System.out.println(count1+" Column addeded.....");
			int count2=stmt.executeUpdate(query2);
			System.out.println(count2+" Updated1....");
			int count3=stmt.executeUpdate(query3);
			System.out.println(count3+" Updated2.....");
			int count4=stmt.executeUpdate(query4);
			System.out.println(count4+" Updated3.....");
			int count5=stmt.executeUpdate(query5);
			System.out.println(count5+" Updated4.....");
			
			System.out.println("Enter your choice:");
			System.out.println("1:Electronic:");
			System.out.println("2:Instrument:");
			System.out.println("3:Container:");
			int choice=scan.nextInt();
			
			switch(choice)
			{
				case 1:
						String query7="select p_name from ProductInfo where category='Electronic'";
						rs=stmt.executeQuery(query7);
						while(rs.next())
						{
							String name=rs.getString("p_name");
							System.out.println("Product name is:"+name);
						}
						
						break;
						
				case 2:
					String query8="select p_name from ProductInfo where category='Instrument'";
					rs=stmt.executeQuery(query8);
					while(rs.next())
					{
						String name=rs.getString("p_name");
						System.out.println("Product name is:"+name);
					}
					
					break;
				
				case 3:
					String query9="select p_name from ProductInfo where category='Container'";
					rs=stmt.executeQuery(query9);
					while(rs.next())
					{
						String name=rs.getString("p_name");
						System.out.println("Product name is:"+name);
					}
					
					break;
				}
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			scan.close();
			if(con!=null)
			{
				try
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
}

