package camp.db;
import camp.gui.IGUI;
import camp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository implements IUserRepository {
    @Autowired
    private IGUI gui;
    private static Map<String, User> users = new HashMap<>();

/*    public UserRepository() {
        this.users.put("admin", new User("admin", "34e410d53ec95272281db69caab50ee0", "admin"));
        this.users.put("janusz", new User("janusz", "fe0f7aafe6829ec45f9278edad8632a1", "user"));
    }*/

    @Override
    public void addUser() {
        //wrzucic Usera w zmienna i wrzucic login do key, a potem calosc Usera wsadzic w value
        User tempUser = gui.readLoginAndPassword();
        this.users.put(tempUser.getLogin(), tempUser);
    }
    @Override
    public User findUserByLogin(String login) {
        return this.users.get(login);
    }

    @Override
    public Collection<User> getUsers() {
        return this.users.values();
    }
    @Override
    public void addUserFromFile(User user) {
        this.users.put(user.getLogin(), user);
    }

}
