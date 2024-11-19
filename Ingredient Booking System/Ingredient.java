package part01;

/**
 * 
 * Author : Ruairi Taylor
 * Student Number : 40406718
 * 
 * Ingredient class used for defining the Ingredient Object
 * 
 */

public class Ingredient 
{
	//  ATTRIBUTES  \\
	private String ID;
	private String name;
	private FoodGroup ingredientFoodGroup;
	private String calories;
	public static int IDNumber = 1;
	
	/**
	 * Default Constructor - used for creating instance of Ingredient class
	 */
	public Ingredient()
	{
	}
	
	/**
	 * Constructor with fields - used for creating instance of Ingredient class
	 * @param name - the ingredient name
	 * @param fg - the ingredient food group
	 * @param calories - the ingredient calories
	 * @throws CustomException - exception thrown if fields entered are not valid 
	 */
	public Ingredient(String name, FoodGroup fg, String calories) throws CustomException
	{
		setID();
		setName(name);
		setFoodGroup(fg);
		setCalories(calories);
	}
	
	//  GETTER METHODS  \\
	
	/**
	 * 
	 * @return the ingredient ID
	 */
	public String getID()
	{
		return this.ID;
	}
	
	/**
	 * 
	 * @return the ingredient name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * 
	 * @return the ingredient food group
	 */
	public FoodGroup getFoodGroup()
	{
		return this.ingredientFoodGroup;
	}
	
	/**
	 * 
	 * @return the ingredient calories
	 */
	public String getCalories()
	{
		return this.calories;
	}
	
	//  set methods  \\
	
	/**
	 * sets the ingredient ID and iterates the IDNumber 
	 */
	public void setID()
	{
		this.ID = "I" + IDNumber;
		IDNumber++;
	}
	
	/**
	 * sets the Ingredient name - calls to validation method
	 * @param name - name that will be input from user
	 * @throws CustomException - exception thrown if the input is not valid
	 */
	public void setName(String name) throws CustomException
	{
		//  call to validation method, throws an exception if the method returns false  \\
		if(Resources.validString(name))
		{
			this.name = name.trim();
		}
		else
		{
			Resources.error = "ERROR: Name field entered incorrectly";
			throw new CustomException (Resources.error);
		}
	}
	
	/**
	 * sets the Ingredient calories - calls to validation method
	 * @param calories - calories that will be input by the user
	 * @throws CustomException - exception thrown if the input is not valid
	 */
	public void setCalories(String calories) throws CustomException
	{
		//  call to validation method, throws an exception if the method returns false  \\
		if(Resources.validDouble(calories))
		{
			this.calories = calories.trim();
		}
		else
		{
			Resources.error = "ERROR: Calorie field entered incorrectly";
			throw new CustomException (Resources.error);
		}
	}
	
	/**
	 * sets the Ingredient food group
	 * @param fg - food group that will be input by user
	 */
	public void setFoodGroup(FoodGroup fg) 
	{
		
		this.ingredientFoodGroup = fg;
		
	}
	
	/**
	 * @return returns a string with all the information about the Ingredient
	 */
	public String toString()
	{
		return "Ingredient ID: " + this.ID + "\n" + "Ingredient Name: " + this.name + "\n" +"Ingredient Food Group: " + this.ingredientFoodGroup + "\n" + "Calories per 100g/100ml: " + this.calories;
	}
	
	
	
	
}
