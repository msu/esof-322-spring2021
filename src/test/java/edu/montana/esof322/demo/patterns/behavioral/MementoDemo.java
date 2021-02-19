package edu.montana.esof322.demo.patterns.behavioral;

public class MementoDemo {

    public interface StarMemento {
    }

    public enum StarType {
        SUN("sun"),
        RED_GIANT("red giant"),
        WHITE_DWARF("white dwarf"),
        SUPERNOVA("supernova"),
        DEAD("dead star");
        private final String name;
        StarType(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    public static class Star {

        private StarType type;
        private int ageYears;
        private int massTons;

        public Star(StarType startType, int startAge, int startMass) {
            this.type = startType;
            this.ageYears = startAge;
            this.massTons = startMass;
        }

        public void timePasses() {
            ageYears *= 2;
            massTons *= 8;
            switch (type) {
                case RED_GIANT:
                    type = StarType.WHITE_DWARF;
                    break;
                case SUN:
                    type = StarType.RED_GIANT;
                    break;
                case SUPERNOVA:
                    type = StarType.DEAD;
                    break;
                case WHITE_DWARF:
                    type = StarType.SUPERNOVA;
                    break;
                case DEAD:
                    ageYears *= 2;
                    massTons = 0;
                    break;
                default:
                    break;
            }
        }

        StarMemento getMemento() {
            var state = new StarMementoInternal();
            state.setAgeYears(ageYears);
            state.setMassTons(massTons);
            state.setType(type);
            return state;
        }

        void setMemento(StarMemento memento) {
            var state = (StarMementoInternal) memento;
            this.type = state.getType();
            this.ageYears = state.getAgeYears();
            this.massTons = state.getMassTons();
        }

        @Override
        public String toString() {
            return String.format("%s age: %d years mass: %d tons", type.toString(), ageYears, massTons);
        }

        private static class StarMementoInternal implements StarMemento {
            private StarType type;
            private int ageYears;
            private int massTons;

            public StarType getType() {
                return type;
            }

            public void setType(StarType type) {
                this.type = type;
            }

            public int getAgeYears() {
                return ageYears;
            }

            public void setAgeYears(int ageYears) {
                this.ageYears = ageYears;
            }

            public int getMassTons() {
                return massTons;
            }

            public void setMassTons(int massTons) {
                this.massTons = massTons;
            }
        }
    }

    public static void main(String[] args) {
        var star = new Star(StarType.SUN, 10000000, 500000);
        StarMemento memento = star.getMemento();
        System.out.println(star.toString());
        star.timePasses();
        System.out.println(star.toString());
        star.timePasses();
        System.out.println(star.toString());
        star.timePasses();
        System.out.println(star.toString());
        star.timePasses();
        System.out.println(star.toString());

        System.out.println("Let's start over...");
        star.setMemento(memento);
        System.out.println(star.toString());
    }

}
