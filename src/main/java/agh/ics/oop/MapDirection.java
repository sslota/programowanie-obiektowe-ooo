package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    NOTHING;
    public String toString () {
        switch(this) {
            case EAST: return "Wschód";
            case WEST: return "Zachód";
            case NORTH: return "Północ";
            case SOUTH: return "Południe";
            default: return "Nothing";
        }
    }
    MapDirection next() {
        switch(this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return NOTHING;
        }
    }
    MapDirection previous() {
        switch(this) {
            case EAST: return NORTH;
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            default: return NOTHING;
        }
    }
    Vector2d toUnitVector() {
        switch(this) {
            case NORTH: return new Vector2d(0,1);
            case EAST: return new Vector2d(1,0);
            case SOUTH: return new Vector2d(0,-1);
            case WEST: return new Vector2d(-1,0);
            default: return new Vector2d(0,0);
        }
    }
}
