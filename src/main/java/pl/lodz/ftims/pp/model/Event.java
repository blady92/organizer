package pl.lodz.ftims.pp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    private String title;
    private Date startDate;
    private Date endDate;
    private String location;

    public Event(String title, Date startDate, Date endDate, String location) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

}
