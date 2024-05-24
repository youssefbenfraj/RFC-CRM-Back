package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.Message;
import pfe.rfc.crm.entities.Chat;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.exceptions.ChatNotFoundException;
import pfe.rfc.crm.exceptions.NoChatExistsInTheRepository;
import pfe.rfc.crm.exceptions.UserNotFoundException;

import java.util.HashSet;
import java.util.List;

public interface IChatService {
/*
    Chat createOrUpdateChat(Chat chat);

    List<Chat> getAllChats();

    Chat getChatById(Long id);

    void deleteChat(Long id);
*/
    ////////////////////////////////
    /*Chat createChat(User sender, User receiver, String initialMessage);

    Chat sendMessage(Chat chat, User sender, String message);*/
    Chat addChat(Chat chat);
    List<Chat> findAllChats() throws NoChatExistsInTheRepository;
    Chat getById(Long id) throws ChatNotFoundException;
    HashSet<Chat> getChatByFirstUserName(String username) throws ChatNotFoundException;
    HashSet<Chat> getChatBySecondUserName(String username) throws ChatNotFoundException;
    HashSet<Chat> getChatByFirstUserNameOrSecondUserName(String username) throws ChatNotFoundException;
    HashSet<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName) throws ChatNotFoundException;
    Chat addMessage(Message add, Long chatId) throws ChatNotFoundException;

    HashSet<Chat> getChatBySender(Long senderId) throws ChatNotFoundException, UserNotFoundException;

    HashSet<Chat> getChatByReceiver(Long receiverId) throws ChatNotFoundException, UserNotFoundException;

    HashSet<Chat> getChatBySenderOrReceiver(User sender, User receiver) throws ChatNotFoundException;
    HashSet<Chat> getChatBySenderAndReceiver(User sender, User receiver) throws ChatNotFoundException;

    HashSet<Chat> getChatBySender(User sender) throws ChatNotFoundException;
    HashSet<Chat> getChatByReceiver(User receiver) throws ChatNotFoundException;



}
