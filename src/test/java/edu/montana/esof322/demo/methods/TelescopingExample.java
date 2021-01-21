package edu.montana.esof322.demo.methods;

import java.util.ArrayList;
import java.util.List;

public class TelescopingExample {

    public class Person {

        public Person(String name, String lastName) {
            this(name, lastName, 0);
        }

        public Person(String name, String lastName, int age) {
            this(name, lastName, age, null);
        }

        public Person(String name, String lastName, int age, String profession) {
            this(name, lastName, age, profession, null);
        }

        public Person(String name, String lastName, int age,
                      String profession, List<String> hobbies) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.profession = profession;
            this.hobbies = hobbies == null ? new ArrayList<>() :
                    new ArrayList<>(hobbies);
        }

        private final String name;
        private final String lastName;
        private final int age;
        private final String profession;
        private final List<String> hobbies;
    }
}
