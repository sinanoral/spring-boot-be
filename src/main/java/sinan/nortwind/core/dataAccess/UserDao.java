package sinan.nortwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import sinan.nortwind.core.entities.User;
import sinan.nortwind.core.utilities.results.DataResult;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
