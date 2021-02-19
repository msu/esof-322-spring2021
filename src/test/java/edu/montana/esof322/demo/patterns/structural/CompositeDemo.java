package edu.montana.esof322.demo.patterns.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeDemo {

    public abstract static class LetterComposite {

        private final List<LetterComposite> children = new ArrayList<>();

        public void add(LetterComposite letter) {
            children.add(letter);
        }

        public int count() {
            return children.size();
        }

        protected void printThisBefore() {
        }

        protected void printThisAfter() {
        }

        public void print() {
            printThisBefore();
            children.forEach(LetterComposite::print);
            printThisAfter();
        }
    }

    public static class Letter extends LetterComposite {

        private final char character;

        public Letter(char c) {
            this.character = c;
        }

        @Override
        protected void printThisBefore() {
            System.out.print(character);
        }
    }

    public static class Word extends LetterComposite {

        public Word(List<Letter> letters) {
            letters.forEach(this::add);
        }

        public Word(char... letters) {
            for (char letter : letters) {
                this.add(new Letter(letter));
            }
        }

        @Override
        protected void printThisBefore() {
            System.out.print(" ");
        }
    }

    public static class Sentence extends LetterComposite {

        public Sentence(List<Word> words) {
            words.forEach(this::add);
        }

        @Override
        protected void printThisAfter() {
            System.out.print(".");
        }
    }

    public static void main(String[] args) {
        Word firstWord = new Word('W', 'h', 'e', 'r', 'e');
        var words = List.of(
                firstWord,
                new Word('t', 'h', 'e', 'r', 'e'),
                new Word('i', 's'),
                new Word('a'),
                new Word('w', 'h', 'i', 'p'),
                new Word('t', 'h', 'e', 'r', 'e'),
                new Word('i', 's'),
                new Word('a'),
                new Word('w', 'a', 'y')
        );

        Sentence sentence = new Sentence(words);
        LetterComposite comp = sentence;
        comp.print();
        comp = firstWord;
        comp.print();
    }

}
