package pl.lodz.ftims.pp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.lodz.ftims.pp.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
 

}
