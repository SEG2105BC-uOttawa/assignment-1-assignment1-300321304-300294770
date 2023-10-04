// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.util.Arrays;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Random;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest
{
  //Class methods *****************************************************
  private static long[]randomValC0 = new long[10000000];
  private static long[] randomValC1 = new long[10000000];
  private static long[] randomValC2 = new long[10000000];

  private static long[] randomValP0 = new long[10000000];
  private static long[] randomValP1 = new long[10000000];
  private static long[] randomValP2 = new long[100000000];


  private static long[] averageMethodC0 = new long[10000000];
  private static long[] averageMethodC1 = new long[10000000];
  private static long[] averageMethodC2 = new long[10000000];

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args)
  {
    
    testRandom();
    System.out.println("");
    testMethods();

  }

  public static void testRandom(){
    PointCP point0;
    PointCP2 point1;
    PointCP3 point2;

    long start;
    long end;

    Random random = new Random();

    for (int i = 0; i < 10000000; i++){
      double x = random.nextDouble() * 100 - 50;
      double y = random.nextDouble() * 100 - 50;

      start =  java.lang.System.nanoTime();;
      point0 = new PointCP('C', x, y);
      end = java.lang.System.nanoTime();;


      randomValC0[i] = end - start;

      start =  java.lang.System.nanoTime();
      point1 = new PointCP2('C', x, y);
      end = java.lang.System.nanoTime();

      randomValC1[i] = end - start;

      start =  java.lang.System.nanoTime();
      point2 = new PointCP3('C', x, y);
      end = java.lang.System.nanoTime();

      randomValC2[i] = end - start;
  
    }

    for (int i = 0; i < 10000000; i++){
      double x = random.nextDouble() * 100 - 50;
      double y = random.nextDouble() * 100 - 50;

      start =  java.lang.System.nanoTime();
      point0 = new PointCP('P', x, y);
      end = java.lang.System.nanoTime();

      randomValP0[i] = end - start;

      start =  java.lang.System.nanoTime();
      point1 = new PointCP2('P', x, y);
      end = java.lang.System.nanoTime();

      randomValP1[i] = end - start;

      start =  java.lang.System.nanoTime();
      point2 = new PointCP3('P', x, y);
      end = java.lang.System.nanoTime();

      randomValP2[i] = end - start;

  
    }

    Arrays.sort(randomValC0);
    Arrays.sort(randomValC1);
    Arrays.sort(randomValC2);
    Arrays.sort(randomValP0);
    Arrays.sort(randomValP1);
    Arrays.sort(randomValP2);

    System.out.println(
      "Random numbers object constructor median time for cartesian for PointCP " + randomValC0[5000000] +
      "ns \nRandom numbers object constructor median time for cartesian for PointCP2 " + randomValC1[5000000] +
      "ns \nRandom numbers object constructor median time for cartesian for PointCP3 " + randomValC2[5000000] +
      "ns \nRandom numbers object constructor median time for Polar for PointCP " + randomValP0[5000000] +
      "ns \nRandom numbers object constructor median time for Polar for PointCP2 " + randomValP1[5000000] +
      "ns \nRandom numbers object constructor median time for Polar for PointCP3 " + randomValP2[5000000] +"ns"
    );
  }

  public static void testMethods(){
    PointCP point0 = new PointCP('C', 1, 1);
    PointCP2 point1= new PointCP2('C', 1, 1);
    PointCP3 point2= new PointCP3('C', 1, 1);

    PointCP point3 = new PointCP('C', 2, 2);
    PointCP2 point4 = new PointCP2('C', 2, 2);
    PointCP3 point5 = new PointCP3('C', 2, 2);

    long start;
    long end;

  for (int i = 0; i < 10000000; i++){
    start =  java.lang.System.nanoTime();
    point0.getX();
    point0.getY();
    point0.getRho();
    point0.getTheta();
    point0.convertStorageToCartesian();
    point0.convertStorageToPolar();
    point0.getDistance(point3);
    point0.rotatePoint(5);
    end = java.lang.System.nanoTime();

    averageMethodC0[i] = end - start;

    start =  java.lang.System.nanoTime();
    point1.getX();
    point1.getY();
    point1.getRho();
    point1.getTheta();
    point1.convertStorageToCartesian();
    point1.convertStorageToPolar();
    point1.getDistance(point4);
    point1.rotatePoint(5);
    end = java.lang.System.nanoTime();

    averageMethodC1[i] = end - start;

    start =  java.lang.System.nanoTime();
    point2.getX();
    point2.getY();
    point2.getRho();
    point2.getTheta();
    point2.convertStorageToCartesian();
    point2.convertStorageToPolar();
    point2.getDistance(point5);
    point2.rotatePoint(5);
    end = java.lang.System.nanoTime();

    averageMethodC2[i] = end - start;
  }

  System.out.println(
    "Median time for calling all the methods for PointCP " + averageMethodC0[5000000] +
    "ns \nMedian time for calling all the methods for PointCP2 " + averageMethodC1[5000000] +
    "ns \nMedian time for calling all the methods for PointCP3 " + averageMethodC2[5000000] +"ns"
  );


  }


}
