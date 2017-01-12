package Assignment3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jeroen on 11/01/2017.
 */
public class State {

    private Node pos1;
    private Node pos2;

    public State(Node pos1, Node pos2)
    {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    //code from the slides//

    LinkedList<State> dfs(State start){
        List<State> solution;
        if(isGoalState(start)){         //solution found
            solution = new LinkedList<State>();
            solution.add(start);
            return (LinkedList<State>) solution;
        }else{
            List<State> neighbours = getNeighbours(start);
            for(State neighbour : neighbours){
                solution = dfs(neighbour);
                if(goalsReached(solution)){
                    solution.addFirst(start);
                    return (LinkedList<State>) solution;
                }
            }
        }
        return new LinkedList<State>();     //no solution
    }

    //if current node (start) is FINISH
    private boolean isGoalState(State state){
        return true; //if the goal is reached
    }

    //get all toNodes from that fromNode
    private List<State> getNeighbours(State state){
        List<State> result = new LinkedList<State>();
        //state is the current node the pawn is on
        //get the maze
        //get the current node
        //find the neighbours
        //return neighbours;
    }

    private void goalsReached(){

    }

    //not reaally sure what this does..
    private void addFirst(Node node){

    }


}
