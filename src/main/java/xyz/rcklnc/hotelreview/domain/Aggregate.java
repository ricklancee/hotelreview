package xyz.rcklnc.hotelreview.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Aggregate {
    @Getter
    private final List<DomainEvent> events = new ArrayList<>();

    protected void addEvent(DomainEvent event) {
        this.events.add(event);
    }
}
