package sinan.nortwind.business.abstracts;

import sinan.nortwind.core.entities.User;
import sinan.nortwind.core.utilities.results.DataResult;
import sinan.nortwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);

    DataResult<User> findByEmail(String email);
}
