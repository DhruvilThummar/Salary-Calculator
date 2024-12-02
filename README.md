# Salary-Calculator
The given Java program is a **Salary Calculator** that computes an employee's gross pay, annual income, and income tax based on their grade level, city classification, and other allowances and deductions.

---

### **Code Overview**:

1. **Purpose**:
   - This program calculates the following for an employee:
     - **Gross Pay** (monthly earnings after allowances and deductions).
     - **Annual Income** (12 months of gross pay).
     - **Income Tax** (based on the employee's annual income).

2. **User Inputs**:
   - The **grade level** of the employee (`A` to `F`).
   - The **city classification** (`1`, `2`, or `3` for Class 1, 2, or 3 cities).

3. **Outputs**:
   - Gross pay for one month.
   - Annual income.
   - Applicable income tax.

---

### **Code Explanation**:

1. **Constants**:
   - **Professional Tax**: Fixed deduction of ₹200.
   - **Transport Allowance**: Fixed addition of ₹900 per month.

   ```java
   double PROFESSIONAL_TAX = 200;
   double TRANSPORT_ALLOWANCE = 900;
   ```

2. **Grade-Based Pay Structure**:
   - The **basic pay** and **other allowances** are determined based on the employee's grade level (`A` to `F`) using a `switch` statement.
   - Invalid grade inputs terminate the program with a message.

   ```java
   switch (gradeLevel) {
       case 'A': basicPay = 50000; otherAllowances = 10000; break;
       case 'B': basicPay = 40000; otherAllowances = 8000; break;
       ...
       default: System.out.println("Invalid grade level entered."); return;
   }
   ```

3. **House Rent Allowance (HRA)**:
   - **HRA** is calculated as a percentage of basic pay, depending on the city classification:
     - Class 1: 30%
     - Class 2: 20%
     - Class 3: 10%
   - Invalid city inputs terminate the program with a message.

   ```java
   switch (city) {
       case 1: houseRentAllowance = 0.3 * basicPay; break;
       case 2: houseRentAllowance = 0.2 * basicPay; break;
       ...
       default: System.out.println("Invalid city entered."); return;
   }
   ```

4. **Allowances and Deductions**:
   - **Dearness Allowance (DRA)**: 50% of basic pay.
   - **Provident Fund (PF)**: 11% of basic pay.

   ```java
   dearnessAllowance = 0.5 * basicPay;
   providentFund = 0.11 * basicPay;
   ```

5. **Gross Pay**:
   - Gross pay is calculated as:
     - Basic Pay + HRA + Dearness Allowance + Other Allowances + Transport Allowance
     - Minus: Professional Tax and Provident Fund.

   ```java
   double grossPay = basicPay + houseRentAllowance + dearnessAllowance + otherAllowances 
                     + TRANSPORT_ALLOWANCE - PROFESSIONAL_TAX - providentFund;
   ```

6. **Annual Income**:
   - Calculated as 12 times the monthly gross pay:

   ```java
   double annualIncome = grossPay * 12;
   ```

7. **Income Tax Calculation**:
   - The tax is calculated based on the annual income using progressive tax slabs:
     - No tax for income below ₹2.5 lakhs.
     - 5% for income between ₹2.5L and ₹5L.
     - 10% for income between ₹5L and ₹10L.
     - 30% for income above ₹10L.
   - Uses an `if-else` block to determine the applicable tax.

   ```java
   if (annualIncome < 250000) {
       incomeTax = 0;
   } else if (annualIncome < 500000) {
       incomeTax = (annualIncome - 250000) * 0.05;
   } else if (annualIncome < 1000000) {
       incomeTax = (annualIncome - 500000) * 0.1 + 12500;
   } else {
       incomeTax = (annualIncome - 1000000) * 0.3 + 12500 + 50000;
   }
   ```

8. **Output Results**:
   - Displays:
     - Gross pay for one month.
     - Annual income.
     - Income tax.

   ```java
   System.out.printf("Gross Pay of an Employee is: %.2f%n", grossPay);
   System.out.printf("Annual income of an Employee is: %.2f%n", annualIncome);
   System.out.printf("Income Tax to be paid by an Employee is: %.2f%n", incomeTax);
   ```

---

### **Key Features**:
1. **Dynamic Calculations**:
   - Adapts to various grade levels and city classifications.

2. **Progressive Tax Slabs**:
   - Follows standard Indian tax slab rules.

3. **Fixed Allowances/Deductions**:
   - Includes professional tax, transport allowance, and provident fund.

4. **Structured and Modular**:
   - Uses `switch` statements for clear handling of grade levels and city classifications.

---

### **Potential Improvements**:
1. **Input Validation**:
   - Ensure grade level and city classification are valid inputs.

2. **Error Handling**:
   - Handle invalid numeric inputs gracefully instead of terminating the program.

3. **Enhancements**:
   - Add options for custom allowances or deductions.
   - Allow dynamic entry for constants like professional tax or transport allowance.

---

This program is a comprehensive solution for calculating salary details, suitable for basic payroll applications.
