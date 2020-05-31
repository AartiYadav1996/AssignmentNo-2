package database;

import java.util.Scanner;

public class Product_Main 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		MinMaxOperation o1=new MinMaxOperation();
		
		System.out.println("Enter your choice:");
		System.out.println("1: Display Product Details of Max Price");
		System.out.println("2: Display Product Details of Min Price");

		int choice=scan.nextInt();
		
		switch(choice)
		{
			case 1:		
					o1.DisplayMaxPrice();
					break;
			case 2:
					o1.DisplayMinPrice();
					break;
		}
		
	}
}

