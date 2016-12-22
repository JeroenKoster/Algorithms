import java.util.Arrays;
import java.util.Random;

/**
 * Created by Jeroen on 17/11/2016.
 */
public class Assignment {

    long counter = 0;
    int[] array = new int[N];

    private final static int N = 10;

    Random random = new Random();


    public void fillArray1() {
        int randomNumber = 0;
        for (int i = 0; i < N ; i++) {
            boolean inList = true;
            while (inList){
                inList = false;
                randomNumber = random.nextInt(N);
                for (int j = 0; j < i; j++) {
                    counter++;
                    if (array[j] == randomNumber) {
                        inList = true;
                        break;
                    }
                }
             }
            array[i] = randomNumber;
        }
    }

    public void fillArray2() {
        counter = 0;
        boolean[] usedNumbers = new boolean[N];
        int randomNumber = 0;

        for (int i = 0; i < N; i++) {
            boolean filled = false;
            while (!filled) {
                counter++;
                randomNumber = random.nextInt(N);
                if (!usedNumbers[randomNumber]) {
                    array[i] = randomNumber;
                    usedNumbers[randomNumber] = true;
                    filled = true;
                }
            }
        }
    }

//    public void fillArray2() {
//        counter = 0;
//        boolean[] usedNumbers = new boolean[N];
//        int randomNumber = 0;
//
//        for (int i = 0; i < N; i++) {
//            boolean filled = false;
//            while (!filled) {
//                counter++;
//                randomNumber = random.nextInt(N);
//                if (!usedNumbers[randomNumber]) {
//                    array[i] = randomNumber;
//                    usedNumbers[randomNumber] = true;
//                    filled = true;
//                }
//            }
//        }
//        System.out.println(counter);
//    }

    public void fillArray3() {
        int randomNumber;
        counter = 0;
        for (int i = 0; i < N; i++) {
            randomNumber = random.nextInt(i+1);
            array[i] = array[randomNumber];
            array[randomNumber] = i;
            counter++;
        }
        System.out.println(counter);
    }

    public static void main(String[] args)
    {
        new Assignment().run();
    }

    public void run() {
        System.out.println(N);
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();

            fillArray3();
            System.out.println(Arrays.toString(array));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

    }

}
