package myDBtest.ui;

import myDBtest.domain.Group;
import myDBtest.domain.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class IOWorker {
    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public static long getLong() {
        long input = -1;
        try {
            input = Long.parseLong(inputReader.readLine());
        } catch (IOException e) {
            System.out.println("IO error");
        } catch (IllegalArgumentException ignored) {}
        return input;
    }

    public static int getInt() {
        int input = -1;
        try {
            input = Integer.parseInt(inputReader.readLine());
        } catch (IOException e) {
            System.out.println("IO error");
        } catch (IllegalArgumentException ignored) {}
        return input;
    }

    public static String getString() {
        String string = null;
        try {
            string = inputReader.readLine();
        } catch (IOException e) {
            System.out.println("IO error");
        }
        return string;
    }

    public static void printResultList(ArrayList<?> list) {
        System.out.println("Execution result:");
        if (list.isEmpty()) System.out.println("No data in table.");
        for (Object string : list) System.out.println(string);
    }

    public static void printResult(String result) {
        System.out.println("Execution result:");
        if (result == null || result.equals("")) System.out.println("No data in table.");
        System.out.println(result);
    }

    public static void printResult(Group group) {
        System.out.println("Execution result:");
        System.out.println("Name of group: " + group.getGroupName());
        System.out.println("List of group students:");
        for (Student student : group.getStudents()) System.out.println(student);
    }

    public static void closeInputReader() {
        try {
            inputReader.close();
        } catch (IOException ignored) {}
    }
}
