import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Vector;
import java.util.Random;
import java.util.Iterator;

public class CollectionExecutingTime{


    public static long getTotalVectors(Vector<Integer> vector){
        long total = 0;
        Iterator<Integer> iterator = vector.iterator();
        while(iterator.hasNext()){
            total = total + (long)iterator.next();
        }
        return total;
    }

    public static long getTotalArray(int[] array){
        long total = 0;
        for(int i = 0; i < array.length; i++){ 
            total = total + array[i];
        }
        return total;
    }

    public static long getTotalListArray(ArrayList<Integer> listOfArray){
        long total = 0;
        Iterator<Integer> iterator = listOfArray.iterator();
        while(iterator.hasNext()){
            total = total + (long)iterator.next();
        }
        return total;
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

        long vectorElapsedTime; //keeps track of the elapsed time for vectors
        long arrayElapsedTime; //keeps track of the elapsed time for the array
	    long listOfArrayElapsedTime;//keeps track of the elapsed time for the listOfArray

        final int size = 1000000; 
	    

        int[] array = new int[size]; //new array of size 'size' (1,000,000)
	    Vector<Integer> vector = new Vector<Integer>(); // new Vector
	    ArrayList<Integer> listOfArray = new ArrayList<Integer>(); //new arrayList
	
	    initializingContents(array, size, vector, listOfArray); //initializing the contents with random numbers thanks to the initializingContents() method
	    long beginTimer = System.nanoTime(); //start time
        getTotalVectors(vector);
        vectorElapsedTime = System.nanoTime();
        getTotalArray(array);
        arrayElapsedTime = System.nanoTime();
        getTotalListArray(listOfArray);
        listOfArrayElapsedTime = System.nanoTime();

        long firstTimeNano = arrayElapsedTime - beginTimer;
        long secondTimeNano = listOfArrayElapsedTime - arrayElapsedTime;
        long thirdTimeNano = vectorElapsedTime - arrayElapsedTime;

        long firstTimeSec = TimeUnit.NANOSECONDS.toSeconds(firstTimeNano);
        long secondTimeSec = TimeUnit.NANOSECONDS.toSeconds(secondTimeNano);
        long thirdTimeSec = TimeUnit.NANOSECONDS.toSeconds(thirdTimeNano);

    }
}