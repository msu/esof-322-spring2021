package edu.montana.esof322.demo.patterns.creation;

public class AbstractFactoryDemo {

    public interface Castle {
        String getDescription();
    }

    public interface King {
        String getDescription();
    }

    public interface Army {
        String getDescription();
    }

    // Elven implementations ->
    static public class ElfCastle implements Castle {
        @Override
        public String getDescription() {
            return "This is the Elven castle!";
        }
    }
    static public class ElfKing implements King {
        @Override
        public String getDescription() {
            return "This is the Elven king!";
        }
    }
    static public class ElfArmy implements Army {
        @Override
        public String getDescription() {
            return "This is the Elven Army!";
        }
    }

    // Orcish implementations ->
    static public class OrcCastle implements Castle {
        @Override
        public String getDescription() {
            return "This is the Orcish castle!";
        }
    }
    static public class OrcKing implements King {
        @Override
        public String getDescription() {
            return "This is the Orcish king!";
        }
    }
    static public class OrcArmy implements Army {
        @Override
        public String getDescription() {
            return "This is the Orcish Army!";
        }
    }

    public interface KingdomFactory {
        Castle createCastle();
        King createKing();
        Army createArmy();
    }

    static public class ElfKingdomFactory implements KingdomFactory {
        public Castle createCastle() {
            return new ElfCastle();
        }
        public King createKing() {
            return new ElfKing();
        }
        public Army createArmy() {
            return new ElfArmy();
        }
    }

    static public class OrcKingdomFactory implements KingdomFactory {
        public Castle createCastle() {
            return new OrcCastle();
        }
        public King createKing() {
            return new OrcKing();
        }
        public Army createArmy() {
            return new OrcArmy();
        }
    }

    public enum KingdomType {
        ELF, ORC
    }

    public static class FactoryMaker {

        public static KingdomFactory makeFactory(KingdomType type) {
            switch (type) {
                case ELF:
                    return new ElfKingdomFactory();
                case ORC:
                    return new OrcKingdomFactory();
                default:
                    throw new IllegalArgumentException("KingdomType not supported.");
            }
        }
    }

    public static void main(String[] args) {
        KingdomFactory kingdomFactory = FactoryMaker.makeFactory(KingdomType.ELF);
        Army army = kingdomFactory.createArmy();
        System.out.println(army.getDescription());
    }

}
