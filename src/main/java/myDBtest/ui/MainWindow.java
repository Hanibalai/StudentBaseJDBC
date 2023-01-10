package myDBtest.ui;

import myDBtest.service.Query;
import myDBtest.service.Reader;
import myDBtest.service.Updater;

public class MainWindow {
    public void start() {
        System.out.println("Hello!\nPlease choose the option.");

        boolean exit = false;
        Menu.initialize();
        Menu.showOptions();

        while (!exit) {
            int option = Validator.getOption();
            switch (option) {
                case 1, 2, 3 -> new Reader().query(Menu.getOptions().get(option));
                case 4, 5 -> new Updater().query(Menu.getOptions().get(option));
                case 6 -> Menu.showOptions();
                case 0 -> {
                    IOWorker.closeInputReader();
                    Query.closeConnection();
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
