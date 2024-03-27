import java.util.*;

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
                studentPart(sc, student);
                break;

            case 2:
                System.out.println();
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

class Student_info {
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
        allEva.chooseWay();
    }

    public Map<Integer, Integer> getAllEvaluation() {
        return allEva.getEva();
    }
}

abstract class Course {
    protected Map<Integer, String> courseMap;

    protected Course() {
        courseMap = new HashMap<>();

        courseMap.put(1, "ArtificialIntelligence");
        courseMap.put(2, "Security");
        courseMap.put(3, "OperationResearch");
        courseMap.put(4, "Networking");
        courseMap.put(5, "EmbeddedSystems");
    }

    public String get_Course_Name(int n) {
        String val = courseMap.get(n);
        return val;
    }

    public void printAllCourses() {
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Course id: " + i);
            System.out.println("Course name: " + courseMap.get(i));
        }
        System.out.println();
    }
}

class EnrollCourse extends Course {
    private Map<String, int[]> enrolledCourse;
    private String roll;

    protected EnrollCourse() {
        enrolledCourse = new HashMap<>();
    }

    public void setCourses(String r, int a, int b, int c, int d) {
        this.roll = r;
        enrolledCourse.put(roll, new int[] { a, b, c, d });
    }

    public void getCourses() {
        int[] array = enrolledCourse.get(roll);
        System.out.println();

        System.out.println("Major courses: ");
        System.out.println("1. " + courseMap.get(array[0]));
        System.out.println("2. " + courseMap.get(array[1]));
        System.out.println("3. " + courseMap.get(array[2]));
        System.out.println();

        System.out.println("Optional courses: ");
        System.out.println("1. " + courseMap.get(array[3]));
        System.out.println();
    }

    public void printCourseName(int n) {
        System.out.println("Course id: " + n);
        System.out.println("Course name: " + courseMap.get(n));
    }

    public String getCourseName(int n) {
        String val = get_Course_Name(n);
        return val;
    }
}

class allEvaluation {
    Midterm mid;
    RegularAssessment rgs;
    Final fnl;
    String str[];
    Map<Integer, Integer> map;
    int total1, total2, total3, total;

    allEvaluation() {
        mid = new Midterm();
        rgs = new RegularAssessment();
        fnl = new Final();

        map = new HashMap<>();

        str = new String[4];
        str[0] = "";
        str[1] = "Midterm";
        str[2] = "Regular Assessment";
        str[3] = "Final";

        total1 = 0;
        total2 = 0;
        total3 = 0;
        total = 0;

    }

    public String evaluationName(int n) {
        return str[n];
    }

    public void chooseWay() {
        Scanner sc = new Scanner(System.in);

        total1 = 0;
        total2 = 0;
        total3 = 0;
        total = 0;

        while (true) {
            System.out.println("1. To choose from Midterm.");
            System.out.println("2. To choose from Regular Assessment.");
            System.out.println("3. To choose from Final.");

            System.out.print("Your choice: ");
            int choose = sc.nextInt();
            System.out.println();

            if (choose > 3 || choose < 1) {
                continue;
            }

            if (choose == 1) {
                mid.printMarks();
                System.out.print("Your choice: ");
                int option = sc.nextInt();

                if (option == 1)
                    total1 += 20;
                else if (option == 2)
                    total1 += 30;
                else if (option == 3)
                    total1 += 40;
            } else if (choose == 2) {
                rgs.printMarks();
                System.out.print("Your choice: ");
                int option = sc.nextInt();
                if (option == 1)
                    total2 += 5;
                else if (option == 2)
                    total2 += 5;
                else if (option == 3)
                    total2 += 10;
            } else if (choose == 3) {
                fnl.printMarks();
                System.out.print("Your choice: ");
                int option = sc.nextInt();

                if (option == 1)
                    total3 += 60;
                else if (option == 2)
                    total3 += 70;
            }

            total = total1 + total2 + total3;

            System.out.println("Total: " + total);
            System.out.println();

            if (total > 100) {
                System.out.println("Total reset to 0.");
                total = 0;
                total1 = 0;
                total2 = 0;
                total3 = 0;
            } else if (total == 100) {
                map.put(1, total1);
                map.put(2, total2);
                map.put(3, total3);

                System.out.println();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    System.out.println(str[entry.getKey()] + ": " + entry.getValue());
                }
                break;
            }
        }

    }

    Map<Integer, Integer> getEva() {
        return map;
    }
}

