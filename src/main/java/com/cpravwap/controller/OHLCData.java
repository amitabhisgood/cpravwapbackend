/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cpravwap.controller;

/**
 *
 * @author Amitabh Choudhury
 */
// New Model Class
public class OHLCData {
    private String time;
    private double open;
    private double high;
    private double low;
    private double close;
    private double cpr;
    private double pivot;
    private double pivotHigh;
    private double pivotLow;
    private double anchorVWAP;

    public OHLCData(String time, double open, double high, double low, double close, double cpr, double pivot, double pivotHigh, double pivotLow, double anchorVWAP) {
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.cpr = cpr;
        this.pivot = pivot;
        this.pivotHigh = pivotHigh;
        this.pivotLow = pivotLow;
        this.anchorVWAP = anchorVWAP;
    }

    // Getters
    public String getTime() {
        return time;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public double getCpr() {
        return cpr;
    }

    public double getPivot() {
        return pivot;
    }

    public double getPivotHigh() {
        return pivotHigh;
    }

    public double getPivotLow() {
        return pivotLow;
    }

    public double getAnchorVWAP() {
        return anchorVWAP;
    }
}
