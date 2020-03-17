package creatures;

import huglife.*;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestClorus {

    @Test
    public void testReplicate() {
        // TODO
        Clorus p=new Clorus(0.7);
        Clorus m=p.replicate();

        assertNotEquals(p,m); // Asserts that two objects do not refer to the same object.
        assertEquals(0.35, m.energy(),0.01);

    }

    /**
     * Cloruses should obey exactly the following behavioral rules:
     * If there are no empty squares, the Clorus will STAY (even if there are Plips nearby they could attack since plip squares do not count as empty squares).
     * Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     * Otherwise, if the Clorus has energy greater than or equal to one, it will REPLICATE to a random empty square.
     * Otherwise, the Clorus will MOVE to a random empty square.
     */
    @Test
    public void testChoice(){
        // No empty adjacent spaces; stay.
        Clorus m=new Clorus(1.5);
        Plip p = new Plip(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, p);
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = m.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        //seen Plip,attack
        Clorus n=new Clorus(1.5);
        Plip q = new Plip(1.2);
        HashMap<Direction, Occupant> surrounded1 = new HashMap<Direction, Occupant>();
        surrounded1.put(Direction.TOP, q);
        surrounded1.put(Direction.BOTTOM, new Empty());
        surrounded1.put(Direction.LEFT, new Impassible());
        surrounded1.put(Direction.RIGHT, new Impassible());

        Action actual1 = n.chooseAction(surrounded1);
        Action expected1 = new Action(Action.ActionType.ATTACK,Direction.TOP);

        assertEquals(expected1, actual1);

        //if the Clorus has energy greater than or equal to one, it will REPLICATE to a random empty square.
        Clorus o=new Clorus(1.5);

        HashMap<Direction, Occupant> surrounded2 = new HashMap<Direction, Occupant>();
        surrounded2.put(Direction.TOP, new Empty());
        surrounded2.put(Direction.BOTTOM, new Impassible());
        surrounded2.put(Direction.LEFT, new Impassible());
        surrounded2.put(Direction.RIGHT, new Impassible());

        Action actual2 = o.chooseAction(surrounded2);
        Action expected2 = new Action(Action.ActionType.REPLICATE,Direction.TOP);

        assertEquals(expected2, actual2);

        //if the Clorus has energy greater than or equal to one, it will REPLICATE to a random empty square.
        Clorus  r=new Clorus(0.8);

        HashMap<Direction, Occupant> surrounded3 = new HashMap<Direction, Occupant>();
        surrounded3.put(Direction.TOP, new Empty());
        surrounded3.put(Direction.BOTTOM, new Impassible());
        surrounded3.put(Direction.LEFT, new Impassible());
        surrounded3.put(Direction.RIGHT, new Impassible());

        Action actual3 = r.chooseAction(surrounded3);
        Action expected3 = new Action(Action.ActionType.MOVE,Direction.TOP);

        assertEquals(expected3, actual3);


    }


}
