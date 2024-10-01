/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cpravwap.service;

/**
 *
 * @author Amitabh Choudhury
 */
import com.cpravwap.entity.D270924java;
import com.cpravwap.repository.D270924javaRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class CsvService {
    
    @Autowired
    private D270924javaRepository repository;

    // Path to the CSV file
    private static final String CSV_FILE_PATH = "E:\\backups2024\\Java\\cpravwapbe\\NIFTY 3rd OCT 26500 CE (20240927).csv";
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss");    
    public void parseAndSaveCsv() {
        System.out.println("Parsing CSV..1");
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            String[] nextLine;
            boolean isHeader = true;
            String dateString = "";
            while ((nextLine = reader.readNext()) != null) {
                // Skip header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // If nextLine contains only 1 element and includes ';', split it into array
                if (nextLine.length == 1 && (nextLine[0].contains(",") || nextLine[0].contains(";"))) {
                    nextLine = nextLine[0].split(";");
                }

                if (nextLine.length != 15) {  // Assuming 15 columns are expected
                    System.err.println("Invalid row length: " + String.join(",", nextLine));
                    continue;
                }

                D270924java record = new D270924java();

                try {
                dateString = nextLine[0].replaceAll("GMT.*", "").trim(); // Remove timezone
                dateString = dateString.replace("(India Standard Time)", "").trim();
                DateTimeFormatter dtfInput = DateTimeFormatter.ofPattern("E MMM dd yyyy HH:mm:ss", Locale.ENGLISH);
                LocalDateTime localDateTime = LocalDateTime.parse(dateString, dtfInput);
                record.setDate(localDateTime); // Set the date

                    // Parse other fields
                    record.setOpen(parseDouble(nextLine[1]));
                    record.setHigh(parseDouble(nextLine[2]));
                    record.setLow(parseDouble(nextLine[3]));
                    record.setClose(parseDouble(nextLine[4]));
                    record.setPivot(parseDouble(nextLine[5]));
                    record.setResistance1(parseDouble(nextLine[6]));
                    record.setSupport1(parseDouble(nextLine[7]));
                    record.setResistance2(parseDouble(nextLine[8]));
                    record.setSupport2(parseDouble(nextLine[9]));
                    record.setResistance3(parseDouble(nextLine[10]));
                    record.setSupport3(parseDouble(nextLine[11]));
                    record.setCprPivot(parseDouble(nextLine[12]));
                    record.setCprBc(parseDouble(nextLine[13]));
                    record.setCprTc(parseDouble(nextLine[14]));
                    System.out.println(record);

                    // Save the record to the database
                    repository.save(record);
                } catch (Exception e) {
                    System.err.println("Error parsing row: " + dateString);
                    e.printStackTrace();
                    break;
                }
            }

        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    }
    private Double parseDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null; // or 0.0 depending on your requirements
        }
        return Double.parseDouble(value.trim());
    }
}
