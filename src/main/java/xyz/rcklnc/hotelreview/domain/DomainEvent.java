package xyz.rcklnc.hotelreview.domain;

import java.time.Instant;

public interface DomainEvent {
    Instant getOccurredOn();
}
