package pfe.rfc.crm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Chat implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idChat;
    String content;
    /*@ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    LocalDateTime timestamp;

    public void appendMessage(String message, User sender) {
        if (content == null) {
            content = "";
        }
        content += "[" + sender.getName() + "]: " + message + "/n";
    }*/
    @JsonIgnore
    @ManyToOne // Many chat messages belong to one post
    @JoinColumn(name = "idPost")
    private Post post;
}
