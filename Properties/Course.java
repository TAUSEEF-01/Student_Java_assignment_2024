package Properties;

import java.util.*;

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

    // public void printCourseName(int n)
    // {
    // System.out.println();
    // System.out.println("Course id: " + n);
    // System.out.println("Course name: " + courseMap.get(n));
    // System.out.println();
    // }

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
