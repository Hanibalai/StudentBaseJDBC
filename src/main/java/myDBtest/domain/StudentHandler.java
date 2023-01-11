package myDBtest.domain;

import myDBtest.dao.StudentDao;
import myDBtest.module.Student;
import myDBtest.ui.Validator;

import java.sql.Date;
import java.util.ArrayList;

public class StudentHandler {
    private static final StudentDao studentDAO = new StudentDao();

    public ArrayList<Student> getAllStudents() {
        return (studentDAO.readAllStudents());
    }

    public Student getOneStudent() {
        ArrayList<Long> idList = studentDAO.readIdList();
        return studentDAO.readOneStudent(Validator.getIdFromTable(idList));
    }

    public ArrayList<Student> removeOneStudent() {
        ArrayList<Long> idList = studentDAO.readIdList();
        studentDAO.removeStudentById(Validator.getIdFromTable(idList));
        return studentDAO.readAllStudents();
    }

    public ArrayList<Student> addStudent() {
        Student student = new Student();
        student.setName(Validator.getName());
        student.setSurname(Validator.getSurname());
        student.setPatronymic(Validator.getPatronymic());
        student.setBirthdate(Date.valueOf(Validator.getBirthDate()));
        student.setGroupName(Validator.getGroupName());
        studentDAO.addStudent(student);
        return studentDAO.readAllStudents();
    }

    public void close() {
        studentDAO.closeConnection();
    }
}
