package SES;

import java.util.ArrayList;
import java.util.Date;

public class Student {

    //Initialize variables
    protected String sId;
    protected String sName;
    protected Date sBirthdate;

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

}
