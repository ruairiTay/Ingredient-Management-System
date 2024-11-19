package part01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author : Ruairi Taylor
 * Student Number : 40406718
 * 
 * Resources class - used to store methods associated with the main system 
 * 
 */

public class Resources 
{
	public static String mainOptions[] = {"Manage Ingredients", "Manage Recipes", "Manage Weekly Menu", "Exit"};
	public static String error = "";
	public static String PROMPT = "----->";

	/**
	 * Method that automatically adds Ingredients and Recipes into the system 
	 * @param ingred - the array list the Ingredients will get added to 
	 * @param recipes - the array list the Recipes will get added to 
	 * @throws CustomException - the Exception that will get thrown if the data is invalid 
	 */
	public static void preSavedInfo(ArrayList <Ingredient> ingred, ArrayList <Recipe> recipes) throws CustomException
	{
		// Instantiating instances of the Ingredient class  \\
		Ingredient I1 = new Ingredient("Chicken", FoodGroup.M_and_P, "78");
		Ingredient I2 = new Ingredient("Tomatoes", FoodGroup.FandV, "34");
		Ingredient I3 = new Ingredient("Bell Peppers", FoodGroup.FandV, "67");
		Ingredient I4 = new Ingredient("Apples", FoodGroup.FandV, "22");
		Ingredient I5 = new Ingredient("Pastry", FoodGroup.COMPFOOD, "41");
		Ingredient I6 = new Ingredient("Ground Meat", FoodGroup.M_and_P, "82");
		Ingredient I7 = new Ingredient("Pasta", FoodGroup.COMPFOOD, "33");
		Ingredient I8 = new Ingredient("Rice", FoodGroup.COMPFOOD, "34");
		Ingredient I9 = new Ingredient("Cheese", FoodGroup.DAIRY, "66");
		Ingredient I10 = new Ingredient("Bread", FoodGroup.CEREAL, "52");
		Ingredient I11 = new Ingredient("Tomato Puree", FoodGroup.COMPFOOD, "12");
		Ingredient I12 = new Ingredient("Sugar", FoodGroup.COMPFOOD, "9");

		//  adding these instances to an Ingredient array list  \\
		ingred.add(I1);
		ingred.add(I2);
		ingred.add(I3);
		ingred.add(I4);
		ingred.add(I5);
		ingred.add(I6);
		ingred.add(I7);
		ingred.add(I8);
		ingred.add(I9);
		ingred.add(I10);
		ingred.add(I11);
		ingred.add(I12);

		//  creating instances of the RecipeIngredient class  \\
		RecipeIngredient R1 = new RecipeIngredient(I1, "300", Mass.G, "Chopped up into small chunks");
		RecipeIngredient R2 = new RecipeIngredient(I2, "150", Mass.G, "");
		RecipeIngredient R3 = new RecipeIngredient(I3, "100", Mass.G, "Cut finely");
		RecipeIngredient R4 = new RecipeIngredient(I4, "200", Mass.G, "skinned and sliced");
		RecipeIngredient R5 = new RecipeIngredient(I5, "90", Mass.G, "");
		RecipeIngredient R6 = new RecipeIngredient(I6, "400", Mass.G, "");
		RecipeIngredient R7 = new RecipeIngredient(I7, "300", Mass.G, "");
		RecipeIngredient R8 = new RecipeIngredient(I8, "240", Mass.G, "");
		RecipeIngredient R9 = new RecipeIngredient(I9, "50", Mass.G, "Grate");
		RecipeIngredient R10 = new RecipeIngredient(I10, "100", Mass.G, "");
		RecipeIngredient R11 = new RecipeIngredient(I11, "20", Mass.G, "");
		RecipeIngredient R12 = new RecipeIngredient(I12, "20", Mass.G, "");

		//  
		ArrayList <RecipeIngredient> recIng1 = new ArrayList <RecipeIngredient>();
		ArrayList <String> steps1 = new ArrayList <String>();
		
		//  adding instances of RecipeIngredient to a RecipeIngredient array list  \\
		recIng1.add(R9);
		recIng1.add(R10);
		
		//  adding steps of a recipe to a string array list  \\
		steps1.add("Heat bread");
		steps1.add("Add cheese to bread");
		steps1.add("Serve");
		
		//  creating an instance of the Recipe class and adding it to a Recipe array list \\
		Recipe Rec1 = new Recipe("Bread and cheese", "4", recIng1, MealType.STARTER, steps1);
		recipes.add(Rec1);
		
		ArrayList <RecipeIngredient> recIng2 = new ArrayList <RecipeIngredient>();
		ArrayList <String> steps2 = new ArrayList <String>();
		
		recIng2.add(R1);
		recIng2.add(R3);
		recIng2.add(R7);
		recIng2.add(R11);
		
		steps2.add("Fry chicken in frying pan for 8 minutes");
		steps2.add("Add peppers and let cook for another 5 minutes");
		steps2.add("Cook pasta");
		steps2.add("Mix chicken, peppers, pasta and puree all together and place in baking tray and put in oven for 2o minutes at 180 degrees");

		Recipe Rec2 = new Recipe("Chicken pasta bake", "4", recIng2, MealType.MAIN, steps2);
		recipes.add(Rec2);
		
		ArrayList <RecipeIngredient> recIng3 = new ArrayList <RecipeIngredient>();
		ArrayList <String> steps3 = new ArrayList <String>();
		
		recIng3.add(R2);
		recIng3.add(R3);
		recIng3.add(R6);
		recIng3.add(R8);
		recIng3.add(R11);

		steps3.add("Fry beef in frying pan until it turns brown");
		steps3.add("Add tomatoes and tomatoe puree and let this simmer of low heat for 20 minutes");
		steps3.add("Cook pasta");
		steps3.add("Once pasta is cooked, serve");
		
		Recipe Rec3 = new Recipe("Chilli", "4", recIng3, MealType.MAIN, steps3);
		recipes.add(Rec3);
		
		ArrayList <RecipeIngredient> recIng4 = new ArrayList <RecipeIngredient>();
		ArrayList <String> steps4 = new ArrayList <String>();
		
		recIng4.add(R2);
		recIng4.add(R3);
		recIng4.add(R6);
		recIng4.add(R7);
		recIng4.add(R11);

		steps4.add("Fry beef in frying pan until it turns brown");
		steps4.add("Add tomatoes and tomatoe puree and let this simmer of low heat for 20 minutes");
		steps4.add("Cook pasta");
		steps4.add("Once pasta is cooked, serve");
		
		Recipe Rec4 = new Recipe("Spaghetti bolognase", "4", recIng4, MealType.MAIN, steps4);
		recipes.add(Rec4);
		
		ArrayList <RecipeIngredient> recIng5 = new ArrayList <RecipeIngredient>();
		ArrayList <String> steps5 = new ArrayList <String>();
		
		recIng5.add(R4);
		recIng5.add(R5);
		recIng5.add(R12);
		
		steps5.add("Add apples to a pan with sugar and heat until sugar melts - should coat apples in a warm caramel");
		steps5.add("Line a pastry dish with your pastry");
		steps5.add("Add apple mix into dish");
		steps5.add("Bake in over an 180 degrees for 20 minutes and then serve");

		Recipe Rec5 = new Recipe("Apple Pie", "4", recIng5, MealType.DESSERT, steps5);
		recipes.add(Rec5);

	}
	
