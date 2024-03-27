package Properties;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class RankListCourse {
    private Map<Integer, Student_info> student;
    private Map<Integer, Vector<Student_info>> rank_List;
    private EnrollCourse enrollCrc;

    public RankListCourse(Map<Integer, Student_info> st) {
        student = st;
        rank_List = new TreeMap<>(Collections.reverseOrder());
        enrollCrc = new EnrollCourse();
        rank();
    }

    private void rank() {
        for (Map.Entry<Integer, Student_info> entry : student.entrySet()) {
            Student_info s = entry.getValue();

            int[] arr = s.getCourses();

            for (int i = 0; i < 4; i++) {
                Vector<Student_info> studentsGrade = rank_List.getOrDefault(arr[i], new Vector<>());
                studentsGrade.add(s);
                rank_List.put(arr[i], studentsGrade);
            }
        }
    }

    public void rankWithInfo() {
        for (Map.Entry<Integer, Vector<Student_info>> entry : rank_List.entrySet()) {
            int courseId = entry.getKey();
            System.out.println("Course id: " + enrollCrc.getCourseName(courseId));

            System.out.println("Ranked Students:");
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-20s %-10s %-20s %-10s\n", "Name", "Roll", "Email", "Total GPA");
            System.out.println("------------------------------------------------------------");

            Vector<Student_info> studentsGrade = entry.getValue();
            for (Student_info s : studentsGrade) {
                String name = s.getName();
                String roll = s.getRoll();
                String email = s.getEmail();
                double gpa = s.getGradeVal();

                System.out.printf("%-20s %-10s %-20s %-10.2f\n", name, roll, email, gpa);
                System.out.println();
            }
        }

        System.out.println("------------------------------------------------------------");
    }
}
