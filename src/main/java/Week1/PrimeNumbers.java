package Week1;

public class PrimeNumbers {
	public static void main(String arg[]) {
                   int i = 2;
                   int j;
                   int max = 50;
                   boolean flag = true;
                   int rem = 0;
                   while ( i < max )
                      {
  		for ( j = 1; j < i; j++) {
                      rem = i % j ;
                      if( rem == 0 )
                        {
                        flag = false;
                        break;
                        }
                     }
                      if ( flag == true )
                        {                        
			System.out.println(i);
                        }
                         flag = true;
                         i++;
		}

}
}
