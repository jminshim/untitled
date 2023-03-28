package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class DeliveryComfirmed extends AbstractEvent {

    private Long id;
}
