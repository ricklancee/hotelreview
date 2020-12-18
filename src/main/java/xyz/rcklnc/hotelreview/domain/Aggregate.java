package xyz.rcklnc.hotelreview.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Aggregate {
    private final List<DomainEvent> events = new ArrayList<>();

    protected void addEvent(DomainEvent event) {
        this.events.add(event);
    }
}
