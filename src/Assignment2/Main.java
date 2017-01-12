package Assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Jeroen on 22/12/2016.
 */
public class Main {

    private static int HEAPSIZE = 10;
    int[] input;
    ArrayList<Integer> output = new ArrayList<>();

    private final static String INPUT_FILE = "unsorted.txt";
    private final static String OUTPUT_FILE = "sorted.txt";


    public static void main(String[] args)
    {
        new Main().run();
    }

    public void run() {
        int nextInputIndex = 10;
        fillInputFile(100);
        input = getNumbersFromFile(100);
        RSHeap2 heap = new RSHeap2(Arrays.copyOf(input,10));
        heap.printAsHeap();
        System.out.println(heap.toString());
//        if (output.size() == 0 || smallest > output.get(output.size()-1)) {
//            output.add(smallest);
//            heap.insert(nextInputIndex);
//            nextInputIndex++;
//        } else {
//            heap.insertToDeadSpace(smallest);
//        }
    }

    private int[] getNumbersFromFile(int amount)
    {
        int[] numbers = new int[amount];
        try {
            Scanner scanner = new Scanner(new File(INPUT_FILE));
            int i = 0;
            while (scanner.hasNext() && i < amount) {
                if (scanner.hasNextInt()) {
                    numbers[i] = scanner.nextInt();
                    i++;
                } else {
                    scanner.next();
                }
            }
        } catch (IOException ioe) {
            System.out.println("Caught IOException: " + ioe.getMessage());
        }
        return numbers;
    }

    private void fillInputFile(int amount)
    {
        try {
            Writer writer = new FileWriter(INPUT_FILE);
            Random random = new Random();
            for (int i = 0; i < amount; i++) {
                writer.write(String.valueOf(random.nextInt(100)).toString() + " ");
            }
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Caught IOException: " + ioe.getMessage());
        }
    }

}
