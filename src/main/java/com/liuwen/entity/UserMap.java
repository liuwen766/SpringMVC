package com.liuwen.entity;

import lombok.Data;
import java.util.Map;
@Data
public class UserMap {
    private Map<String,User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
}
