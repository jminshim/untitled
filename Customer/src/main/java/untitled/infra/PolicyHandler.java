package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStated'"
    )
    public void wheneverCookStated_UpdateStatus(
        @Payload CookStated cookStated
    ) {
        CookStated event = cookStated;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookStated + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryComfirmed'"
    )
    public void wheneverDeliveryComfirmed_UpdateStatus(
        @Payload DeliveryComfirmed deliveryComfirmed
    ) {
        DeliveryComfirmed event = deliveryComfirmed;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryComfirmed + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
