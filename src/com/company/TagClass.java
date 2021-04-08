package com.company;

public class TagClass {


    static abstract class Figure{
        abstract double section();
    }
    
    //원
     static class Circle extends Figure{
        private final double radius;

        public Circle(double r){
            this.radius = r;
        }

        @Override
        double section() {
            return radius * radius * Math.PI;
        }
    }

    //직사각형
     static class Rectangle extends Figure{

        private final double length;
        private final double width;

        public Rectangle(double a, double b){
            this.length = a;
            this.width = b;
        }

        @Override
        double section() {
            return length * width;
        }
    }
    
    //정사각형
    static class Square extends Rectangle {
        Square(double a) {
            super(a, a);
        }
    }
}
