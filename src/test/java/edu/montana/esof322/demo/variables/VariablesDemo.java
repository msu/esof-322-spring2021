package edu.montana.esof322.demo.variables;

import edu.montana.esof322.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VariablesDemo {

    public void variableDemo0() {
        final List<User> all = User.all();
        for (User user : all) {
            System.out.println(user.u_id);
        }
    }

    public void accumulateDemo() {
        List<Long> ids = new ArrayList<>();
        final List<User> all = User.all();
        for (User user : all) {
            ids.add(getUserId(user));
        }
        System.out.println(ids);
    }

    private Long getUserId(User user) {
        return user.u_id;
    }

    final List<User> all = User.all();
    public void accumulateDemo3() {
        List<Long> ids = new ArrayList<>();
        for (User user : all) {
            ids.add(user.u_id);
        }
        System.out.println(ids);
    }

    public void accumulateDemo2() {

        final Stream<Long> all = User.all()
                .stream()
                .map(user -> user.u_id);

        final List<Long> allAsList = User.all()
                .stream()
                .map(user -> user.u_id)
                .collect(Collectors.toList());

    }

    public void variableDemo1() {
        int i = 2;
        {
            int j = 4;
        }
        {
            int j = 8;
            Arrays.asList("16").stream().map(k -> Integer.parseInt(k));
        }
    }


    static class InitInConstructor {
        String name;
        int age;
        InitInConstructor() {
            name = "Example";
            age = 42;
        }
    }

    static class InitInline {
        String name = "Example";
        int age = 42;
    }

    static class MixedInitialization {
        String name = "Example";
        int age;
        MixedInitialization() {
            age = 42;
        }
    }

    static class TelescopingInitialization {
        String name = "Example";
        int age;
        TelescopingInitialization() {
            this(42);
        }
        TelescopingInitialization(int age) {
            this("Example", age);
        }
        TelescopingInitialization(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    static class ScopeDemo {
        public static final int staticallyScopedConstant = 1;
        static int staticallyScopedVariable = 2;
        int instanceScopedVariable = 4;

        private static final ThreadLocal<Integer> threadLocal =
                new ThreadLocal<>();
        static {
            threadLocal.set(32);
        }

        void scopeExample() {
            int methodScopedVariable = 8;
            if(true) {
                int blocScopedVariable = 16;
            }
            System.out.println(threadLocal.get());
        }
    }

}
