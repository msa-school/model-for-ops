package modelforops.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import modelforops.domain.*;
import modelforops.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String hospitalId;
    private String hospitalName;
    private String address;

    public Canceled(Hospital aggregate) {
        super(aggregate);
    }

    public Canceled() {
        super();
    }
}
//>>> DDD / Domain Event
