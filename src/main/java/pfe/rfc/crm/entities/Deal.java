package pfe.rfc.crm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Deal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDeal;
    String title;
    String description;
    LocalDate expectedCloseDate;
    LocalDateTime timestamp;

    @JsonIgnore
    @ManyToOne // Many deals can belong to one user
    @JoinColumn(name = "idUser")
    private User user;
}
