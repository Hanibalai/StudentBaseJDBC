package myDBtest.service;

import myDBtest.dao.DBWorker;

public interface Query {
    DBWorker worker = new DBWorker();

    String SELECT_ALL = "SELECT * FROM Students;";
    String SELECT_ONE = "SELECT * FROM Students WHERE id = %d;";
    String SELECT_GROUP = "SELECT * FROM Students WHERE group_name = '%s';";
    String REMOVE_ONE_BY_ID = "DELETE FROM Students WHERE id = %d;";
    String FIND_MAX_ID = "SELECT MAX(id) FROM Students;";
    String FIND_GROUP_LIST = "SELECT DISTINCT group_name FROM Students ORDER BY 1;";
    String ADD_STUDENT = "INSERT INTO Students (name, surname, patronymic, birthday, group_name) " +
            " values ('%s', '%s', '%s', '%s', '%s');";

    void query(String command);

    static void closeConnection() {
        worker.closeConnection();
    }
}
