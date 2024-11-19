package part01;

public class CustomException extends Exception
{
	private static final long serialVersionUID = 1L; 
	
	//  ATTRIBUTES  \\
    private String errormessageM;

    //  DEFAULT CONSTRUCTOR  \\
    public CustomException() 
    {
        errormessageM = "";
    }

    //  CONSTRUCTOR WITH FIELDS  \\
    public CustomException(String errormessage)
    {
    	super(errormessage);
        errormessageM = errormessage;
    }


    //  PROPERTIES  \\
    public String getErrorMessageM()
    {
        return this.errormessageM;
    }
    
    public void setErrorMessageM(String message)
    {
    	this.errormessageM = message;
    }
    
}
