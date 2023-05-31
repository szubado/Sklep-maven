package camp.core;

import camp.db.IUserRepository;
import camp.gui.IGUI;
import camp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Authenticator implements IAuthenticator {
    @Autowired
    private IUserRepository usersDatabase;
    @Autowired
    private IGUI gui;

    @Override
    public int authenticate() {
        User userFromGui = gui.readLoginAndPassword();
        User userFromDb = usersDatabase.findUserByLogin(userFromGui.getLogin());
        if (userFromDb != null) {
            if (userFromDb.getPassword().equals(userFromGui.getPassword())) {
                if (userFromDb.getRola().equals("admin")) {
                    //admin
                    return 1;
                } else {
                    //user
                    return 2;
                }
            }
        }
        System.out.println("Incorrect login or password !!");
        return 0;
    }
}

