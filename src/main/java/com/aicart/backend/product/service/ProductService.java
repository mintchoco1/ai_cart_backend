package com.aicart.backend.product.service;

import com.aicart.backend.product.dto.ProductResponse;
import com.aicart.backend.product.entity.Product;
import com.aicart.backend.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    // 생성자 주입
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 바코드로 상품 조회
    public ProductResponse findByBarcode(String barcode) {
        Product product = productRepository.findByBarcode(barcode)
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 바코드의 상품을 찾을 수 없습니다: " + barcode
                ));

        return ProductResponse.from(product);
    }

    // YOLO 라벨로 상품 조회
    public ProductResponse findByYoloLabel(String yoloLabel) {
        Product product = productRepository.findByYoloLabel(yoloLabel)
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 YOLO 라벨의 상품을 찾을 수 없습니다: " + yoloLabel
                ));
        //Product 엔티티를 ProductResponse DTO로 변환해서 반환
        return ProductResponse.from(product);
    }
}