package edu.montana.esof322.demo.patterns.creation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
            if (type == CarType.FERRARI) {
                return new Ferrari();
            } else {
                Ford ford = new Ford();
                return (Car) Proxy.newProxyInstance(CarsFactory.class.getClassLoader(), new Class[]{Car.class},
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                                System.out.println("Proxied method call on ford!");
                                return method.invoke(ford, objects);
                            }
                        });
            }
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
        Car car0 = new Ford();
        Car car1 = CarsFactory.getCar(CarType.FORD);
        Car car2 = CarsFactory.getCar(CarType.FERRARI);

        System.out.println(car1.getDescription());
        System.out.println(car2.getDescription());

    }

}
