package com.example.assignment1;

import java.util.HashMap;

public class Data {

    // A hashmap data structure for holding usernames and passwords pair
    HashMap <String, String> hmCredentials;

    public Data(){

        hmCredentials = new HashMap<>();

        // Adding some items into the hashmap table

        hmCredentials.put("AJ", "CoolDude1");
        hmCredentials.put("test", "1234");
    }

    // This method adds a new username and password to the hashmap
    public void AddCredential(String username, String password){
        hmCredentials.put(username, password);
    }

    // This method checks if username exists in the hashmap
    public Boolean CheckUsername(String username){
        Boolean  retval = true;
        // Write your code here

        return retval;
    }

    // This method checks a username and password combination is correct!
    public Boolean CheckCredentials(String username, String Password){
        Boolean  retval = true;
        // Write your code here

        return retval;
    }

}