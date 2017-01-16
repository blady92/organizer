/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.ftims.pp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.lodz.ftims.pp.controller.EventController;
import pl.lodz.ftims.pp.model.Event;
import pl.lodz.ftims.pp.repository.EventRepository;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<Event> synchronization(List<Event> events, String user) {
        eventRepository.save(events);
        return getAllEvent(user);
    }
}
