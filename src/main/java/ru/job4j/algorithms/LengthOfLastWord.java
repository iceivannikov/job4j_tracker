package ru.job4j.algorithms;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord length = new LengthOfLastWord();
        System.out.println(length.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
