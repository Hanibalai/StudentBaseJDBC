package myDBtest.ui;

import myDBtest.domain.StudentHandler;
import myDBtest.domain.GroupHandler;

public class MainWindow {
    public void start() {
        System.out.println("Hello!\nPlease choose the option.");

        boolean exit = false;
        Menu.initialize();
        Menu.showOptions();

        StudentHandler studentHandler = new StudentHandler();
        GroupHandler groupHandler = new GroupHandler();

        while (!exit) {
            int option = Validator.getOption();
            switch (option) {
                case 1 -> IOWorker.printResultList(studentHandler.getAllStudents());
                case 2 -> IOWorker.printResult(studentHandler.getOneStudent().toString());
                case 3 -> IOWorker.printResult(groupHandler.readGroup());
                case 4 -> IOWorker.printResultList(studentHandler.addStudent());
                case 5 -> IOWorker.printResultList(studentHandler.removeOneStudent());
                case 6 -> Menu.showOptions();
                case 0 -> {
                    IOWorker.closeInputReader();
                    studentHandler.close();
                    groupHandler.close();

                    exit = true;
                }
            }
            Menu.showGeneral(option);
        }
        System.out.println("Bye!");
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.start();
    }
}
