package edu.montana.esof322.demo.methods;

import java.util.ArrayList;
import java.util.List;

public class GoodRoutines {

    class Car {
        private String make;
        private String model;
        private int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public int getYear() {
            return year;
        }
    }

    class CarBuilder {
        private String make = "Toyota";
        private String model = "Land Cruiser";
        private int year = 1985;

        public CarBuilder withMake(String make) {
            this.make = make;
            return this;
        }

        public CarBuilder withModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder withYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(make, model, year);
        }
    }

    Car c = new CarBuilder().withMake("Land Rover")
            .withModel("Defender")
            .withYear(1990).build();

    class CarDB {
        List<Car> cars = new ArrayList<>();

        /**
         * This method returns all cars that are of the given year or after,
         * inclusive of the year
         *
         * @param year the year to find cars after
         *
         * @return A list of cars produced on or after the given year
         */
        public List<Car> findCarsAfter(int year) {
            List<Car> matchingCars = new ArrayList<>();
            for (Car car : cars) {
                if (car.getYear() >= year) {
                    matchingCars.add(car);
                }
            }
            return matchingCars;
        }


        public void updateCar(Car carToUpdate) {
            // ... logic to update car
        }

    }


}
