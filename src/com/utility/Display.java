package com.utility;

public class Display {

    public static void main() {
        Display.header();
        System.out.println("| [1] Generate Payroll      |");
        System.out.println("| [2] Modify Configurations |");
        System.out.println("| [3] Exit Program          |");
        System.out.println("+---------------------------+");
        System.out.println();
    }

    public static void configurations() {
        Display.current();
        System.out.println("| [1] Daily Rate            |");
        System.out.println("| [2] Time In               |");
        System.out.println("| [3] Time Out              |");
        System.out.println("| [4] Day Type              |");
        System.out.println("| [5] Go Back               |");
        System.out.println("+---------------------------+");
        System.out.println();
    }

    public static void modifyRate() {
        Terminal.clear();
        System.out.println("+---------------------------+");
        System.out.println("| Modifying Daily Rate...   |");
    }

    public static void modifyIn() {
        Terminal.clear();
        System.out.println("+---------------------------+");
        System.out.println("| Modifying Time In...      |");
    }

    public static void modifyOut() {
        Terminal.clear();
        System.out.println("+---------------------------+");
        System.out.println("| Modifying Time Out...     |");
    }

    public static void modifyType() {
        Terminal.clear();
        System.out.println("+---------------------------+");
        System.out.println("| Modifying Day Type...     |");
    }

    private static void header() {
        Terminal.clear();
        System.out.println("+---------------------------+");
        System.out.println("|   Weekly Payroll System   |");
        System.out.println("|        by airem.iv        |");
        System.out.println("+---------------------------+");
    }

    private static void current() {
        Terminal.clear();
        System.out.println("+---------------------------+");
        System.out.println("|  What one would you like  |");
        System.out.println("|         to tweak?         |");
        System.out.println("+---------------------------+");
    }

}
