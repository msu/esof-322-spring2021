package edu.montana.esof322.demo.homework;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Homework2Help {

    List<String> allFirstNames = new LinkedList<>();

    interface IStudent {
        String getFirstName();
        String getLastName();
    }

    static class Student implements IStudent {
        private String _firstName;
        private String _lastName;

        public Student(String firstName, String lastName) {
            _firstName = firstName;
            _lastName = lastName;
        }

        public String getFirstName() {
            return _firstName;
        }

        public void setFirstName(String firstName) {
            _firstName = firstName;
        }

        public String getLastName() {
            return _lastName;
        }

        public void setLastName(String lastName) {
            _lastName = lastName;
        }
    }

    private static class StudentFactory {
        public static IStudent create(String first, String last) {
            Student student = new Student(first, last);
            return student;
        }
    }

    @Test
    public void extractAnInterface() {
        IStudent s = new Student("Carson", "Gross");
    }

    @Test
    public void createAFactory() {
        IStudent s = StudentFactory.create("Carson", "Gross");
    }

    static class StudentProxy implements IStudent {
        IStudent _proxiedObject;

        public StudentProxy(IStudent proxiedObject) {
            _proxiedObject = proxiedObject;
        }

        @Override
        public String getFirstName() {
            return _proxiedObject.getFirstName();
        }

        @Override
        public String getLastName() {
            return _proxiedObject.getLastName();
        }
    }

    @Test
    public void makeAStudentProxy() {
        IStudent s = new StudentProxy(new Student("Carson", "Gross"));
    }

}
