package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor


public class Products {

    private int id;
    private String availabilityStatus;
    private String category;
    private String description;
    private Double dimensionsDepth;
    private Double dimensionsHeight;
    private Double dimensionsWidth;
    private Double discountPercentage;
    private String images;
    private Double price;
    private Double rating;
    private String shippingInformation;
    private String sku;
    private int stock;
    private String thumbnail;
    private String title;
    private String warrantyInformation;
    private Double weight;

    public Products(String availabilityStatus, String category, String description, Double dimensionsDepth, Double dimensionsHeight,
                    Double dimensionsWidth, Double discountPercentage, String images, Double price, Double rating,
                    String shippingInformation, String sku, int stock, String thumbnail, String title,
                    String warrantyInformation, Double weight) {
        this.availabilityStatus = availabilityStatus;
        this.category = category;
        this.description = description;
        this.dimensionsDepth = dimensionsDepth;
        this.dimensionsHeight = dimensionsHeight;
        this.dimensionsWidth = dimensionsWidth;
        this.discountPercentage = discountPercentage;
        this.images = images;
        this.price = price;
        this.rating = rating;
        this.shippingInformation = shippingInformation;
        this.sku = sku;
        this.stock = stock;
        this.thumbnail = thumbnail;
        this.title = title;
        this.warrantyInformation = warrantyInformation;
        this.weight = weight;
    }
}
