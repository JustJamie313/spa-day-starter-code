package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {
    private static final Map<Integer, User> users = new HashMap<>();

    public static void addUser(User aUser){
        users.put(aUser.getId(),aUser);
    }

    public static Collection<User> getAllUsers(){
        return users.values();
    }

    public static User getUserById(int aId){
        return users.get(aId);
    }
}
