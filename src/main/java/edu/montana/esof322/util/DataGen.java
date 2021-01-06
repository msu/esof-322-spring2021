package edu.montana.esof322.util;

import edu.montana.esof322.model.MSUClass;
import edu.montana.esof322.model.User;
import net.andreinc.mockneat.abstraction.MockUnit;
import net.andreinc.mockneat.unit.user.Names;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.andreinc.mockneat.unit.objects.Filler.filler;
import static net.andreinc.mockneat.unit.types.Ints.ints;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;

public class DataGen {

    private static Random rand = new Random();

    static List<String> classNames = Arrays.asList(
            "Joy and Beauty of Computing",
            "Joy and Beauty of Data",
            "Bsc Data Structures/Algorithms",
            "Social & Ethical Issues in CS",
            "Data Structures and Algorithms",
            "Discrete Structures",
            "Independent Study",
            "Concepts/Programming Languages",
            "Computer Science Theory",
            "Data Mining",
            "Systems Administration",
            "Computer Systems",
            "Comp Vision: Robot Vision",
            "Compilers",
            "Computer Security",
            "Algorithms",
            "Computational Geometry",
            "Reasoning Uncertainty",
            "Advanced Networking",
            "Advanced Networking",
            "Programming with C"
    );

    static List<Long> advisorIds = Stream.of(23896, 23969, 23985, 24277, 24408, 24505, 24542, 24624, 24646, 24752, 24779, 24817).map(integer -> (long) integer).collect(Collectors.toList());
    static Long getRandomAdvisor() {
        int slot = (rand.nextInt(advisorIds.size()) + rand.nextInt(advisorIds.size())) / 2;
        return advisorIds.get(slot);
    }

    public static void main(String[] args) throws SQLException {
        //initalDataGen();
        for (User u : User.all()) {
            if (u.t.equals("Student")) {
                u.adv = getRandomAdvisor();
                u.update();
            }
        }
    }

    private static void initalDataGen() throws SQLException {
//        DB.clearTable("users");
//        DB.clearTable("msu_classes");
//        DB.clearTable("user_msu_classes");
//
//        BiFunction<String, String, String> emailComposer = (firstName, lastName) -> {
//            String fName = firstName.toLowerCase();
//            String lName = lastName.toLowerCase();
//
//            return fName +
//                    "." + // the names are separated with "." or "_"
//                    lName +
//                    ints().bound(100).get() + // additional numbers are added after the lastName
//                    "@montana.edu";
//        };
//
//        List<MSUClass> classes = new ArrayList<>();
//        for (int i = 0; i < classNames.size(); i++) {
//            String className = classNames.get(i);
//            MSUClass msuClass = new MSUClass();
//            msuClass.setTitle(className);
//            msuClass.setName("CSCI 1" + (i * 23 % 12));
//            msuClass.create();
//            classes.add(msuClass);
//        }
//
//        MockUnit<User> userGenerator =
//                filler(User::new)
//                        .setter(User::setFirstName, names().first())
//                        .setter(User::setLastName, names().last())
//                        .setter(User::setType, ()->()->Math.random() < .98 ? "Student" : "Instructor")
//                        .map(user -> {
//                            user.setEmail(emailComposer.apply(user.getFirstName(), user.getLastName()));
//                            return user;
//                        });
//
//        Random rand = new Random();
//
//        for (int i = 0; i < 1000; i++) {
//            if (i % 100 == 0) {
//                System.out.println("User " + i + " being created...");
//            }
//            User user = userGenerator.get();
//            user.create();
//            if (user.getType().equals("Student")) {
//                if (Math.random() < .95) {
//                    user.addClass(randomClass(classes));
//                }
//                if (Math.random() < .85) {
//                    user.addClass(randomClass(classes));
//                }
//                if (Math.random() < .55) {
//                    user.addClass(randomClass(classes));
//                }
//                if (Math.random() < .10) {
//                    user.addClass(randomClass(classes));
//                }
//                if (Math.random() < .2) {
//                    user.addClass(randomClass(classes));
//                }
//            }
//        }
//
//        for (MSUClass aClass : classes) {
//            User randomProf = User.findRandomProf();
//            randomProf.addClass(aClass);
//        }
    }

    private static MSUClass randomClass(List<MSUClass> classes) {
        return classes.get(rand.nextInt(classes.size()));
    }
}
