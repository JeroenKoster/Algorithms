import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Jeroen on 21/12/2016.
 */
public class Assignment3 {

    public final static int PURPLE = 1;
    public final static int BLACK = 2;
    public final static int GREEN = 3;
    public final static int YELLOW = 4;

    public final static int FINISH = 99;

    public static void main(String[] args)
    {
        new Assignment3().run();
    }


    public void run()
    {
        maze.add(new Node(1, Node.PURPLE,
                new ArrayList<>(Arrays.asList(
                        new Connection(1, 4, PURPLE),
                        new Connection(1, 5, BLACK)
                ))));
        maze.add(new Node(2, Node.BLACK,
                new ArrayList<>(Arrays.asList(
                        new Connection(2, 6, GREEN),
                        new Connection(2, 12, PURPLE)
                ))));
        maze.add(new Node(3, Node.GREEN,
                new ArrayList<>(Arrays.asList(
                        new Connection(3, 4, PURPLE)
                ))));
        maze.add(new Node(4, Node.GREEN,
                new ArrayList<>(Arrays.asList(
                        new Connection(4, 13, BLACK)
                ))));
        maze.add(new Node(5, Node.GREEN,
                new ArrayList<>(Arrays.asList(
                        new Connection(5, 9, YELLOW)
                ))));
        maze.add(new Node(6, Node.YELLOW,
                new ArrayList<>(Arrays.asList(
                        new Connection(6, 9, GREEN),
                        new Connection(6, 10, PURPLE)
                ))));
        maze.add(new Node(7, Node.YELLOW,
                new ArrayList<>(Arrays.asList(
                        new Connection(7, 2, GREEN)
                ))));
        maze.add(new Node(8, Node.PURPLE,
                new ArrayList<>(Arrays.asList(
                        new Connection(8, 3, PURPLE)
                ))));
        maze.add(new Node(9, Node.PURPLE,
                new ArrayList<>(Arrays.asList(
                        new Connection(9, 4, GREEN),
                        new Connection(9, 14, BLACK)
                ))));
        maze.add(new Node(10, Node.BLACK,
                new ArrayList<>(Arrays.asList(
                        new Connection(10, 15, GREEN)
                ))));
        maze.add(new Node(11, Node.YELLOW,
                new ArrayList<>(Arrays.asList(
                        new Connection(11, 10, PURPLE),
                        new Connection(11, 12, GREEN)
                ))));
        maze.add(new Node(12, Node.PURPLE,
                new ArrayList<>(Arrays.asList(
                        new Connection(12, 7, GREEN)
                ))));
        maze.add(new Node(13, Node.YELLOW,
                new ArrayList<>(Arrays.asList(
                        new Connection(13, 8, GREEN),
                        new Connection(13, 18, GREEN)
                ))));
        maze.add(new Node(14, Node.GREEN,
                new ArrayList<>(Arrays.asList(
                        new Connection(14, 20, YELLOW),
                        new Connection(14, FINISH, GREEN)
                ))));
        maze.add(new Node(15, Node.YELLOW,
                new ArrayList<>(Arrays.asList(
                        new Connection(15, 22, GREEN),
                        new Connection(15, FINISH, PURPLE)
                ))));
        maze.add(new Node(16, Node.GREEN,
                new ArrayList<>(Arrays.asList(
                        new Connection(16, 15, GREEN)
                ))));
        maze.add(new Node(17, Node.GREEN,
                new ArrayList<>(Arrays.asList(
                        new Connection(17, 11, BLACK),
                        new Connection(17, 12, PURPLE),
                        new Connection(17, 16, BLACK)
                ))));
        maze.add(new Node(18, Node.BLACK,
                new ArrayList<>(Arrays.asList(
                        new Connection(18, 9, YELLOW),
                        new Connection(18, 20, YELLOW)
                ))));
        maze.add(new Node(19, Node.YELLOW,
                new ArrayList<>(Arrays.asList(
                        new Connection(19, 18, GREEN)
                ))));
        maze.add(new Node(20, Node.GREEN,
                new ArrayList<>(Arrays.asList(
                        new Connection(20, 19, BLACK),
                        new Connection(20, 21, YELLOW)
                ))));
        maze.add(new Node(21, Node.BLACK,
                new ArrayList<>(Arrays.asList(
                        new Connection(21,22,YELLOW),
                        new Connection(21,FINISH,BLACK)
                ))));
        maze.add(new Node(22, Node.BLACK,
                new ArrayList<>(Arrays.asList(
                        new Connection(22,17,YELLOW)
                ))));
        maze.add(new Node(Node.FINISH, Node.FINISH, null));
    }

    private ArrayList<Node> maze;


}
