package stmall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmall.config.kafka.KafkaProcessor;
import stmall.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StockUpdated'"
    )
    public void wheneverStockUpdated_NotifyToWaitingUser(
        @Payload StockUpdated stockUpdated
    ) {
        StockUpdated event = stockUpdated;
        System.out.println(
            "\n\n##### listener NotifyToWaitingUser : " + stockUpdated + "\n\n"
        );

        // Sample Logic //
        ProductOrder.notifyToWaitingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverycancled'"
    )
    public void wheneverDeliverycancled_UpdateStatus(
        @Payload Deliverycancled deliverycancled
    ) {
        Deliverycancled event = deliverycancled;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliverycancled + "\n\n"
        );

        // Sample Logic //
        ProductOrder.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_UpdateStatus(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        ProductOrder.updateStatus(event);
    }
}
