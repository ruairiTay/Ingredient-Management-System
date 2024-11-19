package part01;

import java.util.ArrayList;

/**
 * Author : Ruairi Taylor
 * Student Number : 40406718
 * 
 * Recipe class - used to define the Recipe object  
 * 
 */

public class Recipe 
{
//  ATTRIBUTES  \\
	private String recipeID;
	private String recipeName;
	private String recipePortionSize;
	private ArrayList <RecipeIngredient> recIng;
	private MealType recipeType;
	private ArrayList <String> instructions;
	public static int IDNumber = 1;
	
	/**
	 * Default Recipe constructor 
	 */
	public Recipe()
	{
	}
	
	/**
	 * Recipe constructor with fields 
	 * @param recipeName - name of recipe 
	 * @param recipePortionSize - portion size of recipe 
	 * @param recIng - ingredients of recipe 
	 * @param recipeType - type of meal the recipe is 
	 * @param instructions - recipe instructions 
	 * @throws CustomException - exception thrown if any of the data above is invalid 
	 */
	public Recipe(String recipeName, String recipePortionSize, ArrayList <RecipeIngredient> recIng, MealType recipeType, ArrayList <String> instructions) throws CustomException
	{
		setID();
		setRecipeName(recipeName);
		setRecPortionSize(recipePortionSize);
		setRecIng(recIng);
		setRecipeType(recipeType);
		setInstructions(instructions);
	}
	
	//  GET METHODS  \\
	
	/**
	 * @return recipeID
	 */
	public String getRecipeID()
	{
		return this.recipeID;
	}
	
	/**
	 * @return recipeName
	 */
	public String getRecipeName()
	{
		return this.recipeName;
	}
	
	/**
	 * @return recipePortionSize
	 */
	public String getRecipePortionSize()
	{
		return this.recipePortionSize;
	}
	
	/**
	 * @return recipeIngredients
	 */
	public ArrayList <RecipeIngredient> getRecipeIngredients()
	{
		return this.recIng;
	}
	
	/**
	 * @return recipeType
	 */
	public MealType getRecipeType()
	{
		return this.recipeType;
	}
	
	/**
	 * @return recipe instructions
	 */
	public ArrayList <String> getInstructions()
	{
		return this.instructions;
	}
	
	//  SET METHODS  \\
	
	/**
	 * sets the recipe ID and iterates the IDNumber variable
	 */
	public void setID()
	{
		this.recipeID = "R" + IDNumber;
		IDNumber++;
	}
	
	/**
	 * checks for inputs validity and sets it if it is valid 
	 * @param recName - the String that the validity is being checked
	 * @throws CustomException - the Exception thrown if the name is invalid 
	 */
	public void setRecipeName(String recName) throws CustomException
	{
		//  call to validation method, throws an exception if the method returns false  \\
		if(Resources.validStringWithNumbers(recName))
		{
			this.recipeName = recName;
		}
		else
		{
			Resources.error = "ERROR: Recipe name field entered incorrectly";
			throw new CustomException (Resources.error);
		}
	}
	
	/**
	 * checks for inputs validity and sets it if it is valid 
	 * @param ps - the String that the validity is being checked 
	 * @throws CustomException - the Exception thrown if the portion size is invalid 
	 */
	public void setRecPortionSize(String ps) throws CustomException
	{
		//  call to validation method, throws an exception if the method returns false  \\
		if(Resources.validInt(ps))
		{
			this.recipePortionSize = ps;
		}
		else
		{
			Resources.error = "ERROR: Recipe portion size field entered incorrectly";
			throw new CustomException (Resources.error);
		}
	}
	
	/**
	 * Sets the recipe ingredients 
	 * @param recIng - the recipe ingredients the attribute is being set to 
	 */
	public void setRecIng(ArrayList <RecipeIngredient> recIng)
	{
		this.recIng = recIng;
	}
	
	/**
	 * Sets the recipe type 
	 * @param rt - the recipe type the attribute will be set to 
	 */
	public void setRecipeType(MealType rt)
	{
		this.recipeType = rt;
	}
	
	/**
	 * checks for inputs validity and sets it if it is valid 
	 * @param instructions - the input that is being check to see if its valid 
	 * @throws CustomException - the exception that will be thrown if it is not valid 
	 */
	public void setInstructions(ArrayList <String> instructions) throws CustomException
	{
		Boolean valid = true;
		
		for(int i = 0; i < instructions.size(); i++)
		{
			//  call to validation method, throws an exception if the method returns false  \\
			if(!Resources.validStringWithNumbers(instructions.get(i)))
			{
				valid = false;
			}
		}
		
		if(valid)
		{
			this.instructions = instructions;
		}
		else
		{
			Resources.error = "ERROR: Recipe steps cannot be left blank";
			throw new CustomException (Resources.error);
		}
	}
	
	/**
	 * @return a string that contains all information on a Recipe object 
	 */
	public String toString()
	{
		String out = " \n";
		out = "Recipe ID: " + this.recipeID + ", Recipe Meal Type: " + this.recipeType + "\n";
		out += " \n";
		out += "Recipe Name: " + this.recipeName + ", Portion Size: " + this.recipePortionSize + " \n";
		out += " \n";
		out += "RECIPE INGREDIENTS: \n";
		int totalCals = 0;
		
		for(int i = 0; i < this.recIng.size(); i++)
		{
			out += this.recIng.get(i).getIngredient().getName() + ": " + this.recIng.get(i).getAmount() + " " + this.recIng.get(i).getMassDescription() + " - " + this.recIng.get(i).getIngredientExtraInfo() + "\n";
			totalCals += this.recIng.get(i).caloriesPerAmount();
		}
		
		out += " \n";
		out += "RECIPE STEPS: \n";
		
		for(int i = 0; i < this.instructions.size(); i++)
		{
			out+= (i+1) + ". " + this.instructions.get(i) + "\n";
		}
		
		out += "\n";
		out += "Total Calories for recipe: " + totalCals + "\n";
		
		return out;
	}
}
