package part02;

import java.util.ArrayList;

import part01.CustomException;
import part01.FoodGroup;
import part01.Ingredient;
import part01.ManageRecipes;
import part01.Mass;
import part01.MealType;
import part01.Recipe;
import part01.RecipeIngredient;
import part01.Resources;

public class manageRecipeTester {

	static ArrayList <Recipe> sorted = new ArrayList <Recipe>();
	static ArrayList <Ingredient> ing = new ArrayList <Ingredient> ();
	
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
		System.out.println("MR_TC1 - Inserting first element into Recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");
		
		Recipe rec = new Recipe();
		System.out.println("Actual Result: ");
		String step1 = "cook";
		String step2 = "eat";
		ArrayList <String> instrutions  = new ArrayList <String> ();
		ArrayList <RecipeIngredient> recIng = new ArrayList <RecipeIngredient> ();
		instrutions.add(step1);
		instrutions.add(step2);
		
		
		try
		{
			Ingredient I1 = new Ingredient("Oranges", FoodGroup.FandV, "33");
			RecipeIngredient RI1 = new RecipeIngredient (I1, "56", Mass.G, "Peeled");
			Ingredient I2 = new Ingredient("Apples", FoodGroup.FandV, "33");
			RecipeIngredient RI2 = new RecipeIngredient (I2, "56", Mass.G, "Peeled");
			recIng.add(RI1);
			recIng.add(RI2);
			rec = new Recipe("lasagne", "3", recIng, MealType.MAIN, instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Before: " + sorted);
		
		ManageRecipes.insertRecipes(rec,sorted);

		System.out.print("After: ");
		
		displayNames(sorted);

		System.out.println("\t");
		System.out.println("++++++++++++++++ MR_TC1 ++++++++++++++++");
	}
	
	public static void testCase2()
	{
		sorted.clear();
		Recipe.IDNumber = 1;
		System.out.println("\n");
		System.out.println("MR_TC2 - sorting a Recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Before: ");
		
		try
		{
			Resources.preSavedInfo(ing, sorted);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		displayNames(sorted);
		
		System.out.println("\t");
		System.out.println("After: ");
		sorted = ManageRecipes.sortRecipes(sorted);
		displayNames(sorted);

		System.out.println("\t");
		System.out.println("++++++++++++++++ MR_TC2 ++++++++++++++++");
	}
	
	public static void testCase3()
	{
		System.out.println("\n");
		System.out.println("MR_TC3 - inserting an instance of the Recipe class into the middle of a sorted Recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Before: ");
		
		//  the array list is still holding the data from testCase2 where is was sorted into alphabetical order  \\
		displayNames(sorted);
		Recipe rec = new Recipe ();		
		String step1 = "cook";
		String step2 = "eat";
		ArrayList <String> instrutions  = new ArrayList <String> ();
		ArrayList <RecipeIngredient> recIng = new ArrayList <RecipeIngredient> ();
		instrutions.add(step1);
		instrutions.add(step2);
		
		try
		{
			Ingredient I1 = new Ingredient("Carrots", FoodGroup.FandV, "33");
			RecipeIngredient RI1 = new RecipeIngredient (I1, "56", Mass.G, "");
			Ingredient I2 = new Ingredient("Pork", FoodGroup.M_and_P, "33");
			RecipeIngredient RI2 = new RecipeIngredient (I2, "56", Mass.G, "Peeled");
			recIng.add(RI1);
			recIng.add(RI2);
			rec = new Recipe("Casserole", "3", recIng, MealType.MAIN, instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		ManageRecipes.insertRecipes(rec, sorted);
		
		System.out.println("\t");
		System.out.println("After: ");
		displayNames(sorted);

		System.out.println("\t");
		System.out.println("++++++++++++++++ MR_TC3 ++++++++++++++++");
	}
	
	public static void testCase4()
	{
		System.out.println("\n");
		System.out.println("MR_TC4 - inserting an instance of the Recipe class into the start of a sorted Recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Before: ");
		
		//  the array list is still holding the data from testCase2 where is was sorted into alphabetical order  \\
		displayNames(sorted);
		Recipe rec = new Recipe ();		
		String step1 = "cook";
		String step2 = "eat";
		ArrayList <String> instrutions  = new ArrayList <String> ();
		ArrayList <RecipeIngredient> recIng = new ArrayList <RecipeIngredient> ();
		instrutions.add(step1);
		instrutions.add(step2);
		
		try
		{
			Ingredient I1 = new Ingredient("Beef", FoodGroup.M_and_P, "33");
			RecipeIngredient RI1 = new RecipeIngredient (I1, "56", Mass.G, "");
			Ingredient I2 = new Ingredient("Gravy", FoodGroup.COMPFOOD, "33");
			RecipeIngredient RI2 = new RecipeIngredient (I2, "56", Mass.G, "");
			recIng.add(RI1);
			recIng.add(RI2);
			rec = new Recipe("Angus Beef", "3", recIng, MealType.MAIN, instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		ManageRecipes.insertRecipes(rec, sorted);
		
		System.out.println("\t");
		System.out.println("After: ");
		displayNames(sorted);

		System.out.println("\t");
		System.out.println("++++++++++++++++ MR_TC4 ++++++++++++++++");
	}
	
	public static void testCase5()
	{
		System.out.println("\n");
		System.out.println("MR_TC5 - inserting an instance of the Recipe class into the end of a sorted Recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Before: ");
		
		//  the array list is still holding the data from testCase2 where is was sorted into alphabetical order  \\
		displayNames(sorted);
		Recipe rec = new Recipe ();		
		String step1 = "cook";
		String step2 = "eat";
		ArrayList <String> instrutions  = new ArrayList <String> ();
		ArrayList <RecipeIngredient> recIng = new ArrayList <RecipeIngredient> ();
		instrutions.add(step1);
		instrutions.add(step2);
		
		try
		{
			Ingredient I1 = new Ingredient("Flour", FoodGroup.CEREAL, "33");
			RecipeIngredient RI1 = new RecipeIngredient (I1, "56", Mass.G, "Sifted");
			Ingredient I2 = new Ingredient("Eggs", FoodGroup.COMPFOOD, "33");
			RecipeIngredient RI2 = new RecipeIngredient (I2, "56", Mass.G, "");
			recIng.add(RI1);
			recIng.add(RI2);
			rec = new Recipe("Waffles", "3", recIng, MealType.MAIN, instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		ManageRecipes.insertRecipes(rec, sorted);
		
		System.out.println("\t");
		System.out.println("After: ");
		displayNames(sorted);

		System.out.println("\t");
		System.out.println("++++++++++++++++ MR_TC5 ++++++++++++++++");
	}
	
	public static void testCase6()
	{
		System.out.println("\n");
		System.out.println("MR_TC6 - searching for an ID that exists in the Recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("ID being searched for: R1");
		ManageRecipes.searchRecipeID("R1", sorted);
		System.out.println("++++++++++++++++ MR_TC6 ++++++++++++++++");
	}
	
	public static void testCase7()
	{
		System.out.println("\n");
		System.out.println("MR_TC7 - searching for an ID that doesn't exist in the Recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("ID being searched for: R99");
		ManageRecipes.searchRecipeID("R99", sorted);
		System.out.println("++++++++++++++++ MR_TC7 ++++++++++++++++");
	}
	
	public static void testCase8()
	{
		System.out.println("\n");
		System.out.println("MR_TC8 - searching for a recipe name that is at the beginning of the Recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Recipe being searched for: Angus Beef");
		int position = ManageRecipes.searchRecipeName("Angus Beef", sorted);
		System.out.println(sorted.get(position));
		System.out.println("++++++++++++++++ MR_TC8 ++++++++++++++++");
	}
	
	public static void testCase9()
	{
		System.out.println("\n");
		System.out.println("MR_TC9 - searching for a recipe name that is in the middle of the recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Recipe being searched for: Casserole");
		int position = ManageRecipes.searchRecipeName("Casserole", sorted);
		
		if(position == -1)
		{
			System.out.println("Recipe not found");
		}
		else
		{
			System.out.println(sorted.get(position));

		}		
		
		System.out.println("++++++++++++++++ MR_TC9 ++++++++++++++++");
	}
	
	public static void testCase10()
	{
		System.out.println("\n");
		System.out.println("MR_TC10 - searching for a recipe name that is at the end of the recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Recipe being searched for: Waffles");
		int position = ManageRecipes.searchRecipeName("Waffles", sorted);
		
		if(position == -1)
		{
			System.out.println("Recipe not found");
		}
		else
		{
			System.out.println(sorted.get(position));

		}		
		
		System.out.println("++++++++++++++++ MR_TC10 ++++++++++++++++");
	}
	
	public static void testCase11()
	{
		System.out.println("\n");
		System.out.println("MR_TC11 - searching for a recipe name that is not in the recipe array list");
		System.out.println("++++++++++++++++++++++++++++++++");

		System.out.println("Recipe being searched for: Carbonarra");
		int position = ManageRecipes.searchRecipeName("Carbonarra", sorted);
		
		if(position == -1)
		{
			System.out.println("Recipe not found");
		}
		else
		{
			System.out.println(sorted.get(position));

		}		
		
		System.out.println("++++++++++++++++ MR_TC11 ++++++++++++++++");
	}
	
	private static void displayNames(ArrayList <Recipe> rec)
	{
		for(int i = 0; i < rec.size(); i++)
		{
			System.out.print(rec.get(i).getRecipeName() + ", ");
		}
	}


}
