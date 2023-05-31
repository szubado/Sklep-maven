package camp.db;

import camp.model.User;

import java.util.Collection;

public interface IUserRepository {
    public void addUser();
    public User findUserByLogin(String login);
    Collection<User> getUsers();
    public void addUserFromFile(User user);
}
