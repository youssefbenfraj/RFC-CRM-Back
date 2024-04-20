package pfe.rfc.crm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
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
    private Long idPost;
    @NotNull(message = "Title cannot be empty")
    private String titlePost;
    @NotNull(message = "Content cannot be empty")
    private String contentPost;
    private String category;
    private Status status;
    private LocalDateTime timestamp;

    @JsonIgnore
    @ManyToOne // Many posts can belong to one user
    @JoinColumn(name = "idUser")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) // One post can have many chat messages
    private List<Chat> chats;

}
