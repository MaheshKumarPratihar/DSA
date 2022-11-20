package practice.arrays;

import java.util.Arrays;

//Idea behind:
//
//This is so because each gate is visited by its factors only.
//For example 100 will be visited by 1,2,4,5,10,20,25,50,100 in that order.  
//Only perfect squares have an odd number of factors (try proving this). 
//Hence the answer for N will be the number of perfect squares less than or equal to N.

public class NumberOfOpenDoors {

	public static void main(String[] args) {
		int noOfOpenDoors = noOfOpenDoors((long) 4);

		System.out.println("Number of opened doors are --> " + noOfOpenDoors);

	}

	public static int noOfOpenDoors(Long N) {

		if (N == 2 || N == 1 || N == 3) {
			return 1;
		}

		int countSquares = 1;

		for (int i = 4; i <= N; i++) {

			if (i % 2 == 0) {
				double sqrt = Math.sqrt(i);
				if (sqrt - Math.floor(sqrt) == 0) {
					countSquares++;
				}
			}

		}

		return countSquares;
	}

}
