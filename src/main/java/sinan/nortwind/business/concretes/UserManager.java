package sinan.nortwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinan.nortwind.business.abstracts.UserService;
import sinan.nortwind.core.dataAccess.UserDao;
import sinan.nortwind.core.entities.User;
import sinan.nortwind.core.utilities.results.DataResult;
import sinan.nortwind.core.utilities.results.Result;
import sinan.nortwind.core.utilities.results.SuccessDataResult;
import sinan.nortwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

    @Autowired
    private final UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult();
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<>(userDao.findByEmail(email), "Kullanıcı eklendi");
    }
}
