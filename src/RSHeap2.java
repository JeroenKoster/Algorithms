import java.util.Arrays;

/**
 * Created by Jeroen on 20/12/2016.
 */
public class RSHeap2 {

    private final static int ARRAY_SIZE = 10;
    private int[] list = new int[ARRAY_SIZE];
    public static void main(String[] args)
    {
        new RSHeap2().run();
    }

    public void run()
    {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            list[i] = 10-i;
            //list[i] = i+1;
        }
        System.out.println(Arrays.toString(list));
        printHeap();
        createMinHeap();
        System.out.println();
    }

    private void createMinHeap() {
        for (int i = (list.length-1)/2; i >= 0 ; i--) {
            percolateDown(i);
        }
    }

    private void percolateUp(int index) {
        if (getParent(index) > list[index]) {
            swap(getParentIndex(index), index);
        }
        percolateUp(getParentIndex(index));
    }

    private void percolateDown(int index) {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        if (leftChild == -1) { // No children, index is a leaf
            System.out.println("no children for index [" + index + "], can't percolate down");
            return;
        }
        if (rightChild == -1) { // No rightchild, just a left child
            System.out.println("only a left child available for index [" + index + "]");
            if (leftChild < list[index]) {
                swap(index, leftChildIndex);
                percolateDown(leftChildIndex);
            }
        }
        else if(leftChild <= rightChild && leftChild < list[index]) {
            swap(index, leftChildIndex);
            percolateDown(leftChildIndex);
        }
        else if(rightChild < list[index]) {
            swap(index, rightChildIndex);
            percolateDown(rightChildIndex);
        }
    }

    private int getLastIndex() {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 0) {
                return i-1;
            }
        }
        return list.length-1;
    }

    private void swap(int parentIndex, int childIndex) {
        int temp = list[parentIndex];
        list[parentIndex] = list[childIndex];
        list[childIndex] = temp;
    }

    private int getRightChild(int index) {
        if (index == -1) {
            return -1;
        }
        return list[getRightChildIndex(index)];
    }

    private int getRightChildIndex(int index) {
        int rightChildIndex = (index * 2) + 2;
        if (rightChildIndex > getLastIndex()) {
            System.out.println("index " + index + "doesn't have a right child");
            return -1;
        }
        return rightChildIndex;
    }

    private int getLeftChild(int index) {
        if (index == -1) {
            return -1;
        }
        return list[getLeftChildIndex(index)];
    }
    
    private int getLeftChildIndex(int index) {
        int leftChildIndex = (index * 2) + 1;
        if (leftChildIndex > getLastIndex()) {
            System.out.println("index " + index + "doesn't have a left child");
            return -1;
        }
        return leftChildIndex;
    }

    private int getParent(int index) {
        if (index == 0) {
            System.out.println("index already the root");
        }
        return list[getParentIndex(index)];
    }

    private int getParentIndex(int index) {
        if (index == 0) {
            System.out.println("index already the root");
        }
        return (index-1) /2;
    }
    
    
    private void printHeap() {
        System.out.println("\t\t\t\t\t\t\t" + list[0]);
        System.out.println("\t\t\t" + list[1] + "\t\t\t\t\t\t\t\t"+ list[2]);
        System.out.println("\t" + list[3] + "\t\t\t\t"+ list[4]+ "\t\t\t\t"+ list[5]+ "\t\t\t\t"+ list[6]);
        System.out.println(list[7] + "\t\t"+ list[8]+ "\t\t"+ list[9]+ "\t\t");
    }
}
