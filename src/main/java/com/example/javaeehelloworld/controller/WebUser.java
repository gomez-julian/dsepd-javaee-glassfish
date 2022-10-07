package com.example.javaeehelloworld.controller;

import java.util.Vector;

public class WebUser {
    private String username;
    private String password;

    //singleton instance
    private static Vector<WebUser> users;

    public WebUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static WebUser getUser(String username, String password){
        if(users == null) populateUsers();
        for(WebUser user: users)
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        return null;
    }

    private static void populateUsers(){
        users = new Vector<>();
        users.add(new WebUser("administrador", "12345678"));
        users.add(new WebUser("invitado", "00000000"));
    }
}
