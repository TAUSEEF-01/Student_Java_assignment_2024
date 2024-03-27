package Properties;

import java.util.Map;
import java.util.Scanner;

public class Student_info {
    private String name;
    private String roll;
    private String email;
    private EnrollCourse enrollCourse;
    private CalculateGrade calculateGrade;
    private int gradeArray[];
    private int coursesArr[];
    allEvaluation allEva;

    public Student_info(String n, String r, String e) {
        this.name = n;
        this.roll = r;
        this.email = e;
        enrollCourse = new EnrollCourse();
        calculateGrade = new CalculateGrade();
        allEva = new allEvaluation();

        this.gradeArray = new int[10];
        for (int i = 0; i < 10; i++) {
            this.gradeArray[i] = -1;
        }

        setCourses(1, 2, 3, 4);
    }

    public Student_info() {
        enrollCourse = new EnrollCourse();
    }

    public void setCourses(int a, int b, int c, int d) {
        coursesArr = new int[4];
        coursesArr[0] = a;
        coursesArr[1] = b;
        coursesArr[2] = c;
        coursesArr[3] = d;
        enrollCourse.setCourses(this.roll, a, b, c, d);
    }

    public int[] getCourses() {
        try {
            return coursesArr;
        } catch (Exception e) {
            System.out.println("Courses are not added: " + e.getMessage());
            return new int[0];
        }
    }

    public void enrolledCourses() {
        enrollCourse.getCourses();
    }

    public void printAllCourses() {
        enrollCourse.printAllCourses();
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setRoll(String s) {
        this.roll = s;
    }

    public void setEmail(String s) {
        this.email = s;
    }

    public void printAllInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        enrolledCourses();
    }

    public void setGrades(int CourseId, int marks) {
        // if (this.gradeArray == null) {
        // this.gradeArray = new int[10];
        // for (int i = 0; i < 10; i++) {
        // this.gradeArray[i] = -1;
        // }
        // }
        this.gradeArray[CourseId] = marks;
    }

    public void setGrades(int CourseId) {

        Scanner sc = new Scanner(System.in);
        int total = 0;
        Map<Integer, Integer> map = getAllEvaluation();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(
                    "Enter marks for " + allEva.evaluationName(entry.getKey()) + "out of " + entry.getValue() + ": ");
            int val = sc.nextInt();
            total += val;
        }
        System.out.println("Total marks: " + total);
        System.out.println();
        this.gradeArray[CourseId] = total;
    }

    public void getGrades() {
        System.out.println();
        for (int i = 1; i < 10; i++) {
            if (gradeArray[i] == -1)
                continue;
            System.out.println("Course name: " + enrollCourse.getCourseName(i));
            System.out.println("Obtained marks: " + gradeArray[i]);
            System.out.println();
        }
    }

    public void obtainedGrade() {
        int a[] = new int[4];
        int pos = 0;
        for (int i = 1; i < 10; i++) {
            if (gradeArray[i] == -1)
                continue;
            a[pos] = gradeArray[i];
            pos++;
        }
        double grade = calculateGrade.calculateGrade(a);
        System.out.println("Obtained grade: " + grade);
        System.out.println();
    }

    public double getGradeVal() {
        int a[] = new int[4];
        int pos = 0;
        for (int i = 1; i < 10; i++) {
            if (gradeArray[i] == -1)
                continue;
            a[pos] = gradeArray[i];
            pos++;
        }
        double grade = calculateGrade.calculateGrade(a);
        return grade;
    }

    public String courseName(int id) {
        String val = enrollCourse.getCourseName(id);
        return val;
    }

    public void setAllEvaluation() {
        // Map<Integer, Integer> map = ;
        allEva.chooseWay();
    }

    public Map<Integer, Integer> getAllEvaluation() {
        return allEva.getEva();
    }
}