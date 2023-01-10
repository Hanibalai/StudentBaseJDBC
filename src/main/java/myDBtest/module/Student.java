package myDBtest.module;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String birthdate;
    private Group group;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("d MMMM yyyy г.", Locale.getDefault());

    public Student(int id, String name, String surname, String patronymic, Date birthdate, String groupName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthdate = formatter.format(birthdate);
        this.group = new Group(groupName, this);
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = formatter.format(birthdate);
    }

    public String getGroupName() {
        return this.group.getGroupName();
    }

    public ArrayList<Student> getGroup() {
        return this.group.getStudents();
    }
    public void setGroupName(String groupName) {
        this.group = new Group(groupName, this);
    }

    @Override
    public String toString() {
        return "Student id - " + getId() +
                " | name: " + getName() +
                ", surname: " + getSurname() +
                ", patronymic: " + getPatronymic() +
                " | birthdate: " + getBirthdate() +
                " | group: " + getGroupName();
    }
}
