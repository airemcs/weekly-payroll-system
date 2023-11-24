package com.utility;

import java.io.Console;

public class Terminal {
    
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void buffer(String message) {
        System.out.println();
        Console c = System.console();
        c.format(message);
        c.readLine();
    }

    public static void success(String message) {
        System.out.println("\033[32m\033[03m" + message + "\033[00m");
    }

    public static void warning(String message) {
        System.out.println("\033[30m\033[03m" + message + "\033[00m");
    }

    public static void danger(String message) {
        System.out.println("\033[31m\033[03m" + message + "\033[00m");
    }

}
