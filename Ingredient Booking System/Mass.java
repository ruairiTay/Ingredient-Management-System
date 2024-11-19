package part01;

public enum Mass 
{
	G("grams"),
	ML("milli-litres"),
	OTHER("Other");
	
	private String massStr;
	
	private Mass (String massType)
	{
		massStr = massType;
	}
	
	public String toString()
	{
		return massStr;
	}
}
