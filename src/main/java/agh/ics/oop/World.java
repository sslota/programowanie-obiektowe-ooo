package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void run(Direction[] ruchy) {
        out.println("Start");
        for (Direction ruch: ruchy) {
            switch (ruch) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu");
                case RIGHT -> out.println("Zwierzak skręca w prawo");
                case LEFT -> out.println("Zwierzak skręca w lewo");
                default -> {
                }
            }
        }
        out.println("Stop");
    }
    public static void main(String[] args){
        System.out.println("System wystartował oj tak tak");
        String[] ruchy = {"f", "b", "r", "l"};
        Direction[] moveset = convert(ruchy);
        run(moveset);
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection tmp = MapDirection.EAST;
        System.out.println(tmp.next());
        System.out.println("System zakończył działanie biblethump");

    }
    public static Direction[] convert(String[] args) {
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
    }
}
