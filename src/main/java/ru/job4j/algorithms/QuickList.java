package ru.job4j.algorithms;

import java.util.Comparator;
import java.util.List;

public class QuickList {
    public static <T> void quickSort(List<T> sequence, Comparator<T> comparator) {
        quickSort(sequence, 0, sequence.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> sequence, int start, int end, Comparator<T> comparator) {
        if (start < end) {
            int pivotIndex = breakPartition(sequence, start, end, comparator);
            quickSort(sequence, start, pivotIndex - 1, comparator);
            quickSort(sequence, pivotIndex + 1, end, comparator);
        }
    }

    private static <T> int breakPartition(List<T> sequence, int start, int end, Comparator<T> comparator) {
        T pivot = sequence.get(start);
        int beginToEnd = start + 1;
        int endToBegin = end;
        while (true) {
            while (beginToEnd < end && comparator.compare(sequence.get(beginToEnd), pivot) < 0) {
                beginToEnd++;
            }
            while (comparator.compare(sequence.get(endToBegin), pivot) > 0) {
                endToBegin--;
            }
            if (beginToEnd >= endToBegin) {
                break;
            }
            swap(sequence, beginToEnd++, endToBegin--);
        }
        swap(sequence, start, endToBegin);
        return endToBegin;
    }

    private static <T> void swap(List<T> sequence, int i, int j) {
        T temp = sequence.get(i);
        sequence.set(i, sequence.get(j));
        sequence.set(j, temp);
    }
}
