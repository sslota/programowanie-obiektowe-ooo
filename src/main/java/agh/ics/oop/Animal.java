package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(){
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }


    public String toString() {
        return switch(this.orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST ->  "W";
            case EAST -> "E";
            default -> "";
        };
    }

    boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }

    MapDirection getDirection() {
        return this.orientation;
    }

    Vector2d getPosition() {
        return this.position;
    }

    public void move(MoveDirection director) {
        switch (director) {
            case RIGHT -> this.orientation = orientation.next();
            case LEFT -> this.orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newposition = this.position.add(orientation.toUnitVector());
                if(this.map.canMoveTo(newposition)){
                    this.position = newposition;
                }

            }
            case BACKWARD -> {
                Vector2d newposition = this.position.subtract(orientation.toUnitVector());
                if(this.map.canMoveTo(newposition)){
                    this.position = newposition;
                }

            }
        }
    }
}