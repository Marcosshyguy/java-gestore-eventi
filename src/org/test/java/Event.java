package org.test.java;

import java.time.LocalDate;

public class Event {
//      Attributes
    private int capacity;
    private String title;
    private LocalDate date;
    private int reservationNumber;

//     Constructor
//    DO COSTUM EXCEPTION
    public Event(int capacity, String title, LocalDate date) throws RuntimeException {
        if(date.isBefore(LocalDate.now())){
            throw new RuntimeException();
        }
        if (capacity<=0){
            throw new RuntimeException();
        }
        date.format()
        this.capacity = capacity;
        this.title = title;
        this.date = date;
        reservationNumber = 0;
    }

//    Getter and Setter
    public int getCapacity() {
        return capacity;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }
//    Methods


}
