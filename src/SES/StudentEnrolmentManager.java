package SES;

import java.util.ArrayList;
import java.util.List;

public interface StudentEnrolmentManager {
    public void add(List<String> info);
    public void update();
    public void delete();
    public void getOne();
    public void getAll();
}
