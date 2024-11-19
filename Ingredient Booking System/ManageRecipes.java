package part01;


import java.util.ArrayList;

import java.util.Scanner;

/**
 * 
 * Author : Ruairi Taylor
 * Student Number : 40406718
 * 
 * ManageRecipes class used to hold all methods associated with Recipes to help code stay organised 
 * 
 */

public class ManageRecipes 
{
	/**
	 * Method used to check the validity of a String by a user entered and then set it to the name Attribute of a Recipe object
	 * @param rec - the Recipe object that the name attribute belongs to 
	 * @param input - scanner used to get user input 
	 * @param recList - Recipe array list used for conducting a search 
	 */
	public static void recName(Recipe rec, Scanner input, ArrayList <Recipe> recList)
	{
		Boolean valid = false;

		//  loop repeats until a valid string name is entered  \\
		do
		{
			System.out.println(Resources.PROMPT + "PLEASE ENTER RECIPE NAME:");
			String name = input.nextLine();
			
			//  check to see if the name entered already exists  \\
			if(searchRecipeName(name, recList) != -1)
			{
				System.out.println("This recipe is already in the system");
			}
			else
			{
				//  try catch block to catch any exceptions thrown when setting the name string  \\
				try
				{
					rec.setRecipeName(name);
					valid = true;
				}
				catch(CustomException e)
				{
					System.out.println(e.getErrorMessageM());
				}
			}
			
		}while(valid == false);
	}
	
	/**
	 * Method used to check the validity of a String entered by a user and then set it to the portionSize Attribute of a Recipe object
	 * @param rec - the Recipe object that the portionSize attribute belongs to 
	 * @param input - scanner used to get user input 
	 */
	public static void recPortionSize(Recipe rec, Scanner input)
	{
		Boolean valid = false;
		
		//  loop repeats until a valid string portion size is entered  \\
		do
		{
			//  try catch block to catch any exceptions thrown when setting the portion size string  \\
			try
			{
				System.out.println(Resources.PROMPT + "PLEASE ENTER RECIPE PORTION SIZE:");
				String ps = input.nextLine();
				rec.setRecPortionSize(ps);
				valid = true;
			}
			catch(CustomException e)
			{
				System.out.println(e.getErrorMessageM());
			}

		}while(valid == false);
	}
	
	/**
	 * Method used to check the validity of a String array entered by a user and then set it to the instructions Attribute of a Recipe object
	 * @param rec - the Recipe object that the instructions attribute belongs to 
	 * @param input - the Scanner used to get user input 
	 */
	public static void recSteps(Recipe rec, Scanner input)
	{
		Boolean valid = false;
		
		ArrayList <String> recSteps = new ArrayList <String> ();

		//  loop repeats until a valid recipe steps are entered  \\
		do
		{
			//  gets the recipe steps entered by the user  \\
			gatherRecipeSteps(recSteps, input);

			//  try catch block to catch any exceptions thrown when setting the recipe steps  \\
			try
			{
				rec.setInstructions(recSteps);
				valid = true;
			}
			catch(CustomException e)
			{
				System.out.println(e.getErrorMessageM());
				recSteps.clear();
			}
			
		}while(valid == false);
	}
	
	/**
	 * Method used to gather the steps for a recipe and validate the steps to ensure they aren't left blank
	 * @param recSteps - the String array list that will hold the recipe steps  
	 * @param input - scanner used to gather user input 
	 */
	public static void gatherRecipeSteps(ArrayList <String> recSteps, Scanner input)
	{
		Boolean add = true;			
		System.out.println();	
		System.out.println("PLEASE ENTER THE STEPS OF YOUR RECIPE - PRESS ENTER AFTER COMPLETEING EACH STEP");
		int stepNo = 1;
				
		do
		{
			//  gets user to enter in the step  \\
			System.out.println("Enter step " + stepNo + " " + Resources.PROMPT);
			String step = input.nextLine();	
			recSteps.add(step);
					
			//  asks user if they would like to add anther step or not  \\
			int choice = yesNoMenu("Would you like to add another step to the recipe ?");
					
			if(choice == 2)
			{
				add = false;
			}
					
			stepNo++;
					
		 }while(add == true);
	}
	
