package api.Entities;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EntityListeners({AuditingEntityListener.class})
@Entity
@Table(name = "tag")
@Data
public class Tag {
    @Id
    private UUID id;
    private String name;
}
