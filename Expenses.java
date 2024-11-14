import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expenses {

    private static final int month = 0;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Scanner fileScanner = null;
        double monthlyGoal = getMonthlyGoal(keyboard);
        double totalExpenses = processData(fileScanner, monthlyGoal);
        
        System.out.printf("Total amount spent in 12 months: " + totalExpenses);
        
        keyboard.close();
        fileScanner.close();
    }

    public static double getMonthlyGoal(Scanner sc) {
        System.out.print("Enter your monthly goal: ");
        return sc.nextDouble();
    }

    public static double processData(Scanner sc, double goal) {
        double total = 0;

        for (int month = 1; month <= 12; month++) {
            int rent = sc.nextInt();
            double food = sc.nextDouble();
            double tuition = sc.nextDouble();
            double monthlyTotal = processOneMonth(rent, food, tuition, goal);
            total += monthlyTotal;
        }
        return total;
    }

    public static double processOneMonth(int rent, double food, double tuition, double goal) {
        double monthlyTotal = rent + food + tuition;
        if (monthlyTotal > goal) {
            System.out.printf("Expenses exceeded the goal for %s: $%.2f%n", getMonthName(month), monthlyTotal);
        }
        return monthlyTotal;
    }

    public static String getMonthName(int num) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[num - 1];
    }
}
