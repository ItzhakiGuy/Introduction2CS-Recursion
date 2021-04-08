/**
* Course: Intro To Computer Science
* Homework: 7
* Task: 1+2+3+4+5
* Name: Guy Itzhaki
* E-mail: itzhaki1234@gmail.com
*/

public class Recursion 
{
	/**
	 * Exercise 1
	 * @param num - number given to the function
	 * Function prints the number and if even operate function with the number divided by 2, 
	 * if odd operate function with the number multiplied by 3 and adds 1
	 */
	public static void HailstoneSequence (int num)
	{
		int newn=0;
		System.out.print(num+" ");
		if (num%2==0)
		{
			newn=num/2;
			HailstoneSequence (newn);
		}
		else
			if (num!=1)
			{
				newn=(num*3)+1;
				HailstoneSequence (newn);
			}
	}
	
	/**
	 * Exercise 2
	 * @param x - number given to the function
	 * @return - if number is even 0 adds zero and run the function with divided by 2 number, if it odd adds one  and run the function with divided by 2 number
	 * Function takes a number and return a string build by 0 and 1 if the number is even it return zero and operate the function with number divided by 2
	 * if the number is odd it return one and operate the function with number divided by 2
	 */
	public static String integerToBinary (int x)
	{
		if (x==0 || x==1)
			return ""+x;
		if (x%2==0)
			return integerToBinary(x/2)+"0";
		return integerToBinary(x/2)+"1";
	}
	
	/**
	 * Exercise 3
	 * @param binaryStr - The binary string of 0 and 1
	 * @return 0 - if there are a even ones, 1 - if there are odd ones
	 * Function takes a string and return herself plus adds 1 if the first number in the string is 1, then modulo 2
	 */
	public static int parity (String binaryStr)
	{
		if (binaryStr.length()==0)
			return 0;
		return (parity(binaryStr.substring(1, binaryStr.length()))+(binaryStr.charAt(0)-'0'))%2;
	}
	
	/**
	 * Exercise 4
	 * @param nums - array of numbers
	 * @param length - length of a growing series
	 * @return - overloading function boolean (true - if a growing series in the length exist, false - if it doesn't exist)
	 */
	public static boolean increasing(int[] nums, int length)
	{
		if (nums.length==0)
			return length==0;
		return increasing(nums, length, length, nums[0], 0);
	}
	/**
	 * Overloading Exercise 4
	 * @param nums - array of numbers
	 * @param length - length of a growing series
	 * @param newlength - changed length according to the growing current series
	 * @param currentbig - current biggest number in the growing series
	 * @param index - current index of the number in the array
	 * @return True - if the array consist the series of growing numbers within the needed length
	 * Function takes the parameters and check first if we got to the end of the array
	 * After that checks if the number is bigger - if it checks length of the growing series, then run the function with the new biggest number in the series
	 * and then "skips" the number and check after him
	 * Then if the current isn't bigger, it checks length of the growing series, then makes a run with the new number to check a series, 
	 * and checks the current series with skipping that number
	 */
	public static boolean increasing(int[] nums, int length, int newlength, int currentbig, int index)
	{
		if (index==nums.length)
			return newlength==0;
		if (nums[index]>=currentbig)
			return newlength==0 || increasing(nums, length, newlength-1, nums[index], index+1) || increasing(nums, length, newlength, currentbig, index+1); //check if finish then, with bigger one, then pass on the bigger one and continue check if there is another set 
		return newlength==0 || increasing(nums, length, newlength, currentbig, index+1) || increasing(nums, length, length-1, nums[index], index+1); // check if finish, then check the next index number, and pass the number and check last sets.
	}

	/**
	 * Exercise 5 
	 * @param n - number of fractals the function does
	 * Function draws the first circle and operate the overloading function to create next circles
	 */
	public static void banachCurve(int n)
	{
		if (n==0)
			return;
		double x=0.5;
		double y=0.5;
		double r=1.0/3.0;
		StdDraw.setCanvasSize(600, 600);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(x, y, r);
		banachCurve(x, y, r, n-1);
	}
	/**
	 * Overloading Exercise 5
	 * @param x - x direction
	 * @param y - y direction
	 * @param r - radius changing
	 * @param n - number of times left to run
	 * Function takes the 4 parameters and make fractal circles to the bigger circle that was drawn before and run to the next smaller circles
	 */
	private static void banachCurve(double x, double y, double r, int n)
	{
		if (n==0)
			return;
		StdDraw.circle(x, y, r/3);
		StdDraw.circle(x+r, y, r/3);
		StdDraw.circle(x, y+r, r/3);
		StdDraw.circle(x-r, y, r/3);
		StdDraw.circle(x, y-r, r/3);
		StdDraw.circle(x+(r/Math.sqrt(2)), y+(r/Math.sqrt(2)), r/3);
		StdDraw.circle(x+(r/Math.sqrt(2)), y-(r/Math.sqrt(2)), r/3);
		StdDraw.circle(x-(r/Math.sqrt(2)), y+(r/Math.sqrt(2)), r/3);
		StdDraw.circle(x-(r/Math.sqrt(2)), y-(r/Math.sqrt(2)), r/3);
		banachCurve(x, y, r/3, n-1);
		banachCurve(x+r, y, r/3, n-1);
		banachCurve(x, y+r, r/3, n-1);
		banachCurve(x-r, y, r/3, n-1);
		banachCurve(x, y-r, r/3, n-1);
		banachCurve(x+(r/Math.sqrt(2)), y+(r/Math.sqrt(2)), r/3, n-1);
		banachCurve(x+(r/Math.sqrt(2)), y-(r/Math.sqrt(2)), r/3, n-1);
		banachCurve(x-(r/Math.sqrt(2)), y+(r/Math.sqrt(2)), r/3, n-1);
		banachCurve(x-(r/Math.sqrt(2)), y-(r/Math.sqrt(2)), r/3, n-1);
	}	
	
	public static void main(String[] args) 
	{
		/**
		int num1=Integer.parseInt(args[0]);
		HailstoneSequence(num1);
		System.out.println();
		System.out.println(integerToBinary(25638));
		System.out.println(parity("101101111"));
		int[] arr= {9,10,5,2,1,5,3,9,8,10,2,3,9,8};
		banachCurve(4);
		*/
	}

}
