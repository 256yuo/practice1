package com.wangshidai.ATM.Atmdome;

public class Accoun {
    private int id;
    private String name;
    private int password;
    private int password1;
    private double money;

    public Accoun() {
    }

    public Accoun(int id, String name, int password, int password1, double money) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.password1 = password1;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPassword1() {
        return password1;
    }

    public void setPassword1(int password1) {
        this.password1 = password1;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
