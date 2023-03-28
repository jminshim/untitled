package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;

    public CookFinished(Cook aggregate) {
        super(aggregate);
    }

    public CookFinished() {
        super();
    }
}
