package SES;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrolment implements StudentEnrolmentManager  {

    ArrayList<Student> studentArrayList = new ArrayList<Student>();
    ArrayList<Course>  courseArrayList = new ArrayList<Course>();
    protected String semester;
    List<List<String>> enrolment = new ArrayList<List<String>>();

    public StudentEnrolment(String semester) {
        this.semester = semester;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public ArrayList<Course> getCourseArrayList() {
        return courseArrayList;
    }

    public void setCourseArrayList(ArrayList<Course> courseArrayList) {
        this.courseArrayList = courseArrayList;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<List<String>> getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(List<List<String>> enrolment) {
        this.enrolment = enrolment;
    }

    @Override
    public void add(List<String> info) {
        setEnrolment(this.enrolment.add(info));
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void getOne() {

    }

    @Override
    public void getAll() {
        for (int i = 0; i < enrolment.size();i++){
            System.out.println(enrolment.get(i));
        }
    }
}
