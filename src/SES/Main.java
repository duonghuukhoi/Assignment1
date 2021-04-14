package SES;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static final Scanner input = new Scanner(System.in); //Global scanner
    public static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");//Global SDF


    public static void main(String[] args) throws FileNotFoundException,ParseException{

        String fileName ="default.csv";
        System.out.println("Welcome to Student Enrolment Management system");
        System.out.print("Do you want to load a specific file? (Y/N):");
        String option = input.next();
        if (option.equals("y") |option.equals("Y")){
            System.out.print("Please enter filename:");
            fileName = input.next();
        }

        //Declare variable
        StudentEnrolment enrolmentList = new StudentEnrolment("All");
        List<List<String>> studentEnrolmentList = readFile(fileName); // Read file to string list
        enrolmentList.setEnrolment(studentEnrolmentList);
        ArrayList <StudentEnrolment> studentEnrolment = removeDuplicateEnrolment(studentEnrolmentArrayList(fileName)); //Read and remove duplicates semester in the file
        studentEnrolment = removeDuplicateEnrolment(studentEnrolment);//Remove twice for better result
        setValue(studentEnrolment,fileName);
        System.out.println("Menu:");
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Get one ");
        System.out.println("4. Get all");
        System.out.println("5. Print all courses for 1 student in 1 semester");
        System.out.println("6. Print all students of 1 course in 1 semester");
        System.out.println("7. Prints all courses offered in 1 semester");
        System.out.println("Enter your selection:");
        option = input.next();
        if (option.equals("1")){
            ArrayList<String> studentinfo = new ArrayList<String>();
            System.out.println("Student ID:");
            String sID = input.next();
            System.out.println("Semester:");
            String semester =input.next();
            System.out.println("CoursesID:");
            String cID = input.next();
            String[] courses = input.nextLine().split(",");
            for (String str:courses){
                for (int i =0;i<studentEnrolmentList.size();i++){
                    if (studentEnrolmentList.get(i).get(0).equals(sID)){
                        String sName = studentEnrolmentList.get(i).get(1);
                        String dob = studentEnrolmentList.get(i).get(2);
                        studentinfo.add(sID);
                        studentinfo.add(sName);
                        studentinfo.add(dob);
                        break;
                    }
                }
                for (int i =0;i<studentEnrolmentList.size();i++){
                    if (studentEnrolmentList.get(i).get(3).equals(cID)){
                        String cName = studentEnrolmentList.get(i).get(4);
                        String credits = studentEnrolmentList.get(i).get(5);
                        studentinfo.add(cID);
                        studentinfo.add(cName);
                        studentinfo.add(credits);
                        break;
                    }
                }
                studentEnrolmentList.add(studentinfo);
            }
            writeToDefault(studentEnrolmentList,fileName);
            enrolmentList.add();
        }else if (option.equals("2")){
            ArrayList<String> studentinfo = new ArrayList<String>();
            System.out.println("Student ID:");
            String sID = input.next();
            for ( int i = 0; i < enrolmentList.getEnrolment().size();i++) {
                System.out.println("Courses student enrol in:");
                if (sID.equals(enrolmentList.getEnrolment().get(i).get(0))) {
                    System.out.println(enrolmentList.getEnrolment().get(i).get(3));
                }
            }
            for ( int i = 0; i < enrolmentList.getEnrolment().size();i++){
                if(sID.equals(enrolmentList.getEnrolment().get(i).get(0))){
                    String cName =enrolmentList.getEnrolment().get(i).get(1);
                    String dob = enrolmentList.getEnrolment().get(i).get(2);
                    studentinfo.add(cName);
                    studentinfo.add(dob);
                    break;
                }
            }
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("Enter your selection:");
            String option1 = input.next();
            if (option1.equals("1")){
                System.out.println("Course ID:");
                String courseID = input.next();
                System.out.println("Course Name:");
                String courseName = input.next();
                System.out.println("Course credit:");
                String courseCredit = input.next();
                System.out.println("Semester:");
                String semester = input.next();
                studentinfo.add(courseID);
                studentinfo.add(courseName);
                studentinfo.add(courseCredit);
                studentinfo.add(semester);
                studentEnrolmentList.add(studentinfo);
                writeToDefault(studentEnrolmentList,fileName);
                enrolmentList.update();
            }
            else if (option1.equals("2")){
                System.out.println("Course ID:");
                String courseID = input.next();
                for (int i =0; i<studentEnrolmentList.size();i++){
                    if (studentEnrolmentList.get(i).get(0).equals(sID)){
                        if (studentEnrolmentList.get(i).get(3).equals(courseID)){
                            studentEnrolmentList.remove(i);
                        }
                    }
                }
                writeToDefault(studentEnrolmentList,fileName);
                enrolmentList.delete();
            }
        }else if (option.equals("3")){
            System.out.println("Student ID:");
            String sID = input.next();
            System.out.println("Course ID");
            String sC = input.next();
            for (int i = 0; i< enrolmentList.getEnrolment().size() ; i++){
                if (enrolmentList.getEnrolment().get(i).get(0).equals(sID)){
                    if (enrolmentList.getEnrolment().get(i).get(3).equals(sC)){
                        String sName= enrolmentList.getEnrolment().get(i).get(1);
                        String dob = enrolmentList.getEnrolment().get(i).get(2);
                        String cName =enrolmentList.getEnrolment().get(i).get(4);
                        String credit = enrolmentList.getEnrolment().get(i).get(5);
                        String semester = enrolmentList.getSemester();
                        enrolmentList.getOne(sID,sName,dob,sC,cName,credit,semester);
                    }
                }
            }
        }else if (option.equals("4")){
            enrolmentList.getAll();
        }else if (option.equals("5")){
            System.out.println("Student ID:");
            String sID = input.next();
            System.out.println("Semester:");
            String semester = input.next();
            ArrayList<String> coursesofStudent = new ArrayList<String>();
            coursesofStudent.add("Student "+sID+"in semeseter "+semester+"has:");
            for (int i = 0; i<enrolmentList.getEnrolment().size();i++){
                if (enrolmentList.getEnrolment().get(i).get(0).equals(sID)){
                    if (enrolmentList.getEnrolment().get(i).get(6).equals(semester)){
                        coursesofStudent.add(enrolmentList.getEnrolment().get(i).get(3));
                    }
                }
            }
            writeToFile(coursesofStudent);
        }else if (option.equals("6")){
            System.out.println("Course ID:");
            String cID = input.next();
            System.out.println("Semester:");
            String semester = input.next();
            ArrayList<String> listofStudent = new ArrayList<String>();
            listofStudent.add("Course "+cID+" in semester "+semester+"has:");
            for (int i =0 ; i<enrolmentList.getEnrolment().size();i++){
                if (enrolmentList.getEnrolment().get(i).get(3).equals(cID)){
                    if (enrolmentList.getEnrolment().get(i).get(6).equals(semester)){
                        listofStudent.add(enrolmentList.getEnrolment().get(i).get(0));
                    }
                }
            }
            writeToFile(listofStudent);
        }else if (option.equals("7")){
            System.out.println("Semester:");
            String semester = input.next();
            ArrayList<String> listofCourse = new ArrayList<String>();
            listofCourse.add("Semester "+semester+"has:");
            for (int i = 0; i<enrolmentList.getEnrolment().size();i++){
                if (enrolmentList.getEnrolment().get(i).get(6).equals(semester)){
                    listofCourse.add(enrolmentList.getEnrolment().get(i).get(3));
                }
            }
            writeToFile(listofCourse);
        }else {
            System.out.println("Invalid option");
        }


    }

    //Read file into studentEnrolmentList
    public static List<List<String>> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<List<String>> studentEnrolment = new ArrayList<List<String>>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String element[] = line.split(",");
            List<String> a = new ArrayList<String>();
            for (int i = 0; i < element.length; i++) {
                a.add(element[i]);
            }
            studentEnrolment.add(a);
        }
        return studentEnrolment;
    }

    // Read in the semester in the file
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

    //Remove duplicate
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

    //Set value for studentArray and courseArray based on the semester
    public static void setValue (ArrayList<StudentEnrolment> studentEnrolmentArrayList, String fileName) throws FileNotFoundException,ParseException {
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

    //Remove duplicates in student arraylist
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

    //Remove duplicates in course arraylist
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

    //Write to file
    public static void writeToFile(ArrayList<String> string){
        try {
            FileWriter writer = new FileWriter("report.txt");
            PrintWriter printWriter = new PrintWriter(writer);
            for (int i = 0; i<string.size();i++){
                printWriter.println(string.get(i));
            }
            printWriter.close();
        }catch (IOException ioE){
            System.err.println(ioE.getMessage());
        }
    }

    //Write to file CSV
    public static void  writeToDefault(List<List<String>> enrolment,String fileName){
        PrintWriter output =null;
        try{
            output = new PrintWriter(new FileWriter(fileName,false));
            for (int i = 0 ;i<enrolment.size();i++){
                System.out.println(enrolment.get(i).get(0)+","+enrolment.get(i).get(1)+","+enrolment.get(i).get(2)+","+enrolment.get(i).get(3)+","+enrolment.get(i).get(4)+","+enrolment.get(i).get(5)+","+enrolment.get(i).get(6));
            }
        }catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }finally {
            if (output !=null){
                output.close();
            }
        }
    }
}


