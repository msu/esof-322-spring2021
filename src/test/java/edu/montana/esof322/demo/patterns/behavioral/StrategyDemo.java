package edu.montana.esof322.demo.patterns.behavioral;

public class StrategyDemo {
    public interface DragonSlayingStrategy {
        void execute();
    }

    public static class MeleeStrategy implements DragonSlayingStrategy {
        @Override
        public void execute() {
            System.out.println("With your Excalibur you sever the dragon's head!");
        }
    }

    public static class ProjectileStrategy implements DragonSlayingStrategy {
        @Override
        public void execute() {
            System.out.println("You shoot the dragon with the magical crossbow and it falls dead on the ground!");
        }
    }

    public static class SpellStrategy implements DragonSlayingStrategy {
        @Override
        public void execute() {
            System.out.println("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!");
        }
    }

    public static class DragonSlayer {

        private DragonSlayingStrategy strategy;

        public DragonSlayer(DragonSlayingStrategy strategy) {
            this.strategy = strategy;
        }

        public void changeStrategy(DragonSlayingStrategy strategy) {
            this.strategy = strategy;
        }

        public void goToBattle() {
            strategy.execute();
        }
    }

    public static void main(String[] args) {
        System.out.println("Green dragon spotted ahead!");
        var dragonSlayer = new DragonSlayer(new MeleeStrategy());
        dragonSlayer.goToBattle();
        System.out.println("Red dragon emerges.");
        dragonSlayer.changeStrategy(new ProjectileStrategy());
        dragonSlayer.goToBattle();
        System.out.println("Black dragon lands before you.");
        dragonSlayer.changeStrategy(new SpellStrategy());
        dragonSlayer.goToBattle();
    }
}
