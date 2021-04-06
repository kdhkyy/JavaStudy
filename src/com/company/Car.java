package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Car {
    private static final Car car = new Car();
    private int number = 0;
    private String carName = "";
    private String phone = "";

    public static Car newInstance() {
        return car;
    }

    public static Car getInstance(){
        return car;
    }

    public static Car from(String carName) {
        car.carName = carName;
        return car;
    }

    public static EnumSet of(Enum e1, Enum e2) {
        EnumSet result = EnumSet.noneOf(e1.getDeclaringClass());
        result.add(e1);
        result.add(e2);
        return result;
    }

    public static Car getCar() {
        return car;
    }

    public static Car newCar(String carName){
        car.carName = carName;
        return car;
    }

    public static ArrayList list(Enum e){
        ArrayList list = new ArrayList();
        list.add(e);
        return list;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Car)) return false;
        Car car = (Car)o;
        return ((Car) o).carName == carName && ((Car) o).number == number && ((Car) o).phone == phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, carName, phone);
    }

    @Override
    public String toString() {
        return "Car[" +
                "number=" + number +
                ", carName='" + carName + '\'' +
                ", phone='" + phone + '\'' +
                ']';
    }
}