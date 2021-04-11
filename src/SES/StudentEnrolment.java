package SES;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager{

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
        List<List<String>> studentEnrolment = new ArrayList<>();
        Scanner scanner = new Scanner(new File("default.csv"));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String element [] = line.split(",");
            System.out.println(element[0]);
        }
    }

    public static String[][] readFile() throws FileNotFoundException{
        int count=0;
        Scanner scanner = new Scanner(new File("SES/default.csv"));
        List<List<String>> studentEnrolment = new ArrayList<>();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String element [] = line.split("");
            System.out.println(element[0]);
        }
        return null;
    }
}
