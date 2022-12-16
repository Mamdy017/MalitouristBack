package ApiGestionRegion.API.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur",
        uniqueConstraints = {

                @UniqueConstraint(columnNames = "email")
        })
public class Utilisateur {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 20)
        private String nom;

        @NotBlank
        @Size(max = 20)
        private String prenom;

        @NotBlank
        @Size(max = 50)
        @Email
        private String email;

        @NotBlank
        @Size(max = 120)
        private String password;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(  name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

        public Utilisateur(String nom,String prenom, String email, String password) {
                this.nom = nom;
                this.email = email;
                this.password = password;
        }

}
