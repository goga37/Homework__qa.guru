package lesson5;

public class BasicsJava {
    public static void main(String[] args) {
        int x = 5;
        int y = 3;
        double b = 7.5;
        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        System.out.println(x / y + "\n");
        System.out.println(x + b);
        System.out.println(x - b);
        System.out.println(x * b);
        System.out.println(x / b + "\n");
        System.out.println(x < b);
        System.out.println(x > b);
        System.out.println(x >= b);
        System.out.println((x <= b)+ "\n");
        float bigFloat = Float.MAX_VALUE;
        float resultFloat = bigFloat * 2; // Переполнение

        double bigDouble = Double.MAX_VALUE;
        double resultDouble = bigDouble * 2; // Переполнение

        System.out.println("Float overflow: " + resultFloat);
        System.out.println("Double overflow: " + resultDouble);
    }
}
