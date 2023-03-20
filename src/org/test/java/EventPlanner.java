package org.test.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private  String title;
   private List<Event> events;

    public EventPlanner(String title) {
        this.title = title;
        this.events = new ArrayList<>();
    }

    public EventPlanner(String title, List<Event> events) {
        this.title = title;
        this.events = new ArrayList<>();
        this.events.addAll(events);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addToList(Event e){
        events.add(e);
    }

    public List<Event> getFilteredEventByData(LocalDate date){
        ArrayList<Event> dataList = new ArrayList<>();
        for(Event event : events){
            if (event.getDate().equals(date)){
                dataList.add(event);
            }
        }
        return dataList;
    }

    public int eventsCounter(){
        return  events.size();
    }

    public boolean eventsRemover(){
        return  events.removeAll(events);
    }

    public boolean removeEvent(Event e){
        return events.remove(e);
    }

    @Override
    public String toString() {
        String string = getTitle() + "\n";
        List<Event> orderedEvents = new ArrayList<>();
        orderedEvents.addAll(events);
        EventComparatorByDataAsc comparator = new EventComparatorByDataAsc();
        orderedEvents.sort(comparator);
        for (Event e : orderedEvents){
            string += e.toString() + "/n";
        }
        return string;
    }


}
