package com.aicart.backend.product.dto;

import com.aicart.backend.product.entity.Product;

public class ProductResponse {

    private Long id;
    private String name;
    private int price;
    private String barcode;
    private String imageUrl;

    private ProductResponse(Long id, String name, int price, String barcode, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.imageUrl = imageUrl;
    }

    // Entity를 DTO로 변환하는 정적 팩토리 메서드
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getBarcode(),
                product.getImageUrl()
        );
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
}