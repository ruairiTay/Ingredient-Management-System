package part01;

public enum FoodGroup 
{
	FandV("Fruit and Veg - 'Apples', 'Onions'"),
	DAIRY("Dairy Products - 'Milk', 'Cheese'"),
	SPICES_AND_HERBS("Spices and Herbs - 'Paprika'"),
	M_and_P("Meats and Poultry - 'Chicken', 'Pork'"),
	COMPFOOD("Composite Foods - 'Beans', 'Pasta'"),
	CEREAL("Cereals - 'flour', 'granola'"),
	FATS("Fat Based Products - 'Olive Oil'"),
	OTHER("Something Else");
		
		private String foodGroupStr;
		
		private FoodGroup (String foodGroup)
		{
			foodGroupStr = foodGroup;
		}
		
		public String toString()
		{
			return foodGroupStr;
		}
}
