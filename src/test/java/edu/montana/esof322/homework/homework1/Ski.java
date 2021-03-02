package edu.montana.esof322.homework.homework1;

public class Ski {

    private int length;
    private String name;
    private String brand;

    private Ski(int length, String name, String brand) {
        this.length = length;
        this.name = name;
        this.brand = brand;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public static SkiBuilder builder() {
        return new SkiBuilder();
    }

    public static class SkiBuilder {
        public Ski build() {
            return null;
        }
    }
}
