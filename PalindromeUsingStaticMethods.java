class PalindromeUsingStaticMethods{
	
	public static void reverse(int n){
		int rem,rev=0,temp=n;
		while(n!=0){
			rem=n%10;
			rev = rev*10+rem;
			n=n/10;
		}
		checkPalindrome(rev,temp);

	}
	public static void checkPalindrome(int rev,int temp){
		if(temp==rev){
			System.out.println("Given number"+" "+temp+" "+"is a palindrome");
		}
		else{
			System.out.println("Given number"+" "+temp+" "+"is not a palindrome");
		}
	
	}
	public static void main(String args[]){
				
		//PalindromeUsingStaticMethods.reverse(151);
		PalindromeUsingStaticMethods.reverse(145);
	}

}