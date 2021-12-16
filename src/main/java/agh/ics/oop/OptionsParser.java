package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] args){
        int i = 0;
        for (String arg : args){
            if (arg.equals("r") || arg.equals("right") || arg.equals("l") || arg.equals("left") || arg.equals("b") || arg.equals("backward") || arg.equals("f") || arg.equals("forward")) {
                i++;
            }
        }
        MoveDirection[] result = new MoveDirection[i];
        i = 0;
        for (String arg : args) {
            result[i] = switch (arg) {
                case "f", "forward" -> MoveDirection.FORWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "l", "left" -> MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(arg + " is not legal move specification");
            };
            i++;
        }
        return result;
    }

}