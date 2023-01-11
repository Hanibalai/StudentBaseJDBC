package myDBtest.ui;

import java.util.ArrayList;

public final class Menu {

    private final static ArrayList<String> options = new ArrayList<>();

    public static void initialize() {
        String exit = "0. Exit.";
        options.add(exit);
        String readAll = "1. Display all students from table.";
        options.add(readAll);
        String readSpecificStudent = "2. Display specific student by ID.";
        options.add(readSpecificStudent);
        String readGroupOfStudents = "3. Display group of students by name of group.";
        options.add(readGroupOfStudents);
        String addStudent = "4. Add student to table.";
        options.add(addStudent);
        String removeStudent = "5. Remove student by ID.";
        options.add(removeStudent);
        String menu = "6. Show menu.";
        options.add(menu);
    }

    public static void showOptions() {
        for (String s : options) System.out.println(s);
    }

    public static void showGeneral(int command) {
        if (command != 0 && command != 6)
            System.out.println(options.get(0) + "\n" + options.get(6));
    }

    public static ArrayList<String> getOptions() {
        return options;
    }
}
