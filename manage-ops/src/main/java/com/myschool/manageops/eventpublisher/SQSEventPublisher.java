package com.myschool.manageops.eventpublisher;

import com.myschool.manageops.events.NewInstituteEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SQSEventPublisher implements EventPublisher {
//    private final SqsClient sqsClient;

    @Override
    public void newInstituteEvent(UUID instituteId) {
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl("queueUrl")
                .messageBody(String.valueOf(NewInstituteEvent.builder().instituteId(instituteId).build()))
                .build();

//        sqsClient.sendMessage(sendMessageRequest);
    }
}
