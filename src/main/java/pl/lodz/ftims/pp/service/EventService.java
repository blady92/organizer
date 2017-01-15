/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.ftims.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.lodz.ftims.pp.model.Event;
import pl.lodz.ftims.pp.repository.EventRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Validated
public class EventService {
    
    private final EventRepository eventRepository;
    
    @Autowired
    public EventService(final EventRepository eventRepository ) {
        this.eventRepository = eventRepository;
    }

    public String deleteEvent(long eventId) {
        eventRepository.delete(eventId);
        return "OK" ;
    }

    public Event editEvent(Event event) {
       return  eventRepository.save(event);
    }

    public Event addEvent(Event event) {
       return  eventRepository.save(event);
    }

    public Event getEventById(long eventId) {
      return eventRepository.findOne(eventId);
    }

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }
    
    @PostConstruct
    public void addEventsPost() {
        Event event1 = new Event(null , "Konferencja", new Date(116, 1, 8,8,0), new Date(116, 1, 10,16,30), "Łódź");
        Event event2 = new Event(null , "Konferencja", new Date(116, 1, 9,8,0), new Date(116, 1, 10,16,30), "Łódź");
        eventRepository.save(event1);
        eventRepository.save(event2);
    }
}
