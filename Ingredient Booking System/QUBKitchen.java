package part01;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * Author : Ruairi Taylor
 * Student Number : 40406718
 * 
 * QUBKitchen class - main class that handles most of user input  
 * 
 */

public class QUBKitchen {

	//  declaring static variables  \\
	static Scanner input = new Scanner(System.in);
	static ArrayList <Ingredient> ingred = new ArrayList <Ingredient> ();
	static ArrayList <Recipe> recipes = new ArrayList <Recipe>();
	static String [][] Menu = {{"---","---","---"}, {"---","---","---"}, {"---","---","---"}, {"---","---","---"}, {"---","---","---"}};
	
	public static void main(String[] args) 
	{
		//  automatically adding ingredients and recipes for the user to choose from  \\
		try
		{
			Resources.preSavedInfo(ingred, recipes);
		}
		catch(Exception e)
		{
			
		}
		
		//  creating the main menu  \\
		Menu mainMenu = new Menu("QUB Kitchen", Resources.mainOptions);
		int choice = 0;
		boolean quit = false;
		
		do 
		{
			choice = mainMenu.getUserChoice();
			quit = processChoice(choice);
			
		} while (!quit);

		System.out.println("All done - Goodbye!");
	}

	/**
	 * Method used to take user to part of system based on their input
	 * @param choice - input from user on what they have selected from the menu 
	 * @return - a boolean to indicate whether or not to quit the system 
	 */
	private static boolean processChoice(int choice) 
	{
		boolean quit = false;
		
		//  switch case used to process the users choice  \\
		switch (choice) 
		{
		case 1:
			manageIngredients();
			break;
		case 2:
			manageRecipes();
			break;
		case 3:
			manageWeeklyMenu();
			break;
		case 4:
			quit = true;
		}
		
		return quit;
	}
	
	/**
	 * Method that shows a menu to give the user options as to what they would like to do in regards to the Ingredients stored in the system
	 */
	public static void manageIngredients()
	{
		//  creating a sub menu to manage ingredients  \\
		String [] opt = new String [] {"ADD", "VIEW", "SEARCH", "EDIT", "DELETE", "QUIT"};
		Menu manageIngredientsMenu = new Menu("MANAGE INGREDIENTS", opt);
		System.out.println("");
		int choice = manageIngredientsMenu.getUserChoice();
		
		//  call to method to sort ingredients into alphabetical order  \\
		ingred = ManageIngredients.sortIngredients(ingred);
		
	    //  switch case used to manage user choice when managing ingredients  \\
		switch (choice) 
		{
		case 1:
			Ingredient ing = new Ingredient();
			addIngredient(ing);
			break;
		case 2:
			Resources.viewIngredients(ingred);
			break;
		case 3:
			searchIngredients();
			break;
		case 4:
			updateIngredients();
			break;
		case 5:
			deleteIngredients();
			break;
		case 6:
			System.out.println("");
			break;
		}
	}
	
	/**
	 * Method used to add an Ingredient object
	 * @param ing - the Ingredient object that is being instantiated 
	 */
	public static void addIngredient(Ingredient ing)
	{
		//  call to method that collects details from the user about the ingredient they want to add  \\
		ManageIngredients.collectingDetails(ing, input, ingred);
		//  adds the ingredient to the Ingredient array list  \\
		ingred.add(ing);
		System.out.println("New Ingredient Successfully added !!");
		System.out.println("");
		//  resorts the array list with the new ingredient added  \\
		ingred = ManageIngredients.sortIngredients(ingred);

	}
	
