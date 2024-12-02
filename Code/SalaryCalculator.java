import java.util.Scanner;

class SalaryCalculator 
{
 public static void main(String[] args) 
 {
 Scanner scanner = new Scanner(System.in);
// Constants
 double PROFESSIONAL_TAX = 200;
 double TRANSPORT_ALLOWANCE = 900;
 // Basic pay based on grade levels
 double basicPay = 0;
 double houseRentAllowance = 0;
 double dearnessAllowance = 0;
 double otherAllowances = 0;
 double providentFund = 0;
 // Input for grade level
 System.out.print("Enter the grade level (A, B, C, D, E, or F): ");
 char gradeLevel = scanner.next().charAt(0);
 // Set basic pay and other allowances based on grade level
 switch (gradeLevel)
  {
 case 'A':
 basicPay = 50000;
 otherAllowances = 10000;
 break;
 case 'B':
 basicPay = 40000;
 otherAllowances = 8000;
 break;
 case 'C':
 basicPay = 30000;
 otherAllowances = 6000;
 break;
 case 'D':
 basicPay = 20000;
 otherAllowances = 4000;
 break;
 case 'E':
 basicPay = 15000;
 otherAllowances = 2000;
break;
 case 'F':
 basicPay = 10000;
 otherAllowances = 1000;
 break;
 default:
 System.out.println("Invalid grade level entered.");
 return;
 }
 // Input for city
 System.out.print("Enter the city (1 for Class 1, 2 for Class 2, 3 for Class 3): ");
 int city = scanner.nextInt();
 // Calculate house rent allowance (HRA) based on city
 switch (city)
  {
 case 1: // Class 1 City
 houseRentAllowance = 0.3 * basicPay;
 break;
 case 2: // Class 2 City
 houseRentAllowance = 0.2 * basicPay;
 break;
 case 3: // Class 3 City
 houseRentAllowance = 0.1 * basicPay;
 break;
 default:
 System.out.println("Invalid city entered.");
 return;
 }
 // Calculate Dearness Allowance (DRA) and Provident Fund
 dearnessAllowance = 0.5 * basicPay;
 providentFund = 0.11 * basicPay;
 // Calculate Gross Pay for one month
double grossPay = basicPay + houseRentAllowance + dearnessAllowance + otherAllowances + TRANSPORT_ALLOWANCE - PROFESSIONAL_TAX - providentFund;
 // Calculate Annual Income
 double annualIncome = grossPay * 12;
 // Calculate Income Tax based on annual income
 double incomeTax = 0;
 if (annualIncome < 250000)
  {
 incomeTax = 0; // No tax for income less than 2.5 L
 }
  else if (annualIncome < 500000) 
  {
 incomeTax = (annualIncome - 250000) * 0.05; // 5% for income between 2.5L and 5L
 } else if (annualIncome < 1000000)
  {
 incomeTax = (annualIncome - 500000) * 0.1 + 12500; // 10% for income between 5L and 10L
 
} else
  {
 incomeTax = (annualIncome - 1000000) * 0.3 + 12500 + 50000; // 30% for income above 10L
 }
 // Output results
 System.out.printf("Gross Pay of an Employee is: %.2f%n", grossPay);
 System.out.printf("Annual income of an Employee is: %.2f%n", annualIncome);
 System.out.printf("Income Tax to be paid by an Employee is: %.2f%n", incomeTax);
 
 }
}
