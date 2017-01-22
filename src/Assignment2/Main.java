package Assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

/**
 * Created by Jeroen on 22/12/2016.
 */
public class Main {

    private final static String INPUT_FILE = "unsorted.txt";
    private final static String OUTPUT_FILE = "sorted.txt";
    File inputFile;
    File outputFile;

    public static void main(String[] args)
    {
        new Main().run();
    }

    public void run() {
        inputFile = new File(INPUT_FILE);
        outputFile = new File(OUTPUT_FILE);
        fillInputFile(50); // Fills the inputFile with unsorted(Random) numbers between 1 and 100
        RSHeap heap = new RSHeap(10); // Create an empty heap Object
        heap.sort(inputFile, outputFile, 50); // Fill the heap from the inputFile and export the sorted numbers to the outputFile
    }

    /**
     * Method for testing purposes that fills a text-file with random numbers
     * @param amount - the amount of random numbers generated
     */
    private void fillInputFile(int amount)
    {
        try {
            Writer writer = new FileWriter(inputFile);
            Random random = new Random();
            for (int i = 0; i < amount; i++) {
                writer.write(String.valueOf(random.nextInt(100) + 1
                ).toString() + " ");
            }
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Caught IOException: " + ioe.getMessage());
        }
    }

}
