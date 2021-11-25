package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class GrassFieldTest {

    IWorldMap map = new GrassField(10);
    Animal muskox  = new Animal(map, new Vector2d(1,1));
    Animal xolo  = new Animal();
    Animal civet  = new Animal(map, new Vector2d(5,5));
    Animal blobfish = new Animal(map,new Vector2d(3,4));


    @Test
    public void testcanMoveTo(){
        map.place(muskox);
        map.place(xolo);
        map.place(civet);

        assertTrue(map.canMoveTo(new Vector2d(2,5)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
        assertTrue(map.canMoveTo((new Vector2d(6,1))));
    }

    @Test
    public void testPlace(){
        assertTrue(map.place(muskox));
        assertTrue(map.place(xolo));
        assertFalse(map.place(new Animal()));
        assertFalse(map.place(new Animal(map, new Vector2d(1,1))));
    }

    @Test
    public void testidOccupied(){
        map.place(muskox);
        map.place(xolo);
        map.place(civet);

        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertFalse(map.isOccupied(new Vector2d(3,4)));
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(0,0)));
        assertTrue(map.isOccupied(new Vector2d(5,5)));
    }

    @Test
    public void testobjectAt(){
        map.place(muskox);
        map.place(xolo);
        map.place(civet);

        assertEquals(map.objectAt(new Vector2d(2,2)), xolo);
        assertEquals(map.objectAt(new Vector2d(5,5)), civet);
        assertEquals(map.objectAt(new Vector2d(0,0)), null );
        assertEquals(map.objectAt(new Vector2d(1,1)), muskox);
    }

    @Test
    public void testRun(){
        ArrayList<Animal> animals;
        String[] moves = new String[]{"f",  "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        Vector2d[] positions = {xolo.getPosition(), blobfish.getPosition()};
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();

        animals = ((GrassField) map).getAnimal();
        assertEquals(animals.get(0).getPosition(), new Vector2d(3,-1));
        assertEquals(animals.get(1).getPosition(), new Vector2d(2,9));
        assertEquals(animals.get(0).getDirection(),MapDirection.SOUTH);
        assertEquals(animals.get(1).getDirection(), MapDirection.NORTH);

    }
}
