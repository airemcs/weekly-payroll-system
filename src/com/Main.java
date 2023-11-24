package com;

import java.util.Scanner;

import com.model.Employee;
import com.utility.Display;
import com.utility.Terminal;

public class Main {

    private static Employee employee = new Employee();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isTerminated = false;

        while (!isTerminated) {

            Display.main();
            System.out.print("Action: ");

            int action = sc.nextInt();
            if (action > 3 || action < 1) continue;

            switch (action) {
                case 1: generatePayroll(employee); break;
                case 2: modifyConfigurations(employee); break;
                case 3: Terminal.clear(); isTerminated = true;
            }

        }

    }

    private static void generatePayroll(Employee employee) {
        Terminal.clear();
        System.out.println("+---------------------------+");
        System.out.println("|      Payroll Results      |");
        System.out.println("|         Generated         |");
        System.out.println("+---------------------------+");

        System.out.print("| Daily Rate: " + employee.getRate());
        for (int i = 0; i < 14 - Double.toString(employee.getRate()).length(); i++) System.out.print(" ");
        System.out.println("|");

        System.out.print("| Time In: " + employee.getInTime());
        for (int i = 0; i < 17 - Integer.toString(employee.getInTime()).length(); i++) System.out.print(" ");
        System.out.println("|");

        System.out.print("| Time Out: " + employee.getOutTime());
        for (int i = 0; i < 16 - Integer.toString(employee.getOutTime()).length(); i++) System.out.print(" ");
        System.out.println("|");

        System.out.print("| Day Type: " + employee.getDayType());
        for (int i = 0; i < 16 - employee.getDayType().length(); i++) System.out.print(" ");
        System.out.println("|");

        System.out.print("| Hours Overtime: " + employee.getOvertimeHours());
        for (int i = 0; i < 10 - Integer.toString(employee.getOvertimeHours()).length(); i++) System.out.print(" ");
        System.out.println("|");

        System.out.print("| Hours Overtime Night : " + employee.getNightHours());
        for (int i = 0; i < 3 - Integer.toString(employee.getNightHours()).length(); i++) System.out.print(" ");
        System.out.println("|");

        System.out.print("| Day Salary: " + Double.toString(employee.getSalary()));
        for (int i = 0; i < 14 - Double.toString(employee.getSalary()).length(); i++) System.out.print(" ");
        System.out.println("|");

        System.out.print("| Week Salary: " + Double.toString(employee.getSalary() * 5));
        for (int i = 0; i < 13 - Double.toString(employee.getSalary() * 5).length(); i++) System.out.print(" ");
        System.out.println("|");

        System.out.print("+---------------------------+");
        Terminal.buffer("Hit enter to continue..");
    }

    private static void modifyConfigurations(Employee employee) {
        
        boolean isTerminated = false;

        while (!isTerminated) {

            Display.configurations();
            System.out.print("Action: ");

            int action = sc.nextInt();
            if (action > 5 || action < 1) continue;
            
            switch (action) {
                case 1: modifyRate(); break;
                case 2: modifyIn(); break;
                case 3: modifyOut(); break;
                case 4: modifyType(); break;
                case 5: isTerminated = true;
            }

        }

    }

    private static void modifyRate() {
        Display.modifyRate();
        System.out.print("| Current: " + Double.toString(employee.getRate()));
        for (int i = 0; i < 17 - Double.toString(employee.getRate()).length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");
        System.out.println("+---------------------------+");
        System.out.println();
        
        System.out.print("Enter Value: ");
        Double value = sc.nextDouble();
        employee.setRate(value);
    }
    
    private static void modifyIn() {
        Display.modifyIn();
        System.out.print("| Current: " + Integer.toString(employee.getInTime()));
        for (int i = 0; i < 17 - Integer.toString(employee.getInTime()).length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");
        System.out.println("+---------------------------+");
        System.out.println();
        
        // TODO: Validate Proper Military Time
        System.out.print("Enter Value: ");
        int value = sc.nextInt();
        employee.setInTime(value);
    }
    
    private static void modifyOut() {
        Display.modifyOut();
        System.out.print("| Current: " + Integer.toString(employee.getOutTime()));
        for (int i = 0; i < 17 - Integer.toString(employee.getOutTime()).length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");
        System.out.println("+---------------------------+");
        System.out.println();
        
        // TODO: Validate Proper Military Time
        System.out.print("Enter Value: ");
        Integer value = sc.nextInt();
        employee.setOutTime(value);
    }

    private static void modifyType() {
        Display.modifyType();
        System.out.print("| Current: " + employee.getDayType());
        for (int i = 0; i < 17 - employee.getDayType().length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.println("+---------------------------+");
        System.out.println("| [1] Normal Day            |");
        System.out.println("| [2] Rest Day              |");
        System.out.println("| [3] Special Non-Working   |");
        System.out.println("| [4] Special Non-Working   |");
        System.out.println("|     and Rest Day          |");
        System.out.println("| [5] Regular Holiday       |");
        System.out.println("| [6] Regular Holiday       |");
        System.out.println("|     and Rest Day          |");
        System.out.println("+---------------------------+");
        System.out.println();

        System.out.print("Enter Type: ");
        int value = sc.nextInt();
        
        switch (value) {
            case 1: employee.setDayType("Normal Day"); break;
            case 2: employee.setDayType("Rest Day"); break;
            case 3: employee.setDayType("Special Non-Working"); break;
            case 4: employee.setDayType("Special Non-Working and Rest Day"); break;
            case 5: employee.setDayType("Regular Holiday"); break;
            case 6: employee.setDayType("Regular Holiday and Rest Day");
        }

    }

}
