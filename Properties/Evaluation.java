package Properties;

import java.util.*;

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

    // Map<Integer, Integer> chooseWay()
    public void chooseWay() {
        // Map<Integer, Integer> map = new HashMap<>();
        // Map<Integer, Integer> check = new HashMap<>();

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
                // if(check.get(1) == option)
                // {

                // }

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
    // int storeMarks[];

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
        // storeMarks = new int[3];
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
        // storeMarks = new int[3];
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
        // storeMarks = new int[2];
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

// public void marksVal(int n)
// {
// this.marks = n;
// }

// public int assignedMarks()
// {
// return marks;
// }