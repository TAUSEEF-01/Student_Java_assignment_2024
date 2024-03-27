package Properties;

import java.util.*;

public class RankListGpa {
    private Map<Integer, Student_info> student;
    // Map<Double, Student_info> rankList;
    private Map<Double, Vector<Student_info>> rank_List;

    public RankListGpa(Map<Integer, Student_info> st) {
        student = st;
        // rankList = new TreeMap<>();
        rank_List = new TreeMap<>(Collections.reverseOrder());
        rank();
    }

    private void rank() {
        // for (Map.Entry<Integer, Student_info> entry : student.entrySet())
        // {
        // Student_info s = entry.getValue();
        // double d = s.getGradeVal();
        // rankList.put(d, s);
        // }

        for (Map.Entry<Integer, Student_info> entry : student.entrySet()) {
            Student_info s = entry.getValue();
            double grade = s.getGradeVal();

            Vector<Student_info> studentsGrade = rank_List.getOrDefault(grade, new Vector<>());
            studentsGrade.add(s);
            rank_List.put(grade, studentsGrade);
        }
    }

    public void rankWithInfo() {
        System.out.println("Ranked Students:");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s %-10s %-20s %-10s\n", "Name", "Roll", "Email", "Total GPA");
        System.out.println("------------------------------------------------------------");

        // for (Map.Entry<Double, Student_info> entry : rankList.entrySet())
        // {
        // Student_info s = entry.getValue();
        // double gpa = entry.getKey();
        // String name = s.getName();
        // String roll = s.getRoll();
        // String email = s.getEmail();

        // System.out.printf("%-20s %-10s %-20s %-10.2f\n", name, roll, email, gpa);
        // }

        for (Map.Entry<Double, Vector<Student_info>> entry : rank_List.entrySet()) {
            double gpa = entry.getKey();
            Vector<Student_info> studentsGrade = entry.getValue();
            for (Student_info s : studentsGrade) {
                String name = s.getName();
                String roll = s.getRoll();
                String email = s.getEmail();

                System.out.printf("%-20s %-10s %-20s %-10.2f\n", name, roll, email, gpa);
            }
        }

        System.out.println("------------------------------------------------------------");

    }
}
