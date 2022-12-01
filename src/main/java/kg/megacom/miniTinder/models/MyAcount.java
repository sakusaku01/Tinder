package kg.megacom.miniTinder.models;

public interface MyAcount {
    void saveAccount(String login,String password);

    String getLogin();
    String getPassword();
}
