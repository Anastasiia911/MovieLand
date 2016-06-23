package com.nabivach.movieland.dto;

import com.nabivach.movieland.util.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieRequest {

    //Parameters ENUMS
    private Order rating;
    private Order price;

    public Order getRating() {
        return rating;
    }

    public void setRating(Order rating) {
        this.rating = rating;
    }

    public Order getPrice() {
        return price;
    }

    public void setPrice(Order price) {
        this.price = price;
    }
}
