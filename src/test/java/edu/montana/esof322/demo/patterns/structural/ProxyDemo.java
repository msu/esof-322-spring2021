package edu.montana.esof322.demo.patterns.structural;

import java.util.Objects;

public class ProxyDemo {

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

    public static class WizardTowerProxy implements WizardTower {
        private final WizardTower tower;
        private int count = 0;
        public WizardTowerProxy(WizardTower tower) {
            this.tower = tower;
        }
        @Override
        public void enter(Wizard wizard) {
            tower.enter(wizard);
            System.out.println("-- Total Wizards: " + ++count);
        }
    }

    public static void main(String[] args) {
        var proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));
    }

}
