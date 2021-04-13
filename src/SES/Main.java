package SES;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;

public class Main {
    public static final Scanner input = new Scanner(System.in); //Global scanner
    public static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");//Global SDF


    public static void main(String[] args) throws FileNotFoundException,ParseException{

        String fileName ="";
        System.out.println("Welcome to Student Enrolment Management system");
        System.out.print("Do you want to load a specific file? (Y/N):");
        String option = input.next();
        if (option.equals("y") |option.equals("Y")){
            System.out.print("Please enter filename:");
            fileName = input.next();
        } else {
            fileName = "default.csv"; // File name
        }

        //Declare variable
        StudentEnrolment enrolmentList = new StudentEnrolment("All");
        List<List<String>> studentEnrolmentList = readFile(fileName); // Read file to string list
        enrolmentList.setEnrolment(studentEnrolmentList);
        ArrayList <StudentEnrolment> studentEnrolment = removeDuplicateEnrolment(studentEnrolmentArrayList(fileName)); //Read and remove duplicates semester in the file
        studentEnrolment = removeDuplicateEnrolment(studentEnrolment);//Remove twice for better result
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
            System.out.println("Student ID:");
            String sID = input.next();
            System.out.println("Semester:");
            String semester =input.next();
            System.out.println("Courses:");
            String[] courses = input.nextLine().split(",");
            enrolmentList.add();
        }else if (option.equals("2")){
            System.out.println("Student ID:");
            String sID = input.next();
            for ( int i = 0; i < enrolmentList.getEnrolment().size();i++){
                System.out.println("Courses student enrol in:");
                if(sID.equals(enrolmentList.getEnrolment().get(i).get(0))){
                    System.out.println(enrolmentList.getEnrolment().get(i).get(3));
                }
            }
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("Enter your selection:");
            String option1 = input.next();
            if (option1.equals("1")){
                System.out.println("Course ID:");
                String courseID = input.next();
                enrolmentList.update();
            }
            else if (option1.equals("2")){
                System.out.println("Course ID:");
                String courseID = input.next();
                enrolmentList.delete();
            }
        }else if (option.equals("3")){

        }else if (option.equals("4")){

        }else if (option.equals("5")){

        }else if (option.equals("6")){

        }else if (option.equals("7")){

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

}


