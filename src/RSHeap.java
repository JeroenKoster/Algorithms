import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

/**
 * Created by Jeroen on 01/12/2016.
 */
public class RSHeap {

    private static int HEAPSIZE = 10;
    private static int DEADSPACE = 5;


    public static void main(String[] args)
    {
        new RSHeap().run();
    }

    private void run() {
        fillInputFile(10);
    }











    private void fillInputFile(int amount_numbers) {
        try {
            Writer writer = new FileWriter("randomnumbers.txt");
            Random random = new Random();
            for (int i = 0; i < amount_numbers; i++) {
                writer.write(String.valueOf(random.nextInt(100)).toString() + ", ");
            }
            writer.flush();
            writer.close();
        }
        catch (IOException ioe) {
            System.out.println("Caught IOException: " + ioe.getMessage());
        }
    }


}
