package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.Chat;
import pfe.rfc.crm.entities.User;

import java.util.List;

public interface IChatService {

    Chat createOrUpdateChat(Chat chat);

    List<Chat> getAllChats();

    Chat getChatById(Long id);

    void deleteChat(Long id);

    ////////////////////////////////
    /*Chat createChat(User sender, User receiver, String initialMessage);

    Chat sendMessage(Chat chat, User sender, String message);*/
}
