import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jeroen on 21/12/2016.
 */
public class Node {

    public final static int PURPLE = 1;
    public final static int BLACK = 2;
    public final static int GREEN = 3;
    public final static int YELLOW = 4;

    public final static int FINISH = 99;

    private int color;
    private int number;

    private ArrayList<Connection> connection;

    public Node(int number, int color, ArrayList<Connection> connection )
    {
        this.number = number;
        this.color = color;
        this.connection = connection;
    }
}
