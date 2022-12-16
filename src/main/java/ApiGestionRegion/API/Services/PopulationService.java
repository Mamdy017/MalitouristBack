package ApiGestionRegion.API.Services;

import ApiGestionRegion.API.Modele.Population;

import java.util.List;

public interface PopulationService {
    Population creer(Population population);
    List<Population> lire();
    Population modifier(Long Id, Population population);
    String supprimer(Long Id);
}
