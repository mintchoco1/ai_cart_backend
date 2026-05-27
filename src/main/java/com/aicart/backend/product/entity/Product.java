package com.aicart.backend.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false, unique = true)
    private String barcode;

    @Column
    private String imageUrl;

    @Column(nullable = false, unique = true)
    private String yoloLabel;

    // JPA는 엔티티를 DB에서 불러올 때 기본 생성자를 필요로 함
    protected Product() {
    }

    public Product(String name, int price, String barcode, String imageUrl, String yoloLabel) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.imageUrl = imageUrl;
        this.yoloLabel = yoloLabel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getYoloLabel() {
        return yoloLabel;
    }
}