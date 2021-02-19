package edu.montana.esof322.demo.patterns.creation;

import java.util.function.Supplier;

public class FactoryDemo {

    public interface Car {
        String getDescription();
    }

    public static class Ford implements Car {
        @Override
        public String getDescription() {
            return "This is Ford.";
        }
    }

    public static class Ferrari implements Car {
        @Override
        public String getDescription() {
            return "This is Ferrari.";
        }
    }

    public enum CarType {
        FORD(Ford::new),
        FERRARI(Ferrari::new);

        private final Supplier<Car> constructor;

        CarType(Supplier<Car> constructor) {
            this.constructor = constructor;
        }

        public Supplier<Car> getConstructor() {
            return this.constructor;
        }
    }

    public static class CarsFactory {
        public static Car getCar(CarType type) {
            return type.getConstructor().get();
        }
    }

    /**
     * A factory for creating factories that
     *  produce factory factories
     */
    class FactoryFactoryFactoryFactory {
        //...
    }

    public static void main(String[] args) {

        Car car1 = CarsFactory.getCar(CarType.FORD);
        Car car2 = CarsFactory.getCar(CarType.FERRARI);

        System.out.println(car1.getDescription());
        System.out.println(car2.getDescription());

    }

}
