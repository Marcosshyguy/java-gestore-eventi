package org.test.java;

import java.time.LocalDate;

public class Event {

    private int capacity;
    private String title;
    private LocalDate date;
    private int reservationNumber;

    public Event(int capacity, String title, LocalDate date) {
        if(date.isBefore(LocalDate.now())){
            throw new RuntimeException();
        }
        if (capacity<=0){
            throw new RuntimeException();
        }
        this.capacity = capacity;
        this.title = title;
        this.date = date;
        reservationNumber = 0;
    }


}
