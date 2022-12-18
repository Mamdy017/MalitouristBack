package ApiGestionRegion.API.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name="pays")
@Data


public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id ;
    @Column(unique = true, length = 20)
    private String nom;
    @Column(unique = true, length = 20)
    private String capital;
    private String drapeau;
    private String image2;
    private String sperficie;


}
