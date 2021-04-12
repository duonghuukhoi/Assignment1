package SES;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Student {

    //Initialize variables
    protected String sId;
    protected String sName;
    protected Date sBirthdate;
    ArrayList<Course> coursesList = new ArrayList<Course>();

    //Constructor
    public Student(String sId, String sName, Date sBirthdate) {
        this.sId = sId;
        this.sName = sName;
        this.sBirthdate = sBirthdate;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Date getsBirthdate() {
        return sBirthdate;
    }

    public void setsBirthdate(Date sBirthdate) {
        this.sBirthdate = sBirthdate;
    }

    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(ArrayList<Course> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public String toString() {
        return ("Student ID:" + this.getsId()+" Student name:"+this.getsName()+" DOB:"+this.getsBirthdate());
    }
}
