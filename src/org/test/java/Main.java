package org.test.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        asking for arguments of Event constructor
//        event name
        System.out.print("Add event name: ");
        String name = input.nextLine();
//        event name
        System.out.println("Add when the event is going to take place");
        System.out.print("Day(dd): ");
        int day = Integer.parseInt(input.nextLine());
        System.out.print("Month(MM): ");
        int month = Integer.parseInt(input.nextLine());
        System.out.print("Year(yy): ");
        int year = Integer.parseInt(input.nextLine());
        LocalDate date = LocalDate.of(year,month,day);

//         event capacity
        System.out.print("Add how many people the building can hold: ");
        int capacity = Integer.parseInt(input.nextLine());

        Event event = null;
        try {
            event = new Event(capacity,name,date);
            System.out.println( event.toString());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        if(event != null){
                //        asking for add reservation
                System.out.println("How many tickets do you want to buy for this event");
                int ticketsAmount = Integer.parseInt(input.nextLine());

                for (int i = 0; i < ticketsAmount; i++) {
                    event.book();
                }

            //        display
                System.out.println(event.getReservationNumber() + "// remaining seats" + (event.getCapacity()-event.getReservationNumber()) );

            //              asking for call off reservation
                System.out.println("How many reservation do you want to call off");
                int reservationCalledOff = Integer.parseInt(input.nextLine());

                for (int i = 0; i < reservationCalledOff; i++) {
                    event.callOff();
                }

            //        display
                System.out.println(event.getReservationNumber() + "// remaining seats" + (event.getCapacity()-event.getReservationNumber()) );

        }else {
            System.out.println("Qualcosa è andato storto ritenta");
        }

        input.close();
    }
}
