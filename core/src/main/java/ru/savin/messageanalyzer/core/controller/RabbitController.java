package ru.savin.messageanalyzer.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.dto.RabbitMessageDTO;
import liga.medical.dto.RabbitMessageDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.savin.messageanalyzer.core.api.RabbitSenderService;
import ru.savin.messageanalyzer.core.config.RabbitConfig;

@RestController
@RequestMapping("/rabbit")
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class RabbitController {
    private final RabbitSenderService rabbitSenderService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody RabbitMessageDTO rabbitMessageDto) throws JsonProcessingException {
        rabbitSenderService.sendMessage(rabbitMessageDto, RabbitConfig.ROUTER_QUEUE_NAME);
    }
}
