/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cpravwap;

/**
 *
 * @author Amitabh Choudhury
 */


import com.cpravwap.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cpravwap.service", "com.cpravwap.controller"})
public class Cpravwapbe implements CommandLineRunner {

    @Autowired
    private CsvService csvService;

    public static void main(String[] args) {
        // Start the Spring application
        SpringApplication.run(Cpravwapbe.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Ask the user how to run the application
        System.out.println("How do you want to run the application? (web/commandline/both) [default: both]: ");
        String mode = scanner.nextLine().trim().toLowerCase();

        // Default to both if no input is provided
        if (mode.isEmpty()) {
            mode = "both";
        }

        boolean isCommandLine = mode.equals("commandline") || mode.equals("both");
        boolean isWeb = mode.equals("web") || mode.equals("both");

        // If the application should run in command-line mode or both
        if (isCommandLine) {
            System.out.println("Do you want to update the database? (yes/no) [default: no]: ");
            String updateDbResponse = scanner.nextLine().trim().toLowerCase();

            // Default to 'no' if no input is provided
            boolean updateDb = updateDbResponse.equals("yes");

            if (updateDb) {
                System.out.println("Updating the database...");
                csvService.parseAndSaveCsv(); // Call the CSV service to update the database
                System.out.println("Database update completed.");
            } else {
                System.out.println("Skipping database update.");
            }
        }

        // If the application should run as a web service
        if (isWeb) {
            System.out.println("Starting the web application...");
            // The web server is already started by SpringApplication.run() in the main method.
        }
    }
}




