package ApiGestionRegion.API.Repositories;

import ApiGestionRegion.API.Modele.ERole;
import ApiGestionRegion.API.Modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
