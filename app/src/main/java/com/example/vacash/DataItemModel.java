package com.example.vacash;

public class DataItemModel {
    // STORE DATA
    String Name;
    Integer Qty;
    Integer Price;
    Integer Image;

    public DataItemModel(String name, Integer qty, Integer price) {
        Name = name;
        Qty = qty;
        Price = price;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        Image = image;
    }
}
