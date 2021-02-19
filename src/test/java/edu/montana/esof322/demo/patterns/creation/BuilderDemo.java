package edu.montana.esof322.demo.patterns.creation;

public class BuilderDemo {

    enum HairType {STRAIGHT, WAVEY, NONE}
    enum HairColor {BROWN, BLONDE, BLACK,}
    enum Armor {CHAIN, PLATE,}
    enum Weapon {SWORD, SPEAR,}

    static class Hero {

        private final String name;
        private final HairType hairType;
        private final HairColor hairColor;
        private final Armor armor;
        private final Weapon weapon;

        private Hero(Builder builder) {
            this.name = builder.name;
            this.hairColor = builder.hairColor;
            this.hairType = builder.hairType;
            this.weapon = builder.weapon;
            this.armor = builder.armor;
        }

        static class Builder {
            private final String name;
            private HairType hairType;
            private HairColor hairColor;
            private Armor armor;
            private Weapon weapon;

            public Builder(String name) {
                this.name = name;
            }

            public Builder withHairType(HairType hairType) {
                this.hairType = hairType;
                return this;
            }

            public Builder withHairColor(HairColor hairColor) {
                this.hairColor = hairColor;
                return this;
            }

            public Builder withArmor(Armor armor) {
                this.armor = armor;
                return this;
            }

            public Builder withWeapon(Weapon weapon) {
                this.weapon = weapon;
                return this;
            }

            public Hero build() {
                return new Hero(this);
            }
        }

    }

    public static void main(String[] args) {
        Hero hero = new Hero.Builder("foo")
                .withArmor(Armor.CHAIN)
                .build();
    }

}
