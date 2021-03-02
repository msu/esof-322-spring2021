package edu.montana.esof322.homework.homework1;

public class Student {

    private String firstName;
    private String lastName;
    private String id;

    private Student(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private String firstName;
        private String lastName;
        private String id;

        public StudentBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public StudentBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public StudentBuilder withId(String id) {
            this.id = id;
            return this;
        }
        public Student build(){
            if (id == null) {
                id = java.util.UUID.randomUUID().toString();
            }
            return new Student(firstName, lastName, id);
        }
    }
}
