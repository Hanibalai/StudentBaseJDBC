package myDBtest.dao;

import myDBtest.module.Student;

import java.sql.*;
import java.util.ArrayList;

public class DBWorker {
    private static final ConnectionManager connectionManager = new ConnectionManager();

    public ArrayList<Student> read(String query) {
        ArrayList<Student> students = new ArrayList<>();
        try (ResultSet set = connectionManager.getStatement().executeQuery(query)) {
            while (set.next()) {
                Student student = new Student();
                student.setId(set.getInt("id"));
                student.setName(set.getString("name"));
                student.setSurname(set.getString("surname"));
                student.setPatronymic(set.getString("patronymic"));
                student.setBirthdate(set.getDate("birthday"));
                student.setGroupName(set.getString("group_name"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Database reading error " + e.getMessage());
        }
        return students;
    }

    public void update(String query) {
        try {
            connectionManager.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Database updating error " + e.getMessage());
        }
    }

    public int findMaxId(String query) {
        int max = 0;
        try (ResultSet set = connectionManager.getStatement().executeQuery(query)) {
            set.next();
            max = set.getInt("MAX(id)");
        } catch (SQLException e) {
            System.out.println("Database reading error (ID)" + e.getMessage());
        }
        return max;
    }

    public ArrayList<String> findGroupList(String query) {
        ArrayList<String> groups = new ArrayList<>();
        try (ResultSet set = connectionManager.getStatement().executeQuery(query)) {
            while (set.next()) {
                groups.add(set.getString("group_name"));
            }
        } catch (SQLException e) {
            System.out.println("Database reading error (group_name)" + e.getMessage());
        }
        return groups;
    }

    public void closeConnection() {
        connectionManager.closeConnection();
    }
}
