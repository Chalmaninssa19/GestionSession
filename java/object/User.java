/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.util.ArrayList;

/**
 *
 * @author chalman
 */
public class User {
    String user;
    String mdp;
    
///Constructors
    public User(String user, String mdp) {
        this.user = user;
        this.mdp = mdp;
    }
    
///Getters et setters
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
///fonctions
    public boolean login() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("chalman", "chalman"));
        users.add(new User("fy", "fy"));
        users.add(new User("vioart", "vioart"));
        for(int  i = 0; i < users.size(); i++) {
            if(users.get(i).getUser().equalsIgnoreCase(this.getUser())) {
                return true;
            }
        }
        return false;
    } 
    
}
