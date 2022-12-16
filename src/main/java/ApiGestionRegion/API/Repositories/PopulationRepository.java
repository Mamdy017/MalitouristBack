package ApiGestionRegion.API.Repositories;

import ApiGestionRegion.API.Modele.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PopulationRepository extends JpaRepository<Population,Long> {


}
