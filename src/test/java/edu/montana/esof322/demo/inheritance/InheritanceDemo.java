package edu.montana.esof322.demo.inheritance;

public class InheritanceDemo {

    interface IVehicle {
        void start();
    }

    abstract class Vehicle implements IVehicle {
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

    class GoodCar implements IVehicle {
        Engine engine = new Engine();
        @Override
        public void start() { engine.start(); /* other car stuff */ }

        public void beep() { /* beep */ }
    }

    class GoodTruck implements IVehicle {
        Engine engine = new Engine();
        @Override
        public void start() { engine.start();  /* other truck stuff */ }

        public void honk() {
        }
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
