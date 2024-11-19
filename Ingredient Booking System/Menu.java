package part01;

import java.util.Scanner;

/**
 * 
 * Author : Ruairi Taylor
 * Student Number : 40406718
 * 
 * Menu class to create a menu the user can interact with  
 * 
 */

public class Menu 
{
	//  ATTRIBUTES  \\
	private String items[];
	private String title;
	private Scanner input;

	/**
	 * Constructor with fields 
	 * @param title - title of menu
	 * @param data -  array that will hold the menu options
	 */
	public Menu(String title, String data[]) 
	{
		this.title = title;
		this.items = data;
		this.input = new Scanner(System.in);
	}

	/**
	 * Method used to display the menu options 
	 */
	private void display() 
	{
		System.out.println(title);
		
		for (int count = 0; count < title.length(); count++) 
		{
			System.out.print("+");
		}
		
		System.out.println();
		
		for (int option = 1; option <= items.length; option++) 
		{
			System.out.println(option + ". " + items[option - 1]);
		}
		
		System.out.println();
	}

	/**
	 * Method used to get the choice from the menu that the user has selected 
	 * @return the number from the menu the user has selected 
	 */
	public int getUserChoice() 
	{
		boolean ok = false;
		int value = 0;
		display();
		
		do 
		{
			System.out.print("Enter Selection: ");
			
			try 
			{
				value = input.nextInt();
				
				if ( value>=1 && value<=items.length ) 
				{
					ok = true;
				}
				
			}
			catch (Exception ex) 
			{
				input.nextLine();
			}
			
		} while (!ok);
		
		return value;
	}
}
