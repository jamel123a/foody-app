package com.example.foody.Login;

public class UsersHalperClas {
    String fullName, username, email, password,phone;

    public UsersHalperClas() {
    }

    public UsersHalperClas(String fullName, String username, String email, String password, String phone) {
        this.fullName = fullName;
        this.username=username;
        this.email=email;
        this.password=password;
        this.phone=phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;

    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
