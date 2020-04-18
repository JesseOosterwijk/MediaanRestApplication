package api.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "SessionId")
    private long sessionId;

    public long getId() {
        return id;
    }

    public long getSessionId() {
        return sessionId;
    }
}
