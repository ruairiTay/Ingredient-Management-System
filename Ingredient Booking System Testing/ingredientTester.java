package part02;
import part01.Ingredient;
import part01.CustomException;
import part01.FoodGroup;

public class ingredientTester {

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
		testCase9_10();
		testCase11();

	}
	
	private static void testCase1()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("ING_TC1 - Testing the 'setName' setter in the Ingredient class with null data ");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the name is invalid");
		Ingredient ing = new Ingredient();
		String name = null;
		System.out.println("Actual Result: ");
		
		try
		{
			ing.setName(name);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Ingredient name: " + ing.getName());
		
		System.out.println("++++++++++++++++ ING_TC1 ++++++++++++++++");
	}
	
	private static void testCase2()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC2 - Testing the 'setName' setter in the Ingredient class when name = '  ' ");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the name is invalid");
		Ingredient ing = new Ingredient();
		String name = "  ";
		System.out.println("Actual Result: ");
		
		try
		{
			ing.setName(name);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Ingredient name: " + ing.getName());
		
		System.out.println("++++++++++++++++ ING_TC2 ++++++++++++++++");
	}
	
	private static void testCase3()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC3 - Testing the 'setName' setter in the Ingredient class when name = 'Oranges' ");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The Ingredient name will be set to 'Oranges'");
		Ingredient ing = new Ingredient();
		String name = "Oranges";
		System.out.println("Actual Result: ");
		
		try
		{
			ing.setName(name);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Ingredient name: " + ing.getName());
		
		System.out.println("++++++++++++++++ ING_TC3 ++++++++++++++++");
	}
	
	private static void testCase4()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC4 - Testing the 'setFoodGroup' setter in the Ingredient class");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The foodType will be set to whatever food group is input");
		Ingredient ing = new Ingredient();
		FoodGroup fg = FoodGroup.DAIRY;
		System.out.println("Actual Result: ");
		
		ing.setFoodGroup(fg);
		
		System.out.println("Ingredient food type: " + ing.getFoodGroup());
		
		System.out.println("++++++++++++++++ ING_TC4 ++++++++++++++++");
	}
	
	private static void testCase5()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC5 - Testing the 'setCalories' setter in the Ingredient class with null data");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Ingredient ing = new Ingredient();
		String calories = null;
		System.out.println("Actual Result: ");
		
		try
		{
			ing.setCalories(calories);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Calories: " + ing.getCalories());
		
		System.out.println("++++++++++++++++ ING_TC5 ++++++++++++++++");
	}
	
	private static void testCase6()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC6 - Testing the 'setCalories' setter in the Ingredient class when calories = '  '");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Ingredient ing = new Ingredient();
		String calories = "  ";
		System.out.println("Actual Result: ");
		
		try
		{
			ing.setCalories(calories);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Calories: " + ing.getCalories());
		
		System.out.println("++++++++++++++++ ING_TC6 ++++++++++++++++");
	}
	
	private static void testCase7()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC7 - Testing the 'setCalories' setter in the Ingredient class when calories = '-3'");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: An exception will be thrown and caught, informing that the input is invalid");
		Ingredient ing = new Ingredient();
		String calories = "-3";
		System.out.println("Actual Result: ");
		
		try
		{
			ing.setCalories(calories);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Calories: " + ing.getCalories());
		
		System.out.println("++++++++++++++++ ING_TC7 ++++++++++++++++");
	}
	
	private static void testCase8()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC8 - Testing the 'setCalories' setter in the Ingredient class when calories = '33'");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: The calories will be set to 33");
		Ingredient ing = new Ingredient();
		String calories = "33";
		System.out.println("Actual Result: ");
		
		try
		{
			ing.setCalories(calories);
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println("Calories: " + ing.getCalories());
		
		System.out.println("++++++++++++++++ ING_TC8 ++++++++++++++++");
	}
	
	private static void testCase9_10()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC9/10 - Testing construction of Ingredient class with valid parameters'");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: the object will be instantiated with an ingredient ID of I1");
		Ingredient ing = new Ingredient();
		
		try
		{
			ing = new Ingredient("Oranges", FoodGroup.FandV, "33");
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println(ing);
		System.out.println("Ingredient ID: " + ing.getID());
		
		System.out.println("++++++++++++++++ ING_TC9/10 ++++++++++++++++");
	}
	
	
	
	private static void testCase11()
	{
		// TC1: set name of ingredient with null data  \\
		System.out.println("\n");
		System.out.println("ING_TC11 - Testing construction of Ingredient class with invalid parameters'");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Expected Result: the object will not be instantiated");
		Ingredient ing = new Ingredient();
		
		try
		{
			ing = new Ingredient(null, FoodGroup.FandV, " ");
		}
		catch(CustomException e)
		{
			System.out.println(e.getErrorMessageM());
		}
		
		System.out.println(ing);
		
		System.out.println("++++++++++++++++ ING_TC11 ++++++++++++++++");
	}
	
	
	
	

}
