/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.ftims.pp.service;

import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.lodz.ftims.pp.model.Event;
import pl.lodz.ftims.pp.repository.EventRepository;

@Service
@Validated
public class EventService {
    
    private final EventRepository eventRepository;
    
       @Autowired
    public EventService(final EventRepository eventRepository ) {
        this.eventRepository = eventRepository;
    }
    
        @PostConstruct
    public void addEvents() {
        Event event1 = new Event("Konferencja", new Date(116, 1, 8,8,0), new Date(116, 1, 10,16,30), "Łódź");
        eventRepository.save(event1);
    }
}
