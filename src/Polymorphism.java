import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Polymorphism {

    public static class Shape {
        public void define() { System.out.println("I am not defined, PLEASE DEFINE ME :("); }
    }

    public static class Circle extends Shape {
        public void define() { System.out.println("I am a circle! I am defined!"); }
    }

    public static class Triangle extends Shape {
        public void define() { System.out.println("I am a triangle! I am defined!"); }
    }

    public static class Square extends Shape {
        public void define() { System.out.println("I am a square! I am defined!"); }
    }

    public static void main(String[] args) {
        Shape s1 = new Shape();
        Shape s2 = new Circle();
        Shape s3 = new Triangle();
        Shape s4 = new Square();

        Circle c1 = new Circle();
        Triangle t1 = new Triangle();
        Square sq1 = new Square();

        List<Shape> al = new ArrayList<>();
        List<Shape> ll = new LinkedList<>();

        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);
        al.add(c1);
        al.add(t1);
        al.add(sq1);

        /*
            idx 0: Shape p1 -> new Circle()
            idx 1: Shape p2 -> new Triangle()

         */

        for (Shape s : al) {
            s.define();
        }
    }
}
