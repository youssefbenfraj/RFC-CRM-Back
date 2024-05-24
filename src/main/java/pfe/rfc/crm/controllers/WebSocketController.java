package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pfe.rfc.crm.dto.Message;
import pfe.rfc.crm.entities.Chat;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.repositories.UserRepo;
import pfe.rfc.crm.services.ChatService;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
public class WebSocketController {

    private final ChatService chatService;
    private final UserRepo userRepo;

    public WebSocketController(ChatService chatService, UserRepo userRepo) {
        this.chatService = chatService;
        this.userRepo = userRepo;
    }

}
