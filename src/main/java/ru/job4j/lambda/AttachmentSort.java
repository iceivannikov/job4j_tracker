package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparatorText = (o1, o2) -> o1.getName().compareTo(o2.getName());
        attachments.sort(comparatorText);
        System.out.println(attachments);
        Comparator<Attachment> comparatorDescSize = (o1, o2) -> Integer.compare(
                o2.getName().length(),
                o1.getName().length()
        );
        attachments.sort(comparatorDescSize);
        System.out.println(attachments);
    }
}
