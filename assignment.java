package assignment;
import java.util.Scanner;
import java.util.LinkedHashMap;;

public class assignment {
	
	static Scanner input = new Scanner(System.in);
	public static void main(String args[]){
		int tenArray[] = new int[10]; 
		int twentyArray[] = new int[20];
		
//		No. 1
		System.out.println("Taking 10 integers and then printing them.");
		initializeArray(tenArray,tenArray.length);
		printArray(tenArray,tenArray.length);
		
//		No. 2
		System.out.println("Taking 10 integers and checking if a certain element exists.");
		initializeArray(tenArray,tenArray.length);
		System.out.println("Which element do you want to check?");
		int element = input.nextInt();
		
		if(checkElementInArray(tenArray, tenArray.length, element)) {
			System.out.println("The element is in the array");
		}
		else {
			System.out.println("The element is not in the array");
		}
		System.out.println();
		
//		No. 3
		System.out.println("Taking 20 integers and printing the numbers with certain criterias.");
		initializeArray(twentyArray,twentyArray.length);
		printingCertainNumbers(twentyArray, twentyArray.length);
		System.out.println();
		
//		No. 4
		System.out.println("Using the 10 array to print the sum and the product of an array.");
		System.out.println("Sum : " + sum(tenArray,tenArray.length));
		System.out.println("Product : " + product(tenArray,tenArray.length));
		System.out.println();
		
//		No. 5
		System.out.println("Finding the largest and the smallest element of an array");
		System.out.println("Min : " + min(tenArray,tenArray.length));
		System.out.println("Max : " + max(tenArray,tenArray.length));
		System.out.println();
		
//		No. 6
		System.out.println("Checking if an array is the same array when reversed");
		if(checkReversed(tenArray,tenArray.length)) {
			System.out.println("This array is the same when reversed");
		}
		else {
			System.out.println("This array is not the same when reversed");
		}
		System.out.println();
		
//		No. 7
		int firstPart[] = new int[tenArray.length/2];
		int secondPart[] = new int[tenArray.length/2];
		System.out.println("Splitting the 10 array in the middle ");
		System.out.print("10 Array : ");
		printArray(tenArray,tenArray.length);
		splitMiddle(tenArray,firstPart,secondPart);
		
		System.out.print("First Part : ");
		printArray(firstPart,firstPart.length);
		System.out.print("Second Part : ");
		printArray(secondPart,secondPart.length);
		
//		No. 8
		int uniqueArray[] = {1,2,7,4,5};
		System.out.print("Splitting the highest value of a unique array into 2 parts ");
		splitHighestValue(uniqueArray,uniqueArray.length);
		System.out.println();
		
//		No. 9
		System.out.println("Shifting an element to the right");
		shiftRight(uniqueArray, uniqueArray.length);
		printArray(uniqueArray, uniqueArray.length);
		
//		No. 10
		sorter(uniqueArray,uniqueArray.length);
		printArray(uniqueArray,uniqueArray.length);
	}
	
	public static void initializeArray(int array[],int arrayLength){
		for(int i = 0; i < arrayLength; i++) {
			System.out.print("Element no. " + i + " : ");
			array[i] = input.nextInt();
		}
	}
	
	public static boolean checkElementInArray(int array[], int arrayLength, int element) {
		for(int i = 0; i < arrayLength; i++){
			if(element == array[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static int min(int array[], int arrayLength){
		int minVal = array[0];
		for(int i = 0; i < arrayLength; i++){
			minVal = array[i] < minVal ? array[i] : minVal;
		}
		return minVal;
	}
	public static int max(int array[], int arrayLength){ 
		int maxVal = array[0];
		for(int i = 0; i < arrayLength; i++){
			maxVal = array[i] > maxVal ? array[i] : maxVal;
		}
		return maxVal;
	}
	
	public static int sum(int array[], int arrayLength){
		int total = 0;
		for(int i = 0; i < arrayLength; i++){
			total += array[i];
		}
		return total;
	}
	public static int product(int array[], int arrayLength){
		int total = 1;
		for(int i = 0; i < arrayLength; i++){
			total *= array[i];
		}
		return total;
	}
	
	public static void printingCertainNumbers(int array[], int arrayLength){
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		map.put("Positive Numbers", 0);
		map.put("Negative Numbers", 0);
		map.put("Odd Numbers", 0);
		map.put("Even Numbers", 0);
		map.put("Zeroes", 0);
		
		for(int i = 0; i < arrayLength; i++) {
			if(array[i] >= 0) {
				map.replace("Positive Numbers", map.get("Positive Numbers") + 1);
				if(array[i] == 0) {
					map.replace("Zeroes", map.get("Zeroes") + 1);
				}
			}
			else {
				map.replace("Negative Numbers", map.get("Negative Numbers") + 1);
			}
			
			if(array[i] % 2 == 1) {
				map.replace("Odd Numbers", map.get("Odd Numbers") + 1);
			}
			else {
				map.replace("Even Numbers", map.get("Even Numbers") + 1);
			}
		}
		System.out.println(map);
	}
	
	public static boolean checkReversed(int array[], int arrayLength) {
		for(int i = 0; i < arrayLength; i++) {
			if(array[i] != array[arrayLength - i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void shiftRight(int array[], int arrayLength) {
		int tempArray[] = array.clone();
		for(int i = 0; i < arrayLength; i++) {
			if(i + 1 == arrayLength) {
				array[0] = tempArray[i];
			}
			else {
				array[i + 1] = tempArray[i];
			}
		}
	}
	
	public static void splitHighestValue(int array[], int arrayLength) {
		int arrayClone[] = array.clone();
		int maxVal = max(array,arrayLength);
		int maxValIndex = 0;
//		It gets the index of the maximum value and then replaces the maximum value of the clone with value -1
//		Searching the maximum value of the clone will result in the second highest value
		for(int i = 0; i < arrayLength; i++) {
			if(array[i] == maxVal) {
				maxValIndex = i;
				arrayClone[maxValIndex] = -1;
			}
		}
		boolean extraValueAdded = false;
		int secondMaxVal = max(arrayClone,arrayClone.length);
		int newArray[] = new int[arrayLength + 1];
		for(int i = 0; i < arrayLength; i++) {
			if(extraValueAdded) {
				newArray[i+1] = array[i];
			}
			else {
				if(i == maxValIndex) {
					newArray[i] = secondMaxVal;
					newArray[i+1] = maxVal - secondMaxVal;
					extraValueAdded = true;
				}
				newArray[i] = array[i];
			}
		}
		printArray(newArray,newArray.length);
	}
	
	public static void splitMiddle(int inputArray[], int firstOutput[], int secondOutput[]){
//		setting the length at main
		int arrayLength = inputArray.length;
		for(int i = 0; i < (arrayLength / 2) - 1; i++) {
			firstOutput[i] = inputArray[i];
		}
		for(int i = (arrayLength / 2); i < arrayLength ; i++) {
			secondOutput[i - (arrayLength / 2)] = inputArray[i];
		}
	}
	
	public static void sorter(int array[], int arrayLength) {
		boolean sorted = false;
		
		boolean didSwap = false;
		int tempVal = 0;
		
		while(sorted != true) {
			didSwap = false;
			for(int i = 0; i < arrayLength - 1; i++) {
				if(array[i] > array[i+1]) {
					tempVal = array[i+1];
					array[i+1] = array[i];
					array[i] = tempVal;
					didSwap = true;
				}
			}
			if(!didSwap) {
				break;
			}
		}
	}
	
	public static void printArray(int array[], int arrayLength){
		for(int i = 0; i < arrayLength; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}			


}
