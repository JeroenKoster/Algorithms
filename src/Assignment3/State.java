package Assignment3;

/**
 * Created by Jeroen on 11/01/2017.
 */
public class State {

    private Node pos1;
    private Node pos2;

    public State(Node pos1, Node pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public Node getPos1()
    {
        return pos1;
    }

    public Node getPos2()
    {
        return pos2;
    }

    @Override
    public String toString()
    {
        return   "\t\t[" + pos1.getNumber() + "]" +
                "   \t[" + pos2.getNumber() + "]";
    }
}
