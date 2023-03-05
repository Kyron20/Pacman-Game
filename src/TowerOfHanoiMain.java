
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class TowerOfHanoiMain {
    static void usage() {
        out.println("usage: TowerofHanoiMain [<option>...]");
        out.println("options:");
        out.println("  -f <strategy> : Search strategy, one of dfs, bfs, ucs, greedy or astar");
        out.println("  -h <heuristic> : Search heuristic to use (name of the class)");
        out.println("  --help : Print this message and exit");
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
        Integer[][] disks = { { 4, 3, 2, 1 }, {}, {} };
        String function = "ucs";
        String heuristicName = "NullHeuristic";

        for (int i = 0; i < args.length; ++i) {
            String s = args[i];
            switch (s) {
                case "-f":
                    function = args[++i];
                    break;
                case "-h":
                    heuristicName = args[++i];
                    break;
                case "--help":
                    usage();
                default:
                    usage();
            }
        }

        /*
         * Instantiate the search problem.
         */
        TowerOfHanoiSearchProblem problem = new TowerOfHanoiSearchProblem(disks);

        /*
         * Instantiate the heuristic. By default it is the trivial heuristic
         * (NullHeuristic), that always returns 0.
         */
        SearchHeuristic<TowerOfHanoiSearchState, TowerOfHanoiAction> heuristic = (SearchHeuristic) Class
                .forName(heuristicName).getConstructor().newInstance();

        Solution<TowerOfHanoiSearchState, TowerOfHanoiAction> solution = GraphSearch.search(function, problem,
                heuristic, true);

        /*
         * Print the solution
         */
        TowerOfHanoiSearchState startState = problem.getStartState();
        System.out.println(startState);

        TowerOfHanoiSearchState currState = startState;
        for (TowerOfHanoiAction action : solution.actions) {
            TowerOfHanoiSearchState succState = problem.getSuccessor(currState, action);
            System.out.println(succState);
            currState = succState;
        }
    }
}

class TowerOfHanoiSearchProblem extends SearchProblem<TowerOfHanoiSearchState, TowerOfHanoiAction> {

    // TODO: implement here

    public TowerOfHanoiSearchProblem(Integer[][] disks) {

        /*
         * disks: an array of 3 arrays, each representing a stack of disks.
         * Bigger numbers represent bigger disks. Each number must appear only once.
         * 
         * [[3, 2, 1], [], []]
         * 
         * represents the following configuration:
         * 
         * | 1 | | |
         * | 2 | | |
         * | 3 | | |
         * -------------
         * 
         * [[5, 4], [], [3, 2, 1]]
         * 
         * represents the following configuration:
         * 
         * | | | |
         * | | | |
         * | | | 1 |
         * | 4 | | 2 |
         * | 5 | | 3 |
         * -------------
         * 
         */

        // TODO: implement here
    }

    @Override
    public TowerOfHanoiSearchState getStartState() {
        // TODO: implement here
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public boolean isGoalState(TowerOfHanoiSearchState state) {

        // TODO: implement here
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public List<TowerOfHanoiAction> getActions(TowerOfHanoiSearchState state) {
        // TODO: implement here
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public TowerOfHanoiSearchState getSuccessor(TowerOfHanoiSearchState state, TowerOfHanoiAction action) {
        // TODO: implement here
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public double getCost(TowerOfHanoiSearchState state, TowerOfHanoiAction action) {
        // TODO: implement here
        throw new RuntimeException("Not Implemented");

    }

}

class TowerOfHanoiSearchState implements SearchState {

    // TODO: implement here

    @Override
    public String toString() {
        // TODO: implement here
        throw new RuntimeException("Not Implemented");
    }
}

enum TowerOfHanoiAction implements Action {
    /**
     * Action to move the top disk from stack i to stack j
     */
    // TODO: implement here
}

class TowerOfHanoiHeuristic implements SearchHeuristic<TowerOfHanoiSearchState, TowerOfHanoiAction> {

    public TowerOfHanoiHeuristic() {
    }

    @Override
    public Double value(TowerOfHanoiSearchState state,
            SearchProblem<TowerOfHanoiSearchState, TowerOfHanoiAction> problem) {

        if (problem instanceof TowerOfHanoiSearchProblem) {
            // TODO: implement here
            return (double) 0.0;
        }

        return 0.0;
    }
}