	/**
	 * Method used to give user search options and carry out the search according to their input  
	 */
	public static void searchIngredients()
	{
		//  creates sub menu to give user choice as to how they want to search  \\
		String [] opt = new String [] {"ID", "NAME", "PART-NAME", "FODD GROUP"};
		Menu manageIngredientsMenu = new Menu("SEARCH INGREDIENTS", opt);
		System.out.println("");
		int choice = manageIngredientsMenu.getUserChoice();		
		
		switch (choice) 
		{
		case 1:
			System.out.println("Please enter the ID you would like to search for");
			String IDrequest = input.nextLine();
			//  call to method that will see if the ID input exists and will print out the ingredient if it does  \\
			ManageIngredients.searchIngredientID(IDrequest, ingred);
			break;
		case 2:
			System.out.println("\t");
			System.out.println("Please enter the name of the ingredient you would like to search for");
			String nameRequest = input.nextLine();
			
			//  call to method to see if an ingredient has the exact name the user entered, if not, it will return - 1
			if(ManageIngredients.searchIngredientName(nameRequest, ingred) != -1)
			{
				System.out.println("The ingredient has been found !");
				System.out.println(ingred.get(ManageIngredients.searchIngredientName(nameRequest, ingred)));
				System.out.println("\t");

			}
			else
			{
				System.out.println("This ingredient has not been found");
				System.out.println("\t");
			}
			
			break;
			
		case 3:
			
			System.out.println("");
			System.out.println("Enter the part of the name of the ingredient you wish to find: ");
			String part = input.nextLine();
			int num = 0;
			
			//  checks the name of each ingredient to see if it contains the characters that the user has input  \\
			for(int i = 0; i < ingred.size(); i++)
			{
				if(ingred.get(i).getName().contains(part))
				{
					num ++;
					System.out.println(num + ". " + ingred.get(i));
				}
			}
			
			//  if no ingredients contain the characters, the user will be informed that no ingredients contain the characters  \\
			if(num == 0)
			{
				System.out.println("No ingredients contain '" + part + "'");
			}
			
			System.out.println("");
			
			break;
			
		case 4:
			
			System.out.println("\t");
			System.out.println("Select an ingredient food group: ");
			//  call to method that allows user to select a food group  \\
			FoodGroup fg = ManageIngredients.selectFoodGroup();
			
			int fgNum = 0;
			
			//  for loop to check what ingredients belong to the selected food group and prints out those ingredients  \\
			for(int i = 0; i < ingred.size(); i++)
			{
				if(ingred.get(i).getFoodGroup() == fg)
				{
					fgNum++;
					System.out.println(fgNum + ". " + ingred.get(i));
				}
			}
			
			//  if no ingredients belong to the chosen food group, the user will be informed  \\
			if(fgNum == 0)
			{
				System.out.println("No ingredients are in this food group");
			}
			
			System.out.println("\t");

			break;
		case 5:
			break;
		}
	}
	
	/**
	 * Method that is used to give user options on how to update Ingredients and update it accordingly 
	 */
	public static void updateIngredients()
	{
		System.out.println("");
		int value = 0;
		
		//  call to method that displays all ingredients in system  \\
		Resources.viewIngredients(ingred);
		//  call to method that returns the a number which will be the index of the ingredients they have selected  \\
		value = Resources.selection("Select an ingredient you would like to update: ", ingred.size(), input);
		input.nextLine();
		
		//  creating a menu to give the user update options  \\
		String options [] = {"Name", "Food Group", "Calories"};
		Menu ingredEdit = new Menu("SELECT THE PART OF THE INGREDIENT YOU WOULD LIKE TO EDIT: ", options);
		int choice = ingredEdit.getUserChoice();
		
		//  switch case used to execute methods based on user input  \\
		switch(choice)
		{
			case 1:
				//  call to method to validate new ingredient name  \\
				ManageIngredients.ingredName(ingred.get(value-1), input, ingred);
				System.out.println("Ingredient name successfully updated !");
				break;
				
			case 2:
				//  call to method to validate new ingredient food group  \\
				ingred.get(value -1).setFoodGroup(ManageIngredients.selectFoodGroup());
				System.out.println("Ingredient food type successfully updated !");
				break;
			case 3:
				//  call to method to validate new ingredient calories  \\
				ManageIngredients.ingredCalories(ingred.get(value-1), input);
				System.out.println("Ingredient calories successfully updated !");
				break;
		}
	}
	
	/**
	 * Method used to let user select and delete an ingredient
	 */
	public static void deleteIngredients()
	{
		System.out.println("");
		int value = 0;
		//  call to method that displays all ingredients in system  \\
		Resources.viewIngredients(ingred);
		//  call to method that returns the a number which will be the index of the ingredients they have selected  \\
		value = Resources.selection("Select an ingredient you would like to delete: ", ingred.size(), input);
				
		input.nextLine();
		//  removing the ingredient the user has selected  \\
		ingred.remove(value-1);
		
		System.out.println("INGREDIENT SUCCESSFULLY DELETED !!");
	}
	
	
	//  MANAGING RECIPES CODE  \\
	