abstract class Evaluation {
    String evaluationType;

    public void evaluationMarks() {
    }

    public void printMarks() {
    }

    public int marksVal(int n) {
        return 0;
    }

    public void setType(String s) {
        this.evaluationType = s;
    }

    public String getType() {
        return this.evaluationType;
    }
}

class Midterm extends Evaluation {
    int storeMarks[];

    Midterm() {
        storeMarks = new int[3];
        this.evaluationMarks();
    }

    void setName() {
        setType("Midterm");
    }

    @Override
    public void setType(String s) {
        super.setType(s);
    }

    @Override
    public void evaluationMarks() {
        storeMarks[0] = 20;
        storeMarks[1] = 30;
        storeMarks[2] = 40;
    }

    @Override
    public void printMarks() {
        storeMarks[0] = 20;
        storeMarks[1] = 30;
        storeMarks[2] = 40;

        System.out.println();
        System.out.println("Midterm marks options: ");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + storeMarks[i]);
        }
        System.out.println();
    }

    public int marksVal(int n) {
        if (n < 3 && n >= 0)
            return storeMarks[n];
        else
            return 0;
    }
}

class RegularAssessment extends Evaluation {
    int storeMarks[];

    RegularAssessment() {
        storeMarks = new int[3];
        this.evaluationMarks();
    }

    void setName() {
        setType("Regular Assessment");
    }

    @Override
    public void setType(String s) {
        super.setType(s);
    }

    @Override
    public void evaluationMarks() {
        storeMarks[0] = 5;
        storeMarks[1] = 5;
        storeMarks[2] = 10;
    }

    @Override
    public void printMarks() {
        storeMarks[0] = 5;
        storeMarks[1] = 5;
        storeMarks[2] = 10;

        System.out.println();
        System.out.println("Regular Assessment marks options: ");

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + storeMarks[i]);
        }
        System.out.println();
    }

    public int marksVal(int n) {
        if (n < 3 && n >= 0)
            return storeMarks[n];
        else
            return 0;
    }
}

class Final extends Evaluation {
    int storeMarks[];

    Final() {
        storeMarks = new int[2];
        this.evaluationMarks();
    }

    void setName() {
        setType("Final");
    }

    @Override
    public void setType(String s) {
        super.setType(s);
    }

    @Override
    public void evaluationMarks() {
        storeMarks[0] = 60;
        storeMarks[1] = 70;
    }

    @Override
    public void printMarks() {
        storeMarks[0] = 60;
        storeMarks[1] = 70;

        System.out.println();
        System.out.println("Final marks options: ");
        for (int i = 0; i < 2; i++) {
            System.out.println((i + 1) + ". " + storeMarks[i]);
        }
        System.out.println();
    }

    public int marksVal(int n) {
        if (n < 2 && n >= 0)
            return storeMarks[n];
        else
            return 0;
    }
}

abstract class Grade {
    private double gradeVal;

    protected double calcCGPA(double marks, double credit) {
        if (marks >= 80) // A+
            return 4.0 * credit;
        else if (marks >= 75)// A
            return 3.75 * credit;
        else if (marks >= 70) // A-
            return 3.5 * credit;
        else if (marks >= 65) // B+
            return 3.25 * credit;
        else if (marks >= 60) // B
            return 3.00 * credit;
        else if (marks >= 55) // B-
            return 2.75 * credit;
        else if (marks >= 50) // C+
            return 2.5 * credit;
        else if (marks >= 45) // C
            return 2.25 * credit;
        else if (marks >= 40) // D
            return 2.0 * credit;
        else
            return 0;
    }

    protected double calculateGrade(int arr[]) {
        gradeVal = 0;
        for (int i = 0; i < 3; i++) {
            gradeVal += calcCGPA((double) arr[i], 3.0);
        }
        gradeVal += calcCGPA((double) arr[3], 1.5);

        gradeVal /= 10.5;
        return gradeVal;
    }
}

class CalculateGrade extends Grade {
    public double grade(int arr[]) {
        double val = calculateGrade(arr);
        return val;
    }
}

class RankListGpa {
    private Map<Integer, Student_info> student;
    private Map<Double, Vector<Student_info>> rank_List;

    public RankListGpa(Map<Integer, Student_info> st) {
        student = st;
        rank_List = new TreeMap<>(Collections.reverseOrder());
        rank();
    }

    private void rank() {
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

class RankListCourse {
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
