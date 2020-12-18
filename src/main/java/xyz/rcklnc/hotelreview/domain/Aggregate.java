package xyz.rcklnc.hotelreview.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Aggregate {
    private final List<DomainEvent> events = new ArrayList<>();

    protected void addEvent(DomainEvent event) {
        this.events.add(event);
    }

    public List<DomainEvent> getEvents() {
        return Collections.unmodifiableList(this.events);
    }
}
