package camp.model;

public class User implements Writable{
    private String login;
    private String password;
    private String rola;

    public User(String login, String password, String rola) {
        this.login = login;
        this.password = password;
        this.rola = rola;
    }
    public User(String[] vars) {
        this(vars[0], vars[1],vars[2]);
    }

    public User() {
    }
    @Override
    public String toCSV() {
        return new StringBuilder()
                .append(getClass().getSimpleName())
                .append(";")
                .append(this.login)
                .append(";")
                .append(this.password)
                .append(";")
                .append(this.rola)
                .toString();
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
}
