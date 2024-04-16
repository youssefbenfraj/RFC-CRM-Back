package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.Chat;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IChatService;
import pfe.rfc.crm.repositories.ChatRepo;
import pfe.rfc.crm.repositories.UserRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService implements IChatService {
    ChatRepo chatRepo;
    UserRepo userRepo;

    @Override
    public Chat createOrUpdateChat(Chat chat) {
        return chatRepo.save(chat);
    }

    @Override
    public List<Chat> getAllChats() {
        return chatRepo.findAll();
    }

    @Override
    public Chat getChatById(Long id) {
        return chatRepo.findById(id).get();
    }

    @Override
    public void deleteChat(Long id) {
        chatRepo.deleteById(id);
    }


    ////////////////////////////////
    /*
    @Override
    public Chat createChat(User sender, User receiver, String initialMessage) {
        Chat chat = new Chat();
        chat.setSender(sender);
        chat.setReceiver(receiver);
        chat.setTimestamp(LocalDateTime.now()); // Set current timestamp
        chat.appendMessage(initialMessage, sender); // Append initial message

        // Optionally, you can save the chat immediately or return it for further processing
        return chatRepo.save(chat);
    }

    @Override
    public Chat sendMessage(Chat chat, User sender, String message) {
        // Append the new message to the chat content
        chat.appendMessage(message, sender);

        // Save the updated chat to the database
        return chatRepo.save(chat);
    }*/
}
