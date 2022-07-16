package ru.netology.javaqa.domain;

public class Smartphone extends Product {

    private String brandPhone;
    private String madeIn;

    public Smartphone(int id, String name, int price, String brandPhone, String madeIn) {
        super(id, name, price);
        this.brandPhone = brandPhone;
        this.madeIn = madeIn;
    }
}
