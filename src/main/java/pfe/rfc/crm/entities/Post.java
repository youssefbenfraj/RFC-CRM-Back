package pfe.rfc.crm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPost;
    String titlePost;
    String contentPost;
    String category;
    Status status;
    LocalDateTime timestamp;

    @JsonIgnore
    @ManyToOne // Many posts can belong to one user
    @JoinColumn(name = "idUser")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) // One post can have many chat messages
    private List<Chat> chats;

}
