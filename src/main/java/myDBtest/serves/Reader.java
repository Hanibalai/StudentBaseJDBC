package myDBtest.serves;

import myDBtest.ui.Menu;
import myDBtest.ui.Validator;
import myDBtest.ui.IOWorker;
import java.util.ArrayList;

public class Reader implements Query {
    public void query(String command) {
        if (command.equals(Menu.getOptions().get(1))) readAll();
        if (command.equals(Menu.getOptions().get(2))) readOne();
        if (command.equals(Menu.getOptions().get(3))) readGroup();
    }

    private void readAll() {
        IOWorker.showResult(worker.read(SELECT_ALL));
    }

    private void readOne() {
        int maxId = worker.findMaxId(FIND_MAX_ID);
        IOWorker.showResult(worker.read(String.format(SELECT_ONE, Validator.getIdFromTable(maxId))));
    }

    private void readGroup() {
        ArrayList<String> groupNames = worker.findGroupList(FIND_GROUP_LIST);
        IOWorker.showResult(worker.read(String.format(SELECT_GROUP, Validator.getGroupNameFromTable(groupNames))));
    }
}
