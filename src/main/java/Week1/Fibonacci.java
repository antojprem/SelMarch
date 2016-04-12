package Week1;
// program to print the Fibonacci series
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0, b = 1, c, max = 20;
		System.out.println("This is the program for Fibonacci");
		System.out.println(" "+a);
		System.out.println(" "+b);
		for(int i=1;i<max;i++){
			c = a + b;
			a = b;
			b = c;
			
			System.out.println(" "+c);
			
		}
System.out.println("This is the program for Fibonacci");
	}

}
