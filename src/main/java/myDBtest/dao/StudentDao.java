package myDBtest.dao;

import myDBtest.module.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao{
    private static final ConnectionManager connectionManager = new ConnectionManager();
    String SELECT_ALL = "SELECT * FROM Students;";
    String SELECT_ONE = "SELECT * FROM Students WHERE id = ?;";
    String DELETE_BY_ID = "DELETE FROM Students WHERE id = ?;";
    String SELECT_ALL_ID = "SELECT id FROM Students;";
    String ADD_STUDENT = "INSERT INTO Students (name, surname, patronymic, birthday, group_name) " +
            " values (?, ?, ?, ?, ?);";

    public ArrayList<Student> readAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(SELECT_ALL);
             ResultSet set = statement.executeQuery()) {
            while (set.next()) {
                Student student = new Student();
                initializeStudent(student, set);
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Database reading error  " + e.getMessage());
        }
        return students;
    }
    public Student readOneStudent(long id) {
        Student student = new Student();
        try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(SELECT_ONE)) {
            statement.setLong(1, id);
            try (ResultSet set = statement.executeQuery()) {
                set.next(); // check
                initializeStudent(student, set);
            }
        } catch (SQLException e) {
            System.out.println("Database reading error " + e.getMessage());
        }
        return student;
    }

    public void addStudent(Student student) {
        try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(ADD_STUDENT)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getPatronymic());
            statement.setDate(4, student.getBirthdate());
            statement.setString(5, student.getGroupName());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Database updating error " + e.getMessage());
        }
    }

    public void removeStudentById(long id) {
        try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Database deleting error " + e.getMessage());
        }
    }

    public ArrayList<Long> readIdList() {
        ArrayList<Long> idList = new ArrayList<>();
        try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(SELECT_ALL_ID);
             ResultSet set = statement.executeQuery()) {
            while (set.next()) {
                idList.add(set.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Database reading error " + e.getMessage());
        }
        return idList;
    }

    private void initializeStudent(Student student, ResultSet set) throws SQLException {
        student.setId(set.getInt("id"));
        student.setName(set.getString("name"));
        student.setSurname(set.getString("surname"));
        student.setPatronymic(set.getString("patronymic"));
        student.setBirthdate(set.getDate("birthday"));
        student.setGroupName(set.getString("group_name"));
    }

    public void closeConnection() {
        connectionManager.closeConnection();
    }
}
