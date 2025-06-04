package ru.job4j.algorithms;

public class FirstBadVersion {
    private final int firstBad;

    public FirstBadVersion(int firstBad) {
        this.firstBad = firstBad;
    }

    public int firstBadVersion(int n) {
       int left = 1;
       int right = n;
       while (left < right) {
           int mid = left + (right - left) / 2;
           if (isBadVersion(mid)) {
               right = mid;
           } else {
               left = mid + 1;
           }
       }
       return left;
    }

    private boolean isBadVersion(int version) {
        return version >= firstBad;
    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion(4);
        System.out.println(fbv.firstBadVersion(10));
    }
}
