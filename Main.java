/**
 * File: Main.java
 * Goal: To Implement Selection Sort, Bubble Sort, and Binary Search Recursively 
 * */


public class Main
{
   public static void main(String[] args)
   {
      int[] arr = {2,1, 5, 0, 9, -4, 6};

      printArr("Before: " , arr); 

      selectionSort(arr, 0, arr.length-1); 
      printArr("After Selection Sort: " , arr); 

      int target = 5; 
      log("What index is element " + target + " in: " + binarySearch(arr, 0, arr.length-1, target)); 

   }

   //MUST BE SORTED BEFORE USE !!!
   //BINARY SEARCH RECURSIVELY !!!
   public static int binarySearch(int[] arr, int first, int last, int target)
   {
      //BaseCase If Out of bounds Stop looking for it 
      if(first > last)
         return -1; //STOP QUIT !!!! 
      //ELSE 
      int mid = (first + last) / 2; //Finding the MidIndex in the array 

      //Checking if the target is in the mid Index 
      if(arr[mid] == target)
         return mid; //FOUND THE MID INDEX 
      //ELSE checking if the mid Index Element Greater then the target 
      else if(arr[mid] > target)
         return binarySearch(arr, first, mid-1, target); //Eliminating all the Bigger elements from the search 
      else
         return binarySearch(arr, mid+1, last, target); //Eliminating all the Smaller Elements from the search  

   
   }
   //Bubble Sort Recursively 
   public static void bubbleSort(int[] arr, int first, int last) 
   {
      //Base Case If its an array Of 1 Element then its already sorted 
      if(first >= last)
         return ;//STOP  
      
      //Has to be i < last so we dont get an ArrayOutOfBoundsException 
      for(int i = first; i < last; i++)
      {
         if(arr[i] > arr[i+1])
            swap(arr, i, i+1); 
      }

      //Recursively Call the Method 
      bubbleSort(arr, first, last -1); //Reson its last -1 is because the last element will always be in the correct spot 

   }

   //Selection Sort Recursively 
   public static void selectionSort(int[] arr, int first, int last)
   {
      //Base Case IF The array is of size 1 stop already Sorted 
      if(first >= last)
         return ; //STOP

      //else 
      int minIndex = first; //Assuming the minIndex is at the start 

      //i <= last because we want to check all elements 
      for(int i = first+1; i <= last; i++)
      {
         if(arr[i] < arr[minIndex])
            minIndex = i; //Updating the index of the min Number 
      }
      //Swapping the minIndex with the firstIndex 
      swap(arr, minIndex, first); 

      //Now the Element at the first Index is in the correct location 
      selectionSort(arr, first +1, last); //Go up by one 

   }

   private static void swap(int[] arr, int firstIndex, int secondIndex)
   {
      int temp = arr[firstIndex]; 
      arr[firstIndex] = arr[secondIndex]; 
      arr[secondIndex] = temp; 
   }

   //Prints the Array Recursively 
   public static void printArr(String msg, int[] arr)
   {
      String answer = msg + "\n" + "[ "; 
      answer += print(arr, 0, arr.length-1); //Getting the String Of the Array Recursively 
      answer = answer.substring(0, answer.length() -2); 
      answer += "]\n\n";

      log(answer); //Printing the Answer 
   }

   private static String print(int[] arr, int first, int last)
   {
      //Base Case if the Array is out of bounds quit 
      if(first > last)
         return ""; //STOPS THE METHOD!!! 
      //ELSE
      return arr[first] + " , " + print(arr, first +1, last); 

   }

   public static void log(String msg)
   {
      System.out.println(msg); 
   }
}
