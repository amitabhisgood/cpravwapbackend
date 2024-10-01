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
import com.cpravwap.controller.OHLCData;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CsvToJSONService {

    @Autowired
    private D270924javaRepository repository;

    // Path to the CSV file
    private static final String CSV_FILE_PATH = "E:\\backups2024\\Java\\cpravwapbe\\NIFTY 3rd OCT 26500 CE (20240927).csv";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss");

    // Method that reads the CSV file and returns the data as a List of OHLCData
    public List<OHLCData> parseCsvAndReturnJson() {
        List<OHLCData> ohlcDataList = new ArrayList<>();

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

                try {
                    dateString = nextLine[0].replaceAll("GMT.*", "").trim(); // Remove timezone
                    dateString = dateString.replace("(India Standard Time)", "").trim();
                    DateTimeFormatter dtfInput = DateTimeFormatter.ofPattern("E MMM dd yyyy HH:mm:ss", Locale.ENGLISH);
                    LocalDateTime localDateTime = LocalDateTime.parse(dateString, dtfInput);

                    // Create a new OHLCData object
                    OHLCData ohlcData = new OHLCData(
                        localDateTime.toString(),
                        parseDouble(nextLine[1]),
                        parseDouble(nextLine[2]),
                        parseDouble(nextLine[3]),
                        parseDouble(nextLine[4]),
                        parseDouble(nextLine[12]),  // CPR
                        parseDouble(nextLine[5]),   // Pivot
                        parseDouble(nextLine[6]),   // Pivot High (Resistance 1)
                        parseDouble(nextLine[7]),   // Pivot Low (Support 1)
                        parseDouble(nextLine[13])   // AnchorVWAP (Assuming this is CPR BC)
                    );

                    // Add to the list
                    ohlcDataList.add(ohlcData);

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

        return ohlcDataList;  // Return the list of OHLCData objects
    }

    // Helper method to parse String to Double
    private Double parseDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null; // or 0.0 depending on your requirements
        }
        return Double.parseDouble(value.trim());
    }
}
    
