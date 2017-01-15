/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.ftims.pp.service;

import org.hibernate.annotations.common.util.impl.Log_$logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.lodz.ftims.pp.controller.EventController;
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

    public Event deleteEvent(long eventId) {
        Event eventToDelete = eventRepository.findOne(eventId);
        eventRepository.delete(eventId);
        return eventToDelete;
    }

    public Event editEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(long eventId) {
        return eventRepository.findOne(eventId);
    }

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }
  
    @PostConstruct
    public void addEventsPost() {
        Event event1 = new Event(null, "Konferencja", new Date(117, 0, 8, 8, 0), new Date(117, 0, 10, 16, 30), "Łódź");
        Event event2 = new Event(null, "Spotkanie", new Date(117, 0, 10, 17, 15), new Date(117, 0, 10, 20, 00), "Łódź");
        eventRepository.save(event1);
        eventRepository.save(event2);
    }

    public List<Event> synchronization(List<Event> events) {
        List<Event> eventFromBases = getAllEvent();
        for (Event eventBase : eventFromBases) {
            eventRepository.delete(eventBase.getIdEvent());
        }
        for (Event event : events) {
            eventRepository.save(event);
        }

        return getAllEvent();
    }
}
