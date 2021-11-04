package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);


    public String toString() {
        return "pozycja: " + position + ", kierunek: " + orientation;
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

    void move(MoveDirection direction){
        switch(direction){
            case LEFT: this.orientation = this.orientation.previous();
                break;
            case RIGHT: this.orientation = this.orientation.next();
                break;
            case FORWARD: this.position = this.position.add(this.orientation.toUnitVector());
                break;
            case BACKWARD: this.position = this.position.subtract(this.orientation.toUnitVector());
                break;
        }
        if(this.position.getY()>4){
            this.position = new Vector2d(this.position.getX(),4);
        }
        if(this.position.getX()>4){
            this.position = new Vector2d(4, this.position.getY());
        }
        if(this.position.getY()<0){
            this.position = new Vector2d(this.position.getX(),0);
        }
        if(this.position.getX()<0){
            this.position = new Vector2d(0,this.position.getY());
        }
    }


}