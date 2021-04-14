package SES;

import java.util.ArrayList;
import java.util.List;

public interface StudentEnrolmentManager {
    public void add();
    public void update();
    public void delete();
    public void getOne(String sID,String  sName,String dob,String cID,String cName,String credit,String semester);
    public void getAll();
}
