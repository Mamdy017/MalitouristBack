package ApiGestionRegion.API.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Table(name="region")
@Data
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id ;
    @Column(unique = true)
    private String code_region;
    private String nom;
    private String activite;
    private float superficie;
    @ManyToOne
    Pays pays;
}
