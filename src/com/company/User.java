package com.company;
import java.util.Arrays;
/**
 * Created by dpennebacker on 10/28/16.
 */
public class User {
    private String key; // Users personal encryption key
    private String[] keys = new String[10]; // Maximum of 10 users at once
    private Encryption crypt = new Encryption();

    public User(){ //used to create the user
        this.key = crypt.keygen();
        int i = 0;
        for(String s : keys){
            keys[i] = "";
            i++;
        }
    }

    public boolean hasAccess(User u){ //used to determine who can have access
        boolean status = false;
        for(int i=0;i<this.keys.length;i++){
            if(this.keys[i].equals(u.getKey())){
                status = true;
                break;
            }
        }
        return status;
    }
    public void grant(User u){ //used for when the user selects grant
        int i = 0;
        for(String s : this.keys){
            if(s.equals("")){
                this.keys[i] = u.getKey(); //granting user access to grant the key
            }else{
                i++;
            }
        }
    }

    public void revoke(User u){ //used for when the user selects revoke
        int count = 0;
        for(String s : this.keys){
            if(s.equals(u.getKey())){
                this.keys[count] = ""; //doesn't give the key because they revoked it
            }else{
                count++;
            }
        }
    }

    public String getKey(){
        return this.key;
    }

    public String[] getKeys(){
        return this.keys;
    }

    public void newKey(){
        this.key = crypt.keygen();
    }

    public void say(String cmt, int id, User u[], int count){ //used to get the users answers in the main method
        System.out.println("User " + id + " says " + cmt);
        String encrypted = crypt.encrypt(cmt, u[id].getKey());
        System.out.println("This is encrypted to " + encrypted);
        int i;
        for(i=0;i < count; i++){
            if(id == i){
                continue;
            }
            if(u[i].hasAccess(u[id])){
                System.out.println("User " + i + " sees: " + cmt);
            }else{
                System.out.println("User " + i + " sees: " + encrypted);
            }
        }
    }
}
