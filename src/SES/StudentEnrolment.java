package SES;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class    StudentEnrolment implements StudentEnrolmentManager{

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
    public static void main(String[] args) throws FileNotFoundException{
        String fileName = "default.csv";
        List<List<String>> studentEnrolment = readFile(fileName);
    }

    public static List<List<String>> readFile(String fileName) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(fileName));
        List<List<String>> studentEnrolment = new ArrayList<List<String>>();
        List<String> x = new ArrayList<String>();
        System.out.println(Arrays.deepToString(studentEnrolment.toArray()));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String element [] = line.split(",");
            List<String> a = new ArrayList<String>();
            System.out.println(element[0]);
            for (int i =0 ; i < element.length ; i++){
                a.add(element[i]);
            }
            studentEnrolment.add(a);
        }
        return studentEnrolment;
    }
}
