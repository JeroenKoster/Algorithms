package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;

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

    private ArrayList<Connection> connections = new ArrayList<>();

    public Node(int number, int color) {
        this.number = number;
        this.color = color;
    }

    public void addConnection(Node node, int color) {
        connections.add(new Connection(this, node, color));
    }

    public int getColor()
    {
        return color;
    }

    public int getNumber()
    {
        return number;
    }

    public ArrayList<Connection> getConnections()
    {
        return connections;
    }

    @Override
    public String toString()
    {
        int[] connectionNumbers = new int[connections.size()];
        for (int i = 0; i < connections.size(); i++) {
            connectionNumbers[i] = connections.get(i).getToNode().getNumber();
        }
        return  "Node" + number +
                "color = " + color +
                ", connections = " +
                Arrays.toString(connectionNumbers) + "\n";
    }
}
