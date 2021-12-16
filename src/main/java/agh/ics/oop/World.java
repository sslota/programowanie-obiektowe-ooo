package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    /* public static void run(Direction[] ruchy) {
         System.out.println("Start");
         for (Direction ruch : ruchy) {
             switch (ruch) {
                 case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                 case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                 case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                 case LEFT -> System.out.println("Zwierzak skręca w lewo");
                 default -> {
                 }
             }
         }
         System.out.println("Stop");
     }*/
    public static void main(String[] args) {
        Application.launch(App.class, args);
        /*try {
            System.out.println("System wystartował oj tak tak");
            MoveDirection[] directions = new OptionsParser().parse(args);
            //IWorldMap map = new RectangularMap(10, 5);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            System.out.println(map);
            engine.run();
            System.out.println(map);
            System.out.println("System zakończył działanie biblethump");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);*/
    }
    /*public static Direction[] convert(String[] args) {
        int a = 0;
        Direction[] nowy = new Direction[args.length];
        for (String arg : args) {
            switch (arg) {
                case "f" -> nowy[a] = Direction.FORWARD;
                case "b" -> nowy[a] = Direction.BACKWARD;
                case "r" -> nowy[a] = Direction.RIGHT;
                case "l" -> nowy[a] = Direction.LEFT;
                default -> nowy[a] = Direction.NOTHING;
            }
            a += 1;
        }
        return nowy;
    }*/
}