package kg.megacom.miniTinder.models;

import kg.megacom.miniTinder.models.enums.Gender;

public class Users {
    private Long id;
    private String login;
    private String password;
    private String name;
    private Gender gender;
    private String info;



    public Users() {
    }

    public Users(String login, String password, String name, String info, Gender gender) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.info = info;
        this.gender=gender;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "\nId: " + id +"|"+
                " Login: " + login +"|"+
                " Password: " + password +"|"+
                " Name: " + name +"|"+
                " Gender: " + gender + "|"+
                " Info: " + info + "\n" ;
    }

}
