package pl.lodz.ftims.pp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String username;

//    public Event(Long idEvent, String title, Date startDate, Date endDate, String location) {
//        this.idEvent=idEvent;
//        this.title = title;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.location = location;
//    }

    //    public Event() {
   // }
}
