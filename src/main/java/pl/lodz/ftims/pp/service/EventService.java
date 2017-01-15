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
import org.springframework.security.core.context.SecurityContextHolder;

@Service
@Transactional
@Validated
public class EventService {
 private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final EventRepository eventRepository;

    @Autowired
    public EventService(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event deleteEvent(long eventId, String user) {
        Event eventToDelete = eventRepository.findByIdEventAndUsername(eventId, user);
        eventRepository.delete(eventId);
        return eventToDelete;
    }

    public Event editEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(long eventId, String user) {
        return eventRepository.findByIdEventAndUsername(eventId, user);
    }

    public List<Event> getAllEvent(String user) {
        return eventRepository.findByUsername(user);
    }

    @PostConstruct
    public void addEventsPost() {
        Event event1 = new Event(null, "Konferencja", new Date(117, 0, 8, 8, 0), new Date(117, 0, 10, 16, 30), "Łódź", "foo");
        Event event2 = new Event(null, "Spotkanie", new Date(117, 0, 10, 17, 15), new Date(117, 0, 10, 20, 00), "Łódź", "user");
        Event event3 = new Event(null, "Spotkanie", new Date(117, 0, 3, 17, 15), new Date(117, 0, 3, 20, 00), "Łódź", "foo");
        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);
    }

    public List<Event> synchronization(List<Event> events, String user) {
        List<Event> eventFromBases = getAllEvent(user);
        for (Event eventBase : eventFromBases) {
            eventRepository.delete(eventBase.getIdEvent());
        }
        for (Event event : events) {
            eventRepository.save(event);
        }
        return getAllEvent(user);
    }
    
    
}
