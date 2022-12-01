package kg.megacom.miniTinder.models;

public class Acount implements MyAcount{
    private String login;
    private String password;

    public Acount() {
    }

    public Acount(String login, String password) {
        this.login = login;
        this.password = password;
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

    @Override
    public String toString() {
        return "Login" + login + "\n" +
                "Password" + password ;
    }


    @Override
    public void saveAccount(String login, String password) {
        Acount acount  = new Acount();
        setLogin(login);
        setPassword(password);
    }
}
