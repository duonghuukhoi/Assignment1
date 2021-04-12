package SES;

import java.util.ArrayList;

public class Course {

    //Initialize variables
    protected String cId;
    protected String cName;
    protected int noCredits;
    ArrayList<Student> studentList = new ArrayList<Student>();

    //Constructor
    public Course(String cId, String cName, int noCredits) {
        this.cId = cId;
        this.cName = cName;
        this.noCredits = noCredits;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getNoCredits() {
        return noCredits;
    }

    public void setNoCredits(int noCredits) {
        this.noCredits = noCredits;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
