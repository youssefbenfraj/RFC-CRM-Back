package pfe.rfc.crm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;
    String name;
    String email;
    String country;
    String password;
    Role role;

   /* @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // One user can have many posts
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // One user can have many deals
    private List<Deal> deals;*/
}
