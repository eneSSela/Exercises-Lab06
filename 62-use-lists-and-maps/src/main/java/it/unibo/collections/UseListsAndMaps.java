package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int MIN = 1000;
    private static final int MAX = 2000;
    private static final int WRITE_ELEMENTS = 100_000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> listInt = new ArrayList<>();

        for(int i = MIN; i < MAX; i++) {

            listInt.add(i);
        }


        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> linkedInt = new LinkedList<>();
        linkedInt.addAll(listInt); 


        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int dummy = listInt.get(0); 
        listInt.set(0, listInt.get(listInt.size() - 1)); 
        listInt.set(listInt.size() - 1, dummy); 


        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(int num : listInt) {
            System.out.println(num);
        }


        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        ArrayList<Integer> testArrayList = new ArrayList<>();
        LinkedList<Integer> testLinkedList = new LinkedList<>();

        long timeWritingArray = measureListOperation(testArrayList, WRITE_ELEMENTS,0);
        long timeWritingLinked = measureListOperation(testLinkedList, WRITE_ELEMENTS,0);

        System.out.println("Write ArrayList : " + TimeUnit.NANOSECONDS.toMillis(timeWritingArray) + " ms");
        System.out.println("Write LinkedList : " + TimeUnit.NANOSECONDS.toMillis(timeWritingLinked) + " ms");


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }


    public static long measureListOperation(List<Integer> list, int nElements, int operationType) {
        
        /*Scrittura = 0*/
        if(operationType == 0) {

            long start = System.nanoTime();
            
            for (int i = 0; i < nElements; i++) {
                list.add(0, i);
            }
            
            long end = System.nanoTime();
            return end - start;
        }
        /*Lettura = 1*/
        else if(operationType == 1) {

            long start = System.nanoTime();
            int middleIndex = list.size() / 2;

            for (int i = 0; i < nElements; i++) {
                list.get(middleIndex);
            }
            
            long end = System.nanoTime();
            return end - start;
        }
        return 0;
    }
}
