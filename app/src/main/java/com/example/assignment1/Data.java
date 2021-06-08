package com.example.assignment1;

import java.util.HashMap;

public class Data {

    // A hashmap data structure for holding usernames and passwords pair
    HashMap <String, String> hmCredentials;

    public Data() {

        hmCredentials = new HashMap<>();

        // Adding some items into the hashmap table

        hmCredentials.put("AJ", "CoolDude1");
        hmCredentials.put("test", "1234");
    }

    // This method adds a new username and password to the hashmap
    public void addCredential(String username, String password) {
        hmCredentials.put(username, password);
    }

    /**
     * Returns true if username exists in hashmap
     * @param username string username that was entered by user
     * @return true if username key value exists in hashmap, otherwise false
     */
    public Boolean checkUsername(String username) {
        Boolean retval = true;

        retval = hmCredentials.containsKey(username);

        return retval;
    }

    /**
     * Returns true if username with matching password value exists in hashmap
     * @param username inputted username
     * @param password inputted password
     * @return true if username with matching password value exists in hashmap
     */
    public Boolean checkCredentials(String username, String password) {
        Boolean retval = true;
        if (this.checkUsername(username)) {
            if (hmCredentials.get(username).equals(password)) {
                retval = true;
            } else {
                retval = false;
            }
        } else {
            retval = false;
        }

        return retval;
    }

    private void print_hashmap() {
        for (String name: hmCredentials.keySet()) {
            String key = name.toString();
            String value = hmCredentials.get(name).toString();
            System.out.println(key + " " + value);
        }

    }
}
