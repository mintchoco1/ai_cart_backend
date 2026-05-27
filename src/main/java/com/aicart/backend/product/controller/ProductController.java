package com.aicart.backend.product.controller;

import com.aicart.backend.common.ApiResponse;
import com.aicart.backend.product.dto.ProductResponse;
import com.aicart.backend.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // 생성자 주입
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 바코드로 상품 조회: GET /api/products/barcode/{barcode}
    @GetMapping("/barcode/{barcode}")
    public ApiResponse<ProductResponse> findByBarcode(@PathVariable String barcode) {
        //product 변수에 dto가 담김
        ProductResponse product = productService.findByBarcode(barcode);
        //dto를 ApiResponse로 감싸서 반환
        //반환된 객체를 스프링이 JSON으로 변환->http 응답으로 앱에 전송
        return ApiResponse.success("상품 조회 성공", product);
    }

    // YOLO 라벨로 상품 조회: GET /api/products/yolo/{yoloLabel}
    @GetMapping("/yolo/{yoloLabel}")
    public ApiResponse<ProductResponse> findByYoloLabel(@PathVariable String yoloLabel) {
        ProductResponse product = productService.findByYoloLabel(yoloLabel);
        return ApiResponse.success("상품 조회 성공", product);
    }
}