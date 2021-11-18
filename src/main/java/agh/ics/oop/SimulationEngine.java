package agh.ics.oop;

import javax.crypto.spec.RC2ParameterSpec;
import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private IWorldMap map;
    private MoveDirection[] moves;
    private Animal[] animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startingPositions){
        for (Vector2d position:startingPositions) {
            map.place(new Animal(map, position));
        }
        this.moves = moves;
        this.map = map;
    }

    public void run() {
        RectangularMap map2 = (RectangularMap) map;
        int i = 0;
        ArrayList<Animal> animals = map2.getAnimalList();
        int animalsNumber = animals.size();
        System.out.println(map2);
        for(MoveDirection move:moves) {
            animals.get(i % animalsNumber).move(move);
            i += 1;
        }
        System.out.println(map2);
    }
}