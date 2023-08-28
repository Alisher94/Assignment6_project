package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MyStudentRecordsMgmtApp {
    List<Student> studentList;

    public MyStudentRecordsMgmtApp() {
        studentList = new ArrayList<>();
    }

    public void createStudentArray() {
        studentList.add(new Student("110001", "Dave", "11/18/1951"));
        studentList.add(new Student("110002", "Anna", "12/07/1990"));
        studentList.add(new Student("110003", "Erica", "01/31/1974"));
        studentList.add(new Student("110004", "Carlos", "08/22/2009"));
        studentList.add(new Student("110005", "Bob", "03/05/1990"));
    }

    public void printListOfStudents(List<Student> students) {
        for (Student st : students) {
            System.out.println(st.toString());
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Student> getListOfPlatinumAlumniStudents(List<Student> students) {
        List<Student> platinumAlumniStudents = new ArrayList<>();

        for (Student st : students) {
            try {
                long diffInMillies = Math.abs(System.currentTimeMillis() - st.GetAdmissionDate().getTime());

                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                if (diff >= 30 * 365) {
                    platinumAlumniStudents.add(st);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return platinumAlumniStudents;
    }

    public void printHelloWorld(List<Integer> integerList) {
        for (Integer x : integerList) {
            if (x % 5 == 0 && x % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (x % 5 == 0) {
                System.out.println("Hello");
            } else if (x % 7 == 0) {
                System.out.println("World");

            }
        }
    }

    public List<Integer> createIntegerList(int count, int minBound, int maxBound) {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();

        System.out.print("List: [");
        for (int i = 0; i < count; ++i) {
            Integer x = random.nextInt(minBound, maxBound);
            integerList.add(x);
            System.out.print(x.toString());
            if (i < count - 1)
                System.out.print(",");
        }
        System.out.print("]\n");

        return integerList;
    }

    public Integer findSecondBiggest(List<Integer> integerList) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(integerList.size(), Collections.reverseOrder());
        for (Integer x : integerList) {
            priorityQueue.add(x);
        }

        priorityQueue.poll();
        int secondMax = priorityQueue.poll();
        System.out.println("Second biggest integer is:" + priorityQueue.poll());
        return secondMax;
    }

    public static void main(String[] args) {

        MyStudentRecordsMgmtApp myStudentRecordsMgmtApp = new MyStudentRecordsMgmtApp();
        myStudentRecordsMgmtApp.createStudentArray();
        System.out.println("--printListOfStudents--");
        myStudentRecordsMgmtApp.printListOfStudents(myStudentRecordsMgmtApp.getStudentList());


        System.out.println("\n --getListOfPlatinumAlumniStudents-- ");
        myStudentRecordsMgmtApp.printListOfStudents(myStudentRecordsMgmtApp.getListOfPlatinumAlumniStudents(myStudentRecordsMgmtApp.getStudentList()));

        System.out.println("\n --integer list--");
        myStudentRecordsMgmtApp.printHelloWorld(myStudentRecordsMgmtApp.createIntegerList(10, 1, 100));

        System.out.println("\n --findSecondBiggest--");
        myStudentRecordsMgmtApp.findSecondBiggest(myStudentRecordsMgmtApp.createIntegerList(10, 1, 100));
    }

}
