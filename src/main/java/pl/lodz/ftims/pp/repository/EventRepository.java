package pl.lodz.ftims.pp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.lodz.ftims.pp.model.Event;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
 
    @Override
List <Event> findAll();
}
