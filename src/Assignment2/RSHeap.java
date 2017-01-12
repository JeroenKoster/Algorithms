//import java.io.*;
//import java.util.Arrays;
//import java.util.Random;
//import java.util.Scanner;
//
///**
// * Created by Jeroen on 01/12/2016.
// */
//public class RSHeap {
//
//    private static int HEAPSIZE = 10;
//    private static int DEADSPACE = 5;
//    private int[] heap;
//
//    private final static String INPUT_FILE = "randomnumbers.txt";
//
//    public static void main(String[] args)
//    {
//        new RSHeap().run();
//    }
//
//    private void run()
//    {
//        heap = new int[HEAPSIZE ];
//        int[] input;
//        input = generateUnsortedList(10);
//        System.out.println("input: \t\t" + Arrays.toString(input));
//        createHeap(input);
//        System.out.println("First heap: " + Arrays.toString(heap));
//    }
//
//    private void createHeap(int[] input)
//    {
//        heap = Arrays.copyOf(input,input.length);
//        for (int i = (heap.length - 2) / 2; i >= 0; i--) {
//            percolateDown(i);
//        }
//    }
//
//    private void percolateUp(int i)
//    {
//        if (getParent(i) >= 1) {
//            if (heap[i] < heap[getParent(i)]) {
//                swap(i, getParent(i));
//            }
//            percolateUp(getParent(i));
//        }
//    }
//
//    /**
//     * @return smallest element after deleting it from the heap
//     */
//    private int deleteSmallest()
//    {
//        int smallest = heap[0];
//        heap[0] = heap[HEAPSIZE-1];
//        heap[HEAPSIZE-1] = 0;
//        percolateDown(0);
//        return smallest;
//    }
//
//    private void percolateDown(int i)
//    {
//        int leftChild = getLeftChild(i);
//        int rightChild = getRightChild(i);
//        if (!isLeaf(i) && rightChild != -1) {
//            if (heap[leftChild] <= heap[rightChild] && heap[leftChild]< heap[i]) {
//                swap(leftChild, i);
//                percolateDown(leftChild);
//            } else if (heap[rightChild] < heap[i]) {
//                swap(rightChild, i);
//                percolateDown(rightChild);
//            }
//        }
//    }
//
//    private boolean isLeaf(int i)
//    {
//            return (i > (getHeapSize() - 2) / 2);
//    }
//
//    private int getHeapSize(){
//        return heap.length;
//    }
//
//    private void swap(int child, int parent)
//    {
//        int temp = heap[child];
//        heap[child] = heap[parent];
//        heap[parent] = temp;
//    }
//
//
//    private static int getLeftChild(int position)
//    {
//        return (2 * position) + 1;
//    }
//
//    private static int getRightChild(int position)
//    {
//        if (position >= HEAPSIZE) {
//            return 99;
//        }
//        return (2 * position) + 2;
//    }
//
//    private static int getParent(int position)
//    {
//        return (position - 1) / 2;
//    }
//
//    private int[] getNumbersFromFile()
//    {
//        int[] numbers = new int[HEAPSIZE];
//        try {
//            Scanner scanner = new Scanner(new File(INPUT_FILE));
//            int i = 0;
//            while (scanner.hasNext() && i < HEAPSIZE) {
//                if (scanner.hasNextInt()) {
//                    numbers[i] = scanner.nextInt();
//                    i++;
//                } else {
//                    scanner.next();
//                }
//            }
//        } catch (IOException ioe) {
//            System.out.println("Caught IOException: " + ioe.getMessage());
//        }
//        System.out.println(Arrays.toString(numbers));
//        return numbers;
//    }
//
//    private void fillInputFile(int amount_numbers)
//    {
//        try {
//            Writer writer = new FileWriter(INPUT_FILE);
//            Random random = new Random();
//            for (int i = 0; i < amount_numbers; i++) {
//                writer.write(String.valueOf(random.nextInt(100)).toString() + " ");
//            }
//            writer.flush();
//            writer.close();
//        } catch (IOException ioe) {
//            System.out.println("Caught IOException: " + ioe.getMessage());
//        }
//    }
//
//    private int[] generateUnsortedList(int size)
//    {
//        Random random = new Random();
//        int[] array = new int[size];
//        int randomNumber;
//        for (int i = 0; i < size; i++) {
//            randomNumber = random.nextInt(i + 1);
//            array[i] = array[randomNumber];
//            array[randomNumber] = i;
//        }
//        return array;
//    }
//
//
//}
