package cn.chen.bean;

import java.sql.Time;

public class Account {
    int id;
    String password;
    String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    public Account(int id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
    public Account(){}
}
