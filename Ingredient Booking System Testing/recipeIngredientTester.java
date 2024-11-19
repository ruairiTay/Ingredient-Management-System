package part02;

import part01.CustomException;
import part01.FoodGroup;
import part01.Ingredient;
import part01.RecipeIngredient;
import part01.Mass;

public class recipeIngredientTester {

	static Ingredient ing = new Ingredient();
	
	public static void main(String[] args) 
	{
		testCase1();
		testCase2();
		testCase3();
		testCase4();
		testCase5();
		testCase6_7();
		testCase8();
		testCase9();
	}
	
	private static void testCase1()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("RI_TC1 - Testing the 'setAmount' setter in the RecipeIngredient class with null data ");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		RecipeIngredient RI = new RecipeIngredient();
		String amount = null;
		System.out.println("Actual Result: ");
		
		try
		{
			RI.setAmount(amount);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Mass amount: " + RI.getAmount());
		
		System.out.println("++++++++++++++++ RI_TC1 ++++++++++++++++");
	}
	
	private static void testCase2()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("RI_TC2 - Testing the 'setAmount' setter in the RecipeIngredient class when the amount = '  ' ");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		RecipeIngredient RI = new RecipeIngredient();
		String amount = " ";
		System.out.println("Actual Result: ");
		
		try
		{
			RI.setAmount(amount);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Mass amount: " + RI.getAmount());
		
		System.out.println("++++++++++++++++ RI_TC2 ++++++++++++++++");
	}
	
	private static void testCase3()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("RI_TC3 - Testing the 'setAmount' setter in the RecipeIngredient class when the amount = '-78' ");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		RecipeIngredient RI = new RecipeIngredient();
		String amount = "-78";
		System.out.println("Actual Result: ");
		
		try
		{
			RI.setAmount(amount);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Mass amount: " + RI.getAmount());
		
		System.out.println("++++++++++++++++ RI_TC3 ++++++++++++++++");
	}
	
	private static void testCase4()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("RI_TC4 - Testing the 'setAmount' setter in the RecipeIngredient class when the amount = '78' ");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The massAmount will be set to 78");
		RecipeIngredient RI = new RecipeIngredient();
		String amount = "78";
		System.out.println("Actual Result: ");
		
		try
		{
			RI.setAmount(amount);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Mass amount: " + RI.getAmount());
		
		System.out.println("++++++++++++++++ RI_TC4 ++++++++++++++++");
	}
	
	private static void testCase5()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("RI_TC5 - Testing the 'setMassDescription' setter in the RecipeIngredient class");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The massDescription will be set to whatever mass description is selected");
		RecipeIngredient RI = new RecipeIngredient();
		Mass m = Mass.G;
		System.out.println("Actual Result: ");
		
		RI.setMassDescription(m);
		
		System.out.println("Mass description: " + RI.getMassDescription());
		
		System.out.println("++++++++++++++++ RI_TC5 ++++++++++++++++");
	}
	
	private static void testCase6_7()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("RI_TC6/7 - Testing construction of RecipeIngredient class with valid parameters");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: the object will be instantiated");
		RecipeIngredient RI = new RecipeIngredient();
		Mass m = Mass.G;
		System.out.println("Actual Result: ");
		
		try
		{
			Ingredient I1 = new Ingredient("Oranges", FoodGroup.FandV, "33");
			RI = new RecipeIngredient (I1, "56", m, "Peeled");
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println(RI);
		System.out.println("Recipe ingredient ID: " + RI.getIngredient().getID());
		
		System.out.println("++++++++++++++++ RI_TC6/7 ++++++++++++++++");
	}
	
	private static void testCase8()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("RI_TC8 - Testing construction of RecipeIngredient class with invalid parameters");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: the object will not be instantiated");
		RecipeIngredient RI = new RecipeIngredient();
		Mass m = Mass.G;
		System.out.println("Actual Result: ");
		
		try
		{
			Ingredient I1 = new Ingredient("Oranges", FoodGroup.FandV, "35");
			RI = new RecipeIngredient (I1, "  ", m, "Peeled");
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
				
		System.out.println("++++++++++++++++ RI_TC8 ++++++++++++++++");
	}
	
	private static void testCase9()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("RI_TC9 - Testing caloriesPerAmount() method");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: the method will return 18");
		RecipeIngredient RI = new RecipeIngredient();
		Mass m = Mass.G;
		System.out.println("Actual Result: ");
		
		try
		{
			Ingredient I1 = new Ingredient("Oranges", FoodGroup.FandV, "33");
			RI = new RecipeIngredient (I1, "56", m, "Peeled");
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		double result = RI.caloriesPerAmount();
		
		System.out.println("Result: " + result);
		
		System.out.println("++++++++++++++++ RI_TC9 ++++++++++++++++");
	}

}
