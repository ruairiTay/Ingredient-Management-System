package part02;
import part01.ManageIngredients;

import part01.Ingredient;
import part01.Resources;
import part01.Recipe;

import java.util.ArrayList;

import part01.FoodGroup;

public class manageIngredientTester {
	
	static ArrayList <Recipe> rec = new ArrayList <Recipe>();
	static ArrayList <Ingredient> sorted = new ArrayList <Ingredient> ();

	public static void main(String[] args) 
	{
		testCase1();
		testCase2();
		testCase3();
		testCase4();
		testCase5();
		testCase6();
		testCase7();
		testCase8();
		testCase9();
		testCase10();
		testCase11();
	}
	
	public static void testCase1()
	{
		System.out.println("MI_TC1 - Inserting first element into Ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");
		Ingredient ing = new Ingredient();
		
		try
		{
			ing = new Ingredient("Oranges", FoodGroup.FandV, "23");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

		System.out.println("Before: " + sorted);
		
		ManageIngredients.insertIngredients(ing, sorted);
		
		
		System.out.print("After: ");
		
		displayNames(sorted);

		System.out.println("\t");
		System.out.println("++++++++++++++++ MI_TC1 ++++++++++++++++");
	}
	
	public static void testCase2()
	{
		sorted.clear();
		Ingredient.IDNumber = 1;
		System.out.println("\n");
		System.out.println("MI_TC2 - sorting an Ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Before: ");
		
		try
		{
			Resources.preSavedInfo(sorted, rec);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		displayNames(sorted);
		
		System.out.println("\t");
		System.out.println("After: ");
		sorted = ManageIngredients.sortIngredients(sorted);
		displayNames(sorted);

		System.out.println("\t");
		System.out.println("++++++++++++++++ MI_TC2 ++++++++++++++++");
	}
	
	public static void testCase3()
	{
		System.out.println("\n");
		System.out.println("MI_TC3 - inserting an instance of the Ingredient class into the middle of a sorted Ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Before: ");
		
		//  the array list is still holding the data from testCase2 where is was sorted into alphabetical order  \\
		displayNames(sorted);
		Ingredient ing = new Ingredient();
		
		try
		{
			 ing = new Ingredient("Grapes", FoodGroup.FandV, "56");
		}
		catch(Exception e)
		{
			
		}
		
		ManageIngredients.insertIngredients(ing, sorted);
		
		System.out.println("\t");
		System.out.println("After: ");
		displayNames(sorted);

		System.out.println("\t");
		System.out.println("++++++++++++++++ MI_TC3 ++++++++++++++++");
	}
	
	public static void testCase4()
	{
		System.out.println("\n");
		System.out.println("MI_TC4 - inserting an instance of the Ingredient class into the beginning of a sorted Ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Before: ");
		
		//  the array list is still holding the data from testCase2 where is was sorted into alphabetical order  \\
		displayNames(sorted);
		Ingredient ing = new Ingredient();
		
		try
		{
			 ing = new Ingredient("Anchovies", FoodGroup.M_and_P, "56");
		}
		catch(Exception e)
		{
			
		}
		
		ManageIngredients.insertIngredients(ing, sorted);
		System.out.println("\t");
		System.out.println("After: ");
		displayNames(sorted);
		System.out.println("\t");
		System.out.println("++++++++++++++++ MI_TC4 ++++++++++++++++");
	}
	
	public static void testCase5()
	{
		System.out.println("\n");
		System.out.println("MI_TC5 - inserting an instance of the Ingredient class into the end of a sorted Ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Before: ");
		
		//  the array list is still holding the data from testCase2 where is was sorted into alphabetical order  \\
		displayNames(sorted);
		Ingredient ing = new Ingredient();
		
		try
		{
			 ing = new Ingredient("Walnuts", FoodGroup.CEREAL, "56");
		}
		catch(Exception e)
		{
			
		}
		
		ManageIngredients.insertIngredients(ing, sorted);
		System.out.println("\t");
		System.out.println("After: ");
		displayNames(sorted);
		System.out.println("\t");
		System.out.println("++++++++++++++++ MI_TC5 ++++++++++++++++");
	}
	
	public static void testCase6()
	{
		System.out.println("\n");
		System.out.println("MI_TC6 - searching for an ID that exists in the Ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("ID being searched for: I1");
		ManageIngredients.searchIngredientID("I1", sorted);
		System.out.println("++++++++++++++++ MI_TC6 ++++++++++++++++");
	}
	
	public static void testCase7()
	{
		System.out.println("\n");
		System.out.println("MI_TC7 - searching for an ID that doesn't exist in the Ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("ID being searched for: I99");
		ManageIngredients.searchIngredientID("I99", sorted);
		System.out.println("++++++++++++++++ MI_TC7 ++++++++++++++++");
	}
	
	public static void testCase8()
	{
		System.out.println("\n");
		System.out.println("MI_TC8 - searching for an ingredient name that is at the beginning of the ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Ingredient being searched for: Anchovies");
		int position = ManageIngredients.searchIngredientName("Anchovies", sorted);
		System.out.println(sorted.get(position));
		System.out.println("++++++++++++++++ MI_TC8 ++++++++++++++++");
	}
	
	public static void testCase9()
	{
		System.out.println("\n");
		System.out.println("MI_TC9 - searching for an ingredient name that is in the middle ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Ingredient being searched for: Grapes");
		int position = ManageIngredients.searchIngredientName("Grapes", sorted);
		
		if(position == -1)
		{
			System.out.println("Ingredient not found");
		}
		else
		{
			System.out.println(sorted.get(position));

		}		
		
		System.out.println("++++++++++++++++ MI_TC9 ++++++++++++++++");
	}
	
	public static void testCase10()
	{
		System.out.println("\n");
		System.out.println("MI_TC10 - searching for an ingredient name that is at the end of ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Ingredient being searched for: Walnuts");
		int position = ManageIngredients.searchIngredientName("Walnuts", sorted);
		
		if(position == -1)
		{
			System.out.println("Ingredient not found");
		}
		else
		{
			System.out.println(sorted.get(position));

		}
		
		System.out.println("++++++++++++++++ MI_TC10 ++++++++++++++++");
	}
	
	public static void testCase11()
	{
		System.out.println("\n");
		System.out.println("MI_TC11 - searching for an ingredient name that is not in the ingredient array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Ingredient being searched for: Pineapple");
		int position = ManageIngredients.searchIngredientName("Pineapple", sorted);
		
		if(position == -1)
		{
			System.out.println("Ingredient not found");
		}
		else
		{
			System.out.println(sorted.get(position));

		}
		
		System.out.println("++++++++++++++++ MI_TC11 ++++++++++++++++");
	}
	
	private static void displayNames(ArrayList <Ingredient> ingred)
	{
		for(int i = 0; i < ingred.size(); i++)
		{
			System.out.print(ingred.get(i).getName() + ", ");
		}
	}

}
