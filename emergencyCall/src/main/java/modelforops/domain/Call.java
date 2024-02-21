package modelforops.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import modelforops.EmergencyCallApplication;
import modelforops.domain.CallCanceled;
import modelforops.domain.Called;

@Entity
@Table(name = "Call_table")
@Data
//<<< DDD / Aggregate Root
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String carId;

    private String driverName;

    private String position;

    private String accidentTime;

    @PostPersist
    public void onPostPersist() {
        Called called = new Called(this);
        called.publishAfterCommit();

        CallCanceled callCanceled = new CallCanceled(this);
        callCanceled.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static CallRepository repository() {
        CallRepository callRepository = EmergencyCallApplication.applicationContext.getBean(
            CallRepository.class
        );
        return callRepository;
    }
}
//>>> DDD / Aggregate Root
