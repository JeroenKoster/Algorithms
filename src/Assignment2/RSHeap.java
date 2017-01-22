package Assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by Jeroen on 20/12/2016.
 */
public class RSHeap {

    private int[] heap;
    private static int MAX_HEAP_SIZE;
    private static int DEAD_SPACE = 0;


    /**
     * Constructor for RSHeap
     * @param maxHeapSize the maximum amount of numbers to fit in this Heap
     */
    public RSHeap(int maxHeapSize)
    {
        MAX_HEAP_SIZE = maxHeapSize;
        this.heap = new int[maxHeapSize];
    }

    /**
     * Performs a percolateDown on the top half of the heap, to create a min-Heap
     */
    private void createMinHeap()
    {
        for (int i = (MAX_HEAP_SIZE - 1) / 2; i >= 0; i--) {
            if (heap[i] == 0) {
                Swap(i, getLastIndex());
                DEAD_SPACE++;
            }
            percolateDown(i);
        }
    }

    /**
     * Deletes the smallest element from the heap (that isn't 0)
     * @return the smallest int
     */
    public int deleteSmallest()
    {
        int smallest = heap[0];
        heap[0] = 0;
        return smallest;
    }

    /**
     * Inserts a number in the top of the heap, and then percolates down
     * @param number
     */
    public void insert(int number) {
        heap[0] = number;
        percolateDown(0);
    }

    /**
     * Inserts a number to the DeadSpace (the end of the list), and increases the DeadSpace size by 1
     * @param number
     */
    public void insertToDeadSpace(int number) {
        heap[0] = number;
        Swap(0, getLastIndex());
        DEAD_SPACE++;
        percolateDown(0);
    }

    private void percolateUp(int index)
    {
        if (getParent(index) > heap[index]) {
            Swap(getParentIndex(index), index);
            percolateUp(getParentIndex(index));
        }
    }

    private void percolateDown(int index)
    {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if (leftChild == -1 || leftChild == 0) { // No children, index is a leaf or deadspace
            return;
        }
        if (rightChild == -1 || rightChild == 0) { // No rightchild, just a left child
            if (leftChild < heap[index]) {
                Swap(index, leftChildIndex);
                percolateDown(leftChildIndex);
            }
        } else if (leftChild <= rightChild && leftChild < heap[index]) {
            Swap(index, leftChildIndex);
            percolateDown(leftChildIndex);
        } else if (rightChild < heap[index] ) {
            Swap(index, rightChildIndex);
            percolateDown(rightChildIndex);
        }
    }

    /**
     * @return index of last element that is not part of deadSpace
     */
    private int getLastIndex()
    {
        return heap.length - DEAD_SPACE - 1;
    }

