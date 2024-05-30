package com.works.project.models;

import java.util.List;

public class Product {
    private long id;
    private String title;
    private String description;
    private Category category;
    private double price;
    private double discountPercentage;
    private double rating;
    private long stock;
    private List<String> tags;
    private String brand;
    private String sku;
    private long weight;
    private Dimensions dimensions;
    private String warrantyInformation;
    private String shippingInformation;
    private AvailabilityStatus availabilityStatus;
    private List<Review> reviews;
    private ReturnPolicy returnPolicy;
    private long minimumOrderQuantity;
    private Meta meta;
    private List<String> images;
    private String thumbnail;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public Category getCategory() { return category; }
    public void setCategory(Category value) { this.category = value; }

    public double getPrice() { return price; }
    public void setPrice(double value) { this.price = value; }

    public double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(double value) { this.discountPercentage = value; }

    public double getRating() { return rating; }
    public void setRating(double value) { this.rating = value; }

    public long getStock() { return stock; }
    public void setStock(long value) { this.stock = value; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> value) { this.tags = value; }

    public String getBrand() { return brand; }
    public void setBrand(String value) { this.brand = value; }

    public String getSku() { return sku; }
    public void setSku(String value) { this.sku = value; }

    public long getWeight() { return weight; }
    public void setWeight(long value) { this.weight = value; }

    public Dimensions getDimensions() { return dimensions; }
    public void setDimensions(Dimensions value) { this.dimensions = value; }

    public String getWarrantyInformation() { return warrantyInformation; }
    public void setWarrantyInformation(String value) { this.warrantyInformation = value; }

    public String getShippingInformation() { return shippingInformation; }
    public void setShippingInformation(String value) { this.shippingInformation = value; }

    public AvailabilityStatus getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(AvailabilityStatus value) { this.availabilityStatus = value; }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> value) { this.reviews = value; }

    public ReturnPolicy getReturnPolicy() { return returnPolicy; }
    public void setReturnPolicy(ReturnPolicy value) { this.returnPolicy = value; }

    public long getMinimumOrderQuantity() { return minimumOrderQuantity; }
    public void setMinimumOrderQuantity(long value) { this.minimumOrderQuantity = value; }

    public Meta getMeta() { return meta; }
    public void setMeta(Meta value) { this.meta = value; }

    public List<String> getImages() { return images; }
    public void setImages(List<String> value) { this.images = value; }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String value) { this.thumbnail = value; }
}
