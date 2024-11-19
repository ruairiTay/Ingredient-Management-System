package part01;

public enum MealType 
{
		STARTER("Starter"),
		MAIN("Main"),
		DESSERT("Dessert"),
		OTHER("Not specified");
		
		private String mealTypeStr;
		
		private MealType (String mealType)
		{
			mealTypeStr = mealType;
		}
		
		public String toString()
		{
			return mealTypeStr;
		}
}
