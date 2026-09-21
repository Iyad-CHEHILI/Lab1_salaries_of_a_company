import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Using an ArrayList handles dynamic sizing automatically
        List<Worker> companyWorkers = new ArrayList<>(100);

        // Adding 3 sample workers
        companyWorkers.add(new Worker("Ana", 2500.00, 400.00));
        companyWorkers.add(new Worker("Carlos", 2800.50, 350.00));
        companyWorkers.add(new Worker("Elena", 3100.00, 600.00));

        double globalTotalSalary = 0.0;

        System.out.println("--- Employee Salary Report ---");
        for (Worker worker : companyWorkers) {
            double individualTotal = worker.getTotalSalary();
            globalTotalSalary += individualTotal;

            System.out.printf("Name: %-8s | Base: %.2f | Complement: %.2f | Total: %.2f%n",
                    worker.getName(),
                    worker.getBaseSalary(),
                    worker.getComplement(),
                    individualTotal);
        }

        System.out.println("------------------------------");
        System.out.printf("Global Total Salary for all workers: %.2f%n", globalTotalSalary);
    }
}