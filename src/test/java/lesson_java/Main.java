package lesson_java;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human dima = new Human("Dmitri", 18, true);
        List<String> lectures = new ArrayList<>();
        lectures.add("git");
        lectures.add("java");
        lectures.add("files");
        lectures.add("junit");


        dima.printSome(12, "hello", lectures);
    }
}
