/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cpravwap.entity;

/**
 * Entity representing the D270924java table in the cprst database.
 * 
 * @author 
 */
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "D270924java")
public class D270924java {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date")
//    private Date date;
//    private Date date;
//    private Date date;
    private LocalDateTime date;
    
    @Column(name = "open")
    private Double open;

    @Column(name = "high")
    private Double high;

    @Column(name = "low")
    private Double low;

    @Column(name = "close")
    private Double close;

    @Column(name = "pivot")
    private Double pivot;

    @Column(name = "resistance1")
    private Double resistance1;

    @Column(name = "support1")
    private Double support1;

    @Column(name = "resistance2")
    private Double resistance2;

    @Column(name = "support2")
    private Double support2;

    @Column(name = "resistance3")
    private Double resistance3;

    @Column(name = "support3")
    private Double support3;

    @Column(name = "cpr_pivot")
    private Double cprPivot;

    @Column(name = "cpr_bc")
    private Double cprBc;

    @Column(name = "cpr_tc")
    private Double cprTc;

    // Constructors

    /**
     * Default constructor required by JPA.
     */
    public D270924java() {
        // Default constructor
    }

    /**
     * Parameterized constructor for easy object creation.
     *
     * @param date         The date of the stock data.
     * @param open         Opening price.
     * @param high         Highest price.
     * @param low          Lowest price.
     * @param close        Closing price.
     * @param pivot        Pivot point.
     * @param resistance1  First resistance level.
     * @param support1     First support level.
     * @param resistance2  Second resistance level.
     * @param support2     Second support level.
     * @param resistance3  Third resistance level.
     * @param support3     Third support level.
     * @param cprPivot     CPR Pivot value.
     * @param cprBc        CPR BC value.
     * @param cprTc        CPR TC value.
     */
    public D270924java(LocalDateTime date, Double open, Double high, Double low, Double close, Double pivot,
                      Double resistance1, Double support1, Double resistance2, Double support2,
                      Double resistance3, Double support3, Double cprPivot, Double cprBc, Double cprTc) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.pivot = pivot;
        this.resistance1 = resistance1;
        this.support1 = support1;
        this.resistance2 = resistance2;
        this.support2 = support2;
        this.resistance3 = resistance3;
        this.support3 = support3;
        this.cprPivot = cprPivot;
        this.cprBc = cprBc;
        this.cprTc = cprTc;
    }

    // Getters and Setters

    /**
     * Gets the ID of the record.
     *
     * @return The ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the record.
     * Note: Typically, the ID is auto-generated, so setting it manually is not common.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the date of the stock data.
     *
     * @return The date.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date of the stock data.
     *
     * @param date The date to set.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getPivot() {
        return pivot;
    }

    public void setPivot(Double pivot) {
        this.pivot = pivot;
    }

    public Double getResistance1() {
        return resistance1;
    }

    public void setResistance1(Double resistance1) {
        this.resistance1 = resistance1;
    }

    public Double getSupport1() {
        return support1;
    }

    public void setSupport1(Double support1) {
        this.support1 = support1;
    }

    public Double getResistance2() {
        return resistance2;
    }

    public void setResistance2(Double resistance2) {
        this.resistance2 = resistance2;
    }

    public Double getSupport2() {
        return support2;
    }

    public void setSupport2(Double support2) {
        this.support2 = support2;
    }

    public Double getResistance3() {
        return resistance3;
    }

    public void setResistance3(Double resistance3) {
        this.resistance3 = resistance3;
    }

    public Double getSupport3() {
        return support3;
    }

    public void setSupport3(Double support3) {
        this.support3 = support3;
    }

    public Double getCprPivot() {
        return cprPivot;
    }

    public void setCprPivot(Double cprPivot) {
        this.cprPivot = cprPivot;
    }

    public Double getCprBc() {
        return cprBc;
    }

    public void setCprBc(Double cprBc) {
        this.cprBc = cprBc;
    }

    public Double getCprTc() {
        return cprTc;
    }

    public void setCprTc(Double cprTc) {
        this.cprTc = cprTc;
    }

    // toString()

    /**
     * Returns a string representation of the object.
     *
     * @return A string with all field values.
     */
    @Override
    public String toString() {
        return "D270924java{" +
                "id=" + id +
                ", date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", pivot=" + pivot +
                ", resistance1=" + resistance1 +
                ", support1=" + support1 +
                ", resistance2=" + resistance2 +
                ", support2=" + support2 +
                ", resistance3=" + resistance3 +
                ", support3=" + support3 +
                ", cprPivot=" + cprPivot +
                ", cprBc=" + cprBc +
                ", cprTc=" + cprTc +
                '}';
    }

    // equals() and hashCode()

    /**
     * Determines whether another object is equal to this one.
     *
     * @param o The other object.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        D270924java that = (D270924java) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(open, that.open) &&
                Objects.equals(high, that.high) &&
                Objects.equals(low, that.low) &&
                Objects.equals(close, that.close) &&
                Objects.equals(pivot, that.pivot) &&
                Objects.equals(resistance1, that.resistance1) &&
                Objects.equals(support1, that.support1) &&
                Objects.equals(resistance2, that.resistance2) &&
                Objects.equals(support2, that.support2) &&
                Objects.equals(resistance3, that.resistance3) &&
                Objects.equals(support3, that.support3) &&
                Objects.equals(cprPivot, that.cprPivot) &&
                Objects.equals(cprBc, that.cprBc) &&
                Objects.equals(cprTc, that.cprTc);
    }

    /**
     * Generates a hash code for the object based on its fields.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, date, open, high, low, close, pivot, resistance1, support1,
                resistance2, support2, resistance3, support3, cprPivot, cprBc, cprTc);
    }
}
