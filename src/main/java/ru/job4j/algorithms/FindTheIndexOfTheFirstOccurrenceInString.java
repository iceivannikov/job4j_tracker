package ru.job4j.algorithms;

public class FindTheIndexOfTheFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        int result = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInString find = new FindTheIndexOfTheFirstOccurrenceInString();
        System.out.println(find.strStr("sadbutsad", "sad"));
    }
}
