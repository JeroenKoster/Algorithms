package Assignment2;

import java.util.Arrays;

/**
 * Created by Jeroen on 20/12/2016.
 */
public class RSHeap2 {

    private final static int ARRAY_SIZE = 10;
    private int[] heap;
    private static int HEAP_SIZE;
    private static int DEAD_SPACE = 0;

    public RSHeap2(int[] list)
    {
        HEAP_SIZE = list.length;
        this.heap = list;
        createMinHeap();
    }

    private void createMinHeap()
    {
        for (int i = (HEAP_SIZE - 1) / 2; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public int deleteSmallest()
    {
        int lastIndex = getLastIndex();
        int smallest = heap[0];
        heap[0] = heap[lastIndex];
        heap[lastIndex] = 0;
        percolateDown(0);
        return smallest;
    }

    public void insert(int number) {
        heap[getLastIndex()] = number;
        percolateUp(getLastIndex());
    }

    public void insertToDeadSpace(int number) {
        heap[getLastIndex()] = number;
        DEAD_SPACE++;
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
        if (leftChild == -1) { // No children, index is a leaf
            return;
        }
        if (rightChild == -1) { // No rightchild, just a left child
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

    private int getLastIndex()
    {
        return heap.length - DEAD_SPACE - 1;
    }

    private void Swap(int parentIndex, int childIndex)
    {
        int temp = heap[parentIndex];
        heap[parentIndex] = heap[childIndex];
        heap[childIndex] = temp;
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


    public void printAsHeap()
    {
        System.out.println("\t\t\t\t\t\t\t" + heap[0]);
        System.out.println("\t\t\t" + heap[1] + "\t\t\t\t\t\t\t\t" + heap[2]);
        System.out.println("\t" + heap[3] + "\t\t\t\t" + heap[4] + "\t\t\t\t" + heap[5] + "\t\t\t\t" + heap[6]);
        System.out.println(heap[7] + "\t\t" + heap[8] + "\t\t" + heap[9] + "\t\t");
    }
    
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

    @Override
    public String toString()
    {
        return "Heap = " + Arrays.toString(heap) + " (isValid: " + isValidHeap() + ")";
    }
}
