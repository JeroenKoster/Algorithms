package Assignment3;

import java.util.LinkedList;
import java.util.List;

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
                if (goalIsReached(solution)) {
                    solution.addFirst(start);
                    return (LinkedList<State>) solution;
                }
            }
        }
        return new LinkedList<State>();     //no solution
    }

    //the goal is reached, stop. (Or continue and find a different route to the goal)

    private boolean goalIsReached(List<State> state) {

    }

    //if current node (start) is FINISH
    private boolean isGoalState(State state) {
        return true; //if this is actually the goal state
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
