package edu.montana.esof322.demo.defensive;

public class FunDemo {

    public static void main(String[] args){
        Fun fun = new Fun();
        fun.printUppercaseName();
    }

    static class Fun {
        private String _name;
        public void printUppercaseName(){
            System.out.println(_name.toUpperCase());
        }
        public String toString(){
            if (_name == null) {
                _name = "";
            }
            return "Name: " + _name;
        }
    }

}
