package Optiver;

public class Shapes {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        int rectArea = r.getArea(4, 3);
        System.out.println(rectArea);

        Triangle t = new Triangle();
        int triArea = t.getArea(5, 2);
        System.out.println(triArea);

        Circle c = new Circle();
        int cirArea = c.getArea(5, 0);
        System.out.println(cirArea);

        int total = rectArea + triArea + cirArea;
        System.out.println(total);
    }

    interface Shape {
        double pi = 3.14;
        int getArea(double x, double y);
    }

    public static class Rectangle implements Shape{

        public int getArea(double x, double y) {
            double answer = x * y;
            return (int) Math.round(answer);
        }
    }

    public static class Triangle implements Shape {

        public int getArea(double x, double y) {
            double answer = x * y / 2;
            return (int) Math.round(answer);
        }
    }

    public static class Circle implements Shape {

        public int getArea(double x, double y) {
            double answer = pi * x * x;
            return (int) Math.round(answer);
        }
    }
}
