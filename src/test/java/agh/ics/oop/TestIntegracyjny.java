//package agh.ics.oop;
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestIntegracyjny {
//
//
//    @Test
//    public void orientationTest(){
//        IWorldMap map = new RectangularMap(10, 10);
//        Animal a = new Animal(map, new Vector2d(2, 2));
//        String[] moves = new String[]{"l","forward","left","backward"};
//        OptionsParser p = new OptionsParser();
//        for(MoveDirection move : p.parse(moves)){a.move(move);}
//
//        assertEquals(a.getDirection(), MapDirection.SOUTH );
//
//        String[] moves1 = new String[]{"r","forward", "b","b", "right"};
//        for(MoveDirection move : p.parse(moves1)){a.move(move);}
//
//        assertEquals(a.getDirection(), MapDirection.NORTH);
//    }
//
//    @Test
//    public void positionTest(){
//        IWorldMap map = new RectangularMap(10, 10);
//        Animal a = new Animal(map, new Vector2d(2, 2));
//        String[] moves = new String[]{"l", "f", "left", "b"};
//        OptionsParser p = new OptionsParser();
//        for(MoveDirection move : p.parse(moves)){a.move(move);}
//
//        assertEquals(a.getPosition(), new Vector2d(1,3));
//
//        String[] moves1 = new String[]{"r","forward", "b","b", "right"};
//        for(MoveDirection move : p.parse(moves1)){a.move(move);}
//
//        assertEquals(a.getPosition(), new Vector2d(2,3));
//    }
//
//    @Test
//    public void mapTest(){
//        IWorldMap map = new RectangularMap(5, 5);
//        Animal a = new Animal(map, new Vector2d(2, 2));
//        String[] moves = new String[]{"f", "f", "f", "f", "f", "f", "f"};
//        OptionsParser p = new OptionsParser();
//        for(MoveDirection move : p.parse(moves)){a.move(move);}
//
//        assertEquals(a.getPosition(), new Vector2d(2,4));
//        assertEquals(a.getDirection(),MapDirection.NORTH);
//
//        String[] moves1 = new String[]{"r", "f", "f", "f", "r", "f", "f", "f", "f", "f","f"};
//        for(MoveDirection move : p.parse(moves1)){a.move(move);}
//
//        assertEquals(a.getPosition(), new Vector2d(4,0));
//        assertEquals(a.getDirection(),MapDirection.SOUTH);
//    }
//
//    @Test
//    public void interpretationTest(){
//        try{
//            IWorldMap map = new RectangularMap(10, 10);
//            Animal a = new Animal(map, new Vector2d(2, 2));
//            String [] moves = new String[]{"f", "right", "muskox", "left", "l", "xolo", "backward"};
//            OptionsParser p = new OptionsParser();
//            for(MoveDirection move : p.parse(moves)){a.move(move);}
//        }catch(IllegalArgumentException iae){
//            assertEquals(iae.getMessage(),"gdzie mi z tym piżmowołem arktycznym");
//        }
//
//        try{
//            IWorldMap map = new RectangularMap(10, 10);
//            Animal a = new Animal(map, new Vector2d(2, 2));
//            String [] moves = new String[]{"f", "right", "left", "l", "backward","F"};
//            OptionsParser p = new OptionsParser();
//            for(MoveDirection move : p.parse(moves)){a.move(move);}
//        }catch(IllegalArgumentException iae){
//            assertEquals(iae.getMessage(),"nie no tera to poleciałeś z tym F");
//        }
//    }
//}