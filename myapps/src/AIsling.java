package myapps;

import java.util.Scanner;

class AIsling {

    public static void main() {
        System.out.println("Hello, my name is AISLING. How may I help You?");

        Scanner sc = new Scanner(System.in);
        String str;
        int n = 10;
        String[] ar = new String[n];

        while (sc.hasNextLine() == true) {
            str = sc.nextLine();
            ar = str.split(str);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ar[i] + " bla");
        }

    }

    static double add(double a, double b) {
        return a + b;
    }

    static double add(float a, float b) {
        return a + b;
    }

    static double add(float a, double b) {
        return a + b;
    }

    static double add(double a, float b) {
        return a + b;
    }

    static double sub(double a, double b) {
        return a - b;
    }

    static double mul(double a, double b) {
        return a * b;
    }

    static double div(double a, double b) {
        return a / b;
    }
}
