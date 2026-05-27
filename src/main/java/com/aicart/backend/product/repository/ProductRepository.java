package com.aicart.backend.product.repository;

import com.aicart.backend.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 바코드로 상품 조회 (수동 바코드 스캔용)
    //Optional<Product> findByBarcode(String barcode);

    // YOLO 라벨로 상품 조회 (AI 인식 결과로 상품 정보 조회용)
    Optional<Product> findByYoloLabel(String yoloLabel);
}