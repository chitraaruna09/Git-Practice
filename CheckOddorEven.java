class CheckOddorEven
{
	
  public static void main (String args [])
   {
	    int number = Integer.parseInt(args[0]);
	  
		if ((number % 2) == 0)
		{
			System.out.print(" Given number is an Even ");
		}
		else
		{
			System.out.print(" Given number is Odd ");
		}
   }
}