	/**
	 * Method that shows a menu to give the user options as to what they would like to do in regards to the Recipes stored in the system
	 */
	public static void manageRecipes()
	{
		//  menu used for managing ingredients  \\
		String [] opt = new String [] {"ADD", "VIEW", "SEARCH", "EDIT", "DELETE", "QUIT"};
		Menu manageRecipesMenu = new Menu("MANAGE RECIPES", opt);
		System.out.println("");
		int choice = manageRecipesMenu.getUserChoice();
		
		//  call to a methods that sort the ingredients and recipes into alphabetical order  \\
		recipes = ManageRecipes.sortRecipes(recipes);
		ingred = ManageIngredients.sortIngredients(ingred);

		//  switch case used to execute methods based on user input  \\
		switch (choice) 
		{
		case 1:
			Recipe rec = new Recipe();
			addRec(rec);
			break;
		case 2:
			viewRec();
			break;
		case 3:
			searchRec();
			break;
		case 4:
			editRec();
			break;
		case 5:
			recDelete();
		case 6:
			System.out.println("");
			break;
			
		}
		
	}
 
	/**
	 * Method used to add a Recipe 
	 * @param rec - the Recipe object that the data is being set to 
	 */
	public static void addRec(Recipe rec)
	{
		//  gets the name of the recipe from user input  \\
		ManageRecipes.recName(rec, input, recipes);
		
		//  gets the portion size of the recipe from user input  \\
		ManageRecipes.recPortionSize(rec, input);
		
		//  gets the recipe type from user input  \\
		rec.setRecipeType(ManageRecipes.selectMealType());
		
		//  gets the recipe ingredients from user input  \\
		ArrayList <RecipeIngredient> recIng = new ArrayList <RecipeIngredient> ();
		ManageRecipes.gatherRecipeIngredients(recIng, ingred, input);
		rec.setRecIng(recIng);
		
		//  gets the recipe steps from user input  \\
		ManageRecipes.recSteps(rec, input);

		//  sets the recipe ID  \\
		rec.setID();
		
		System.out.println("YOU HAVE SUCCESSFULLY ADDED A RECIPE !!");
		System.out.println("");
		
		//  adds new recipe to the recipe arrayList  \\
		recipes.add(rec);
		
		// organising array list into alphabetical order for when its displayed  \\
		recipes = ManageRecipes.sortRecipes(recipes);
	}
	
	/**
	 * Method that displays all Recipes in the system
	 */
	public static void viewRec()
	{
		//  for loop that displays each recipe stores in the recipe array list  \\
		for(int i = 0; i < recipes.size(); i++)
		{
			System.out.println("-------------------------");
			System.out.println(recipes.get(i));
			System.out.println("-------------------------");
		}
	}
	
	/**
	 * Method used to give user search options and carry out the search according to their input  
	 */
	public static void searchRec()
	{
		//  sub menu to display the search options to the user  \\
		String [] opt = new String [] {"ID", "NAME", "PART-NAME"};
		Menu searchRecipesMenu = new Menu("SEARCH RECIPES", opt);
		System.out.println("");
		int choice = searchRecipesMenu.getUserChoice();
		
		//  switch case used to execute methods based on user input  \\
		switch (choice) 
		{
		case 1:
			
			System.out.println("Please enter the ID you would like to search for");
			String IDrequest = input.nextLine();
			//  call to method that will check to see if the ID entered by the user exists, and will print out the recipe if it does  \\
			ManageRecipes.searchRecipeID(IDrequest, recipes);
			break;
		case 2:
			
			System.out.println("\t");
			System.out.println("Please enter the name of the recipe you would like to search for");
			String nameRequest = input.nextLine();
			
			//  call to a method to see if the exact recipe name entered by a user exists, if it doesn't, the method returns -1  \\
			if(ManageRecipes.searchRecipeName(nameRequest, recipes) != -1)
			{
				System.out.println("The recipe has been found !");
				System.out.println(recipes.get(ManageRecipes.searchRecipeName(nameRequest, recipes)));
				System.out.println("\t");

			}
			else
			{
				System.out.println("This recipe has not been found");
				System.out.println("\t");
			}
			
			break;
			
		case 3:
			
			System.out.println("");
			System.out.println("Enter the part of the name of the recipe you wish to find: ");
			String part = input.nextLine();
			int num = 0;
			
			System.out.println("These are the recipes that contain '" + part + "'");
			
			//  for loop that checks if the characters that have been entered are present in any of the recipe names present  \\
			for(int i = 0; i < recipes.size(); i++)
			{
				if(recipes.get(i).getRecipeName().toLowerCase().contains(part.toLowerCase()))
				{
					num ++;
					System.out.println(num + ". " + recipes.get(i));
				}
			}
			
			if(num == 0)
			{
				System.out.println("No recipes contain '" + part + "'");
			}
			
			System.out.println("");
			
			break;
		
		case 4:
			break;
		}
	}
	
