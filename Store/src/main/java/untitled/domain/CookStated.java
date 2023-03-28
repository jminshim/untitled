package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class CookStated extends AbstractEvent {

    private Long id;

    public CookStated(Cook aggregate) {
        super(aggregate);
    }

    public CookStated() {
        super();
    }
}
