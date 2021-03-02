package edu.montana.esof322.demo.inheritance;

import java.lang.reflect.Field;

public class InheritanceDemo {

    interface IVehicle {
        void start();
    }

    abstract class Vehicle implements IVehicle {
        private String foo = "Foo";
        @Override
        public void start() {
            /* a bunch of internal stuff */
        }
    }

    class BadCar extends Vehicle {
        @Override
        public void start() {
            super.start();
            /* other car stuff */
        }
    }

    class GoodCar implements IVehicle, Honkable {
        Engine engine = new Engine();
        @Override
        public void start() { engine.start(); /* other car stuff */ }

        public void beep() { /* beep */ }

        @Override
        public void honk() {
            beep();
        }
    }

    class GoodTruck implements IVehicle, Honkable {
        Engine engine = new Engine();
        @Override
        public void start() { engine.start();  /* other truck stuff */ }

        public void honk() {
        }
    }

    interface Honkable {
        void honk();
    }

    class Engine {
        public void start() {
            /* ... */
        }
    }

    void demo() {


        IVehicle v = getVehicle("KDF 1324");
        if (v instanceof GoodCar) {
            ((GoodCar) v).beep();
        } else if (v instanceof GoodTruck) {
            ((GoodTruck) v).honk();
        }


    }

    private IVehicle getVehicle(String licenseNumber) {
        return null;
    }

}
