package pfe.rfc.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.Message;
import pfe.rfc.crm.entities.Chat;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.exceptions.ChatNotFoundException;
import pfe.rfc.crm.exceptions.NoChatExistsInTheRepository;
import pfe.rfc.crm.exceptions.UserNotFoundException;
import pfe.rfc.crm.services.ChatService;
import pfe.rfc.crm.services.UserService;

import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat) {
        return new ResponseEntity<>(chatService.addChat(chat), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Chat>> getAllChats() {
        try {
            return new ResponseEntity<>(chatService.findAllChats(), HttpStatus.OK);
        } catch (NoChatExistsInTheRepository e) {
            return new ResponseEntity("List not found", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(chatService.getById(id), HttpStatus.OK);
        } catch (ChatNotFoundException e) {
            return new ResponseEntity("Chat Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sender/{idUser}")
    public ResponseEntity<?> getChatBySender(@PathVariable Long idUser) {
        try {
            User sender = userService.findUserById(idUser);
            HashSet<Chat> chats = chatService.getChatBySender(sender);
            return new ResponseEntity<>(chats, HttpStatus.OK);
        } catch (ChatNotFoundException e) {
            return new ResponseEntity<>("Chat Not Exists", HttpStatus.CONFLICT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/receiver/{idUser}")
    public ResponseEntity<?> getChatByReceiver(@PathVariable Long idUser) {
        try {
            User receiver = userService.findUserById(idUser);
            HashSet<Chat> chats = chatService.getChatByReceiver(receiver);
            return new ResponseEntity<>(chats, HttpStatus.OK);
        } catch (ChatNotFoundException e) {
            return new ResponseEntity<>("Chat Not Exists", HttpStatus.CONFLICT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getChatBySenderOrReceiver")
    public ResponseEntity<?> getChatBySenderOrReceiver(@RequestParam("sender") Long senderId, @RequestParam("receiver") Long receiverId) {
        try {
            User sender = userService.findUserById(senderId);
            User receiver = userService.findUserById(receiverId);
            HashSet<Chat> chats = chatService.getChatBySenderOrReceiver(sender, receiver);
            return new ResponseEntity<>(chats, HttpStatus.OK);
        } catch (ChatNotFoundException e) {
            return new ResponseEntity<>("Chat Not Exists", HttpStatus.CONFLICT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getChatBySenderAndReceiver")
    public ResponseEntity<?> getChatBySenderAndReceiver(@RequestParam("sender") Long senderId, @RequestParam("receiver") Long receiverId) {
        try {
            User sender = userService.findUserById(senderId);
            User receiver = userService.findUserById(receiverId);
            HashSet<Chat> chats = chatService.getChatBySenderAndReceiver(sender, receiver);
            return new ResponseEntity<>(chats, HttpStatus.OK);
        } catch (ChatNotFoundException e) {
            return new ResponseEntity<>("Chat Not Exists", HttpStatus.NOT_FOUND);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/message/{chatId}")
    public ResponseEntity<Chat> addMessage(@RequestBody Message message, @PathVariable Long chatId) {
        try {
            return new ResponseEntity<>(chatService.addMessage(message, chatId), HttpStatus.OK);
        } catch (ChatNotFoundException e) {
            return new ResponseEntity("Chat Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
