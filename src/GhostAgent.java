
import java.util.List;
import java.util.Random;

public abstract class GhostAgent {
    Game game;

    /*
     * The ghost managed by the agent
     */
    Ghost ghost;

    int delay = 2;
    int scaredCoeff = 2;
    int ticksAfterLastAction = 0;

    public GhostAgent(Game game, Ghost ghost) {
        this.game = game;
        this.ghost = ghost;
    }

    public void doTick() {
        if (ghost.getIsDead())
            return;

        ghost.tick();

        if (ticksAfterLastAction == delay * (ghost.getIsScared() ? scaredCoeff : 1)) {

            ticksAfterLastAction = 0;

            game.applyAction(ghost, getNextMove());
        }

        ticksAfterLastAction += 1;
    }

    /***
     * Returns a next valid move
     */
    protected abstract PacmanAction getNextMove();
}

class RandomGhostAgent extends GhostAgent {
    Random nextMoveGenerator;

    public RandomGhostAgent(Game game, Ghost ghost) {
        super(game, ghost);

        nextMoveGenerator = new Random();
    }

    public PacmanAction getNextMove() {
        /***
         * Returns a valid move chosen randomly from the list of available ones
         */
        List<PacmanAction> availableActions = game.maze.getPacmanActions(ghost.getLocation());
        int directionIndex = nextMoveGenerator.nextInt(availableActions.size());
        return availableActions.get(directionIndex);
    }
}

class BlinkyGhostAgent extends RandomGhostAgent {
    Pacman pacman;

    public BlinkyGhostAgent(Game game, Ghost ghost, Pacman pacman) {
        super(game, ghost);

        this.pacman = pacman;
    }

    @Override
    public PacmanAction getNextMove() {

        Coordinate pacmanLocation = game.getPacman().getLocation();
        Coordinate ghostLocation = ghost.getLocation();

        SearchProblem<PacmanPositionSearchState, PacmanAction> solution1 = new PacmanPositionSearchProblem(
                game.getMaze(), pacmanLocation, ghostLocation);
        Solution<PacmanPositionSearchState, PacmanAction> solution2 = GraphSearch.search("ucs", solution1, null, false);

        return solution2.actions.get(0);
    }
}
//