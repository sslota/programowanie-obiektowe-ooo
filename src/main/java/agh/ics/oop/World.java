package agh.ics.oop;

public class World {
    public static void run(Direction[] ruchy) {
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
    }
    public static void main(String[] args) {
        System.out.println("System wystartował oj tak tak");
        Animal muskox = new Animal();
        OptionsParser parser = new OptionsParser();
        MoveDirection[] moves = parser.parse(args);
        System.out.println(muskox);
        for (MoveDirection move : moves){
            if (move == null)
                continue;
            muskox.move(move);
            System.out.println(muskox);
        }
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
