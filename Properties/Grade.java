package Properties;

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
