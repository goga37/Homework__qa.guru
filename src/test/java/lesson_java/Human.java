package lesson_java;

import java.util.List;

public class Human {
    private final String name;
    private final int age;
    private final boolean isCute;

    public Human(String name, int age, boolean isCute) {
        this.name = name;
        this.age = age;
        this.isCute = isCute;
    }
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isCute=" + isCute +
                '}';
    }

    void printSome(int i, String str, List<String> list){
        System.out.println(i + " " + str + " " + list);
    }

}
