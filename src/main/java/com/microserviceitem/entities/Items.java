package com.microserviceitem.entities;

public class Items {

//    private Long id;
    private Products product;
    private Integer quantity;

    public Items(Products product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Items(){};
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalCost(){
       return product.getPrice() * quantity.doubleValue();
    }


}
