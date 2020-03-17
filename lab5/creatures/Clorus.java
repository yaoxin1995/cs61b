package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Random;

public class Clorus extends Creature {
    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * probability of taking a move when ample space available.
     */
    private double moveProbability=0.5;


    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    @Override
    public String name() {
        return name;
    }

    /**
     * Clorus should lose 0.03 units of energy when moving. If you want to
     * to avoid the magic number warning, you'll need to make a
     * private static final variable. This is not required for this lab.
     */
    @Override
    public void move() {
        // TODO
        energy=energy-0.03;
       /* if(energy<0)
            energy=0;

        */
    }

    /**
     * Clorus lose 0.01 energy when staying
     */
    public void stay() {
        // TODO

        energy=energy-0.1;
        /*if(energy>2)
            energy=2;

         */
    }

    @Override
    public Color color() {
        return  color(r,g,b);
        //return color(r, g, b);
    }

    @Override

    /**
     * a Clorus attack another creature ,it should gain that creature's energy.
     */
    public void attack(Creature c) {
        // do nothing.
        energy+=c.energy();
    }

    /**
     * Clorus and their offspring each get 50% of the energy, with none
     * lost to the process. Now that's efficiency! Returns a baby
     * Plip.
     */
    public Clorus replicate() {
        Clorus m=new Clorus(energy*0.5);
        this.energy=energy*0.5;
        return m;
    }

    @Override
    /**
     * Cloruses should obey exactly the following behavioral rules:
     * If there are no empty squares, the Clorus will STAY (even if there are Plips nearby they could attack since plip squares do not count as empty squares).
     * Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     * Otherwise, if the Clorus has energy greater than or equal to one, it will REPLICATE to a random empty square.
     * Otherwise, the Clorus will MOVE to a random empty square.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> impossibleNeighbors=new ArrayDeque();
        Deque<Direction> plipNeighbors=new ArrayDeque();
        boolean anyPlip = false;
        for(Direction key: neighbors.keySet()){
            if(neighbors.get(key).name().equals("empty"))
                emptyNeighbors.add(key);
            else if(neighbors.get(key).name().equals("plip"))
                plipNeighbors.add(key);

        }

        if(emptyNeighbors.size()==0)
            return new Action(Action.ActionType.STAY);
        else if(plipNeighbors.size()>0)
            return new Action(Action.ActionType.ATTACK,randomEntry(plipNeighbors));
        else if(energy>=1)
            return new Action(Action.ActionType.REPLICATE,randomEntry(emptyNeighbors));
        else
            return  new Action(Action.ActionType.MOVE,randomEntry(emptyNeighbors));
    }

    private Direction randomEntry(Deque<Direction> emptyNeighbors){
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(emptyNeighbors.size());
        Object[] direction=emptyNeighbors.toArray();
        Direction pickDirection=(Direction) direction[index];
        return pickDirection;
    }

}
