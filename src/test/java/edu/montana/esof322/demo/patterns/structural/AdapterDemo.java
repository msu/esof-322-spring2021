package edu.montana.esof322.demo.patterns.structural;

import java.util.Arrays;
import java.util.List;

public class AdapterDemo {

    public interface RowingBoat {
        void row();
    }

    public static class FishingBoat {
        public void sail() {
            System.out.println("The fishing boat is sailing");
        }
    }

    public static class Captain {
        private final RowingBoat rowingBoat;
        // default constructor and setter for rowingBoat
        public Captain(RowingBoat rowingBoat) {
            this.rowingBoat = rowingBoat;
        }

        public void row() {
            rowingBoat.row();
        }
    }

    public static class FishingBoatAdapter implements RowingBoat {
        private final FishingBoat boat;
        public FishingBoatAdapter(FishingBoat boat) {
            this.boat = boat;
        }

        @Override
        public void row() {
            boat.sail();
        }
    }

    public static void main(String[] args) {
        FishingBoat boat = new FishingBoat();
        var captain = new Captain(new FishingBoatAdapter(boat));
        captain.row();
    }


}