	/**
	 * Method that gets the size of a list and wont accept input that is not in the list 
	 * @param message - the message that will be shown - eg - select an Ingredient 
	 * @param listSize - the size of the list that the user can select from 
	 * @param input - scanner used to get user input 
	 * @return the number from the list the user has selected 
	 */
	public static int selection(String message, int listSize, Scanner input)
	{
		System.out.println("");
		Boolean ok = false;
		int value = 0;
		
		do 
		{
			//  prints selection message  \\
			System.out.println(message);
			
			try 
			{
				value = input.nextInt();
				
				//  check to see if number entered by user is within range  \\
				if ( value >= 1 && value <= listSize ) 
				{
					ok = true;
				}
			}
			catch (Exception ex) 
			{
				input.nextLine();
			}
			
		} while (!ok);  //  loop executes until the user enters a number that is within range  \\
		
		return value;
	}
	
	/**
	 * Method that shows all ingredients in an Ingredient array list 
	 * @param ingred - array list being displayed 
	 */
	public static void viewIngredients (ArrayList <Ingredient> ingred)
	{
		//  checks initial size of array list and if it is empty will display a message saying this  \\
		if(ingred.size() == 0)
		{
			System.out.println("No ingredients saved in the system yet");
		}
		else
		{
			System.out.println("");
			System.out.println("INGREDIENTS CURRENTLY SAVED IN SYSTEM: ");
			System.out.println("");
			
			//  for loop that prints out any ingredients stored in the Ingredient array list  \\
			for(int i = 0; i < ingred.size(); i++)
			{
				System.out.println(i+1 +") " + ingred.get(i).toString());
				System.out.println("");
			}
		}
	}
	
