package org.test.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Event implements Comparable<Event> {
//      Attributes
    private int capacity;
    private String title;
    private LocalDate date;
    private int reservationNumber;

//     Constructor
//    DO COSTUM EXCEPTION
    public Event(int capacity, String title, LocalDate date) throws RuntimeException, NullPointerException {
        if (date == null){
            throw new NullPointerException("Date must not be null");
        }
        if(date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The event has already occurred");
        }
        if (capacity<=0){
            throw new IllegalArgumentException("The capacity must be bigger than 0");
        }

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

    public void setDate(LocalDate date) throws NullPointerException, IllegalArgumentException {
        if (date == null){
            throw new NullPointerException("Date must not be null");
        }
        if(date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The event has already occurred");
        }
        this.date = date;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public int getAvailableSeats(){
        return capacity-reservationNumber;
    }
//    Methods

    public String formatDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public void book() throws IllegalStateException {
        if(date.isBefore(LocalDate.now())){
            throw new RuntimeException("The event has already occurred");
        }
        if(getAvailableSeats() < 1){
            throw new RuntimeException("Your choice overcome the seats availability");
        }

        reservationNumber++;

    }

    public void callOff() throws RuntimeException {
        if(date.isBefore(LocalDate.now())){
            throw new RuntimeException("The event has already occurred");
        }
        if(reservationNumber <= 0){
            throw new RuntimeException("Yuo have less reservation booked");
        }
//
        reservationNumber--;
    }

//    override

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + formatDate(date) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (capacity != event.capacity) return false;
        if (reservationNumber != event.reservationNumber) return false;
        if (!Objects.equals(title, event.title)) return false;
        return date.equals(event.date);
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + date.hashCode();
        result = 31 * result + reservationNumber;
        return result;
    }

    @Override
    public int compareTo(Event o) {
        return this.getDate().compareTo(o.getDate());
    }

}
