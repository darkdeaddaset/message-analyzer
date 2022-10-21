package ru.savin.messageanalyzer.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.dto.RabbitMessageDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import ru.savin.messageanalyzer.core.api.RabbitSenderService;

@Service
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class RabbitSenderImpl implements RabbitSenderService {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void sendMessage(RabbitMessageDto messageDto, String queue) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(messageDto);
        amqpTemplate.convertAndSend(queue, message);
        System.out.println("Очередь отправлена");
    }
}
