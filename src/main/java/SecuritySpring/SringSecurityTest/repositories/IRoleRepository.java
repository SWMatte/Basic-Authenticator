package SecuritySpring.SringSecurityTest.repositories;

import SecuritySpring.SringSecurityTest.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role,Integer> {


    Role findByAuthority(String authority);
}