	/**
	 * Method that checks for the validity of a String 
	 * @param str - the String being checked 
	 * @return true if its valid and false if its invalid 
	 */
	public static Boolean validString(String str)
	{
		Boolean valid = false;
		
		//  check to see if the string is null  \\
		if(str != null)
		{
			//  trim string to get rid of any whiteSpace  \\
			str = str.trim();
			
			//  check to see if the string has a length of more than 0  \\
			if(str.length() > 0)
			{
				//System.out.println(str.length());
				valid = true;
				
				//  check to ensure all characters in the string are letters  \\
				for(char c : str.toCharArray())
				{
					if(Character.isDigit(c))
					{
						valid = false;
					}
				}
			}
		}
		
		return valid;
	}
	
	/**
	 * Method that checks for the validity of a String with Numbers
	 * @param str - the String being checked 
	 * @return true if its valid and false if its invalid 
	 */
	public static Boolean validStringWithNumbers(String str)
	{
		Boolean valid = false;
		
		if(str != null)
		{
			//  trim string to get rid of any whiteSpace  \\
			str = str.trim();
			
			//  check to see if the string has a length of more than 0  \\
			if(str.length() > 0)
			{
				valid = true;
			}
		}
		
		return valid;
	}
	
	/**
	 * Method that checks for the validity of an int being processed as a String 
	 * @param str - the String being checked 
	 * @return true if its valid and false if its invalid 
	 */
	public static Boolean validInt(String str)
	{
		Boolean valid = false;
		
		if(str != null)
		{
			//  trim string to get rid of any whiteSpace  \\
			str = str.trim();
			
			//  check to see if the string has a length of more than 0  \\
			if(str.length() > 0)
			{
				valid = true;
			}
		}
		else
		{
			return false;
		}
		
		//  check to see if each character of the string is a digit  \\
		for(int i = 0; i < str.length(); i++)
		{
			if(!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}

		return valid;
	}
	
	/**
	 * Method that checks for the validity of a double being processed as a String 
	 * @param str - the String being checked 
	 * @return true if its valid and false if its invalid 
	 */
	public static Boolean validDouble(String str)
	{
		Boolean valid = false;
		
		if(str != null)
		{
			//  trim string to get rid of any whiteSpace  \\
			str.trim();
			
			//  check to see if the string has a length of more than 0  \\
			if(str.length() > 0)
			{
				valid = true;
			}
		}
		else
		{
			return false;
		}
		
		//  checks each character of the string to ensure its either a digit or '.'  \\
		for(int i = 0; i < str.length(); i++)
		{
			if(!Character.isDigit(str.charAt(i)))
			{
				if(str.charAt(i) != '.')
				{
					return false;
				}
			}
		}

		return valid;
	}
}
