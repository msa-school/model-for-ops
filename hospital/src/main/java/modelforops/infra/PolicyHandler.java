package modelforops.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import modelforops.config.kafka.KafkaProcessor;
import modelforops.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    HospitalRepository hospitalRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Dispatched'"
    )
    public void wheneverDispatched_MakeReservation(
        @Payload Dispatched dispatched
    ) {
        Dispatched event = dispatched;
        System.out.println(
            "\n\n##### listener MakeReservation : " + dispatched + "\n\n"
        );

        // Sample Logic //
        Hospital.makeReservation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DispatchCanceled'"
    )
    public void wheneverDispatchCanceled_CancelReservation(
        @Payload DispatchCanceled dispatchCanceled
    ) {
        DispatchCanceled event = dispatchCanceled;
        System.out.println(
            "\n\n##### listener CancelReservation : " +
            dispatchCanceled +
            "\n\n"
        );

        // Sample Logic //
        Hospital.cancelReservation(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
