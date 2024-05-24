package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.Message;
import pfe.rfc.crm.entities.Chat;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.exceptions.ChatNotFoundException;
import pfe.rfc.crm.exceptions.NoChatExistsInTheRepository;
import pfe.rfc.crm.exceptions.UserNotFoundException;
import pfe.rfc.crm.interfaces.IChatService;
import pfe.rfc.crm.repositories.ChatRepo;
import pfe.rfc.crm.repositories.MessageRepo;
import pfe.rfc.crm.repositories.UserRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChatService implements IChatService {
    private final ChatRepo chatRepository;
    private final UserRepo userRepository;
    private final MessageRepo messageRepo;

    public Chat addChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> findAllChats() throws NoChatExistsInTheRepository {
        List<Chat> chats = chatRepository.findAll();
        if (chats.isEmpty()) {
            throw new NoChatExistsInTheRepository();
        } else {
            return chats;
        }
    }

    @Override
    public Chat getById(Long id) throws ChatNotFoundException {
        Optional<Chat> chat = chatRepository.findById(id);
        return chat.orElseThrow(ChatNotFoundException::new);
    }

    @Override
    public HashSet<Chat> getChatByFirstUserName(String username) throws ChatNotFoundException {
        User user = userRepository.findByFirstName(username)
                .orElseThrow(ChatNotFoundException::new);

        List<Chat> chats = chatRepository.findBySenderOrReceiver(user, user);

        return new HashSet<>(chats);
    }

    @Override
    public HashSet<Chat> getChatBySecondUserName(String username) throws ChatNotFoundException {
        return getChatByFirstUserName(username);
    }

    @Override
    public HashSet<Chat> getChatByFirstUserNameOrSecondUserName(String username) throws ChatNotFoundException {
        return getChatByFirstUserName(username);
    }

    @Override
    public HashSet<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName) throws ChatNotFoundException {
        User firstUser = userRepository.findByFirstName(firstUserName)
                .orElseThrow(ChatNotFoundException::new);
        User secondUser = userRepository.findByFirstName(secondUserName)
                .orElseThrow(ChatNotFoundException::new);

        List<Chat> chats = chatRepository.findBySenderAndReceiver(firstUser, secondUser);

        return new HashSet<>(chats);
    }

    @Override
    public Chat addMessage(Message add, Long chatId) throws ChatNotFoundException {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(ChatNotFoundException::new);
        Message savedMessage = messageRepo.save(add);

        if (chat.getMessageList() == null) {
            List<Message> messages = new ArrayList<>();
            messages.add(savedMessage);
            chat.setMessageList(messages);
        } else {
            chat.getMessageList().add(savedMessage);
        }

        return chatRepository.save(chat);
    }

    @Override
    public HashSet<Chat> getChatBySender(Long senderId) throws ChatNotFoundException, UserNotFoundException {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new UserNotFoundException());

        List<Chat> chatList = (List<Chat>) chatRepository.findBySender(sender);
        if (chatList.isEmpty()) {
            throw new ChatNotFoundException();
        }
        return new HashSet<>(chatList);
    }

    @Override
    public HashSet<Chat> getChatByReceiver(Long receiverId) throws ChatNotFoundException, UserNotFoundException {
        User receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new UserNotFoundException());

        List<Chat> chatList = (List<Chat>) chatRepository.findByReceiver(receiver);
        if (chatList.isEmpty()) {
            throw new ChatNotFoundException();
        }
        return new HashSet<>(chatList);
    }

    @Override
    public HashSet<Chat> getChatBySenderOrReceiver(User sender, User receiver) throws ChatNotFoundException {
        HashSet<Chat> chats = new HashSet<>(chatRepository.findBySenderOrReceiver(sender, receiver));
        if (chats.isEmpty()) {
            throw new ChatNotFoundException();
        }
        return chats;
    }

    @Override
    public HashSet<Chat> getChatBySenderAndReceiver(User sender, User receiver) throws ChatNotFoundException {
        HashSet<Chat> chats = new HashSet<>(chatRepository.findBySenderAndReceiver(sender, receiver));
        if (chats.isEmpty()) {
            throw new ChatNotFoundException();
        }
        return chats;
    }

    @Override
    public HashSet<Chat> getChatBySender(User sender) throws ChatNotFoundException {
        return null;
    }

    @Override
    public HashSet<Chat> getChatByReceiver(User receiver) throws ChatNotFoundException {
        return null;
    }

}
