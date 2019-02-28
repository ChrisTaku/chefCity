package chefCity;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class chefCityProgram {
	
	public static void main(String[] args) {
		
		// Specify length in array
		Scanner in = new Scanner(System.in);
		int arrayLength = 0;
		do {
			try {
				System.out.println("Specify number of test cases:");
				arrayLength = in.nextInt();
				int array[] = new int[arrayLength];
			} catch (InputMismatchException e) {
				System.out.println("Enter a Int value between 1 -200");
				in.next();
			}
		}while(!(arrayLength >=1 && arrayLength <= 200));
		
		//Input theatre location
		for (int i = 1; i<=arrayLength; i++) {
			int theatrePlace = 0;
			do {
				try {
				System.out.println("Enter test case #" + i + ":");
				theatrePlace = in.nextInt();
				int checkNearestStation = findNearest(theatrePlace);
				System.out.println("Time taken to theatre position: " + checkNearestStation + "min");
				} catch (InputMismatchException e) {
					System.out.println("Enter a Int value between 1 -1000000000");
					in.next();
				}
			}while(!(theatrePlace >=1 && theatrePlace <= 1000000000));
		}
	}
	
	//Finding nearest station
	static int findNearest(int x) {
		int stations = 1;
		int stationLength = 0;
		int timeTaken [] = new int [2];
		int difference;
		
		if (x != 0) {
			for (int i = 1; stationLength < x; i++) {
				stationLength = findLength(i);
				stations = i;
			}
			
			for (int i = 0; (i <= 1); i++) {
				if(x != stationLength) {
					difference = Math.abs(x - findLength(stations));
					timeTaken[i] = stations + difference;
				} 
				//length of stations is the same as length
				else if (x == stationLength) {
					return stations;
				}
				stations--;
			}
			Arrays.sort(timeTaken);
			return timeTaken[0];
		}
		return 0;
	}
	
	//Recursion for the length from start to station
	static int findLength ( int station) {
		if(station == 1) {
			return 1;
		} else {
			return findLength(station-1)+station; 			
	}
 }
}
