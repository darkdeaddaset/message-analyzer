package ru.savin.messageanalyzer.core.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.dto.RabbitMessageDTO;
import liga.medical.dto.RabbitMessageDto;

public interface RabbitSenderService {
    void sendMessage(RabbitMessageDTO messageDto, String queue) throws JsonProcessingException;
}
