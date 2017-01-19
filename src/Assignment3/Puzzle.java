package Assignment3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jeroen on 21/12/2016.
 */
public class Puzzle {
    // TODO: swapping the 2 nodes in a state should not matter

    public final static int PURPLE = 1;
    public final static int BLACK = 2;
    public final static int GREEN = 3;
    public final static int YELLOW = 4;

    public final static int FINISH = 99;

    private ArrayList<Node> maze;

    public static void main(String[] args) {
        new Puzzle().run();
    }

    /**
     * Adds nodes, then adds connections, then does dfs on start-position 1 & 2
     */
    public void run() {
        maze = new ArrayList<>();
        initializeNodes();
        initializeConnections();
        State startState = new State(maze.get(0), maze.get(1)); // Setup the starting positions of the 2 virtual pawns.
        LinkedList<State> solution = dfs(startState); // Tries to find the shortest solution recursively
        System.out.println("Solution.size = " + solution.size() + "\nPos 1 \tPos 2" );
        for (State s : solution) {
            System.out.println(s.toString());
        }
    }

    private LinkedList<State> dfs(State start) {
        LinkedList<State> solution;
        if (isGoalState(start)) {         //solution found
            solution = new LinkedList<State>();
            solution.add(start);
            return solution;
        } else {
            List<State> neighbours = getNeighbours(start);
            for (State neighbour : neighbours) {
                solution = dfs(neighbour);
                if (solution.size() > 0) { // Goal is reached
                    solution.addFirst(start);
                    return solution;
                }
            }
        }
        return new LinkedList<State>();     //no solution
    }

    //if one of the current state's nodes is FINISH
    private boolean isGoalState(State state) {
        return (state.getPos1().getNumber() == FINISH ||
                state.getPos2().getNumber() == FINISH);
    }

    /**
     * returns the neighbour states of the entered state
     * (1 pawn will stay put, and one will move to the next node)
     * @param state
     * @return neighbourState
     */
    private List<State> getNeighbours(State state) {
        Node pos1 = state.getPos1();
        Node pos2 = state.getPos2();
        ArrayList<State> neighbourStates = new ArrayList<State>();
        for (Connection c : pos1.getConnections()) {
            if (c.getArrowColor() == pos2.getColor()) {
                neighbourStates.add(new State(c.getToNode(), pos2));
            }
        }
        for (Connection c : pos2.getConnections()) {
            if (c.getArrowColor() == pos1.getColor()) {
                neighbourStates.add(new State(c.getToNode(), pos1));
            }
        }
        return neighbourStates;
    }

    private void initializeNodes() {
        maze.add(new Node(1, PURPLE));
        maze.add(new Node(2, BLACK));
        maze.add(new Node(3, GREEN));
        maze.add(new Node(4, GREEN));
        maze.add(new Node(5, GREEN));
        maze.add(new Node(6, YELLOW));
        maze.add(new Node(7, YELLOW));
        maze.add(new Node(8, PURPLE));
        maze.add(new Node(9, PURPLE));
        maze.add(new Node(10, BLACK));
        maze.add(new Node(11, YELLOW));
        maze.add(new Node(12, PURPLE));
        maze.add(new Node(13, YELLOW));
        maze.add(new Node(14, GREEN));
        maze.add(new Node(15, YELLOW));
        maze.add(new Node(16, GREEN));
        maze.add(new Node(17, GREEN));
        maze.add(new Node(18, BLACK));
        maze.add(new Node(19, YELLOW));
        maze.add(new Node(20, GREEN));
        maze.add(new Node(21, BLACK));
        maze.add(new Node(22, BLACK));
        maze.add(new Node(FINISH, FINISH));
    }

    private void initializeConnections() {

        addConnectionToNode(1, 4, PURPLE);
        addConnectionToNode(1, 5, BLACK);
        addConnectionToNode(2, 6, GREEN);
        addConnectionToNode(2, 12, PURPLE);
        addConnectionToNode(3, 1, YELLOW);
        addConnectionToNode(3, 4, PURPLE);
        addConnectionToNode(4, 13, BLACK);
        addConnectionToNode(5, 9, YELLOW);
        addConnectionToNode(6, 9, GREEN);
        addConnectionToNode(6, 10, PURPLE);
        addConnectionToNode(7, 2, GREEN);
        addConnectionToNode(8, 3, PURPLE);
        addConnectionToNode(9, 4, GREEN);
        addConnectionToNode(9, 14, BLACK);
        addConnectionToNode(10, 15, GREEN);
        addConnectionToNode(11, 10, PURPLE);
        addConnectionToNode(11, 12, GREEN);
        addConnectionToNode(12, 7, GREEN);
        addConnectionToNode(13, 8, GREEN);
        addConnectionToNode(13, 18, GREEN);
        addConnectionToNode(14, 20, YELLOW);
        addConnectionToNode(14, FINISH, GREEN);
        addConnectionToNode(15, 22, GREEN);
        addConnectionToNode(15, FINISH, PURPLE);
        addConnectionToNode(16, 15, GREEN);
        addConnectionToNode(17, 11, BLACK);
        addConnectionToNode(17, 12, PURPLE);
        addConnectionToNode(17, 16, BLACK);
        addConnectionToNode(18, 9, YELLOW);
        addConnectionToNode(18, 20, YELLOW);
        addConnectionToNode(19, 18, GREEN);
        addConnectionToNode(20, 19, BLACK);
        addConnectionToNode(20, 21, YELLOW);
        addConnectionToNode(21, 22, YELLOW);
        addConnectionToNode(21, FINISH, BLACK);
        addConnectionToNode(22, 17, YELLOW);

    }
    private void addConnectionToNode(int node, int neighbour, int color) {
        if (node == FINISH) {
            node = maze.size();
        }
        if (neighbour == FINISH) {
            neighbour = maze.size();
        }
        maze.get(node-1).addConnection(maze.get(neighbour-1), color);
    }


}
