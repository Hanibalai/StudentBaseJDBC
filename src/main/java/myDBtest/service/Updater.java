package myDBtest.service;

import myDBtest.ui.Menu;
import myDBtest.ui.Validator;
import myDBtest.ui.IOWorker;

public class Updater implements Query {
    public void query(String command) {
        if (command.equals(Menu.getOptions().get(4))) addStudent();
        if (command.equals(Menu.getOptions().get(5))) removeStudent();
    }

    private void addStudent() {
        String name = Validator.getName();
        String surname = Validator.getSurname();
        String patronymic = Validator.getPatronymic();
        String birthdate = Validator.getBirthDate();
        String groupName = Validator.getGroupName();
        worker.update(String.format(ADD_STUDENT, name, surname, patronymic, birthdate, groupName));
        IOWorker.showResult(worker.read(SELECT_ALL));
    }

    private void removeStudent() {
        int maxId = worker.findMaxId(FIND_MAX_ID);
        worker.update(String.format(REMOVE_ONE_BY_ID, Validator.getIdFromTable(maxId)));
        IOWorker.showResult(worker.read(SELECT_ALL));
    }
}
