/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cpravwap.controller;

/**
 *
 * @author Amitabh Choudhury
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.cpravwap.service.CsvToJSONService;


@RestController
public class OHLCDataretriever {

    @GetMapping("/api/ohlc-data")
    public List<OHLCData> ohlcData() {
        List<OHLCData> ohlcDataList = (new CsvToJSONService()).parseCsvAndReturnJson();
        
        // Add sample data
//        ohlcDataList.add(new OHLCData("timestamp", 123, 150, 120, 130, 128, 129, 132, 125, 130));
        
        return ohlcDataList;
    }
}

