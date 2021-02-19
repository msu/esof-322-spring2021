package edu.montana.esof322.demo.patterns.behavioral;

public class VisitorDemo {

    public static abstract class Unit {

        private final Unit[] children;

        public Unit(Unit... children) {
            this.children = children;
        }

        public void accept(UnitVisitor visitor) {
            for (Unit child : children) {
                child.accept(visitor);
            }
        }
    }

    public interface UnitVisitor {

        void visitSoldier(Soldier soldier);

        void visitSergeant(Sergeant sergeant);

        void visitCommander(Commander commander);
    }

    public static  class Commander extends Unit {

        public Commander(Unit... children) {
            super(children);
        }

        @Override
        public void accept(UnitVisitor visitor) {
            visitor.visitCommander(this);
            super.accept(visitor);
        }

        @Override
        public String toString() {
            return "commander";
        }
    }

    public static  class Sergeant extends Unit {

        public Sergeant(Unit... children) {
            super(children);
        }

        @Override
        public void accept(UnitVisitor visitor) {
            visitor.visitSergeant(this);
            super.accept(visitor);
        }

        @Override
        public String toString() {
            return "sergeant";
        }
    }

    public static class Soldier extends Unit {

        public Soldier(Unit... children) {
            super(children);
        }

        @Override
        public void accept(UnitVisitor visitor) {
            visitor.visitSoldier(this);
            super.accept(visitor);
        }

        @Override
        public String toString() {
            return "soldier";
        }
    }

    // TODO implement a cook

    public static void main(String[] args) {
        Commander commander = new Commander(
                new Sergeant(new Soldier(), new Soldier(), new Soldier()),
                new Sergeant(new Soldier()));

        commander.accept(new UnitGreeter());

    }

    public static class UnitGreeter implements UnitVisitor {
        @Override
        public void visitSoldier(Soldier soldier) {
            System.out.println("Greetings soldier");
        }

        @Override
        public void visitSergeant(Sergeant sergeant) {
            System.out.println("Hello sergeant");
        }

        @Override
        public void visitCommander(Commander commander) {
            System.out.println("Sir, good morning");
        }
    }

    public static class Greeter {
        void greet(Unit unit) {
            if (unit instanceof Soldier) {
                System.out.println("Greetings soldier");
            } else if (unit instanceof Sergeant) {
                System.out.println("Hello sergeant");
            } else if (unit instanceof Commander) {
                System.out.println("Sir, good morning");
            } else {
                throw new IllegalArgumentException("Don't know how to greet" + unit.getClass().getName());
            }
            for (Unit child : unit.children) {
                greet(child);
            }
        }
    }
}
