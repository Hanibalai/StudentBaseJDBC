package myDBtest.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class IOWorker {
    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

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

    public static void showResult(ArrayList<?> list) {
        System.out.println("Execution result:");
        if (list.isEmpty()) System.out.println("No data in table.");
        for (Object string : list) System.out.println(string);
    }

    public static void showList(ArrayList<?> list) {
        for (Object string : list) System.out.println(string);
    }

    public static void closeInputReader() {
        try {
            inputReader.close();
        } catch (IOException ignored) {}
    }
}
