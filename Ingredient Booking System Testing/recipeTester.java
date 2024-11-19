package part02;

import part01.RecipeIngredient;
import part01.CustomException;
import part01.FoodGroup;
import part01.Ingredient;
import part01.Mass;
import part01.Recipe;
import part01.MealType;
import java.util.ArrayList;

public class recipeTester {

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
		testCase12_13();
		testCase14();
	}
	
	private static void testCase1()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("R_TC1 - Testing the 'setRecipeName' setter in the Recipe class with null data ");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Recipe rec = new Recipe();
		String name = null;
		System.out.println("Actual Result: ");
		
		try
		{
			rec.setRecipeName(name);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe name: " + rec.getRecipeName());
		
		System.out.println("++++++++++++++++ R_TC1 ++++++++++++++++");
	}
	
	private static void testCase2()
	{
		System.out.println("\n");
		System.out.println("R_TC2 - Testing the 'setRecipeName' setter in the Recipe class when name = '  '");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Recipe rec = new Recipe();
		String name = "  ";
		System.out.println("Actual Result: ");
		
		try
		{
			rec.setRecipeName(name);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe name: " + rec.getRecipeName());
		
		System.out.println("++++++++++++++++ R_TC2 ++++++++++++++++");
	}
	
	private static void testCase3()
	{
		System.out.println("\n");
		System.out.println("R_TC3 - Testing the 'setRecipeName' setter in the Recipe class when name = 'lasagne'");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: the recipe name will be set to 'lasagne'");
		Recipe rec = new Recipe();
		String name = "lasagne";
		System.out.println("Actual Result: ");
		
		try
		{
			rec.setRecipeName(name);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe name: " + rec.getRecipeName());
		
		System.out.println("++++++++++++++++ R_TC3 ++++++++++++++++");
	}
	
	private static void testCase4()
	{
		System.out.println("\n");
		System.out.println("R_TC4 - Testing the 'setRecPortionSize' setter in the Recipe class when portionSize is null");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Recipe rec = new Recipe();
		String portionSize = null;
		System.out.println("Actual Result: ");
		
		try
		{
			rec.setRecPortionSize(portionSize);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe name: " + rec.getRecipePortionSize());
		
		System.out.println("++++++++++++++++ R_TC4 ++++++++++++++++");
	}
	
	private static void testCase5()
	{
		System.out.println("\n");
		System.out.println("R_TC5 - Testing the 'setRecPortionSize' setter in the Recipe class when portionSize = '-3'");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Recipe rec = new Recipe();
		String portionSize = "-3";
		System.out.println("Actual Result: ");
		
		try
		{
			rec.setRecPortionSize(portionSize);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe name: " + rec.getRecipePortionSize());
		
		System.out.println("++++++++++++++++ R_TC5 ++++++++++++++++");
	}
	
	private static void testCase6()
	{
		System.out.println("\n");
		System.out.println("R_TC6 - Testing the 'setRecPortionSize' setter in the Recipe class when portionSize = '3'");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The recipe portion size will be set to 3");
		Recipe rec = new Recipe();
		String portionSize = "3";
		System.out.println("Actual Result: ");
		
		try
		{
			rec.setRecPortionSize(portionSize);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe portion size: " + rec.getRecipePortionSize());
		
		System.out.println("++++++++++++++++ R_TC6 ++++++++++++++++");
	}
	
	private static void testCase7()
	{
		System.out.println("\n");
		System.out.println("R_TC7 - Testing the 'setRecipeIngredints' setter in the Recipe class");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The recipe ingredients will be set to the array list passed into the setter");
		Recipe rec = new Recipe();
		System.out.println("Actual Result: ");
		ArrayList <RecipeIngredient> recIng = new ArrayList <RecipeIngredient> ();
		
		try
		{
			Ingredient I1 = new Ingredient("Oranges", FoodGroup.FandV, "33");
			RecipeIngredient RI1 = new RecipeIngredient (I1, "56", Mass.G, "Peeled");
			Ingredient I2 = new Ingredient("Apples", FoodGroup.FandV, "33");
			RecipeIngredient RI2 = new RecipeIngredient (I2, "56", Mass.G, "Peeled");
			recIng.add(RI1);
			recIng.add(RI2);

			rec.setRecIng(recIng);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe Ingredients: " + rec.getRecipeIngredients());
		
		System.out.println("++++++++++++++++ R_TC7 ++++++++++++++++");
	}
	
	private static void testCase8()
	{
		System.out.println("\n");
		System.out.println("R_TC8 - Testing the 'setRecipeType' setter in the Recipe class");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The recipe type will be set to starter");
		Recipe rec = new Recipe();
		MealType mt = MealType.STARTER;
		System.out.println("Actual Result: ");
		
		rec.setRecipeType(mt);
		
		System.out.println("Recipe Meal Type: " + rec.getRecipeType());
		
		System.out.println("++++++++++++++++ R_TC8 ++++++++++++++++");
	}
	
	private static void testCase9()
	{
		System.out.println("\n");
		System.out.println("R_TC9 - Testing the 'setInstructions' setter in the Recipe class with null data");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Recipe rec = new Recipe();
		System.out.println("Actual Result: ");
		String step1 = null;
		String step2 = null;
		ArrayList <String> instrutions  = new ArrayList <String> ();
		instrutions.add(step1);
		instrutions.add(step2);
		
		
		try
		{
			rec.setInstructions(instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe Steps: " + rec.getInstructions());
		
		System.out.println("++++++++++++++++ R_TC9 ++++++++++++++++");
	}
	
	private static void testCase10()
	{
		System.out.println("\n");
		System.out.println("R_TC10 - Testing the 'setInstructions' setter in the Recipe class when step1 = '  ' and step2 = '  '");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Recipe rec = new Recipe();
		System.out.println("Actual Result: ");
		String step1 = "  ";
		String step2 = "  ";
		ArrayList <String> instrutions  = new ArrayList <String> ();
		instrutions.add(step1);
		instrutions.add(step2);
		
		
		try
		{
			rec.setInstructions(instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe Steps: " + rec.getInstructions());
		
		System.out.println("++++++++++++++++ R_TC10 ++++++++++++++++");
	}
	
	private static void testCase11()
	{
		System.out.println("\n");
		System.out.println("R_TC11 - Testing the 'setInstructions' setter in the Recipe class when step1 = 'cook' and step2 = 'eat'");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The recipe instructions will be set to the instructions passed into the setter");
		Recipe rec = new Recipe();
		System.out.println("Actual Result: ");
		String step1 = "cook";
		String step2 = "eat";
		ArrayList <String> instrutions  = new ArrayList <String> ();
		instrutions.add(step1);
		instrutions.add(step2);
		
		
		try
		{
			rec.setInstructions(instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Recipe Steps: " + rec.getInstructions());
		
		System.out.println("++++++++++++++++ R_TC11 ++++++++++++++++");
	}
	
	private static void testCase12_13()
	{
		System.out.println("\n");
		System.out.println("R_TC12_13 - Testing construction of Recipe class with valid parameters");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The object will be instantiated");
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

			rec = new Recipe("lasagne", "3", recIng, MealType.STARTER, instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println(rec);
		System.out.println("Recipe ID: " + rec.getRecipeID());
		
		System.out.println("++++++++++++++++ R_TC12_13 ++++++++++++++++");
	}
	
	private static void testCase14()
	{
		System.out.println("\n");
		System.out.println("R_TC14 - Testing construction of Recipe class with invalid parameters");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The object will be instantiated");
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

			rec = new Recipe("", "-3", recIng, MealType.MAIN, instrutions);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
				
		System.out.println("++++++++++++++++ R_TC14 ++++++++++++++++");
	
	}
	
	

}
