import java.util.*;

import Properties.RankListCourse;
import Properties.RankListGpa;
import Properties.Student_info;

public class Student {
    public static int student_cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Student_info> student = new HashMap<>();
        student_cnt = 1;

        Boolean running = true;

        while (running == true) {
            running = mainLoop(sc, running, student);
        }
    }

    public static boolean mainLoop(Scanner sc, boolean running, Map<Integer, Student_info> student) {
        System.out.println("1. Input student information.");
        System.out.println("2. Show student information.");
        System.out.println("3. Show GPA rank list.");
        System.out.println("4. Show Course based rank list.");
        System.out.println("5. EXIT.");

        System.out.println();

        System.out.print("Your choice: ");

        int n = sc.nextInt();
        clearScreen();
        switch (n) {
            case 1:
                System.out.println();
                // clearScreen();
                studentPart(sc, student);
                break;

            case 2:
                System.out.println();
                // clearScreen();
                showStudentInfo(sc, student);
                break;

            case 3:
                System.out.println();
                GPArankList(sc, student);
                break;

            case 4:
                System.out.println();
                courseRankList(sc, student);
                break;

            case 5:
                running = false;
                break;

            default:
                break;
        }
        System.out.println();

        clearScreen();
        return running;
    }

    public static void studentPart(Scanner sc, Map<Integer, Student_info> student) {
        while (true) {
            System.out.println("1. Create students.");
            System.out.println("2. Update information of a student.");
            System.out.println("3. Return.");

            System.out.println();
            System.out.print("Your choice: ");
            int n = sc.nextInt();

            // clearScreen();
            int id;

            switch (n) {
                case 1:
                    System.out.println();
                    clearScreen();

                    createStudentDatabase(sc, student);
                    break;

                case 2:
                    System.out.print("Input student id: ");
                    id = sc.nextInt();
                    System.out.println();
                    if (student.get(id) == null) {
                        System.out.println("Student is not created.");
                        System.out.println();
                        continue;
                    }
                    clearScreen();

                    updateStudentInfo(sc, student, id);
                    break;

                // case 3:
                // System.out.print("Input student id: ");
                // id = sc.nextInt();
                // System.out.println();
                // if (student.get(id) == null) {
                // System.out.println("Student is not created.");
                // System.out.println();
                // continue;
                // }
                // clearScreen();

                // evaluationInfo(sc, student, id);
                // break;

                case 3:
                    System.out.println();
                    clearScreen();
                    return;

                default:
                    break;
            }
        }

    }

    // creating student database ------->
    public static void createStudentDatabase(Scanner sc, Map<Integer, Student_info> student) {
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 0; i < n; i++) {
            Student_info s = new Student_info("", "", "");

            student.put(student_cnt, s);
            student_cnt++;
        }

        System.out.println("Students created!");
        System.out.println();
        clearScreen();
    }

    public static void updateStudentInfo(Scanner sc, Map<Integer, Student_info> student, int id) {

        while (true) {
            System.out.println("1. Update basic information.");
            System.out.println("2. Update Courses.");
            System.out.println("3. Update Marks.");
            System.out.println("4. Return.");

            System.out.println();
            System.out.print("Your choice: ");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    clearScreen();
                    updateBasic_StudentInfo(sc, student, id);
                    break;

                case 2:
                    clearScreen();
                    updateCourse_StudentInfo(sc, student, id);
                    break;

                case 3:
                    clearScreen();
                    updateMarks_StudentInfo(sc, student, id);
                    break;

                case 4:
                    System.out.println();
                    clearScreen();
                    return;

                default:
                    break;
            }
        }
    }

    // updating student information ------->
    public static void updateBasic_StudentInfo(Scanner sc, Map<Integer, Student_info> student, int i) {
        if (student.get(i) == null) {
            System.out.println("Student not created.");
            System.out.println();
            clearScreen();
            return;
        }

        Student_info s = student.get(i);
        System.out.println("Enter basic information for student id no: " + i);

        String name = null, roll = null, email = null;
        while (true) {
            if (name == null) {
                System.out.print("Enter your name: ");
                name = sc.next();
                continue;
            }

            if (roll == null) {
                System.out.print("Enter your roll: ");

                boolean flag = true;
                String r = sc.next();
                for (int j = 1; j <= i; j++) {
                    String str = student.get(j).getRoll();
                    if (str.length() == r.length()) {
                        int f = 0, l = str.length();
                        for (int k = 0; k < l; k++) {
                            if (str.charAt(k) != r.charAt(k)) {
                                f = 1;
                                break;
                            }
                        }
                        if (f == 0) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag == true) {
                    roll = r;
                }
                continue;
            }

            if (email == null) {
                System.out.print("Enter your email: ");

                boolean flag = true;
                String e = sc.next();
                for (int j = 1; j <= i; j++) {
                    String str = student.get(j).getEmail();
                    if (str.length() == e.length()) {
                        int f = 0, l = str.length();
                        for (int k = 0; k < l; k++) {
                            if (str.charAt(k) != e.charAt(k)) {
                                f = 1;
                                break;
                            }
                        }
                        if (f == 0) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag == true) {
                    email = e;
                    break;
                }
            }
        }

        s.setName(name);
        s.setRoll(roll);
        s.setEmail(email);

        System.out.println();
        clearScreen();
    }

    public static void updateCourse_StudentInfo(Scanner sc, Map<Integer, Student_info> student, int i) {
        if (student.get(i) == null) {
            System.out.println("Student not created.");
            System.out.println();
            clearScreen();
            return;
        }

        Student_info s = student.get(i);
        System.out.println("Enter course information for student id no: " + i);

        s.printAllCourses();
        int cnt = 0;
        int arr[] = new int[4];

        while (cnt < 3) {
            System.out.print("Select " + (cnt + 1) + " no Major Course by selecting the course id: ");
            int crc = sc.nextInt();

            if (crc > 5 || crc < 1) {
                continue;
            }

            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if (crc == arr[j]) {
                    flag = false;
                }
            }
            if (flag == true) {
                arr[cnt] = crc;
                cnt++;
            }
        }

        int crc;
        while (true) {
            System.out.print("Select 1 Optional course by selecting the course id: ");
            crc = sc.nextInt();

            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if (crc == arr[j]) {
                    flag = false;
                }
            }

            if (flag == true)
                break;
        }

        arr[cnt] = crc;
        System.out.println();

        s.setCourses(arr[0], arr[1], arr[2], arr[3]);
        clearScreen();
        System.out.println();

        evaluationInfo(sc, student, i);
    }

    public static void updateMarks_StudentInfo(Scanner sc, Map<Integer, Student_info> student, int i) {
        if (student.get(i) == null) {
            System.out.println("Student not created.");
            System.out.println();
            clearScreen();
            return;
        }

        Student_info s = student.get(i);
        System.out.println("Enter marks information for student id no: " + i);

        int[] arr = s.getCourses();

        System.out.println("Input obtained marks for courses: ");
        for (int j = 0; j < 4; j++) {
            System.out.println("Input marks for " + s.courseName(arr[j]) + " course: ");

            // int marks = sc.nextInt();

            // if (marks > 100 || marks < 0) {
            // System.out.println("Input valid marks for this course.");
            // j--;
            // continue;
            // }

            // s.setGrades(arr[j], marks);
            s.setGrades(arr[j]);
        }
        System.out.println();
        clearScreen();
    }

    public static void evaluationInfo(Scanner sc, Map<Integer, Student_info> student, int id) {
        Student_info s = student.get(id);

        s.setAllEvaluation();
        while (true) {
            System.out.println("Type 0 to return.");
            int n = sc.nextInt();
            if (n == 0) {
                clearScreen();
                return;
            }
        }
    }

    // showing student information ------>
    public static void showStudentInfo(Scanner sc, Map<Integer, Student_info> student) {
        while (true) {
            System.out.println("1. Show All information.");
            System.out.println("2. Show basic information.");
            System.out.println("3. Show Courses.");
            System.out.println("4. Show Marks.");
            System.out.println("5. Show Grade.");
            System.out.println("6. Return.");

            System.out.println();
            System.out.print("Your choice: ");
            int n = sc.nextInt();

            // clearScreen();

            int id;
            switch (n) {
                case 1:
                    System.out.print("Input student id: ");
                    id = sc.nextInt();
                    System.out.println();
                    if (student.get(id) == null) {
                        System.out.println("Student is not created.");
                        System.out.println();
                        continue;
                    }

                    showAllInfo(sc, student, id);
                    break;

                case 2:
                    System.out.print("Input student id: ");
                    id = sc.nextInt();
                    System.out.println();
                    if (student.get(id) == null) {
                        System.out.println("Student is not created.");
                        System.out.println();
                        continue;
                    }

                    showBasicInfo(sc, student, id);
                    break;

                case 3:
                    System.out.print("Input student id: ");
                    id = sc.nextInt();
                    System.out.println();
                    if (student.get(id) == null) {
                        System.out.println("Student is not created.");
                        System.out.println();
                        continue;
                    }

                    showCourseInfo(sc, student, id);
                    break;

                case 4:
                    System.out.print("Input student id: ");
                    id = sc.nextInt();
                    System.out.println();
                    if (student.get(id) == null) {
                        System.out.println("Student is not created.");
                        System.out.println();
                        continue;
                    }

                    showMarksInfo(sc, student, id);
                    break;

                case 5:
                    System.out.print("Input student id: ");
                    id = sc.nextInt();
                    System.out.println();
                    if (student.get(id) == null) {
                        System.out.println("Student is not created.");
                        System.out.println();
                        continue;
                    }

                    showGradeInfo(sc, student, id);
                    break;

                case 6:
                    System.out.println();
                    clearScreen();
                    return;

                default:
                    break;
            }
        }
    }

    public static void showBasicInfo(Scanner sc, Map<Integer, Student_info> student, int i) {
        Student_info s = student.get(i);
        System.out.println("Student id: " + i);
        System.out.println("Name: " + s.getName());
        System.out.println("Email: " + s.getEmail());
        System.out.println("Roll: " + s.getRoll());
        System.out.println();
        while (true) {
            System.out.println("Press 0 to return.");
            int press = sc.nextInt();
            if (press == 0) {
                clearScreen();
                return;
            }
        }
    }

    public static void showCourseInfo(Scanner sc, Map<Integer, Student_info> student, int i) {
        Student_info s = student.get(i);
        System.out.println("Student id: " + i);
        s.enrolledCourses();
        System.out.println();
        while (true) {
            System.out.println("Press 0 to return.");
            int press = sc.nextInt();
            if (press == 0) {
                clearScreen();
                return;
            }
        }
    }

    public static void showMarksInfo(Scanner sc, Map<Integer, Student_info> student, int i) {
        Student_info s = student.get(i);
        System.out.println("Student id: " + i);
        s.getGrades();
        System.out.println();
        while (true) {
            System.out.println("Press 0 to return.");
            int press = sc.nextInt();
            if (press == 0) {
                clearScreen();
                return;
            }
        }
    }

    public static void showGradeInfo(Scanner sc, Map<Integer, Student_info> student, int i) {
        Student_info s = student.get(i);
        System.out.println("Student id: " + i);
        s.obtainedGrade();
        System.out.println();
        while (true) {
            System.out.println("Press 0 to return.");
            int press = sc.nextInt();
            if (press == 0) {
                clearScreen();
                return;
            }
        }
    }

    public static void showAllInfo(Scanner sc, Map<Integer, Student_info> student, int i) {
        Student_info s = student.get(i);
        System.out.println("Student id: " + i);
        System.out.println("Name: " + s.getName());
        System.out.println("Email: " + s.getEmail());
        System.out.println("Roll: " + s.getRoll());
        s.enrolledCourses();
        s.getGrades();
        s.obtainedGrade();
        while (true) {
            System.out.println("Press 0 to return.");
            int press = sc.nextInt();
            if (press == 0) {
                clearScreen();
                return;
            }
        }
    }

    // GPA rankList ------->
    public static void GPArankList(Scanner sc, Map<Integer, Student_info> student) {
        RankListGpa rank = new RankListGpa(student);

        while (true) {
            rank.rankWithInfo();

            System.out.println("Press 0 to return.");
            int press = sc.nextInt();
            if (press == 0) {
                clearScreen();
                return;
            }
        }

    }

    // Course based rankList ------->
    public static void courseRankList(Scanner sc, Map<Integer, Student_info> student) {
        RankListCourse rank = new RankListCourse(student);

        while (true) {
            rank.rankWithInfo();

            System.out.println("Press 0 to return.");
            int press = sc.nextInt();
            if (press == 0) {
                clearScreen();
                return;
            }
        }
    }

    // clearing terminal screen ------->
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

/*
 * Terminal command:
 * javac Student.java && java Student
 */