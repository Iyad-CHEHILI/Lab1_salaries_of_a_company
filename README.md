### Is your design ready to easily accept changes in how to calculate the total salary? for example for calculating the total salary taking into account taxes.
Yes, the design is highly adaptable because it relies on **encapsulation**. The calculation logic is isolated entirely within the `getTotalSalary()` method of the `Worker` class. 

If the company decides to change how the salary is calculated (for example, deducting a 15% tax), you only need to update the logic inside that single method:

```java
public double getTotalSalary() {
    // Example: Deducting a 15% flat tax
    return (this.baseSalary + this.complement) * 0.85; 
}
