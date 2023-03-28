package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Rejeted extends AbstractEvent {

    private Long id;

    public Rejeted(Cook aggregate) {
        super(aggregate);
    }

    public Rejeted() {
        super();
    }
}