	/**
	 * Method that is used to give user options on how to edit Recipes and update it accordingly 
	 */
	public static void editRec()
	{
		int value = 0;
		
		//  displaying the recipe names for the user to select one  \\
		for(int i = 0; i < recipes.size(); i++)
		{
			System.out.println((i+1) + ". " + recipes.get(i).getRecipeName());
		}
		
		//  call to method that returns the int the user has chose which will be the position of the recipe in the recipe array list  \\
		value = Resources.selection("SELECT A RECIPE YOU WOULD LIKE TO UPDATE", recipes.size(), input);
		
		System.out.println(" ");
		input.nextLine();
		
		//  sub menu to give user choice of which aspect of the recipe they would like to edit  \\
		String options[] = { "Name", "Portion Size", "Recipe Type", "Ingredients", "Steps", "Quit"};
		Menu recEdit = new Menu("SELECT WHICH PART OF RECIPE YOU WOULD LIKE TO EDIT: ", options);
		int choice = recEdit.getUserChoice();
		
		//  switch case used to execute methods based on user input  \\
		switch (choice) 
		{
			case 1:
				//  call to a method that will set the new name the user has entered  \\
				ManageRecipes.recName(recipes.get(value -1), input, recipes);
				System.out.println("RECIPE NAME UPDATED");
				break;
			case 2:
				//  call to a method that will set the new portion size the user has entered  \\
				ManageRecipes.recPortionSize(recipes.get(value -1), input);
				System.out.println("RECIPE PORTION SIZE UPDATED");
				break;
			case 3:
				//  call to a method that will set the new recipe type the user has entered  \\
				recipes.get(value -1).setRecipeType(ManageRecipes.selectMealType());
				System.out.println("RECIPE MEAL TYPE UPDATED");
				break;
			case 4:
				
				for(int i = 0; i < recipes.get(value -1).getRecipeIngredients().size(); i++)
				{
					recipes.get(value -1).getRecipeIngredients().remove(i);
				}
				
				ArrayList <RecipeIngredient> recIng = new ArrayList <RecipeIngredient> ();
				//  call to a method that will let the user select new recipe ingredients  \\
				ManageRecipes.gatherRecipeIngredients(recIng, ingred, input);
				recipes.get(value -1).setRecIng(recIng);
				System.out.println("RECIPE INGREDIENTS UPDATED");
				break;
				
			case 5:
				
				for(int i = 0; i < recipes.get(value -1).getInstructions().size(); i++)
				{
					recipes.get(value -1).getInstructions().remove(i);
				}
				
				//  call to a method that will let the user add new recipe steps  \\
				ManageRecipes.recSteps(recipes.get(value -1), input);
				System.out.println("RECIPE STEPS UPDATED");
				break;
				
			default:
				break;
		}
		
	}
	
	/**
	 * Method that will let user select and delete a Recipe object from the system 
	 */
	public static void recDelete()
	{
		System.out.println("");
		int value = 0;
		
		//  for loop that prints the name of all the recipes saved in the system  \\
		for(int i = 0; i < recipes.size(); i++)
		{
			System.out.println((i+1) + ". " + recipes.get(i).getRecipeName());
		}
		
		//  call to method that will return an int which can be used to access the recipe they have selected in the recipes array list  \\
		value = Resources.selection("SELECT A RECIPE YOU WOULD LIKE TO DELETE", recipes.size(), input);

		input.nextLine();
		//  removes recipe the user has selected  \\
		recipes.remove(value-1);
		
		System.out.println("RECIPE SUCCESSFULLY DELETED !!");
	}
	
