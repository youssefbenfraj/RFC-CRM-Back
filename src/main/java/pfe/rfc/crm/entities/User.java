package pfe.rfc.crm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @NotNull(message = "FirstName cannot be empty")
    private String firstName;
    @NotNull(message = "LastName cannot be empty")
    private String lastName;
    @NotNull(message = "Birthday cannot be empty")

    private Date birthDay;
    @NotNull(message = "address cannot be empty")

    private String address;
    @Email(message = "Invalid Email , Please enter a valid email")
    @NotBlank(message = "Email cannot be empty")

    private String mail;
    @NotNull(message = "PhoneNumber cannot be empty")
    private String telNumber;
    @NotEmpty(message = "Password cannot be empty")

    private String password;
    private Boolean approuvement = false ;
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Role cannot be empty")

    private Role role;

    private  String imagePath;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // One user can have many posts
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

/*
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // One user can have many deals
    private List<Deal> deals;*/
}
