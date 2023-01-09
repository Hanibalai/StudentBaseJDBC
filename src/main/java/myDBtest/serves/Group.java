package myDBtest.serves;

import java.util.ArrayList;

public class Group {
    private String groupName;
    private ArrayList<Student> students = new ArrayList<>();

    public Group(String groupName, Student student) {
        this.groupName = groupName;
        students.add(student);
    }
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
