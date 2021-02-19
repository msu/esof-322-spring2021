package edu.montana.esof322.demo.patterns.creation;

public class SingletonDemo {

    private static final SingletonDemo INSTANCE
            = new SingletonDemo();

    private SingletonDemo() {}

    public static SingletonDemo instance() {
        return INSTANCE;
    }

    private void doIt() {
        System.out.println("Did it...");
    }

    enum EnumSingleton {
        INSTANCE;
        public void doIt() {
            System.out.println("Did it...");
        }
    }


    public static void main(String[] args) {

        SingletonDemo.instance().doIt();

        EnumSingleton.INSTANCE.doIt();

    }


}
