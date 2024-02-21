package modelforops.domain;

import java.util.*;
import lombok.*;
import modelforops.domain.*;
import modelforops.infra.AbstractEvent;

@Data
@ToString
public class Dispatched extends AbstractEvent {

    private Long id;
    private String carId;
    private String carType;
    private String workerId;
    private String dispatchTime;
}
