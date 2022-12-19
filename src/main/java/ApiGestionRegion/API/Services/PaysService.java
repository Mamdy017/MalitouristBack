package ApiGestionRegion.API.Services;

import ApiGestionRegion.API.Modele.Pays;

import java.util.List;
import java.util.Optional;

public interface PaysService {


    Pays creer(Pays pays);

    List<Pays> lire();

    Pays modifier(Long Id, Pays pays);

    String supprimer(Long Id);

    Optional<Pays> paysParId(Long id);
}
