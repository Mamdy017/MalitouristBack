package ApiGestionRegion.API.Services;

import ApiGestionRegion.API.Modele.Region;

import java.util.List;

public interface RegionService {


    Region creer(Region region);

    List<Region> lire();

    Region modifier(Long Id, Region region);

    String supprimer(Long Id);

    List<Object[]>getRegionsP();


}
