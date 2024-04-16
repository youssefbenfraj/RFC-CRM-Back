package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.Chat;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IChatService;
import pfe.rfc.crm.interfaces.IUserService;

import java.util.List;

@RestController
@RequestMapping("/Chat")
@AllArgsConstructor
public class ChatController {
    IChatService chatService;
    IUserService userService;

    @GetMapping("/getAllChats")
    public List<Chat> retrieveAllChats() {
        return chatService.getAllChats();
    }

    @PostMapping("/addChat")
    public Chat addChat(@RequestBody Chat chat) {
        return chatService.createOrUpdateChat(chat);
    }

    @DeleteMapping("/deleteChat/{id}")
    public void removeChat(@PathVariable Long id) {
        chatService.deleteChat(id);
    }

    @GetMapping("/getChatById/{id}")
    public Chat retrieveChat(@PathVariable Long id) {
        return chatService.getChatById(id);
    }

    ///////////////////////////////
    /*
    @PostMapping("/create")
    public ResponseEntity<Chat> createChat(@RequestParam Long senderId,
                                           @RequestParam Long receiverId,
                                           @RequestParam String initialMessage) {
        // Retrieve sender and receiver users from the database
        User sender = userService.getUserById(senderId);
        User receiver = userService.getUserById(receiverId);

        if (sender == null || receiver == null) {
            // Handle invalid sender or receiver IDs
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // Create the chat
        Chat chat = chatService.createChat(sender, receiver, initialMessage);

        // Return the created chat in the response body with a success status code
        return ResponseEntity.status(HttpStatus.CREATED).body(chat);
    }

    @PostMapping("/{chatId}/send")
    public ResponseEntity<Chat> sendMessage(@PathVariable Long chatId,
                                            @RequestParam Long senderId,
                                            @RequestParam String message) {
        // Retrieve the chat from the database
        Chat chat = chatService.getChatById(chatId);

        if (chat == null) {
            // Handle invalid chat ID
            return ResponseEntity.notFound().build();
        }

        // Retrieve the sender user from the database
        User sender = userService.getUserById(senderId);

        if (sender == null) {
            // Handle invalid sender ID
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // Send the message in the chat
        Chat updatedChat = chatService.sendMessage(chat, sender, message);

        // Return the updated chat in the response body with a success status code
        return ResponseEntity.ok(updatedChat);
    }*/
}
