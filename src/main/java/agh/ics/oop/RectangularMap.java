package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private int width;
    private int height;
    private ArrayList<Animal> animalList = new ArrayList<>();


    public RectangularMap(int width, int height){
        this.width = width;
        this.height=height;
    }

    public ArrayList<Animal> getAnimalList(){
        return this.animalList;
    }
    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0),new Vector2d(this.width,this.height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.getX()<=this.width && position.getX()>=0 && position.getY()<=this.height && position.getY()>=0 && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(animal.getPosition().getX()<0 || animal.getPosition().getX()>this.width || animal.getPosition().getY()<0 || animal.getPosition().getY()>height){
            return false;
        }else{
            animalList.add(animal);
            return true;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Object animal:animalList.toArray()){
            Animal animal2 = (Animal) animal;
            if(animal2.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Object animal : animalList.toArray()) {
            Animal animal2 = (Animal) animal;
            if (animal2.getPosition().equals(position)) {
                return animal2;
            }
        }
        return null;
    }
}