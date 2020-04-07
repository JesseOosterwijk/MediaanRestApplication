package api.Entities;

import java.util.UUID;

public class Order {

    private UUID id;

    private int sessionId;

    public UUID getId() {
        return id;
    }

    public int getSessionId() {
        return sessionId;
    }
}
