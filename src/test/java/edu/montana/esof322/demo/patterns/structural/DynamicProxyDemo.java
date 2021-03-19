package edu.montana.esof322.demo.patterns.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {

    public static class Wizard {

        private final String name;

        public Wizard(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public interface WizardTower {

        void enter(Wizard wizard);
    }

    public static class IvoryTower implements WizardTower {
        public void enter(Wizard wizard) {
            System.out.println(wizard + " enters the tower.");
        }
    }

    public static void main(String[] args) {
        WizardTower proxy = makeLazyProxy();
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));
    }

    private static WizardTower makeProxy(final IvoryTower tower) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                System.out.println("Calling " + method.getName());
                return method.invoke(tower, args);
            }
        };

        Object proxy = Proxy.newProxyInstance
                (DynamicProxyDemo.class.getClassLoader(),
                new Class[]{WizardTower.class}, handler);

        return (WizardTower) proxy;
    }

    private static WizardTower makeLazyProxy() {
        final IvoryTower[] tower = {null};
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                if (method.getName().contains("toString")) {
                    return "Proxy";
                }
                if (tower[0] == null) {
                    System.out.println("Creating the tower...");
                    tower[0] = new IvoryTower();
                }
                System.out.println("Calling " + method.getName());
                return method.invoke(tower[0], args);
            }
        };

        Object proxy = Proxy.newProxyInstance
                (DynamicProxyDemo.class.getClassLoader(),
                new Class[]{WizardTower.class}, handler);

        return (WizardTower) proxy;
    }

}
