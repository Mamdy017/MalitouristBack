package ApiGestionRegion.API.Services;

import ApiGestionRegion.API.Modele.Pays;
import ApiGestionRegion.API.Repositories.PaysRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
@AllArgsConstructor
public class PaysServiceImpl implements PaysService {
    @Autowired
  private final PaysRepository paysRepository;
    @Override
    public Pays creer(Pays pays) {
        return this.paysRepository.save(pays);
    }

    @Override
    public List<Pays> lire() {
        return this.paysRepository.findAll();
    }

    @Override
    public Pays modifier(Long Id, Pays pays) {
        return this.paysRepository.findById(Id).map(p->{
               p.setNom(pays.getNom());
            return paysRepository.save(p);
        }
      ).orElseThrow(()-> new  RuntimeException("Pays non trouvé"));
    }
    @Override
    public String supprimer(Long Id) {
         this.paysRepository.deleteById(Id);
        return "Pays" +Id+ "supprimer avec succès";
    }
}
