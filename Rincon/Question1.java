package Rincon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class Question1 {
    public static void main(String[] args) {
        //100 numbers in an unbounded stream of numbers read from stdin.

        // Since we only need to keep the top 100 numbers, I will use a max heap.
        // I can limit the size of the heap to 100.  This will keep the runtime of our heapify method
        // to a reasonable amount.
        // I will assume that not only do you need the top 100 numbers, but you want them in descending order.
        // It would be easy to reverse the arraylist returned by the findLargestNumbers() method if you wanted
        // them in ascending order.

        // In a real life example with a true stream, every time you receive a new input from the stream, you can send that
        // value to a method that adds that number to our max heap.  Then you could call another method that
        // simply returns the values of that max heap anytime you wanted to know what those top 100 numbers were
        // at that time.

        // I used Integers but this could be easily changed to handle floats, longs, etc.  You would just want to
        // be mindful about any overflow concerns.

        // I will first generate a list of 1000 random numbers
        // This will mimic my input stream
        // You can alter the size of the 'stream' by changing the argument sent to the randomIntegers method
        ArrayList<Integer> randomIntegers = generateStream(1000);

        // I will use this "stream" and find the top 100 numbers
        // You can alter the size of the list you would like by changing the argument sent to the findLargestNumbers method.
        // For example, if you only wanted the top 10 numbers, you would send randomIntegers, 10
        ArrayList<Integer> largestNumbers = findLargestNumbers(randomIntegers, 100);

        // Print our results
        for (Integer num : largestNumbers) {
            System.out.println(num);
        }
    }

    private static ArrayList<Integer> findLargestNumbers(ArrayList<Integer> randomIntegers, int count) {

        // Create a Max Heap using a PriorityQueue with a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Here we will iterate through our list to 'mimic a stream'
        // Add all elements from the randomIntegers list to the maxHeap as they come in from the stream
        for (Integer num : randomIntegers) {
            maxHeap.offer(num);

            // If the maxHeap size exceeds the count, remove the smallest element
            // this is the part where we limit the size of the max heap in order to
            // minimize time of the heapify operation as we add elements
            if (maxHeap.size() > count) {
                maxHeap.poll();
            }
        }

        // Create a new ArrayList to return
        ArrayList<Integer> largestNumbers = new ArrayList<>();

        // Add the elements from the maxHeap to the largestNumbers list in ascending order
        while (!maxHeap.isEmpty()) {
            largestNumbers.add(maxHeap.poll());
        }

        return largestNumbers;
    }

    private static ArrayList<Integer> generateStream(int limit) {

        // Create an arrayList to return
        ArrayList<Integer> randomIntegers = new ArrayList<>();

        // Create a Random object to generate random numbers
        Random random = new Random();

        // Generate random integers and add them to the ArrayList
        for (int i = 0; i < limit; i++) {
            // Here I limit the input from 0 to max value to avoid overflow
            int randomInt = random.nextInt(Integer.MAX_VALUE);
            randomIntegers.add(randomInt);
        }

        return randomIntegers;
    }
}

