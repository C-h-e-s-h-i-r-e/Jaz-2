package pl.edu.pjwstk.jaz;

import java.util.Set;

public class User {
    public String login;
    public String password;
    public String name;
    private boolean isAdmin;

    public User(String login, String password, String name, boolean isAdmin){
        this.login = login;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
    }
    public User(String login, String password, String name){
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }


    // ?????
    public <T> User(Set<T> emptySet) {
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

    // ???
    public Set<String> getAuthorities() {
        return null;
    }
}
