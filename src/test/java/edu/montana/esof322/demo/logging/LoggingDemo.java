package edu.montana.esof322.demo.logging;

import edu.montana.esof322.model.MSUClass;
import edu.montana.esof322.model.User;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.*;
import java.util.stream.Collectors;

public class LoggingDemo {


    static Logger LOGGER =
            Logger.getLogger(LoggingDemo.class.getName());
    static ConsoleHandler CONSOLE_HANDLER = new ConsoleHandler();
    static {
        LOGGER.addHandler(CONSOLE_HANDLER);
        try {
            FileHandler handler = new FileHandler("log.txt");
            LOGGER.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.setUseParentHandlers(false);
    }

    static LinkedList<User> best(Integer msuClassId) {

        LOGGER.log(Level.INFO, "Looking up class");
        MSUClass msuClass = MSUClass.find(msuClassId);
        Set<User> advisors = new HashSet<>();

        LOGGER.log(Level.INFO, "Iterating over users");
        // For each student in the class
        for (User student : msuClass.getUsers()) {
            //   collect the advisor for that student into a set
            Long advisorId = student.adv;
            User advisor = User.find(advisorId);
            if (advisor == null) {
                LOGGER.log(Level.WARNING, "The advisor for " + student.em + " was null");
            } else {
                LOGGER.log(Level.FINE, "Found advisor: " +  advisor.em);
                advisors.add(advisor);
            }
        }

        // Return the set of advisors
        LinkedList<User> advisorsAsList = new LinkedList<>(advisors);

        if (LOGGER.isLoggable(Level.FINE)) {
            LOGGER.log(Level.FINE, "Final advisor list: " +
                    advisorsAsList.stream().map(user -> user.em)
                            .collect(Collectors.joining(", ")));
        }

        return advisorsAsList;

    }

    static LinkedList<User> better(Integer msuClassId) {

        LOGGER.log(Level.INFO, "Looking up class");
        MSUClass msuClass = MSUClass.find(msuClassId);
        Set<User> advisors = new HashSet<>();

        LOGGER.log(Level.INFO, "Iterating over users");
        // For each student in the class
        for (User student : msuClass.getUsers()) {
            //   collect the advisor for that student into a set
            Long advisorId = student.adv;
            User advisor = User.find(advisorId);
            LOGGER.log(Level.FINE, "Found advisor: " +  advisor.em);
            advisors.add(advisor);
        }

        // Return the set of advisors
        LinkedList<User> advisorsAsList = new LinkedList<>(advisors);
        LOGGER.log(Level.INFO, "Final advisor list: " + advisorsAsList);
        return advisorsAsList;

    }

    static LinkedList<User> simplest(Integer msuClassId) {

        System.out.println("Looking up class");
        MSUClass msuClass = MSUClass.find(msuClassId);
        Set<User> advisors = new HashSet<>();

        System.out.println("Iterating over users");
        // For each student in the class
        for (User student : msuClass.getUsers()) {
            //   collect the advisor for that student into a set
            Long advisorId = student.adv;
            User advisor = User.find(advisorId);
            System.out.println("Found advisor: " + advisor);
            advisors.add(advisor);
        }

        // Return the set of advisors
        LinkedList<User> advisorsAsList = new LinkedList<>(advisors);
        System.out.println("Final advisor list: " + advisorsAsList);
        return advisorsAsList;

    }

    public static void main(String[] args) {
        best(22);
    }
}
