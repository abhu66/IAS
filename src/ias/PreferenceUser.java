/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias;

import ias.models.User;
import java.util.prefs.Preferences;

/**
 *
 * @author asyst
 */
public class PreferenceUser {
    private Preferences prefs  = Preferences.userRoot().node(this.getClass().getName());
    String username = "username";
    String role = "role";
    String name = "name";
    
    public void setPreference(User user){
       
        User dataUser = user;
        System.out.println("uSER : "+user.getUsername());
      
        prefs.put(username,dataUser.getUsername());
        prefs.put(role,dataUser.getRole());
        prefs.put(name,dataUser.getName());
        
        System.out.println("Username : "+prefs.get(username,"username"));
    }
    
    public String getUsernamePrefs(){
        return prefs.get(username, "username");
    }
    public String getUserRolePrefs(){
        return prefs.get(role, "role");
    }
    
    
}
