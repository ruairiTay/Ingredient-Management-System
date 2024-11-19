package part01;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * Author : Ruairi Taylor
 * Student Number : 40406718
 * 
 * ManageIngredients class used to hold all methods associated with Ingredients to help code stay organised 
 * 
 */

public class ManageIngredients 
{
    /**
     * Displays options of the available food groups that the user can select from
     * @return a FoodGroup
     */
	public static FoodGroup selectFoodGroup() 
	{
		//  provides a sub menu to allow the user to enter the food group of the ingredient they are entering  \\
		String options[] = { "Fruit and Vegetables - 'Apples', 'Onions'", "Dairy Products - 'Milk', 'Cheese'", "Spices and Herbs - 'Paprika'", "Meats and Poultry - 'Chicken', 'Pork'", "Composite Foods - 'Beans', 'Pasta'", "Cereals - 'flour', 'granola'", "Fat Based Products - 'Olive Oil'", "Other" };
		Menu fgSelect = new Menu("Select a Food Group", options);
		int choice = fgSelect.getUserChoice();
		
		switch (choice) 
		{
			case 1:
				return FoodGroup.FandV;
			case 2:
				return FoodGroup.DAIRY;
			case 3:
				return FoodGroup.SPICES_AND_HERBS;
			case 4:
				return FoodGroup.M_and_P;
			case 5:
				return FoodGroup.COMPFOOD;
			case 6:
				return FoodGroup.CEREAL;
			case 7:
				return FoodGroup.FATS;
			default:
				return FoodGroup.OTHER;
		}
	}
	
    /**
     * Method used to get all details from the user needed to instantiate an instance of the Ingredient class
     * @param ing - Ingredient that the details will be added to 
     * @param input - scanner to gather user input 
     * @param ingreds - Ingredient array list used for doing a search in the 'ingredName' method  
     */
	public static void collectingDetails(Ingredient ing , Scanner input, ArrayList <Ingredient> ingreds)
	{
		input.nextLine();
		
		ingredName(ing, input, ingreds);
		
		System.out.println("");
		ing.setFoodGroup(selectFoodGroup());
		
		ingredCalories(ing, input);
		
		//  sets ingredient ID  \\
		ing.setID();
	}
	
	/**
	 * Method that gets a String as input from the user and checks its validity for the name field
	 * @param ing - the object that contains the name attribute the String is getting set to 
	 * @param input - scanner to allow for user input 
	 * @param ingreds - Ingredient array list used to conduct a search
	 */
	public static void ingredName(Ingredient ing, Scanner input, ArrayList <Ingredient> ingreds)
	{
		Boolean validName = false;
		
	    //  loop repeats until a valid string name is entered  \\
		do
		{
			//  getting name input from user  \\
			System.out.println("");
			System.out.println(Resources.PROMPT + "Enter ingredient name: ");
			String name = input.nextLine();
			
			//  check to see if the Ingredient input already exists in the system  \\
			if(searchIngredientName(name, ingreds) != -1) 
			{
				System.out.println("This ingredient in already in the system");
			}
			else
			{
				//  try catch block to catch any exceptions thrown when setting the name string  \\
				try
				{
					ing.setName(name);
					validName = true;
				}
				catch(CustomException e)
				{
					System.out.println(e.getErrorMessageM());
				}
			}
			
		}while(validName == false);
	}
	
	/**
	 * Method that gets a String as input from the user and checks its validity for the calorie field
	 * @param ing - the object that contains the attribute the String is getting set to 
	 * @param input - scanner to allow for user input 
	 */
	public static void ingredCalories(Ingredient ing, Scanner input)
	{
		Boolean validCalories = false;
		
		//  loop repeats until a valid string calories is entered  \\
		do
		{
			//  try catch block to catch any exceptions thrown when setting the calories string  \\
			try
			{
				System.out.println("");
				System.out.println(Resources.PROMPT + "Enter calories per 100g/100ml: ");
				String calories = input.nextLine();
				ing.setCalories(calories);
				validCalories = true;
			}
			catch(CustomException e)
			{
				System.out.println(e.getErrorMessageM());
			}
				
		}while(validCalories == false);
			
	}
	
	/**
	 * Method that sorts the data array list into alphabetical order by using the call to the insertion sort method
	 * @param data -  the array list that is getting sorted 
	 * @return - the alphabtically sorted array list 
	 */
	public static ArrayList <Ingredient> sortIngredients (ArrayList <Ingredient> data)
	{
		ArrayList <Ingredient> result = new ArrayList <Ingredient>();
		
		if(data != null)
		{
			if(data.size() != 0)
			{
				for(Ingredient ing : data)
				{
					insertIngredients(ing, result);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Insertion sort method that compares an instance of the Ingredient class to the data Ingredient array list and inserts it to the right spot in the list
	 * @param ing - the object being inserted to the list
	 * @param data - the list the object is being added to 
	 */
	public static void insertIngredients(Ingredient ing, ArrayList <Ingredient> data)
	{
		int position = 0;
		
		if(data.size() == 0)
		{
			data.add(ing);
		}
		else
		{
			String ing1 = ing.getName();
			
			for(position = 0; position < data.size(); position++)
			{
				String ing2 = data.get(position).getName();
				
				//  compares the element being added to the each element of the array list to see where it will be added  \\
				if(ing1.toLowerCase().compareTo(ing2.toLowerCase()) < 0)
				{
					break;
				}
			}
			
			//  adds ingredient to the correct position in the array list  \\
			data.add(position, ing);
		}
		
		
	}
	
	/**
	 * Method that takes an ID and checks to see if it exists in the availableID ingredient array list 
	 * @param ID - the ID being searched for 
	 * @param availableID - the array list that is being searched  
	 */
	public static void searchIngredientID(String ID, ArrayList <Ingredient> availableID)
	{
		int search = -1;
		
		//  for loop that compares the ID provided by the user to the existing IDs  \\
		for(int i = 0; i < availableID.size(); i++)
		{
			if(ID.equals(availableID.get(i).getID()))
			{
				System.out.println("The ingredient with this ID has been found !");
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
	 * Method conducts a binary search to see if an Ingredient name exists in the Ingredient array list
	 * @param name - the Ingredient name being searched for 
	 * @param ing - the list that is being searched
	 * @return - returns the position of the name if its found or '-1' if its not found  
	 */
	public static int searchIngredientName(String name, ArrayList <Ingredient> ing)
	{
		int start = 0;
		int end = ing.size()-1;
		
		do
		{
			//  sets middle point of array list  \\
			int pivot = start + (end-start)/2;
			
			//  compares the name entered with middle point and halves the array based on the outcome of comparing the two values  \\
			if(name.equalsIgnoreCase(ing.get(pivot).getName()))
			{
				return pivot;
			}
			else if(name.compareToIgnoreCase(ing.get(pivot).getName()) < 0)
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
