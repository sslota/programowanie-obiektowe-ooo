package agh.ics.oop;

import agh.ics.oop.gui.App;
import java.util.ArrayList;

public class SimulationEngine implements Runnable {
    private final IWorldMap map;
    private final MoveDirection[] moves;
    private final ArrayList<Animal> animals;
    private final App application;
    private final int moveDelay;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startingPositions, App application, int moveDelay){
        this.map = map;
        this.moves = moves;
        this.animals = new ArrayList<>();
        this.application = application;
        this.moveDelay = moveDelay;

        for (Vector2d pos: startingPositions){
            Animal animal = new Animal(this.map, pos);
            if (this.map.place(animal)) {
                animals.add(animal);
            }
        }
    }
    @Override
    public void run() {
        int l = animals.size();
        int i = 0;

        for (MoveDirection direction : moves) {
            try{
                Thread.sleep(moveDelay);
                Animal animal = animals.get(i % l);
                animal.move(direction);
                application.drawMap();
                i++;
            }catch (InterruptedException ex){
                System.out.println(ex.toString());
            }

        }
    }
}