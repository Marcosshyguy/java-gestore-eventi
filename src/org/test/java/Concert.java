package org.test.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {
    private LocalTime hour;
    private BigDecimal price;

    public Concert(int capacity, String title, LocalDate date, LocalTime hour, BigDecimal price) throws RuntimeException {
        super(capacity, title, date);
        this.hour = hour;
        this.price = price;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


//    methods
    public String getFormattedHour() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return  hour.format(formatter);
    }

    public String getFormattedPrice(){
        DecimalFormat format = new DecimalFormat("##.##");
        String formattedPrice = format.format(price);
        return formattedPrice;
    }

    @Override
    public LocalDate getDate() {
        return super.getDate();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    //    Ovveride

    @Override
    public String toString() {
        return "The concert " + getTitle() + " will be at " +  super.formatDate(getDate()) + " " + getFormattedHour() +
                  ". The concert price is " +getFormattedPrice() + "$";
    }
}