	/**
	 * Method that will show user all available Ingredients and let them select one to add to a Recipe
	 * @param recIng - array list that will hold all Ingredients for the recipe being created 
	 * @param ingred - array list that will hold all available ingredients 
	 * @param input - scanner used to get user input 
	 */
	public static void gatherRecipeIngredients(ArrayList <RecipeIngredient> recIng, ArrayList <Ingredient> ingred, Scanner input)
	{
		Boolean add = true;
		
		//  loop will repeat until the user says the don't want to add another ingredient, which will set add to false  \\
		do
		{
			if(ingred.size() == 0)
			{
				System.out.println("There are no ingredients saved in the system");
				System.out.println("");
				add = false;
			}
			else
			{
				int value = 0;
				//  call to a method that displays the ingredients in the system to the user  \\
				Resources.viewIngredients(ingred);
				
				//  call to method that returns the a number which will be the index of the ingredients they have selected  \\
				value = Resources.selection("SELECT AN INGREDIENT YOU WOULD LIKE TO ADD TO THE RECIPE", ingred.size(), input);
				
				//  creating new instance of the RecipeIngredient class  \\
				RecipeIngredient RI = new RecipeIngredient();
				
				//  checks to see if there is any elements int he recIng array list  \\
				if(recIng.size() == 0)
				{
					addRecIng(RI, value, ingred, input);
					recIng.add(RI);
				}
				else
				{
					Boolean present = false;
					
					//  for loop to check to see if the selected ingredient is already in the recipe ingredient array list  \\
					for(int i = 0; i < recIng.size(); i++)
					{
						//  if ingredient is already in the list the user is notified of this  \\
						if(ingred.get(value - 1).getID().equalsIgnoreCase(recIng.get(i).getIngredient().getID()))
						{
							System.out.println("This ingredient - " + recIng.get(i).getIngredient().getName() +  " - is already in the recipe");
							System.out.println("");
							present = true;
						}
					}
					
					//  if the ingredient is not present in the list, the ingredient is added to the list  \\
					if(!present)
					{
						addRecIng(RI, value, ingred, input);
						recIng.add(RI);
					}
				}
				
				//  gives the user the option to add another ingredient  \\
				int choice = yesNoMenu("Would you like to add another ingredient to the recipe?");
				
				if(choice == 2)
				{
					add = false;
				}
			}
			
			
		}while(add == true);
	}
	
	/**
	 * Method that gathers and validates all necessary data needed to create an instance of the RecipeIngredient class
	 * @param RI -  the instance of the RecipeIngredient class the data is being added to 
	 * @param value - the position of the Ingredient in the Ingredient array list that is going to put into the RecipeIngredient object
	 * @param ingred -  the ingredient array list which holds all existing Ingredients 
	 * @param input - scanner used to gather user input 
	 */
	public static void addRecIng(RecipeIngredient RI, int value, ArrayList <Ingredient> ingred, Scanner input)
	{
		//  sets the Ingredient of RecipeIngredient based on user input 'value'  \\
		RI.setIngredient(ingred.get(value - 1));
		
		System.out.println("You have selected " + ingred.get(value - 1).getName());
		input.nextLine();
		
		Boolean validNumAmount = false;

		//  loop repeats until a valid amount is entered  \\
		do
		{
			//  try catch block to catch any exceptions thrown when setting the amount  \\
			try
			{
				System.out.println("");
				System.out.println(Resources.PROMPT + "Enter the numeric amount required for the recipe ");
				String amount = input.nextLine();
				RI.setAmount(amount);
				validNumAmount = true;
			}
			catch(CustomException e)
			{
				System.out.println(e.getErrorMessageM());
			}
			
		}while(validNumAmount == false);
		
		System.out.println(Resources.PROMPT + "Select the weight description for the weight you entered");
		//  setting mass description using a method to return a mass type  \\
		RI.setMassDescription(selectMassType());
		
		System.out.println("");
		System.out.println("You can enter in any extra information about the ingredient here: ");
		String extraInfo = input.nextLine();
		//  setting extraInfo for a recipe ingredient  \\
		RI.setIngredientExtraInfo(extraInfo);
	}
	
	/**
	 * Method that creates a menu and lets the user select the mass type - grams or milli litres 
	 * @return a Mass 
	 */
	public static Mass selectMassType()
	{
		//  creating a sub menu to give the user the option of which mass description they would like to select  \\
		System.out.println("");
		String options[] = { "grams", "milli - litres"};
		Menu mtSelect = new Menu("Select a Mass Type", options);
		int choice = mtSelect.getUserChoice();
		
		switch (choice) 
		{
			case 1:
				return Mass.G;
			case 2:
				return Mass.ML;
			default:
				return Mass.OTHER;
		}
	}
	
