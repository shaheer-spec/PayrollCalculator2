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

        System.out.print("Enter the name of the payroll file to create:");
        String payrollFile = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(payrollFile));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                String outputLine = String.format("%d | %s | %.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                writer.write(outputLine);
            }

            reader.close();
            writer.close();
        } catch (Exception ex) {
            System.err.println("Error reading file: " + fileName);
        }
    }
}
