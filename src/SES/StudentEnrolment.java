package SES;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;


public class    StudentEnrolment implements StudentEnrolmentManager {

    @Override
    public void add() {

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

    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        //Declare variables
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        String fileName = "default.csv";
        List<List<String>> studentEnrolment = readFile(fileName);
        ArrayList<Student> studentArrayList = addStudent(studentEnrolment);
//        for (Student s :studentArrayList){
//            System.out.println(s.toString());
//        }
        ArrayList<Course> courseArrayList = new ArrayList<Course>();


//        Student a = new Student("s3820797","Duong Huu Khoi",sdf.parse("10/21/1996"));
        Student s = new Student(studentEnrolment.get(1).get(0), studentEnrolment.get(1).get(1), sdf.parse(studentEnrolment.get(1).get(2)));
        studentArrayList.add(s);
        System.out.println(studentArrayList.contains(s));
//        System.out.println(a.getsId());
//        if (studentArrayList.contains(s)){
//            System.out.println("yes");
//        }
    }

    public static List<List<String>> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<List<String>> studentEnrolment = new ArrayList<List<String>>();
        //List<String> x = new ArrayList<String>();
        //System.out.println(Arrays.deepToString(studentEnrolment.toArray()));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String element[] = line.split(",");
            List<String> a = new ArrayList<String>();
            //System.out.println(element[0]);
            for (int i = 0; i < element.length; i++) {
                a.add(element[i]);
            }
            studentEnrolment.add(a);
        }
        return studentEnrolment;
    }

    public static ArrayList<Student> addStudent(List<List<String>> enrolmentList) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        ArrayList<Student> studentList = new ArrayList<Student>();
        List<String> course = new ArrayList<String>();
        Student s = new Student(enrolmentList.get(0).get(0),enrolmentList.get(0).get(1),sdf.parse(enrolmentList.get(0).get(2)));
        studentList.add(s);
        System.out.println(enrolmentList.size());
        for (int i = 1; i < enrolmentList.size(); i++) {
            for (int j = 0; j < studentList.size(); i++){
                System.out.println(studentList.size());
                if (enrolmentList.get(i).get(j).equals(studentList.get(j).getsId())){
                    System.out.println("true");
                }else {
                    Student a = new Student(enrolmentList.get(i).get(0),enrolmentList.get(i).get(1),sdf.parse(enrolmentList.get(i).get(2)));
                    studentList.add(s);
                }
            }
        }
        return studentList;
    }
}