	/**
	 * Method creates a menu and lets the user select the meal type of the Recipe object being instantiated 
	 * @return a MealType
	 */
	public static MealType selectMealType() 
	{
		//  creating a sub menu to give the user the option of which meal type they would like to select  \\
		System.out.println("");
		String options[] = { "Starter", "Main", "Dessert"};
		Menu mtSelect = new Menu("Select a Meal Type", options);
		int choice = mtSelect.getUserChoice();
		
		switch (choice) 
		{
			case 1:
				return MealType.STARTER;
			case 2:
				return MealType.MAIN;
			case 3:
				return MealType.DESSERT;
			default:
				return MealType.OTHER;
		}
	}
	
	/**
	 * Method user to create a yes no menu
	 * @param message
	 * @return the yes choice - '1' or the no choice - '2'
	 */
	public static int yesNoMenu(String message)
	{
		String [] opt = new String [] {"YES", "NO"};
		Menu manageRecIngMenu = new Menu(message, opt);
		System.out.println("");
		return manageRecIngMenu.getUserChoice();
	}
	
	/**
	 * Method used to sort a Recipe array list into alphabetical order by calling to the insertion sort method
	 * @param data - the array list being sorted 
	 * @return - the sorted list 
	 */
	public static ArrayList <Recipe> sortRecipes (ArrayList <Recipe> data)
	{
		ArrayList <Recipe> result = new ArrayList <Recipe>();
			
		if(data != null)
		{
			if(data.size() != 0)
			{
				for(Recipe rec : data)
				{
					insertRecipes(rec, result);
				}
			}
		}
			
		return result;
	}
		
	/**
	 * Method that takes an instance of the Recipe class and inserts it into the correct spot in the data Recipe array list according to alphabetical order
	 * @param rec - the Recipe object being inserted 
	 * @param data - the list the object is being inserted into 
	 */
	public static void insertRecipes(Recipe rec, ArrayList <Recipe> data)
	{
		int position = 0;
			
		if(data.size() == 0)
		{
			data.add(rec);
		}
		else
		{
			String rec1 = rec.getRecipeName();
			
			for(position = 0; position < data.size(); position++)
			{
				String rec2 = data.get(position).getRecipeName();
					
				//  compares the element being added to the each element of the array list to see where it will be added  \\
				if(rec1.toLowerCase().compareTo(rec2.toLowerCase()) < 0)
				{
					break;
				}
			}
			
			//  adds recipe to the correct position in the array list  \\
			data.add(position, rec);
		}
	}
		
	/**
	 * Method used to see if a recipe ID exists the Recipe array list
	 * @param ID - the ID being searched for 
	 * @param availableID - the list being searched 
	 */
	public static void searchRecipeID(String ID, ArrayList <Recipe> availableID)
	{
		int search = -1;
			
		//  for loop that compares the ID provided by the user to the existing IDs  \\
		for(int i = 0; i < availableID.size(); i++)
		{
			if(ID.equals(availableID.get(i).getRecipeID()))
			{
				System.out.println("The recipe with this ID has been found !");
				System.out.println("");
				System.out.println(availableID.get(i));
				System.out.println("");
				search = 1;
				break;
			}
		}
			
		if(search == -1)
		{
			System.out.println("This ID could not be found");
			System.out.println("");
		}
	}
		
	/**
	 * Method conducts a binary search to see if the Recipe with the name given exists in the Recipe array list 
	 * @param name - the name of the recipe being searched for 
	 * @param rec -  the array list being searched 
	 * @return - returns the position of the recipe in the array list if its been found or -1 if it has not been found
	 */
	public static int searchRecipeName(String name, ArrayList <Recipe> rec)
	{
		int start = 0;
		int end = rec.size()-1;
			
		do
		{
			//  sets middle point of array list  \\
			int pivot = start + (end-start)/2;
				
			//  compares the name entered with middle point and halves the array based on the outcome of comparing the two values  \\
			if(name.equalsIgnoreCase(rec.get(pivot).getRecipeName()))
			{
				return pivot;
			}
			else if(name.compareToIgnoreCase(rec.get(pivot).getRecipeName()) < 0)
			{
				end = pivot -1;
			}
			else
			{
				start = pivot + 1;
			}
				
		}while(start <= end);
		
		//  if the start = end then -1 will be returned (value not found)  \\
		return -1;
	}
	
	}

