package de.hsba.bi.webshop.atzos;

import de.hsba.bi.webshop.atzos.user.User;
import de.hsba.bi.webshop.atzos.user.UserRepository;
import de.hsba.bi.webshop.atzos.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
public class UserUnitTests {

    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserService userServiceMock;

    @Test
    public List<User> findAllUsers() {
        return userRepositoryMock.findAll();
    }

    @Test
    public User findCurrentUser() {
        return userRepositoryMock.findByUserName(User.getCurrentUsername());
    }
}
