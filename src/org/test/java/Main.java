package org.test.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        EventPlanner planner = new EventPlanner("Main list");
        Scanner input = new Scanner(System.in);

//        this loop is for testing the methods addToList of EventPlanner
//        for (int i = 0; i < 3; i++) {
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

//        setting hour and price manually
            BigDecimal price =  new BigDecimal("1000.67900");
            LocalTime hour = LocalTime.of(20, 30);


//        creating an event if all the constructor's arguments  are correct

            Event event = null;
            try {
                event = new Concert(capacity,name,date,hour,price);
                System.out.println(event.toString());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

//        Bonus**************************************************
//      BONUS testing if the Event Planner can add multiple events
            planner.addToList(event);
//        }

//      BONUS testing if the event planner filters by date and counts how many they are
        System.out.println("You have " + planner.eventsCounter() + " events");

//        System.out.println(planner.getFilteredEventByData(LocalDate.of(2024,10,10)));
//        System.out.println(planner.toString());
//        System.out.println(planner.eventsRemover());
//        System.out.println("Now you have " + planner.eventsCounter() + " events");
//        /Bonus***************************************************

//          section where the costumer decide how many tickets want to buy and then if he want to call them off

//        if(event != null){
//            boolean flag = false;
//            boolean flag2 = false;
//
//            while(!flag){
//                System.out.println("Do you want to buy tickets? y/n");
//                String answer = input.nextLine().toLowerCase();
//                if (answer.equals("y")){
//                    flag = true;
//                    flag2 = true;
//                    //        asking for add reservation
//                    System.out.println("How many tickets do you want to buy for this event");
//                    int ticketsAmount = Integer.parseInt(input.nextLine());
//
//                    for (int i = 0; i < ticketsAmount; i++) {
//                        try {
//                            event.book();
//                        } catch (RuntimeException e) {
//                            System.out.println(e.getMessage());
//                        }
//                    }
//
//                    //        display
//                    System.out.println("Now you have" + event.getReservationNumber()+ " seats" + "// remaining available seats " + (event.getCapacity()-event.getReservationNumber()) );
//
//                } else if (answer.equals("n")) {
//                    flag = true;
//                    System.out.println("Good see you soon");
//                }else{
//                    System.out.println("Choose y/n");
//                }
//            }
//
//            if(flag2){
//                    boolean flag3 = false;
//
//                    while(!flag3){
//                        System.out.println("Do you want to cancel any reservation? y/n");
//                        String answer2 = input.nextLine().toLowerCase();
//                        if (answer2.equals("y")){
//                            flag3 = true;
//                            //              asking for call off reservation
//                            System.out.println("How many reservation do you want to call off?");
//                            int reservationCalledOff = Integer.parseInt(input.nextLine());
//
//                            for (int i = 0; i < reservationCalledOff; i++) {
//                                try {
//                                    event.callOff();
//                                } catch (RuntimeException e) {
//                                    System.out.println(e.getMessage());
//                                    break;
//                                }
//                            }
//
//                            //        display
//                            System.out.println("Now you have "+ event.getReservationNumber()+ " seats" + "// remaining available seats " + (event.getCapacity()-event.getReservationNumber()) );
//                        }else if (answer2.equals("n")) {
//                            flag3 = true;
//                            System.out.println("Good see you soon");
//                        }else{
//                            System.out.println("Choose y/n");
//                        }
//                    }
//                }
//
//        }else {
//            System.out.println("Something went wrong, retry");
//        }

        input.close();
    }
}