    private void Swap(int index1, int index2)
    {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    /**
     * returns the value of the rightChild of the entered index (uses getRightChildIndex)
     * @param index
     * @return heapValue of rightChild
     */
    private int getRightChild(int index)
    {
        int rightChildIndex = getRightChildIndex(index);
        if (rightChildIndex == -1) {
            return -1;
        } else {
            return heap[rightChildIndex];
        }
    }

    /**
     * Calculates the index of the rightchild of the entered index
     * @param index
     * @return childIndex or -1 if rightChild is not found;
     */
    private int getRightChildIndex(int index)
    {
        int rightChildIndex = (index * 2) + 2;
        if (rightChildIndex > getLastIndex()) {
            return -1;
        } else {
            return rightChildIndex;
        }
    }
    /**
     * returns the value of the leftChild of the entered index (uses getLeftChildIndex)
     * @param index
     * @return heapValue of leftChild
     */
    private int getLeftChild(int index)
    {
        int leftChildIndex = getLeftChildIndex(index);
        if (leftChildIndex == -1) {
            return -1;
        }
        return heap[leftChildIndex];
    }

    /**
     * Calculates the index of the left child of the entered index
     * @param index
     * @return childIndex or -1 if leftChild is not found;
     */
    private int getLeftChildIndex(int index)
    {
        int leftChildIndex = (index * 2) + 1;
        if (leftChildIndex > getLastIndex()) {
            return -1;
        }
        return leftChildIndex;
    }

    private int getParent(int index)
    {
        if (index == 0) {
            System.out.println("index already the root");
        }
        return heap[getParentIndex(index)];
    }

    private int getParentIndex(int index)
    {
        if (index == 0) {
            System.out.println("index already the root");
        }
        return (index - 1) / 2;
    }

    /**
     * Ugly hard-coded Method that tries to print a heap of size 10 in the shape of a heap
     */
    public void printAsHeap()
    {
        System.out.println("\t\t\t\t\t\t\t" + heap[0]);
        System.out.println("\t\t\t" + heap[1] + "\t\t\t\t\t\t\t\t" + heap[2]);
        System.out.println("\t" + heap[3] + "\t\t\t\t" + heap[4] + "\t\t\t\t" + heap[5] + "\t\t\t\t" + heap[6]);
        System.out.println(heap[7] + "\t\t" + heap[8] + "\t\t" + heap[9] + "\t\t");
    }

    /**
     * Loops through a heap to check if te heap is actually valid (all children are a higher number than their parent)
     * @return boolean
     */
    public boolean isValidHeap() {
        for (int i = 0 ; i < (getLastIndex() /2); i++) {
            if (getRightChildIndex(i) == 0) {
                int counter = 1;
                if (getLeftChild(i) == 0)
                    i = 2;
                for (int k = i+1; k < heap.length; k++) {
                    if (heap[k] == 0) {
                        counter++;
                    }
                    else {
                        return false; // Empty space not at the end of array
                    }
                }
                System.out.println("DeadSpace is size: " + counter);
            }
            if (getLeftChild(i) != -1 && getLeftChild(i) < heap[i]) {
                return false;
            }
            if (getRightChild(i) != -1 && getRightChild(i) < heap[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param inputFile
     * @param outputFile
     * @param amount
     */
    public void sort(File inputFile, File outputFile, int amount)
    {
        try {
            Scanner scanner = new Scanner(inputFile);
            int i = 0;
            // Fill the heap with numbers from the inputFile
            while (scanner.hasNext() && i < amount && i < MAX_HEAP_SIZE) {
                if (scanner.hasNextInt()) {
                    heap[i] = scanner.nextInt();
                    i++;
                } else {
                    scanner.next();
                }
            }
            // Heap is filled and build into minHeap
            createMinHeap();
            System.out.println(toString());
            i = 0;
            int currentSmallest;
            int lastOutputNumber = 0;
            int nextInt = 0;
            Writer writer = new FileWriter(outputFile);
            while (i < amount ) {
                if (DEAD_SPACE == MAX_HEAP_SIZE) { // If DeadSpace is full
                    DEAD_SPACE = 0;
                    createMinHeap();
                    System.out.println("Deadspace full, rebuilded the heap: \n" + toString());
                    lastOutputNumber = -1;
                    writer.write("\n");
                }
                currentSmallest = deleteSmallest();
                if (currentSmallest >= lastOutputNumber) { // Smallest number can be transferred to the outputFile
                    writer.write(String.valueOf(currentSmallest) + ' ');
                    writer.flush();
                    System.out.println("[" + currentSmallest + "] moved to output");
                    lastOutputNumber = currentSmallest;
                    if (scanner.hasNextInt()) {
                        nextInt = scanner.nextInt(); // Retrieve a new number from the input file
                        insert(nextInt);
                    } else {
                        System.out.println("inputFile empty");
                    }
                    System.out.println("after inserting [" + String.valueOf(nextInt) + "] : \n" + toString());
                    i++;
                } else {
                    insertToDeadSpace(currentSmallest);
                    System.out.println("Moving [" + currentSmallest + "] to DeadSpace (previous smallest was: " + lastOutputNumber + ")");
                    System.out.println(toString());
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @Override
    public String toString()
    {
        int heapLength = heap.length;
        StringBuilder builder = new StringBuilder();
        builder.append("Heap : ");
        for (int i = 0 ; i < heapLength; i++) {
            if (i == heapLength - DEAD_SPACE)
                builder.append(" || ");
            if (i < heapLength - DEAD_SPACE) {
                builder.append("[" + heap[i] + "]");
            } else {
                builder.append("(" + heap[i] + ")");
            }
        }
        builder.append(" \t (DeadSpace: " + DEAD_SPACE +")");
        builder.append(" (isValid: " + isValidHeap() + ")\n");
        return builder.toString();
    }

    public static void setMaxHeapSize(int maxHeapSize)
    {
        MAX_HEAP_SIZE = maxHeapSize;
    }
}
