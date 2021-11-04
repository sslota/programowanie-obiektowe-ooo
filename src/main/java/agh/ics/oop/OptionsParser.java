package agh.ics.oop;

public class OptionsParser {
    MoveDirection[] parse(String[] args){
        int i = 0;
        for (String arg : args){
                if (arg.equals("r") || arg.equals("right") || arg.equals("l") || arg.equals("left") || arg.equals("b") || arg.equals("backward") || arg.equals("f") || arg.equals("forward")) {
                    i++;
                }
        }
        MoveDirection[] result = new MoveDirection[i];
        i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f":
                case "forward": result[i] = MoveDirection.FORWARD;
                i++;
                        break;
                case "b":
                case "backward": result[i] = MoveDirection.BACKWARD;
                i++;
                        break;
                case "l":
                case "left": result[i] = MoveDirection.LEFT;
                i++;
                        break;
                case "r":
                case "right": result[i] = MoveDirection.RIGHT;
                i++;
                        break;
            }
        }
        return result;
    }

}
