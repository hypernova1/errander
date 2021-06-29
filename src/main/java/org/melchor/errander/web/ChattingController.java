package org.melchor.errander.web;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.config.security.AuthUser;
import org.melchor.errander.domain.Chatting;
import org.melchor.errander.domain.ChattingMessage;
import org.melchor.errander.domain.User;
import org.melchor.errander.service.ChattingService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChattingController {

    private final ChattingService chattingService;

    @GetMapping("/{errandId}")
    public ResponseEntity<?> getChatting(@PathVariable Long errandId, @AuthUser User user) {
        Chatting chatting = chattingService.getByErrandId(errandId);

        return ResponseEntity.ok(chatting);
    }

    @MessageMapping("/{id}")
    @SendTo("/subscribe/{id}")
    public ChattingMessage sendMessage(@DestinationVariable Long id, ChattingMessage message) {
        return message;

    }

}
