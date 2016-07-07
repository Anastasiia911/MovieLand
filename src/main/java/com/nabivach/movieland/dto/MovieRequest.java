package com.nabivach.movieland.dto;

import com.nabivach.movieland.util.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieRequest {

    //Parameters ENUMS
    private Order rating;
    private Order price;
    private int pageNumber;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

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
