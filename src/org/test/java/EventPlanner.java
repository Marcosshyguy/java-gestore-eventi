package org.test.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private  String title;
   private List<Event> events;

    public EventPlanner(String title) {
        this.title = title;
        events = new ArrayList<>();
    }

    public EventPlanner(String title, List<Event> event) {
        this.title = title;
        this.events = new ArrayList<>();
        this.events.addAll(event);
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

    @Override
    public String toString() {
        return "EventPlanner{" +
                "title='" + title + '\'' +
                ", event=" + events +
                '}';
    }


}
