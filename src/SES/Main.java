package SES;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException,ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        String fileName = "default.csv";

        ArrayList <StudentEnrolment> studentEnrolmentList = removeDuplicateEnrolment(studentEnrolmentArrayList(fileName));
        studentEnrolmentList = removeDuplicateEnrolment(studentEnrolmentList);
        setValue(studentEnrolmentList,fileName);
        for (StudentEnrolment s :studentEnrolmentList){
            s.setCourseArrayList(removeDuplicateCourse(s.getCourseArrayList()));
            s.setStudentArrayList(removeDuplicateStudent(s.getStudentArrayList()));
        }
        for (StudentEnrolment s :studentEnrolmentList){
            if (s.getSemester().equals("2020C")){
                for (Student student: s.getStudentArrayList()){
                    System.out.println(student.toString());
                }
            }
        }
    }

    public static ArrayList<StudentEnrolment> studentEnrolmentArrayList(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        ArrayList<StudentEnrolment> studentEnrolmentArrayList = new ArrayList<StudentEnrolment>();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String element[] = line.split(",");
            studentEnrolmentArrayList.add(new StudentEnrolment(element[6]));
        }
        return studentEnrolmentArrayList;
    }

    public static ArrayList<StudentEnrolment> removeDuplicateEnrolment(ArrayList<StudentEnrolment> studentEnrolmentArrayList){
        for (int i=0; i<studentEnrolmentArrayList.size();i++){
            for (int j = i+1; j < studentEnrolmentArrayList.size();j++){
                if (studentEnrolmentArrayList.get(i).getSemester().equals(studentEnrolmentArrayList.get(j).getSemester())){
                    studentEnrolmentArrayList.remove(i);
                }
            }
        }
        return studentEnrolmentArrayList;
    }

    public static void setValue (ArrayList<StudentEnrolment> studentEnrolmentArrayList, String fileName) throws FileNotFoundException,ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String element[] = line.split(",");
            for (int i = 0; i < studentEnrolmentArrayList.size();i++){
                if (element[6].equals(studentEnrolmentArrayList.get(i).getSemester())){
                    ArrayList<Student> s = new ArrayList<Student>();
                    ArrayList<Course> c = new ArrayList<Course>();
                    Student student  = new Student(element[0],element[1],sdf.parse(element[2]));
                    s = studentEnrolmentArrayList.get(i).getStudentArrayList();
                    s.add(student);
                    studentEnrolmentArrayList.get(i).setStudentArrayList(s);
                    Course course = new Course(element[3],element[4],Integer.parseInt(element[5]));
                    c=studentEnrolmentArrayList.get(i).getCourseArrayList();
                    c.add(course);
                    studentEnrolmentArrayList.get(i).setCourseArrayList(c);
                }
            }
        }
    }

    public static ArrayList<Student> removeDuplicateStudent(ArrayList<Student> studentArrayList){
        for (int i=0; i<studentArrayList.size();i++){
            for (int j = i+1; j < studentArrayList.size();j++){
                if (studentArrayList.get(i).getsId().equals(studentArrayList.get(j).getsId())){
                    studentArrayList.remove(i);
                }
            }
        }
        return studentArrayList;
    }

    public static ArrayList<Course> removeDuplicateCourse(ArrayList<Course> courseArrayList){
        for (int i=0; i<courseArrayList.size();i++){
            for (int j = i+1; j < courseArrayList.size();j++){
                if (courseArrayList.get(i).getcId().equals(courseArrayList.get(j).getcId())){
                    courseArrayList.remove(i);
                }
            }
        }
        return courseArrayList;
    }


}


