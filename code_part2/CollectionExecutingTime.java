// Everytime we run the code we always get 0 seconds... And whenever we increase the size our computers won't run it because we don't have enough memory

import java.util.ArrayList;
import java.util.Vector;
import java.util.Random;
import java.util.Iterator;

public class CollectionExecutingTime{


    public static long getTotalVectors(Vector<Integer> vector){
        long total = 0;
        Iterator<Integer> iterator = vector.iterator(); //Using an Iterator for the Vector
        while(iterator.hasNext()){ //as long as this condition is true it will continue to iterate
            total = total + iterator.next();
        }
        return (total);
    }

    public static long getTotalArray(int[] array){
        long total = 0;
        for(int i = 0; i < array.length; i++){ 
            total = total + array[i];
        }
        return (total);
    }

    public static long getTotalListArray(ArrayList<Integer> listOfArray){
        long total = 0;
        Iterator<Integer> iterator = listOfArray.iterator(); // Use a an iterator for ArrayList.
        while(iterator.hasNext()){ //as long as this condition is true it will continue to iterate
            total = total + iterator.next();
        }
        return (total);
    }

    public static void initializingContents(int[] array, int size, Vector<Integer> vector, ArrayList<Integer> listOfArray){
        Random randomize = new Random(); //creating a randomiser
        for(int j = 0; j < size; j++){
            int randomNumber = randomize.nextInt(1000000); //Generates random numbers from bounds from 0 till 1000000
            array[j] = randomNumber;
            vector.addElement(randomNumber);
            listOfArray.add(randomNumber);
        }
    }

    public static void main(String[] args){

        long vectorTime; //keeps track of the elapsed time for vectors
        long arrayTime; //keeps track of the elapsed time for the array
	    long listOfArrayTime;//keeps track of the elapsed time for the listOfArray

        final int size = 10000000; //This will be the size used by all the vector, array and arraylist
	    

        int[] array = new int[size]; //new array of size 'size' (1,000,000)
	    Vector<Integer> vector = new Vector<Integer>(); // new Vector
	    ArrayList<Integer> listOfArray = new ArrayList<Integer>(); //new arrayList
	
	    initializingContents(array, size, vector, listOfArray); //initializing the contents with random numbers thanks to the initializingContents() method
	    long beginTimer = System.nanoTime(); //start time
        getTotalVectors(vector);
        vectorTime = System.nanoTime();
        getTotalArray(array);
        arrayTime = System.nanoTime();
        getTotalListArray(listOfArray);
        listOfArrayTime = System.nanoTime();

        long thirdTimeNano = arrayTime - vectorTime ; //calculating the elapsed time (in ns) for vector
        long firstTimeNano = arrayTime - beginTimer; //calculating the elapsed time (in ns) for array
        long secondTimeNano = listOfArrayTime - arrayTime; //calculating the elapsed time (in ns) for array of list

        System.out.println("Vector size is: " + size); //Printing the size for vector
        System.out.println("time for vector is: " + thirdTimeNano +" ns"); //Printing the time for the vector
        
        System.out.println("--------------------------------------------");

        System.out.println("Array size is: " + size); //Printing the size for array
        System.out.println("time for array is: " + firstTimeNano + " ns"); //Printing the time for the array

        System.out.println("--------------------------------------------");

        System.out.println("List of array size is: " + size); //Printing the size for list of array
        System.out.println("time for list of array is: " + secondTimeNano +" ns"); //Printing the time for the list of array

    }
}
