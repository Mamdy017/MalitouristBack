package ApiGestionRegion.API.Services;

import ApiGestionRegion.API.Modele.Region;
import ApiGestionRegion.API.Repositories.RegionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.List;
@Data
@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService{


  private final  RegionRepository regionRepository;

    @Override
    public Region creer(Region region) {

        return regionRepository.save(region);
    }

    @Override
    public List<Region> lire() {
        return regionRepository.findAll();
    }

    @Override
    public Region modifier(Long Id, Region region) {
        // TODO Auto-generated method stub
        return regionRepository.findById(Id)
                .map(R->{
                    R.setCode_region(region.getCode_region());
                    R.setNom(region.getNom());
                    R.setActivite(region.getActivite());
                    R.setSuperficie(region.getSuperficie());
                    return regionRepository.save(R);
                }).orElseThrow(()->new RuntimeException("Region non trouvée"));
    }

    @Override
    public String supprimer(Long Id) {
        // TODO Auto-generated method stub
        regionRepository.deleteById(Id);
        return "Region supprimée";
    }

    public List<Object[]> getRegionsP() {
        // TODO Auto-generated method stub
        return regionRepository.getRegionsP() ;
    }


}
