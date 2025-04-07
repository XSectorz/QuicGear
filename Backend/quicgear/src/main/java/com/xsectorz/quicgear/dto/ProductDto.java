package com.xsectorz.quicgear.dto;

import java.util.Arrays;
import java.util.List;

import com.xsectorz.quicgear.enums.ProductType;

public class ProductDto {

    private Long id;
    private String productName;
    private String productDescription;
    private List<String> productImages;  
    private ProductType productType;
    private double productPrice;
    private int productRating;
    private int productRatingCount;
    private int productStock;
    private String productColor;

    public ProductDto() {
        
    }

    public ProductDto(Long id, String productName, String productDescription, List<String> productImages,
            ProductType productType, double productPrice, int productRating, int productRatingCount, int productStock,
            String productColor) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImages = productImages;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.productRatingCount = productRatingCount;
        this.productStock = productStock;
        this.productColor = productColor;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public List<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<String> productImages) {
        this.productImages = productImages;
    }

    public void setProductImage(String productImage) {
        if (productImage != null && !productImage.isEmpty()) {
            this.productImages = Arrays.asList(productImage.split(","));
        }
    }
    public ProductType getProductType() {
        return productType;
    }
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public int getProductRating() {
        return productRating;
    }
    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }
    public int getProductRatingCount() {
        return productRatingCount;
    }
    public void setProductRatingCount(int productRatingCount) {
        this.productRatingCount = productRatingCount;
    }
    public int getProductStock() {
        return productStock;
    }
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    public String getProductColor() {
        return productColor;
    }
    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

}
