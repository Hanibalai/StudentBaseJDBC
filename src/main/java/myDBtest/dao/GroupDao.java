package myDBtest.dao;

import myDBtest.module.Group;
import myDBtest.module.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupDao {
    private static final ConnectionManager connectionManager = new ConnectionManager();
    String SELECT_GROUP = "SELECT * FROM Students WHERE group_name = ?;";
    String SELECT_GROUP_NAMES_LIST = "SELECT DISTINCT group_name FROM Students ORDER BY 1;";

    public ArrayList<String> readGroupNames() {
        ArrayList<String> groups = new ArrayList<>();
        try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(SELECT_GROUP_NAMES_LIST);
             ResultSet set = statement.executeQuery()) {
            while (set.next()) {
                groups.add(set.getString("group_name"));
            }
        } catch (SQLException e) {
            System.out.println("Database reading error " + e.getMessage());
        }
        return groups;
    }

    public Group readGroup(String nameOfGroup) {
        ArrayList<Student> students = new ArrayList<>();
        try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(SELECT_GROUP)) {
            statement.setString(1, nameOfGroup);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    long id = set.getLong(1);
                    String name = set.getString(2);
                    String surname = set.getString(3);
                    String patronymic = set.getString(4);
                    Date birthDate = set.getDate(5);
                    String groupName = set.getString(6);
                    students.add(new Student(id, name, surname, patronymic, birthDate, groupName));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database reading error " + e.getMessage());
        }
        return new Group(students.get(0).getGroupName(), students);
    }

    public void closeConnection() {
        connectionManager.closeConnection();
    }
}
