package pl.lodz.ftims.pp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.lodz.ftims.pp.model.Event;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
 
    List <Event> findByUsername(String username);
    Event findByIdEventAndUsername(Long idEvent, String username);
    
    @Override
List <Event> findAll();
}
