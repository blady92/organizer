/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.ftims.pp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.lodz.ftims.pp.model.Event;
import pl.lodz.ftims.pp.service.EventService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

private final EventService eventService;

    @Autowired
    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }
    
        @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getAllEvents() {
        LOGGER.info("Start getAllEvents :: ");
        return eventService.getAllEvent();
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Event getEventById(@RequestParam(value = "eventId", required = true) long eventId) {
        LOGGER.info("Start getEventById :: ");
        return eventService.getEventById(eventId);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Event addEvent(@Validated @RequestBody(required = true) Event event) {
        LOGGER.info("Start addEvent  :: ",event);
        return eventService.addEvent(event);

    }
    
        @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Event editEvent(@Validated @RequestBody(required = true) Event event) {
        LOGGER.info("Start editEvent  :: ");
        return eventService.editEvent(event);

    }
    
        @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String deleteEvent(@RequestParam(value = "eventId", required = true) long eventId) {
        LOGGER.info("Start deleteEvent :: ");
        return eventService.deleteEvent(eventId);

    }
}

