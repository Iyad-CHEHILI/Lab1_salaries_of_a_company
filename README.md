# Workers Salary Management

This project implements a Java program to manage a list of workers and calculate their total salaries.

## Questions

### 1. Is the design ready to easily accept changes in how to calculate the total salary?

**Yes.**

The design separates the salary calculation from the `Worker` class by using the `SalaryCalculator` interface.

Currently, the salary is calculated as:

```text
Total Salary = Base Salary + Complement
```

This calculation is implemented in the `BasicSalaryCalculator` class.

If we need to change the calculation in the future, for example to take taxes into account, we can create another implementation of the `SalaryCalculator` interface:

```java
public class TaxSalaryCalculator implements SalaryCalculator {

    @Override
    public double calculate(Worker worker) {

        double grossSalary =
                worker.getBaseSalary() + worker.getComplement();

        double taxes = grossSalary * 0.20;

        return grossSalary - taxes;
    }
}
```

We would then change:

```java
SalaryCalculator calculator = new BasicSalaryCalculator();
```

to:

```java
SalaryCalculator calculator = new TaxSalaryCalculator();
```

The `Worker` and `Company` classes do not need to be modified.

Therefore, the design is flexible and can easily accommodate different salary calculation rules.

---

### 2. How to implement the case where I don't use all of the 100 "spaces" for workers?

Instead of using an array with exactly 100 positions:

```java
Worker[] workers = new Worker[100];
```

we use a dynamic `ArrayList`:

```java
private List<Worker> workers = new ArrayList<>();
```

Workers are added only when they actually exist:

```java
company.addWorker(new Worker("Alice", 2000, 300));
company.addWorker(new Worker("Bob", 2200, 200));
```

If the company has only 20 workers, the list contains only 20 workers. There are no unused spaces to manage.

The `ArrayList` also means that the company is not limited to exactly 100 workers. It can contain 20, 50, 100, or more workers.

Therefore, using `ArrayList<Worker>` provides a more flexible solution than a fixed-size array.
