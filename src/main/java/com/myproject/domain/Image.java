package com.myproject.domain;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    @Column(nullable = false)
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "hotelForImage")
    private Hotel hotelForImage;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Hotel getHotelForImage() {
        return hotelForImage;
    }

    public void setHotelForImage(Hotel hotelForImage) {
        this.hotelForImage = hotelForImage;
    }
}
