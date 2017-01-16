package Assignment3;

/**
 * Created by Jeroen on 22/12/2016.
 */
public class Connection {

    public final static int PURPLE = 1;
    public final static int BLACK = 2;
    public final static int GREEN = 3;
    public final static int YELLOW = 4;

    private Node startNode;
    private Node toNode;

    private int arrowColor;

    public int getArrowColor()
    {
        return arrowColor;
    }

    public Connection(Node startNode, Node endNode, int arrowColor) {
        this.startNode = startNode;
        this.toNode = endNode;
        this.arrowColor = arrowColor;
    }

    public Node getToNode()
    {
        return toNode;
    }
}
