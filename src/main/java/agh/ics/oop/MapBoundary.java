package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class MapBoundary implements IPositionChangeObserver {
    private final SortedSet<IMapElement> xSet;
    private final SortedSet<IMapElement> ySet;
    private final IWorldMap map;

    public MapBoundary(IWorldMap map) {
        this.xSet = new TreeSet<>(new xComparator());
        this.ySet = new TreeSet<>(new yComparator());
        this.map = map;

    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = (IMapElement) map.objectAt(newPosition);
        xSet.remove(element);
        xSet.add(element);
        ySet.remove(element);
        ySet.add(element);
    }

    public void addElements(IMapElement element) {
        xSet.add(element);
        ySet.add(element);
    }
    public Vector2d getRightCorner() {
        return xSet.last().getPosition().upperRight(ySet.last().getPosition());
    }
    public Vector2d getLeftCorner() {
        return xSet.first().getPosition().lowerLeft(ySet.first().getPosition());
    }
}
class xComparator implements Comparator<IMapElement> {
    @Override
    public  int compare(IMapElement comp1, IMapElement comp2) {
        Vector2d comp1Position = comp1.getPosition();
        Vector2d comp2Position = comp2.getPosition();
        if (comp1Position.x > comp2Position.x) return 1;
        else if(comp1Position.x == comp2Position.x){
            if(comp1Position.y > comp2Position.y || (comp1 instanceof Animal && comp2 instanceof  Grass)) return 1;
            else if(comp1Position.y < comp2Position.y || (comp1 instanceof Grass && comp2 instanceof Animal)) return 2;
            else return 0;
        }
        return -1;
// 1 to comp1 jest wiekszy jezeli 2 to comp2 jest wiekszy essa
    }
}
class yComparator implements Comparator<IMapElement> {
    @Override
    public  int compare(IMapElement comp1, IMapElement comp2) {
        Vector2d comp1Position = comp1.getPosition();
        Vector2d comp2Position = comp2.getPosition();
        if (comp1Position.y > comp2Position.y) return 1;
        else if(comp1Position.y == comp2Position.y){
            if(comp1Position.x > comp2Position.x || (comp1 instanceof Animal && comp2 instanceof  Grass)) return 1;
            else if(comp1Position.x < comp2Position.x || (comp1 instanceof Grass && comp2 instanceof Animal)) return 2;
            else return 0;
        }
        return -1;
// 1 to comp1 jest wiekszy jezeli 2 to comp2 jest wiekszy essa
    }
}