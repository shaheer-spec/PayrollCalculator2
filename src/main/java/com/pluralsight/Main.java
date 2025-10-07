package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the employee file to process: ");
        String fileName = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            System.out.print("Enter the name of the payroll file to create:");
            String payrollFile = scanner.nextLine();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(payrollFile));

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.printf("%d | %s | $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }

            reader.close();
            bufferedWriter.close();
        } catch (Exception ex) {
            System.err.println("Error reading file: " + fileName);
        }
    }
}
