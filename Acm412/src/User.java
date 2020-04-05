// Code with ❤
//┌─────────────────────────────┐
//│ Created by Mirac OZKAN      │
//│ ─────────────────────────── │
//│ mirac.ozkan123@gmail.com    │
//│ ─────────────────────────── │
//│ 26.03.2020 - 20:17          │
//└─────────────────────────────┘

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class User {

    private int uid;
    private String name;
    private String surName;
    private String country;
    private String password;
    private int age;

    //Default Constructor
    public User() {

    }

    public User(int uid, String name, String surName, String country, int age) {
        this.uid = uid;
        this.name = name;
        this.surName = surName;
        this.country = country;
        this.age = age;
    }

    private boolean isExist() {
        DBConnect conn = new DBConnect();
        return getUserFromRemote(conn.connection);
    }

    private boolean getUserFromRemote(Connection conn) {
        String query = "Select * from Users where uname =" + this.name + " and password= " + this.password;
        boolean isExistUser = false;
        try {
            Statement st = conn.createStatement();
            ResultSet sonuc = st.executeQuery(query);
            isExistUser = sonuc.wasNull();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !isExistUser;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
