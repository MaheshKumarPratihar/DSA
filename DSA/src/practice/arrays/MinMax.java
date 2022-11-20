package practice.arrays;

import java.util.Arrays;

public class MinMax {

	public static void main(String[] args) {
		
		int size = 6;
		
		long[] longArray = new long[] {3, 2, 1, 56, 1000, 167};
		
		System.out.println("Given array is --> " + Arrays.toString(longArray));
		
		System.out.println(getMinMax(longArray, size).toString());
		

	}
	
	public static pair getMinMax(long a[], long n)  
    {
       long min = Long.MAX_VALUE;
	   long max = Long.MIN_VALUE;
       for(int i = 0; i < n; i++){
           if(min > a[i]){
               min = a[i];
           }
           
           if(max < a[i]){
               max = a[i];
           }
       }
       
       return new pair(min, max);
    }

}


class pair  
{  
   long first, second;  
   public pair(long first, long second)  
   {  
       this.first = first;  
       this.second = second;  
   }
@Override
public String toString() {
	return "pair [min=" + first + ", max=" + second + "]";
}  
   
   
}
