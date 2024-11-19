package part01;

/**
 * Author : Ruairi Taylor
 * Student Number : 40406718
 * 
 * RecipeIngredient class - used to define the RecipeIngredient object  
 * 
 */

public class RecipeIngredient  
{
	//  ATTRIBUTES  \\
	private Ingredient ing;
	private String massAmount;
	private Mass massDescription;
	private String ingredientExtraInfo;
	
	/**
	 * default constructor
	 */
	public RecipeIngredient()
	{}
	
    /**
     * Constructor with fields 
     * @param ing - Ingredient object
     * @param amount - numeric amount of the Ingredient required for a recipe 
     * @param massDescription - Mass description of the amount 
     * @param ingredientExtraInfo - Extra info of an ingredient 
     * @throws CustomException - Exception thats thrown if the data above is invalid 
     */
	public RecipeIngredient(Ingredient ing, String amount, Mass massDescription, String ingredientExtraInfo) throws CustomException
	{
		setIngredient(ing);
		setAmount(amount);
		setMassDescription(massDescription);
		setIngredientExtraInfo(ingredientExtraInfo);
	}
	
	//  get methods  \\
	
	/**
	 * @return the Ingredient object
	 */
	public Ingredient getIngredient()
	{
		return this.ing;
	}
	
	/**
	 * @return the amount
	 */
	public String getAmount()
	{
		return this.massAmount;
	}
	
	/**
	 * @return the mass description
	 */
	public Mass getMassDescription()
	{
		return this.massDescription;
	}
	
	/**
	 * @return the extra info on the ingredient 
	 */
	public String getIngredientExtraInfo()
	{
		return this.ingredientExtraInfo;
	}
	
	//  set methods  \\
	
	/**
	 * Method that will set the Ingredient 
	 * @param ing - Ingredient object the attribute will be set to
	 */
	public void setIngredient(Ingredient ing)
	{
		this.ing = ing;
	}
	
	/**
	 * Method that will check the validity of the String being input and set it if it is valid 
	 * @param amount - the String that will be checked for its validity
	 * @throws CustomException - the Exception that will be thrown if its not valid
	 */
	public void setAmount(String amount) throws CustomException
	{
		//  call to validation method that throws an error if it comes back false  \\
		if(Resources.validDouble(amount))
		{
			this.massAmount = amount;
		}
		else
		{
			Resources.error = "ERROR: Amount field entered incorrectly";
			throw new CustomException (Resources.error);
		}
	}
	
	/**
	 * Sets the massDescription
	 * @param m - the Mass it will be set to 
	 */
	public void setMassDescription(Mass m)
	{
		this.massDescription = m;
	}
	
	/**
	 * Sets the extraInfo
	 * @param extraInfo - the String it will be set to 
	 */
	public void setIngredientExtraInfo(String extraInfo)
	{
		this.ingredientExtraInfo = extraInfo;
	}
	
	/**
	 * Method that calculates the amount of calories for that ingredient based on the amount of the Ingredient required for the recipe 
	 * @return the calories per amount 
	 */
	public double caloriesPerAmount()
	{
		return (Double.parseDouble(ing.getCalories())/100) * Double.parseDouble(massAmount);
	}
	
	/**
	 * @return a String with all information of RecipeIngredient object
	 */
	public String toString()
	{
		return this.ing.toString() + " Mass Amount: " + this.massAmount + " , Mass Description: " + this.massDescription + " , Ingredient Extra Info: " + this.ingredientExtraInfo;
	}
	
}
