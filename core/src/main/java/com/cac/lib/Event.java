package com.cac.lib;

import java.util.Scanner;


public class Event {
    public Error err = new Error();

    /**
     * This method prints a message to the console. <p>
     * the same as print()
     * 
     * @param message :the message to be print.
     * @see {@link System.out#println()}.
     */
    public static void print(Object message) {
        try {
            System.out.println(message);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    /**
     * This method print a message to the console. <p>
     * the same as print()
     * 
     * @param message :the message to be print.
     * @param end :the end of the sentence.
     * @see {@link System.out#println()}.
     */
    public static void print(Object message, Object end) {
        try {
            System.out.println(message);
            System.out.println(end);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    /**
     * This method let user input a message and return what they are input.<p>
     * 
     * @param ask :print the message before user input.
     * @return {@code String} : what user input.
     */
    public static String input(String ask) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print(ask);
            String input = scanner.nextLine();
            scanner.close();

            return input;
        } catch (Exception error) {
            error.printStackTrace();

            return null;
        } 
    }

    /*
     * To raise the error code
     * 
     * @param errorCode :the error code
     * @return {@code void}
     */
    public static void error(int errorCode) {
        try {
            System.out.println("[Error: "+ errorCode + "]");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}

class Error {
    public static void error(String error) {
        System.out.println("[Error] :" + error);
    }
}