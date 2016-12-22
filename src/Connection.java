/**
 * Created by Jeroen on 22/12/2016.
 */
public class Connection {

    public final static int PURPLE = 1;
    public final static int BLACK = 2;
    public final static int GREEN = 3;
    public final static int YELLOW = 4;

    private int fromNode;
    private int toNode;

    private int arrowColor;

    public Connection(int fromNode, int toNode, int arrowColor)
    {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.arrowColor = arrowColor;
    }
}