	/**
	 * Method that will give the user options as to how they would like to manage the weekly menu
	 */
	public static void manageWeeklyMenu()
	{
		//  menu that allows the user to manage the weekly menu  \\
		String [] opt = new String [] {"ADD OR EDIT MEALS", "VIEW MEALS", "QUIT"};
		Menu manageWeeklyMenu = new Menu("MANAGE WEEKLY MENU", opt);
		System.out.println("");
		int choice = manageWeeklyMenu.getUserChoice();

		//  switch case used to execute methods based on user input  \\
		switch (choice) 
		{
		case 1:
			addToWeeklyMenu();
			break;
		case 2:
			viewWeeklyMenu();
			break;
		case 3:
			break;
		}
	}
	
	/**
	 * Method that will let the user select a day for which they want to add meals to
	 */
	public static void addToWeeklyMenu()
	{
		//  sub menu of the days of the week  \\
		String [] opt = new String [] {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
		Menu daysOfWeek = new Menu("SELECT A DAY TO ADD MEALS TO: ", opt);
		int choice = daysOfWeek.getUserChoice();
		
		//  switch case used to execute methods based on user input  \\
		switch (choice) 
		{
		case 1:
			getAllMenuItems(choice);
			break;
		case 2:
			getAllMenuItems(choice);
			break;
		case 3:
			getAllMenuItems(choice);
			break;
		case 4:
			getAllMenuItems(choice);
			break;
		case 5:
			getAllMenuItems(choice);
			break;
		}
		
	}
	
	/**
	 * Method that displays the weekly menu 
	 */
	public static void viewWeeklyMenu()
	{
		System.out.println("");
		System.out.println("*****WEEKLY MENU*****");
		System.out.println("MONDAY | " + Menu[0][0] + " | " +  Menu[0][1] + " | "  + Menu[0][2]);
		System.out.println("TUESDAY | " + Menu[1][0] + " | " +  Menu[1][1] + " | "  + Menu[1][2]);
		System.out.println("WEDNESDAY | " + Menu[2][0] + " | " +  Menu[2][1] + " | "  + Menu[2][2]);
		System.out.println("THURSDAY | " + Menu[3][0] + " | " +  Menu[3][1] + " | "  + Menu[3][2]);
		System.out.println("FRIDAY | " + Menu[4][0] + " | " +  Menu[4][1] + " | "  + Menu[4][2]);
		System.out.println("");
	}
	
	/**
	 * Method that gets the meals for a given day
	 * @param choice - the choice input by the user which indicated the day they wish to add a meal to 
	 */
	public static void getAllMenuItems(int choice)
	{
		selectMenuItem("Starter", MealType.STARTER, choice, 0);
		selectMenuItem("Main", MealType.MAIN, choice, 1);
		selectMenuItem("Desert", MealType.DESSERT, choice, 2);
	}
	
	/**
	 * Method that allows the user to select a certain meal - eg - a starter
	 * @param mealType - the name of meal being selected 
	 * @param MT - the type of meal being selected 
	 * @param choice -  the day of the week that the meal will be saved to 
	 * @param mealTypeNo - number gives indication if the meal is a starter, main or dessert 
	 */
	public static void selectMenuItem(String mealType, MealType MT, int choice, int mealTypeNo)
	{
		int numberOfChoice = 0;
		int displayNo = 1;
		ArrayList <String> choices = new ArrayList <String>();
		
		//  for loop that prints out all meals that are the meal type that is passed through as a parameter - eg - shows all starters  \\
		System.out.println("\n Select a " + mealType + " :");
		
		for(int i = 0; i < recipes.size(); i++)
		{
			if(recipes.get(i).getRecipeType() == MT)
			{
				System.out.println(displayNo + ". " + recipes.get(i).getRecipeName());
				choices.add(recipes.get(i).getRecipeName());
				numberOfChoice++;
				displayNo++;
			}
		}
		

		int value = 0;
		
		//  call to method that will return an int which can be used to access the name of the recipe they have selected in the choices string array list  \\
		value = Resources.selection("Select the number of the meal you would like to choose", numberOfChoice , input);
		
		//  adds the name of the meal to the correct day at the correct meal type position  \\
		Menu[choice-1][mealTypeNo] = choices.get(value-1);
	}
}