package pc.v.pkg3.pkg0.pkg006.binary.search;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Pro/g/ramming Challenges v 3.0 
 * 006 - Binary Search (integers, strings, etc)
 * @author Emil.Karpowicz
 */



public class Main 
{
    public static void main(String[] args) 
    {
        int[] arrayToLookIn = ArrayGenerator.generateArrayToLookIn(20, 30);
        int itemToLookFor = 19;
        
        int result = BinarySearch.binarySearch(arrayToLookIn, 0, arrayToLookIn.length, itemToLookFor);
        
        if (result == -1) System.out.println("Nie znaleziono szukanej przez Ciebie liczby");
        else System.out.println("Twoja liczba znajduje się na "+ result+ "tej pozycji w rabeli");
    }
}

class BinarySearch
{
    public static int binarySearch(int[] arrayToLookIn, int startIndex, int endIndex, int itemToLookFor)
    {
        if (endIndex >= startIndex)
        {
            int mid = startIndex + (endIndex - startIndex)/2;
            
            if (itemToLookFor == arrayToLookIn[mid]) return mid;
            else if (itemToLookFor > arrayToLookIn[mid]) return binarySearch(arrayToLookIn, mid + 1, arrayToLookIn.length, itemToLookFor);
            else if (itemToLookFor < arrayToLookIn[mid]) return binarySearch(arrayToLookIn, startIndex, mid - 1, itemToLookFor);
        
        }
        return -1;
    }
}

class ArrayGenerator
{
    static int[] arrayToLookIn;
    
    public static int[] generateArrayToLookIn(int arraySize, int itemValueRange)
    {
        TreeSet<Integer> tempSet = new TreeSet<>();
        arrayToLookIn = new int[arraySize];
        
        while (tempSet.size() < arraySize)
        {
            tempSet.add(new Random().nextInt(itemValueRange));
        }
        
        Iterator<Integer> iter = tempSet.iterator();
        int i = 0;
        
        while (iter.hasNext())
        {
            arrayToLookIn[i] = iter.next();
            i++;
        }
        
        return arrayToLookIn;
    }
}


