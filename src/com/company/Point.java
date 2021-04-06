package com.company;

public class Point implements Comparable<Point>{

    private int x, y;
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point a) {
        if(this.x > a.x) {
            return 1;
        }else if(this.x == a.x) {
            if(this.y > a.y) return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Point[" +
                "x=" + x +
                ", y=" + y +
                ']';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
