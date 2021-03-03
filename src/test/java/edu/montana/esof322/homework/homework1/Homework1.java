package edu.montana.esof322.homework.homework1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Homework1 {

    @Test
    void fixThisTest() {
        assertTrue(false);
    }

    @Test
    void useABuilder() {

        // add the code to work with this builder
        // please chain the methods
        Student s = Student.builder()
                .build();

        assertEquals("Joe", s.getFirstName());
        assertEquals("Smith", s.getLastName());
        assertEquals("An ID", s.getId());

        // build a student and take advantage of the autoid generation
        Student s2 = Student.builder()
                .build();

        assertEquals("Joe", s2.getFirstName());
        assertEquals("Smith", s2.getLastName());
        assertNotNull(s2.getId());
    }

    @Test
    void createABuilder() {
        // TODO - uncomment and make this builder work
        Ski ski = Ski.builder()
                //.withLength(180)
                //.withBrand("dps")
                //.withName("Alchemist Lotus")
                    .build();
        assertEquals("dps", ski.getBrand());
        assertEquals("Alchemist Lotus", ski.getName());
        assertEquals(180, ski.getLength());
    }

}
