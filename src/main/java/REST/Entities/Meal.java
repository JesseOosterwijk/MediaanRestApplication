package REST.Entities;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EntityListeners({AuditingEntityListener.class})
@Entity
@Table(name = "meal")
@Data
public class Meal {
    @Id
    private UUID id;
    private String name;
    private double Price;
}
