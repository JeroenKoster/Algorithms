package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jeroen on 21/12/2016.
 */
public class Assignment3 {

    public final static int PURPLE = 1;
    public final static int BLACK = 2;
    public final static int GREEN = 3;
    public final static int YELLOW = 4;

    public final static int FINISH = 99;

    private ArrayList<Node> maze;

    public static void main(String[] args) {
        new Assignment3().run();
    }

    public void run() {
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
                        new Connection(21, 22, YELLOW),
                        new Connection(21, FINISH, BLACK)
                ))));
        maze.add(new Node(22, Node.BLACK,
                new ArrayList<>(Arrays.asList(
                        new Connection(22, 17, YELLOW)
                ))));
        maze.add(new Node(Node.FINISH, Node.FINISH, null));
    }


    //code from the slides//

    private LinkedList<State> dfs(State start) {
        List<State> solution;
        if (isGoalState(start)) {         //solution found
            solution = new LinkedList<State>();
            solution.add(start);
            return (LinkedList<State>) solution;
        } else {
            List<State> neighbours = getNeighbours(start);
            for (State neighbour : neighbours) {
                solution = dfs(neighbour);
                if (goalIsReached(solution)) {      //TODO: this shoulnd be a boolean, isGoal state is a boolean already
                    solution.addFirst(start);
                    return (LinkedList<State>) solution;
                }
            }
        }
        return new LinkedList<State>();     //no solution
    }

    //the goal is reached, stop. (Or continue and find a different route to the goal)
    private void goalIsReached(List<State> state) {
        //TODO: this is what happens when we reach finish,
        // not a check is this node is finish
        //this is what its like in the pseudo code tho
    }

    //if current node (start) is FINISH
    private boolean isGoalState(State state) {
        if (maze.get(Integer.valueOf(String.valueOf(state))).equals(FINISH)) {  //looks bad, could be better?
            return true;
        } else { //not FINISH
            return false;
        }
    }

    //get all toNodes from that fromNode
    private List<State> getNeighbours(State state) {
        List<State> result = new LinkedList<State>();
        //state is the current node the pawn is on
        //get the maze
        //get the current node
        //find the neighbours
        //return neighbours;
    }

    //TODO: addFirst method


}
