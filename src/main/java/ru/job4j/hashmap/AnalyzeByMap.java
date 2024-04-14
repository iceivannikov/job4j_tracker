package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sizePupils = pupils.size();
        double sumScore = 0;
        double averageScore = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            int sizeSubjects = subjects.size();
            for (Subject subject : subjects) {
                sumScore += subject.score();
            }
            averageScore = sumScore / sizeSubjects;
        }
        return averageScore / sizePupils;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        String name;
        double averageScore;
        for (Pupil pupil : pupils) {
            name = pupil.name();
            int sumScore = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                int score = subject.score();
                sumScore += score;
            }
            averageScore = (double) sumScore / subjects.size();
            result.add(new Label(name, averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = getStringIntegerMap(pupils);
        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int totalScore = entry.getValue();
            double averageScore = (double) totalScore / pupils.size();
            result.add(new Label(key, averageScore));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        String name;
        for (Pupil pupil : pupils) {
            name = pupil.name();
            List<Subject> subjects = pupil.subjects();
            int sumScore = 0;
            for (Subject subject : subjects) {
                sumScore += subject.score();
            }
            labels.add(new Label(name, sumScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = getStringIntegerMap(pupils);
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int totalScore = entry.getValue();
            labels.add(new Label(key, totalScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    private static Map<String, Integer> getStringIntegerMap(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        return map;
    }
}
