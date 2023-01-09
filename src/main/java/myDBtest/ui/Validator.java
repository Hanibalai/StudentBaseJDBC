package myDBtest.ui;

import java.util.ArrayList;

public final class Validator {
    public static int getOption() {
        int option;
        while ((option = IOWorker.getInt()) < 0 || option >= Menu.getOptions().size()) {
            System.out.println("You entered the wrong option number.\nPlease try again");
            Menu.showGeneral(option);
        }
        return option;
    }

    public static int getIdFromTable(int maxId) {
        System.out.println("Please enter the student ID from the table.");
        int studentId;
        while ((studentId = IOWorker.getInt()) < 1 || studentId > maxId)
            System.out.println("There are no students with the given ID.\nPlease try again.");
        return studentId;
    }

    public static String getGroupNameFromTable(ArrayList<String> groupNames) {
        boolean isCorrect = false;
        String groupName;
        System.out.println("Please select a group name from the list:");
        IOWorker.showList(groupNames);
        while (true) {
            groupName = IOWorker.getString();
            for (String name : groupNames)
                if (groupName.trim().equalsIgnoreCase(name.trim())) {
                    isCorrect = true;
                    break;
                }
            if (isCorrect) break;
            System.out.println("You entered the wrong group name.\nPlease try again.");
        }
        return groupName;
    }

    public static String getName() {
        System.out.println("Please enter the student's name.");
        return IOWorker.getString().trim();
    }

    public static String getSurname() {
        System.out.println("Please enter the student's surname.");
        return IOWorker.getString().trim();
    }

    public static String getPatronymic() {
        System.out.println("Please enter the student's patronymic.");
        return IOWorker.getString().trim();
    }

    public static String getGroupName() {
        System.out.println("Please enter the student's group name.");
        return IOWorker.getString().trim();
    }

    public static String getBirthDate() {
        String warn = "You entered an invalid date.\nPlease try again.";
        System.out.println("Please enter day of birth.");
        int day;
        while ((day = IOWorker.getInt()) < 1 || day > 31)
            System.out.println(warn);
        System.out.println("Please enter month of birth.");
        int month;
        while ((month = IOWorker.getInt()) < 1 || month > 12)
            System.out.println(warn);
        System.out.println("Please enter year of birth (in four digit format).");
        int year;
        while ((year = IOWorker.getInt()) < 1 || year > 2023)
            System.out.println(warn);

        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
