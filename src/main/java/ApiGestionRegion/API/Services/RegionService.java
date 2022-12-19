package ApiGestionRegion.API.Services;

import ApiGestionRegion.API.Modele.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RegionService {


    Region creer(Region region);

    List<Region> lire();

    Region modifier(Long Id, Region region);

    String supprimer(Long Id);

    List<Object[]>getRegionsP();

    void uploaderImage(MultipartFile f1) throws IOException;


}
