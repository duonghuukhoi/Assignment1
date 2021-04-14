package SES;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;


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
    public void add() {
        System.out.println("Added");
    }

    @Override
    public void update() {
        System.out.println("Updated");
    }

    @Override
    public void delete() {
        System.out.println("Deleted");

    }

    @Override
    public void getOne(String sID,String  sName,String dob,String cID,String cName,String credit,String semester){
        System.out.println(sID+","+sName+","+dob+","+cID+","+cName+","+credit+","+semester);
    }

    @Override
    public void getAll() {
        for (int i = 0; i < enrolment.size();i++){
            System.out.println(enrolment.get(i).get(0)+","+enrolment.get(i).get(1)+","+enrolment.get(i).get(2)+","+enrolment.get(i).get(3)+","+enrolment.get(i).get(4)+","+enrolment.get(i).get(5)+","+enrolment.get(i).get(6));
        }
    }
}
